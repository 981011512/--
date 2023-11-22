package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkPackagePriceMapper;
import com.cf.carpark.domain.CfCarParkPackage;
import com.cf.carpark.domain.CfCarParkPackagePrice;
import com.cf.carpark.domain.CfCarParkPackagePriceExample;
import com.cf.carpark.domain.CfCarParkUseLog;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.CfCarParkPackagePriceQuery;
import com.cf.carpark.domain.request.CfCarParkPackageQuery;
import com.cf.carpark.domain.request.CfCarParkUseLogQuery;
import com.cf.carpark.domain.type.FeeQueryMode;
import com.cf.carpark.service.CfCarParkChargingRulesService;
import com.cf.carpark.service.CfCarParkPackagePriceService;
import com.cf.carpark.service.CfCarParkPackageService;
import com.cf.carpark.service.CfCarParkUseLogService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.CustomException;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.response.ResultMap;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayConfig;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.CfCouponService;
import com.cf.pay.service.CfOrderService;
import com.cf.pay.service.CfUserPaymentAgencyService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @ClassName CfCarParkPackagePriceServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/28/028 7:06
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkPackagePriceServiceImpl implements CfCarParkPackagePriceService {

    @Autowired
    private CfCarParkPackagePriceMapper cfCarParkPackagePriceMapper;
    @Autowired
    private CfCarParkPackageService cfCarParkPackageService;
    @Autowired
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Autowired
    private CfCarParkChargingRulesService cfCarParkChargingRulesService;
    @Autowired
    private IdWorker idWorker;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserPaymentAgencyService cfUserPaymentAgencyService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfOrderService cfOrderService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponService cfCouponService;

    @Override
    public CfCarParkPackagePrice add(CfCarParkPackagePrice cfCarParkPackagePrice) {
        cfCarParkPackagePrice.setId(idWorker.nextId());
        cfCarParkPackagePriceMapper.insert(cfCarParkPackagePrice);
        return cfCarParkPackagePrice;
    }

    @Override
    public CfCarParkPackagePrice update(CfCarParkPackagePrice cfCarParkPackagePrice) {
        cfCarParkPackagePriceMapper.updateByPrimaryKey(cfCarParkPackagePrice);
        return cfCarParkPackagePrice;
    }

    @Override
    public Integer delete(String id) {
        return cfCarParkPackagePriceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfCarParkPackagePriceQuery cfCarParkPackagePriceQuery) {
        return cfCarParkPackagePriceMapper.deleteByExample(getExampleByQuery(cfCarParkPackagePriceQuery));
    }

    @Override
    public List<CfCarParkPackagePrice> getListByQuery(CfCarParkPackagePriceQuery cfCarParkPackagePriceQuery) {
        CfCarParkPackagePriceExample exampleByQuery = getExampleByQuery(cfCarParkPackagePriceQuery);
        return cfCarParkPackagePriceMapper.selectByExample(exampleByQuery);
    }

    @Override
    public CfCarParkPackagePriceExample getExampleByQuery(CfCarParkPackagePriceQuery cfCarParkPackagePriceQuery) {
        CfCarParkPackagePriceExample cfCarParkPackagePriceExample = new CfCarParkPackagePriceExample();
        CfCarParkPackagePriceExample.Criteria criteria = cfCarParkPackagePriceExample.createCriteria();
        if(cfCarParkPackagePriceQuery.getTitle()!=null){
            criteria.andTitleLike(cfCarParkPackagePriceQuery.getTitle());
        }
        if(StringUtils.isNotEmpty(cfCarParkPackagePriceQuery.getId())){
            criteria.andIdEqualTo(cfCarParkPackagePriceQuery.getId());
        }
        if(StringUtils.isNotEmpty(cfCarParkPackagePriceQuery.getCarParkId())){
            criteria.andCarParkIdEqualTo(cfCarParkPackagePriceQuery.getCarParkId());
        }
        if(cfCarParkPackagePriceQuery.getCarParkIds()!=null && cfCarParkPackagePriceQuery.getCarParkIds().size()>0){
            criteria.andCarParkIdIn(cfCarParkPackagePriceQuery.getCarParkIds());
        }
        if(StringUtils.isNotEmpty(cfCarParkPackagePriceQuery.getFlagKey())){
            criteria.andFlagKeyEqualTo(cfCarParkPackagePriceQuery.getFlagKey());
        }
        if(cfCarParkPackagePriceQuery.getSpecialGive()!=null){
            criteria.andSpecialGiveEqualTo(cfCarParkPackagePriceQuery.getSpecialGive());
        }
        if(cfCarParkPackagePriceQuery.getSpecialCarPackage()!=null){
            criteria.andSpecialCarPackageEqualTo(cfCarParkPackagePriceQuery.getSpecialCarPackage());
        }
        if(StringUtils.isNotEmpty(cfCarParkPackagePriceQuery.getOrderBy())){
            cfCarParkPackagePriceExample.setOrderByClause(cfCarParkPackagePriceQuery.getOrderBy());
        }

        if(StringUtils.isNotEmpty(cfCarParkPackagePriceQuery.getOrderBy())){
            cfCarParkPackagePriceExample.setOrderByClause(cfCarParkPackagePriceQuery.getOrderBy());
        }
        if(cfCarParkPackagePriceQuery.getPage()!=null && cfCarParkPackagePriceQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkPackagePriceQuery.getPage(), cfCarParkPackagePriceQuery.getSize());
        }

        return cfCarParkPackagePriceExample;
    }

    @Override
    public ResultMap buyCfCarParkPackage(String cfCarParkPackagePriceId, String uid, String payTypeId, String numberPlate, String ip) throws Exception {
        CfCarParkPackagePrice cfCarParkPackagePrice = findById(cfCarParkPackagePriceId, false);
        CfUserPaymentAgency cfUserPaymentAgency = cfUserPaymentAgencyService.findById(payTypeId, false);

        CfCarParkOrder cfCarParkOrder = null;
        try {
            cfCarParkOrder = queryCfCarParkPackageRecoverFee(cfCarParkPackagePrice, uid, numberPlate);
        } catch (Exception e){

        }

        //判断指定订单是否已经存在，若存在继续使用，否则创建
        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setGoodsType(GoodsType.CARPARK_PAYMENT_PACKEAGE);
        cfOrderQuery.setGoodsId(cfCarParkPackagePriceId);
        cfOrderQuery.setUid(uid);
        cfOrderQuery.setStatus(PayStatus.TO_BE_PAID);
        cfOrderQuery.setMinCreateTime(System.currentTimeMillis()- PayConfig.ORDER_EXPIRATION_TIME);
        List<CfOrder> cfOrders = cfOrderService.getListByQuery(cfOrderQuery);
        CfOrder cfOrder = null;
        if(cfOrders==null || cfOrders.size()==0){
            cfOrder = new CfOrder();
            cfOrder.setId(idWorker.nextId());
            cfOrder.setRandomId(idWorker.nextId());
            cfOrder.setGoodsImage(cfCarParkPackagePrice.getImage());
            cfOrder.setGoodsId(cfCarParkPackagePriceId);
            cfOrder.setGoodsName(cfCarParkPackagePrice.getTitle()+"【套餐购买】"+numberPlate);
            cfOrder.setUid(uid);
            cfOrder.setShopId(cfCarParkPackagePrice.getCarParkId());
            cfOrder.setStatus((byte)0);
            cfOrder.setGoodsType(GoodsType.CARPARK_PAYMENT_PACKEAGE);
            if(cfCarParkOrder!=null && cfCarParkOrder.getCfOrder()!=null && cfCarParkOrder.getCfOrder().getPayTime()==0){
                cfOrder.setAmountsPayable(cfCarParkPackagePrice.getCurrentPrice().add(cfCarParkOrder.getCfOrder().getAmountsPayable()));
                cfOrder.setGoodsName(cfCarParkPackagePrice.getTitle()+"【套餐续费+车费补缴】"+numberPlate);
                cfOrder.setCollectionAmount(cfCarParkOrder.getCfOrder().getAmountsPayable());
                //找到停车账单，标记该账单已被套餐账单代缴
                CfOrder parkOrder = new CfOrder();
                parkOrder.setId(cfCarParkOrder.getCfOrder().getId());
                parkOrder.setCollectionOrderId(cfOrder.getId());
                cfOrderService.updateByPrimaryKeySelective(parkOrder);
            }else{
                cfOrder.setAmountsPayable(cfCarParkPackagePrice.getCurrentPrice());
            }
            cfOrder.setPaymentAgencyShortName(cfUserPaymentAgency.getPaymentAgencyShortName());
            cfOrder.setCreateTime(System.currentTimeMillis());
            cfOrder.setEffectObject(numberPlate);
            cfOrder.setUserPaymentAgencyId(payTypeId);
            cfOrder.setAmountActuallyPaid(new BigDecimal(0.00));
            cfOrder = cfOrderService.add(cfOrder);
        }else{
            cfOrder = cfOrders.get(0);
            cfOrder.setUserPaymentAgencyId(payTypeId);
            if(cfCarParkOrder!=null && cfCarParkOrder.getCfOrder()!=null && cfCarParkOrder.getCfOrder().getPayTime()==0){
                cfOrder.setAmountsPayable(cfCarParkPackagePrice.getCurrentPrice().add(cfCarParkOrder.getCfOrder().getAmountsPayable()));
                cfOrder.setGoodsName(cfCarParkPackagePrice.getTitle()+"【套餐续费+车费补缴】"+numberPlate);
                cfOrder.setCollectionAmount(cfCarParkOrder.getCfOrder().getAmountsPayable());
                //找到停车账单，标记该账单已被套餐账单代缴
                CfOrder parkOrder = new CfOrder();
                parkOrder.setId(cfCarParkOrder.getCfOrder().getId());
                parkOrder.setCollectionOrderId(cfOrder.getId());
                cfOrderService.updateByPrimaryKeySelective(parkOrder);
            }
        }
        return cfOrderService.payForOrder(cfOrder, payTypeId, ip);
    }

    @Override
    public CfCarParkOrder queryCfCarParkPackageRecoverFee(CfCarParkPackagePrice cfCarParkPackagePrice, String uid, String numberPlate) throws Exception {
        CfCarParkOrder cfCarParkOrder = null;

        //如果车辆对应的套餐已经过期
        CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
        if(cfCarParkPackageQuery.getUid()!=null){
            cfCarParkPackageQuery.setUid(uid);
        }
        cfCarParkPackageQuery.setPackagePriceId(cfCarParkPackagePrice.getId());
        cfCarParkPackageQuery.setNumberPlate(numberPlate);
        cfCarParkPackageQuery.setOrderBy("end_time desc");
        List<CfCarParkPackage> cfCarParkPackages = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
        if(cfCarParkPackages!=null && cfCarParkPackages.size()>0 && cfCarParkPackages.get(0).getEndTime()<System.currentTimeMillis()){
            List<String> carParkIdList = new ArrayList<>();
            carParkIdList.add(cfCarParkPackages.get(0).getCarParkId());
            //找到该套餐的所有跨区车场
            cfCarParkPackageQuery.setUid(null);
            cfCarParkPackageQuery.setPackagePriceId(null);
            cfCarParkPackageQuery.setNumberPlate(null);
            cfCarParkPackageQuery.setOrderBy(null);
            cfCarParkPackageQuery.setParentId(cfCarParkPackages.get(0).getId());
            List<CfCarParkPackage> childCfCarParkPackageList = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
            if(childCfCarParkPackageList!=null && childCfCarParkPackageList.size()>0){
                for (CfCarParkPackage childCfCarParkPackage: childCfCarParkPackageList){
                    carParkIdList.add(childCfCarParkPackage.getCarParkId());
                }
            }
            //判断该车辆是否还有未出场的停车记录
            CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
            cfCarParkUseLogQuery.setCarParkIds(carParkIdList);
            cfCarParkUseLogQuery.setNumberPlate(numberPlate);
            cfCarParkUseLogQuery.setPage(1);
            cfCarParkUseLogQuery.setSize(1);
            cfCarParkUseLogQuery.setOrderBy("in_time desc");
            List<CfCarParkUseLog> cfCarParkUseLogList = cfCarParkUseLogService.getListByQuery(cfCarParkUseLogQuery);
            if(cfCarParkUseLogList!=null && cfCarParkUseLogList.size()>0){
                if(cfCarParkUseLogList.get(0).getPayTime()==0){
                    //说明正在续费过期套餐时，该车辆存在临停费
                    if(cfCarParkPackagePrice.getGracePeriod()+cfCarParkPackages.get(0).getEndTime()<System.currentTimeMillis()){
                        try {
                            cfCarParkUseLogList.get(0).setUid(uid);
                            cfCarParkOrder = cfCarParkChargingRulesService.calculateTheAmounPayable(cfCarParkUseLogList.get(0), uid, FeeQueryMode.QUERY_MODE_QUERY_ONLY);
                        } catch (CustomException e){
                            if(e.getResultCode().code()!=12006){
                                throw e;
                            }
                        }

                    }
                }
            }
        }
        return cfCarParkOrder;
    }

    @Override
    public CfCarParkPackagePrice findById(String id) {
        return cfCarParkPackagePriceMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCarParkPackagePrice findById(String id, boolean expectEmpty) {
        CfCarParkPackagePrice cfCarParkPackagePrice = findById(id);
        if(!expectEmpty && cfCarParkPackagePrice==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }else if(expectEmpty && cfCarParkPackagePrice!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        return cfCarParkPackagePrice;
    }

    @Override
    public List<CfCarParkPackagePrice> selectPackagePriceListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT cppp.*,cp.name carpark_name,cpct.name car_type_name " +
                "FROM cf_car_park_package_price cppp " +
                "LEFT JOIN cf_car_park cp ON(cppp.car_park_id=cp.id) " +
                "LEFT JOIN cf_car_park_car_type cpct ON(cpct.flag_key=cppp.flag_key)";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCarParkPackagePriceMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectPackagePriceListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_car_park_package_price cppp";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCarParkPackagePriceMapper.selectListByConditionCounts(sql);
    }

    @Override
    public CfCarParkPackagePrice findByIdContainName(String id) {
        return cfCarParkPackagePriceMapper.findByIdContainName(id);
    }
}
