package com.cf.carpark.service.impl;

import com.alibaba.fastjson.JSON;
import com.cf.carpark.dao.mapper.CfCarParkPackageMapper;
import com.cf.carpark.dao.mapper.CfCarParkPackagePriceMapper;
import com.cf.carpark.domain.*;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.CfCarParkDeviceQuery;
import com.cf.carpark.domain.request.CfCarParkPackageLogQuery;
import com.cf.carpark.domain.request.CfCarParkPackageQuery;
import com.cf.carpark.domain.request.CfCarParkSpecialCarQuery;
import com.cf.carpark.service.*;
import com.cf.carpark.service.core.cache.ClientCache;
import com.cf.carpark.service.core.dto.ClientDTO;
import com.cf.framework.domain.charging.response.ChargingCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.CfOrderService;
import com.cf.ucenter.domain.CfRole;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.service.CfUserService;
import com.github.pagehelper.PageHelper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @ClassName CfCarParkPackageServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/23/023 18:59
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkPackageServiceImpl implements CfCarParkPackageService, ApplicationContextAware {

    @Autowired
    CfCarParkPackageMapper cfCarParkPackageMapper;
    @Autowired
    CfCarParkPackagePriceMapper cfCarParkPackagePriceMapper;
    @Autowired
    IdWorker idWorker;
    @Autowired
    private CfCarParkPackageLogService cfCarParkPackageLogService;
    @Autowired
    private CfCarParkPackagePriceService cfCarParkPackagePriceService;
    @Autowired
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Autowired
    private CfCarParkSpecialCarService cfCarParkSpecialCarService;
    @Autowired
    private CfCarParkDeviceService cfCarParkDeviceService;
    @Autowired
    private IMqttDataService iMqttDataService;
    @Autowired
    private CfCarParkReleaseLogService cfCarParkReleaseLogService;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfOrderService cfOrderService;

    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext _applicationContext) throws BeansException {
        applicationContext = _applicationContext;
    }

    @Override
    public CfCarParkPackage add(CfCarParkPackage cfCarParkPackage) {
        if(StringUtils.isEmpty(cfCarParkPackage.getId()) || cfCarParkPackage.getId().length()<17){
            cfCarParkPackage.setId(idWorker.nextId());
        }
        cfCarParkPackage.setCreateTime(System.currentTimeMillis());
        handleUidByPhone(cfCarParkPackage);
        if(cfCarParkPackage.getTransRegional()==(byte)0){
            cfCarParkPackage.setMainCarParkId(cfCarParkPackage.getCarParkId());
        }
        CfCarParkPackagePrice cfCarParkPackagePrice = cfCarParkPackagePriceService.findById(cfCarParkPackage.getPackagePriceId(), false);
        if(cfCarParkPackagePrice.getSpecialCarPackage()==(byte)1){
            cfCarParkPackage.setSpecialCarId(idWorker.nextId());
        }
        cfCarParkPackageMapper.insertSelective(cfCarParkPackage);

        if(cfCarParkPackagePrice.getSpecialCarPackage()==(byte)1){
            //如果其带有特殊车辆id，先删除对应停车场该车辆的特殊车辆，再新增对应特殊车辆
            CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery = new CfCarParkSpecialCarQuery();
            cfCarParkSpecialCarQuery.setCarParkId(cfCarParkPackage.getCarParkId());
            cfCarParkSpecialCarQuery.setNumberPlate(cfCarParkPackage.getNumberPlate());
            cfCarParkSpecialCarService.deleteByQuery(cfCarParkSpecialCarQuery);

            CfCarParkSpecialCar cfCarParkSpecialCar = new CfCarParkSpecialCar();
            cfCarParkSpecialCar.setId(cfCarParkPackage.getSpecialCarId());
            cfCarParkSpecialCar.setCarParkId(cfCarParkPackage.getCarParkId());
            cfCarParkSpecialCar.setTypeKey(cfCarParkPackage.getTypeKey());
            cfCarParkSpecialCar.setStartTime(cfCarParkPackage.getStartTime());
            cfCarParkSpecialCar.setEndTime(cfCarParkPackage.getEndTime());
            cfCarParkSpecialCar.setCreateTime(cfCarParkPackage.getCreateTime());
            cfCarParkSpecialCar.setUid(cfCarParkPackage.getUid());
            cfCarParkSpecialCar.setNumberPlate(cfCarParkPackage.getNumberPlate());
            cfCarParkSpecialCar.setPhone(cfCarParkPackage.getPhone());
            cfCarParkSpecialCar.setRemarks(cfCarParkPackage.getRemarks());
            cfCarParkSpecialCar.setCarOwnerName(cfCarParkPackage.getCarOwnerName());
            cfCarParkSpecialCar.setGroupFlag(cfCarParkPackage.getGroupFlag());
            cfCarParkSpecialCar.setStatus(cfCarParkPackage.getStatus());
            cfCarParkSpecialCarService.add(cfCarParkSpecialCar);
        }

        handleParentId(cfCarParkPackage);
        updateGroupFlagTime(cfCarParkPackage);
        return cfCarParkPackage;
    }

    @Override
    public CfCarParkPackage artificialAdd(CfCarParkPackage cfCarParkPackage, String handleUid) throws Exception {
        cfCarParkPackage.setId(idWorker.nextId());
        recordArtificialActionFee("add", null, cfCarParkPackage, handleUid);
        CfCarParkPackage carParkPackage = add(cfCarParkPackage);
        return carParkPackage;
    }

    @Override
    public CfCarParkPackage update(CfCarParkPackage cfCarParkPackage) {
        handleUidByPhone(cfCarParkPackage);
        if(cfCarParkPackage.getTransRegional()==(byte)0){
            cfCarParkPackage.setMainCarParkId(cfCarParkPackage.getCarParkId());
        }
        cfCarParkPackage.setIssuedWhitelist((byte)0);
        cfCarParkPackage.setIssuedWhitelistTime(0l);
        CfCarParkPackagePrice cfCarParkPackagePrice = cfCarParkPackagePriceService.findById(cfCarParkPackage.getPackagePriceId(), false);
        if(cfCarParkPackagePrice.getSpecialCarPackage()==(byte)1){
            cfCarParkPackage.setSpecialCarId(idWorker.nextId());
        }
        cfCarParkPackageMapper.updateByPrimaryKeySelective(cfCarParkPackage);

        if(cfCarParkPackagePrice.getSpecialCarPackage()==(byte)1){
            //如果其带有特殊车辆id，先删除对应停车场该车辆的特殊车辆，再新增对应特殊车辆
            CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery = new CfCarParkSpecialCarQuery();
            cfCarParkSpecialCarQuery.setCarParkId(cfCarParkPackage.getCarParkId());
            cfCarParkSpecialCarQuery.setNumberPlate(cfCarParkPackage.getNumberPlate());
            cfCarParkSpecialCarService.deleteByQuery(cfCarParkSpecialCarQuery);

            CfCarParkSpecialCar cfCarParkSpecialCar = new CfCarParkSpecialCar();
            cfCarParkSpecialCar.setId(cfCarParkPackage.getSpecialCarId());
            cfCarParkSpecialCar.setCarParkId(cfCarParkPackage.getCarParkId());
            cfCarParkSpecialCar.setTypeKey(cfCarParkPackage.getTypeKey());
            cfCarParkSpecialCar.setStartTime(cfCarParkPackage.getStartTime());
            cfCarParkSpecialCar.setEndTime(cfCarParkPackage.getEndTime());
            cfCarParkSpecialCar.setCreateTime(cfCarParkPackage.getCreateTime());
            cfCarParkSpecialCar.setUid(cfCarParkPackage.getUid());
            cfCarParkSpecialCar.setNumberPlate(cfCarParkPackage.getNumberPlate());
            cfCarParkSpecialCar.setPhone(cfCarParkPackage.getPhone());
            cfCarParkSpecialCar.setRemarks(cfCarParkPackage.getRemarks());
            cfCarParkSpecialCar.setCarOwnerName(cfCarParkPackage.getCarOwnerName());
            cfCarParkSpecialCar.setGroupFlag(cfCarParkPackage.getGroupFlag());
            cfCarParkSpecialCar.setStatus(cfCarParkPackage.getStatus());
            cfCarParkSpecialCarService.add(cfCarParkSpecialCar);
        }

        handleParentId(cfCarParkPackage);
        updateGroupFlagTime(cfCarParkPackage);
        return cfCarParkPackage;
    }

    @Override
    public CfCarParkPackage onlyUpdate(CfCarParkPackage cfCarParkPackage) {
        cfCarParkPackageMapper.updateByPrimaryKeySelective(cfCarParkPackage);
        return cfCarParkPackage;
    }

    @Override
    public CfCarParkPackage artificialUpdate(CfCarParkPackage cfCarParkPackage, String handleUid) throws Exception {
        CfCarParkPackage oldCarParkPackage = findById(cfCarParkPackage.getId(), false);
        recordArtificialActionFee("update", oldCarParkPackage, cfCarParkPackage, handleUid);
        //设置是否已经短信通知字段值为 0
        cfCarParkPackage.setNoticeExpiringSoon((byte)0);
        cfCarParkPackage.setNoticeExpired((byte)0);
        cfCarParkPackage = update(cfCarParkPackage);
        return cfCarParkPackage;
    }

    @Override
    public void handleParentId(CfCarParkPackage cfCarParkPackage) {
        if(cfCarParkPackage.getTransRegional()==0 && StringUtils.isNotEmpty(cfCarParkPackage.getCarParkIds())){
            CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
            cfCarParkPackageQuery.setParentId(cfCarParkPackage.getId());

            //如果为特殊车辆套餐，删除原有特殊车辆
            List<String> oldCarParkIds = new ArrayList<>();
            if(StringUtils.isNotEmpty(cfCarParkPackage.getSpecialCarId())){
                //找到原来关联的所有停车场id
                List<CfCarParkPackage> cfCarParkPackages = getListByQuery(cfCarParkPackageQuery);
                if(cfCarParkPackages!=null && cfCarParkPackages.size()>0){
                    for (CfCarParkPackage carParkPackage: cfCarParkPackages){
                        if(StringUtils.isNotEmpty(carParkPackage.getSpecialCarId())){
                            oldCarParkIds.add(carParkPackage.getCarParkId());
                        }
                    }
                }
            }
            if(oldCarParkIds.size()>0){
                CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery = new CfCarParkSpecialCarQuery();
                cfCarParkSpecialCarQuery.setCarParkIds(oldCarParkIds);
                cfCarParkSpecialCarQuery.setNumberPlate(cfCarParkPackage.getNumberPlate());
                cfCarParkSpecialCarService.deleteByQuery(cfCarParkSpecialCarQuery);
            }

            //删除其所有子数据
            cfCarParkPackageMapper.deleteByExample(getExampleByQuery(cfCarParkPackageQuery));

            String[] carParkIds = cfCarParkPackage.getCarParkIds().split(",");
            String batchAddSQL = "insert into cf_car_park_package (id, car_park_id, type_key, \n" +
                    "      start_time, end_time, create_time, \n" +
                    "      uid, number_plate, special_give, \n" +
                    "      package_price_id, trans_regional, parent_id, \n" +
                    "      phone, main_car_park_id, remarks, car_owner_name, group_flag, special_car_id)\n" +
                    "    values ";
            List<CfCarParkSpecialCar> cfCarParkSpecialCarList = new ArrayList<>();
            String carParkSpecialCarId = "";
            for(String carParkId: carParkIds){

                if(StringUtils.isNotEmpty(cfCarParkPackage.getSpecialCarId())){
                    carParkSpecialCarId = idWorker.nextId();
                    CfCarParkSpecialCar cfCarParkSpecialCar = new CfCarParkSpecialCar();
                    cfCarParkSpecialCar.setId(carParkSpecialCarId);
                    cfCarParkSpecialCar.setCarParkId(carParkId);
                    cfCarParkSpecialCar.setTypeKey(cfCarParkPackage.getTypeKey());
                    cfCarParkSpecialCar.setStartTime(cfCarParkPackage.getStartTime());
                    cfCarParkSpecialCar.setEndTime(cfCarParkPackage.getEndTime());
                    cfCarParkSpecialCar.setCreateTime(cfCarParkPackage.getCreateTime());
                    cfCarParkSpecialCar.setUid(cfCarParkPackage.getUid());
                    cfCarParkSpecialCar.setNumberPlate(cfCarParkPackage.getNumberPlate());
                    cfCarParkSpecialCar.setPhone(cfCarParkPackage.getPhone());
                    cfCarParkSpecialCar.setRemarks(cfCarParkPackage.getRemarks());
                    cfCarParkSpecialCar.setCarOwnerName(cfCarParkPackage.getCarOwnerName());
                    cfCarParkSpecialCar.setGroupFlag(cfCarParkPackage.getGroupFlag());
                    cfCarParkSpecialCar.setStatus(cfCarParkPackage.getStatus());
                    //查询主套餐的特殊车辆
                    CfCarParkSpecialCar carParkSpecialCar = cfCarParkSpecialCarService.findById(cfCarParkPackage.getSpecialCarId());
                    if(carParkSpecialCar!=null){
                        cfCarParkSpecialCar.setRemainingParkTime(carParkSpecialCar.getRemainingParkTime());
                        cfCarParkSpecialCar.setAutoGiveAway(carParkSpecialCar.getAutoGiveAway());
                        cfCarParkSpecialCar.setAutoCleared(carParkSpecialCar.getAutoCleared());
                        cfCarParkSpecialCar.setAutoGiveAwayDate(carParkSpecialCar.getAutoGiveAwayDate());
                        cfCarParkSpecialCar.setAutoGiveAwayAmount(carParkSpecialCar.getAutoGiveAwayAmount());
                        cfCarParkSpecialCar.setAutoGiveAwayTime(carParkSpecialCar.getAutoGiveAwayTime());

                        cfCarParkSpecialCarList.add(cfCarParkSpecialCar);
                    }
                }
                batchAddSQL += "('"+idWorker.nextId()+"','"+carParkId+"','"+cfCarParkPackage.getTypeKey()+"','"+cfCarParkPackage.getStartTime()
                        +"','"+cfCarParkPackage.getEndTime()+"','"+cfCarParkPackage.getCreateTime()+"','"+cfCarParkPackage.getUid()
                        +"','"+cfCarParkPackage.getNumberPlate()+"','"+cfCarParkPackage.getSpecialGive()+"','"+cfCarParkPackage.getPackagePriceId()
                        +"','1','"+cfCarParkPackage.getId()+"','"+cfCarParkPackage.getPhone()+"','"+cfCarParkPackage.getCarParkId()+"',+'"+cfCarParkPackage.getRemarks()
                        +"','"+cfCarParkPackage.getCarOwnerName()+"','"+cfCarParkPackage.getGroupFlag()+"','"+carParkSpecialCarId+"'),";
            }
            batchAddSQL = batchAddSQL.substring(0, batchAddSQL.length()-1);
            cfCarParkPackageMapper.batchAdd(batchAddSQL);

            if(cfCarParkSpecialCarList.size()>0){
                //批量新增特殊车辆
                cfCarParkSpecialCarService.batchAdd(cfCarParkSpecialCarList);
            }
        }
    }

    @Override
    public CfCarParkPackage handleUidByPhone(CfCarParkPackage cfCarParkPackage) {
        if(StringUtils.isNotEmpty(cfCarParkPackage.getPhone())){
            CfUser cfUser = cfUserService.findByPhone(cfCarParkPackage.getPhone());
            if(cfUser!=null){
                cfCarParkPackage.setUid(cfUser.getId());
                //如果传入的有车主姓名，将姓名更到对应的用户真实名字字段
                if(StringUtils.isNotEmpty(cfCarParkPackage.getCarOwnerName())){
                    cfUser.setTrueName(cfCarParkPackage.getCarOwnerName());
                    cfUserService.update(cfUser);
                }
            }
        }
        if(cfCarParkPackage.getParentId()==null){
            cfCarParkPackage.setParentId("");
        }
        return cfCarParkPackage;
    }

    /**
     * 记录人工新增和续费 套餐车俩的费用
     * @param actionType
     * @param oldData
     * @param nowData
     */
    private CfOrder recordArtificialActionFee(String actionType, CfCarParkPackage oldData, CfCarParkPackage nowData, String handleUid) throws Exception {
        CfCarParkPackagePrice cfCarParkPackagePrice = cfCarParkPackagePriceMapper.selectByPrimaryKey(nowData.getPackagePriceId());
        if(cfCarParkPackagePrice==null){
            return null;
        }

        CfCarParkOrder cfCarParkOrder = null;
        try {
            cfCarParkOrder = cfCarParkPackagePriceService.queryCfCarParkPackageRecoverFee(cfCarParkPackagePrice, null, nowData.getNumberPlate());
        } catch (Exception e){

        }

        CfOrder cfOrder = new CfOrder();

        cfOrder.setId(idWorker.nextId());
        cfOrder.setGoodsId(nowData.getPackagePriceId());
        cfOrder.setGoodsImage(cfCarParkPackagePrice.getImage());
        cfOrder.setGoodsType(GoodsType.CARPARK_PAYMENT_PACKEAGE);
        cfOrder.setShopId(nowData.getCarParkId());
        cfOrder.setPaymentAgencyShortName("cash_pay_cny");
        cfOrder.setEffectObject(nowData.getNumberPlate());
        cfOrder.setPayTime(System.currentTimeMillis());
        cfOrder.setStatus(PayStatus.PAID);
        Long totalTIme = 0l;
        BigDecimal price = cfCarParkPackagePrice.getCurrentPrice().doubleValue()>0?cfCarParkPackagePrice.getCurrentPrice():cfCarParkPackagePrice.getOriginalPrice();
        if(actionType.equals("add")){
            cfOrder.setGoodsName("【"+nowData.getNumberPlate()+"】现金购买车辆套餐");
            if(nowData.getQuantity()!=null && nowData.getQuantity()>0){
                cfOrder.setPurchaseQuantity(nowData.getQuantity());
                cfOrder.setAmountsPayable(new BigDecimal(nowData.getQuantity()*price.doubleValue()));
                //判断是否为月卡
                if(cfCarParkPackagePrice.getTimeQuota().longValue()>2419199000l && cfCarParkPackagePrice.getTimeQuota().longValue()<=2678400000l){
                    Calendar calendar = Calendar.getInstance();
                    Date date = new Date(oldData.getEndTime());
                    calendar.setTime(date);
                    calendar.add(Calendar.MONTH, nowData.getQuantity().intValue());//增加N个⽉
                    nowData.setEndTime(calendar.getTimeInMillis());
                }else{
                    //按固定时间倍数增加
                    nowData.setEndTime(nowData.getQuantity().longValue()*cfCarParkPackagePrice.getTimeQuota().longValue());
                }

            }else{
                totalTIme = nowData.getEndTime()-nowData.getStartTime();
                BigDecimal number = new BigDecimal(new Double(totalTIme) / cfCarParkPackagePrice.getTimeQuota()).setScale(2, RoundingMode.HALF_UP);
                cfOrder.setPurchaseQuantity(number.intValue());
                cfOrder.setAmountsPayable(new BigDecimal(number.doubleValue()*price.doubleValue()));
            }
        }else{
            cfOrder.setGoodsName("【"+nowData.getNumberPlate()+"】现金续费车辆套餐");
            if(nowData.getQuantity()!=null && nowData.getQuantity()>0){
                cfOrder.setPurchaseQuantity(nowData.getQuantity());
                cfOrder.setAmountsPayable(new BigDecimal(nowData.getQuantity()*price.doubleValue()));
            }else{
                totalTIme = nowData.getEndTime()-oldData.getEndTime();
                BigDecimal number = new BigDecimal(new Double(totalTIme) / cfCarParkPackagePrice.getTimeQuota()).setScale(2, RoundingMode.HALF_UP);
                cfOrder.setPurchaseQuantity(number.intValue());
                cfOrder.setAmountsPayable(new BigDecimal(number.doubleValue()*price.doubleValue()));
            }

            //新增套餐修改记录
            CfCarParkPackageLog cfCarParkPackageLog = new CfCarParkPackageLog();
            cfCarParkPackageLog.setPackageId(nowData.getId());
            cfCarParkPackageLog.setActionTime(System.currentTimeMillis());
            cfCarParkPackageLog.setBeforeCarParkId(oldData.getCarParkId());
            cfCarParkPackageLog.setAfterCarParkId(nowData.getCarParkId());
            cfCarParkPackageLog.setBeforeTypeKey(oldData.getTypeKey());
            cfCarParkPackageLog.setAfterTypeKey(nowData.getTypeKey());
            cfCarParkPackageLog.setBeforeStartTime(oldData.getStartTime());
            cfCarParkPackageLog.setAfterStartTime(nowData.getStartTime());
            cfCarParkPackageLog.setBeforeEndTime(oldData.getEndTime());
            cfCarParkPackageLog.setAfterEndTime(nowData.getEndTime());
            cfCarParkPackageLog.setBeforeCreateTime(oldData.getCreateTime());
            cfCarParkPackageLog.setAfterCreateTime(nowData.getCreateTime());
            cfCarParkPackageLog.setBeforeUid(oldData.getUid());
            cfCarParkPackageLog.setAfterUid(nowData.getUid());
            cfCarParkPackageLog.setBeforeNumberPlate(oldData.getNumberPlate());
            cfCarParkPackageLog.setAfterNumberPlate(nowData.getNumberPlate());
            cfCarParkPackageLog.setBeforeSpecialGive(oldData.getSpecialGive());
            cfCarParkPackageLog.setAfterSpecialGive(nowData.getSpecialGive());
            cfCarParkPackageLog.setBeforePackagePriceId(oldData.getPackagePriceId());
            cfCarParkPackageLog.setAfterPackagePriceId(nowData.getPackagePriceId());
            cfCarParkPackageLog.setBeforeTransRegional(oldData.getTransRegional());
            cfCarParkPackageLog.setAfterTransRegional(nowData.getTransRegional());
            cfCarParkPackageLog.setBeforeParentId(oldData.getParentId());
            cfCarParkPackageLog.setAfterParentId(nowData.getParentId());
            cfCarParkPackageLog.setBeforePhone(oldData.getPhone());
            cfCarParkPackageLog.setAfterPhone(nowData.getPhone());
            cfCarParkPackageLog.setBeforeMainCarParkId(oldData.getMainCarParkId());
            cfCarParkPackageLog.setAfterMainCarParkId(nowData.getMainCarParkId());
            cfCarParkPackageLog.setBeforeRemarks(oldData.getRemarks());
            cfCarParkPackageLog.setAfterRemarks(nowData.getRemarks());
            cfCarParkPackageLog.setBeforeCarOwnerName(oldData.getCarOwnerName());
            cfCarParkPackageLog.setAfterCarOwnerName(nowData.getCarOwnerName());
            cfCarParkPackageLog.setBeforeGroupFlag(oldData.getGroupFlag());
            cfCarParkPackageLog.setAfterGroupFlag(nowData.getGroupFlag());
            cfCarParkPackageLog.setBeforeStatus(oldData.getStatus());
            cfCarParkPackageLog.setAfterStatus(nowData.getStatus());
            cfCarParkPackageLog.setHandleUid(handleUid);
            cfCarParkPackageLogService.add(cfCarParkPackageLog);
        }

        if(totalTIme<=0 && (nowData.getQuantity()==null || nowData.getQuantity()==0)){
            return null;
        }

        if(cfCarParkOrder!=null && cfCarParkOrder.getCfOrder()!=null && cfCarParkOrder.getCfOrder().getPayTime()==0){
            BigDecimal amountsPayable = cfOrder.getAmountsPayable();
            cfOrder.setAmountsPayable(amountsPayable.add(cfCarParkOrder.getCfOrder().getAmountsPayable()));
            cfOrder.setAmountActuallyPaid(cfOrder.getAmountsPayable());
            //标记相关停车记录已结束
            CfCarParkUseLog cfCarParkUseLog = cfCarParkOrder.getCfCarParkUseLog();
            CfCarParkUseLog updateCfCarParkUseLog = new CfCarParkUseLog();
            updateCfCarParkUseLog.setId(cfCarParkUseLog.getId());
            updateCfCarParkUseLog.setPayTime(System.currentTimeMillis());
            cfCarParkUseLogService.updateByPrimaryKeySelective(updateCfCarParkUseLog);
            //找到停车账单，标记该账单已被套餐账单代缴
            cfOrder.setGoodsName(cfCarParkPackagePrice.getTitle()+"【套餐续费+车费补缴】"+cfCarParkUseLog.getNumberPlate());
            cfOrder.setCollectionAmount(cfCarParkOrder.getCfOrder().getAmountsPayable());
            CfOrder parkOrder = new CfOrder();
            parkOrder.setId(cfCarParkOrder.getCfOrder().getId());
            parkOrder.setCollectionOrderId(cfOrder.getId());
            parkOrder.setPayTime(System.currentTimeMillis());
            parkOrder.setStatus(PayStatus.PAID);
            parkOrder.setPaymentAgencyShortName("cash_pay_cny");
            cfOrderService.updateByPrimaryKeySelective(parkOrder);
        }else{
            cfOrder.setAmountActuallyPaid(cfOrder.getAmountsPayable());
        }

        cfOrder.setRandomId(idWorker.nextId());
        //如果当前用户为admin用户，则不记录财务入账记录
        boolean isAdmin = false;
        CfUser cfUser = cfUserService.getUserByUid(handleUid, true);
        if(cfUser.getCfRoles()!=null && cfUser.getCfRoles().size()>0){
            List<CfRole> cfRoles = cfUser.getCfRoles();
            for (CfRole cfRole: cfRoles){
                if(cfRole.getFlagKey().equals("admin")){
                    isAdmin = true;
                    break;
                }
            }
        }
        if(isAdmin){
            return null;
        }
        CfOrder order = cfOrderService.add(cfOrder);
        //存在停车记录，结束该停车和相关账单

        return order;
    }

    @Override
    public CfCarParkPackageExample getExampleByQuery(CfCarParkPackageQuery cfCarParkPackageQuery) {
        CfCarParkPackageExample cfCarParkPackageExample = new CfCarParkPackageExample();
        CfCarParkPackageExample.Criteria criteria = cfCarParkPackageExample.createCriteria();

        if(cfCarParkPackageQuery.getIds()!=null && cfCarParkPackageQuery.getIds().size()>0){
            criteria.andIdIn(cfCarParkPackageQuery.getIds());
        }
        if(StringUtils.isNotEmpty(cfCarParkPackageQuery.getCarParkId())){
            criteria.andCarParkIdEqualTo(cfCarParkPackageQuery.getCarParkId());
        }
        if(StringUtils.isNotEmpty(cfCarParkPackageQuery.getTypeKey())){
            criteria.andTypeKeyEqualTo(cfCarParkPackageQuery.getTypeKey());
        }
        if(cfCarParkPackageQuery.getMinStartTime()!=null){
            criteria.andStartTimeGreaterThanOrEqualTo(cfCarParkPackageQuery.getMinStartTime());
        }
        if(cfCarParkPackageQuery.getMaxStartTime()!=null){
            criteria.andStartTimeLessThanOrEqualTo(cfCarParkPackageQuery.getMaxStartTime());
        }
        if(cfCarParkPackageQuery.getMinEndTime()!=null){
            criteria.andEndTimeGreaterThanOrEqualTo(cfCarParkPackageQuery.getMinEndTime());
        }
        if(cfCarParkPackageQuery.getMaxEndTime()!=null){
            criteria.andEndTimeLessThanOrEqualTo(cfCarParkPackageQuery.getMaxEndTime());
        }
        if(cfCarParkPackageQuery.getSpecialGive()!=null){
            criteria.andSpecialGiveEqualTo(cfCarParkPackageQuery.getSpecialGive());
        }
        if(cfCarParkPackageQuery.getUid()!=null){
            criteria.andUidEqualTo(cfCarParkPackageQuery.getUid());
        }
        if(cfCarParkPackageQuery.getNumberPlate()!=null){
            criteria.andNumberPlateEqualTo(cfCarParkPackageQuery.getNumberPlate());
        }
        if(cfCarParkPackageQuery.getNumberPlates()!=null && cfCarParkPackageQuery.getNumberPlates().size()>0){
            criteria.andNumberPlateIn(cfCarParkPackageQuery.getNumberPlates());
        }
        if(cfCarParkPackageQuery.getNumberPlateNotIn()!=null && cfCarParkPackageQuery.getNumberPlateNotIn().size()>0){
            criteria.andNumberPlateNotIn(cfCarParkPackageQuery.getNumberPlateNotIn());
        }
        if(cfCarParkPackageQuery.getNumberPlateLike()!=null){
            criteria.andNumberPlateLike("%"+cfCarParkPackageQuery.getNumberPlate()+"%");
        }

        if(cfCarParkPackageQuery.getMainCarParkId()!=null){
            criteria.andMainCarParkIdEqualTo(cfCarParkPackageQuery.getMainCarParkId());
        }
        if(cfCarParkPackageQuery.getPackagePriceId()!=null){
            criteria.andPackagePriceIdEqualTo(cfCarParkPackageQuery.getPackagePriceId());
        }
        if(cfCarParkPackageQuery.getPhone()!=null){
            criteria.andPhoneEqualTo(cfCarParkPackageQuery.getPhone());
        }
        if(cfCarParkPackageQuery.getSpecialGive()!=null){
            criteria.andSpecialGiveEqualTo(cfCarParkPackageQuery.getSpecialGive());
        }
        if(cfCarParkPackageQuery.getTransRegional()!=null){
            criteria.andTransRegionalEqualTo(cfCarParkPackageQuery.getTransRegional());
        }
        if(cfCarParkPackageQuery.getParentId()!=null){
            criteria.andParentIdEqualTo(cfCarParkPackageQuery.getParentId());
        }
        if(cfCarParkPackageQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfCarParkPackageQuery.getStatus());
        }
        if(cfCarParkPackageQuery.getMinStatus()!=null){
            criteria.andStatusGreaterThanOrEqualTo(cfCarParkPackageQuery.getMinStatus());
        }
        if(cfCarParkPackageQuery.getGroupFlag()!=null){
            criteria.andGroupFlagEqualTo(cfCarParkPackageQuery.getGroupFlag());
        }
        if(cfCarParkPackageQuery.isGroupFlagNotEmpty()){
            criteria.andGroupFlagNotEqualTo("");
        }
        if(cfCarParkPackageQuery.getCarOwnerName()!=null){
            criteria.andCarOwnerNameEqualTo(cfCarParkPackageQuery.getCarOwnerName());
        }
        if(cfCarParkPackageQuery.getIssuedWhitelist()!=null){
            criteria.andIssuedWhitelistEqualTo(cfCarParkPackageQuery.getIssuedWhitelist());
        }
        if(cfCarParkPackageQuery.getNoticeExpiringSoon()!=null){
            criteria.andNoticeExpiringSoonEqualTo(cfCarParkPackageQuery.getNoticeExpiringSoon());
        }
        if(cfCarParkPackageQuery.getNoticeExpired()!=null){
            criteria.andNoticeExpiredEqualTo(cfCarParkPackageQuery.getNoticeExpired());
        }
        if(StringUtils.isNotEmpty(cfCarParkPackageQuery.getOrderBy())){
            cfCarParkPackageExample.setOrderByClause(cfCarParkPackageQuery.getOrderBy());
        }
        if(cfCarParkPackageQuery.getPage()!=null && cfCarParkPackageQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkPackageQuery.getPage(), cfCarParkPackageQuery.getSize());
        }
        return cfCarParkPackageExample;
    }

    @Override
    public Integer countsByQuery(CfCarParkPackageQuery cfCarParkPackageQuery) {
        cfCarParkPackageQuery.setPage(null);
        return cfCarParkPackageMapper.countByExample(getExampleByQuery(cfCarParkPackageQuery));
    }

    @Override
    public List<CfCarParkPackage> getListByQuery(CfCarParkPackageQuery cfCarParkPackageQuery) {
        return cfCarParkPackageMapper.selectByExample(getExampleByQuery(cfCarParkPackageQuery));
    }

    @Override
    public List<CfCarParkPackage> selectByQuery(CfCarParkPackageQuery cfCarParkPackageQuery) {
        if(StringUtils.isNotEmpty(cfCarParkPackageQuery.getNumberPlate())){
            cfCarParkPackageQuery.setNumberPlate("%"+cfCarParkPackageQuery.getNumberPlate()+"%");
        }
        return cfCarParkPackageMapper.selectByQuery(cfCarParkPackageQuery);
    }

    @Override
    public List<CfCarParkPackage> getListByQueryContainCarParkName(CfCarParkPackageQuery cfCarParkPackageQuery) {
        return cfCarParkPackageMapper.selectByExampleContainCarParkName(getExampleByQuery(cfCarParkPackageQuery));
    }

    @Override
    public Integer updateByQuery(CfCarParkPackageQuery cfCarParkPackageQuery, CfCarParkPackage cfCarParkPackage) {
        return cfCarParkPackageMapper.updateByExampleSelective(cfCarParkPackage, getExampleByQuery(cfCarParkPackageQuery));
    }

    @Override
    public Integer delete(String id) throws Exception {
        CfCarParkPackage cfCarParkPackage = findById(id, false);
        int i = cfCarParkPackageMapper.deleteByPrimaryKey(id);
        ArrayList<CfCarParkPackage> cfCarParkPackageArrayList = new ArrayList<>();
        cfCarParkPackageArrayList.add(cfCarParkPackage);
        if(cfCarParkPackage.getIssuedWhitelist()==(byte)1){
            synchronizePackageDataToDevice((byte)1, cfCarParkPackageArrayList);
        }
        //如果该套餐不是跨区套餐，删除其跨区套餐
        if(StringUtils.isEmpty(cfCarParkPackage.getParentId())){
            CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
            cfCarParkPackageQuery.setParentId(id);

            //如果该套擦为特殊车辆套餐，删除其子套餐对应停车场的特殊车辆数据
            List<String> oldCarParkIds = new ArrayList<>();
            if(StringUtils.isNotEmpty(cfCarParkPackage.getSpecialCarId())){
                //找到原来关联的所有停车场id
                List<CfCarParkPackage> cfCarParkPackages = getListByQuery(cfCarParkPackageQuery);
                if(cfCarParkPackages!=null && cfCarParkPackages.size()>0){
                    for (CfCarParkPackage carParkPackage: cfCarParkPackages){
                        if(StringUtils.isNotEmpty(carParkPackage.getSpecialCarId())){
                            oldCarParkIds.add(carParkPackage.getCarParkId());
                        }
                    }
                }
            }
            if(oldCarParkIds.size()>0){
                CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery = new CfCarParkSpecialCarQuery();
                cfCarParkSpecialCarQuery.setCarParkIds(oldCarParkIds);
                cfCarParkSpecialCarQuery.setNumberPlate(cfCarParkPackage.getNumberPlate());
                cfCarParkSpecialCarService.deleteByQuery(cfCarParkSpecialCarQuery);
            }

            deleteByQuery(cfCarParkPackageQuery);
        }
        //如果该套擦为特殊车辆套餐，删除其对应停车场的特殊车辆数据
        if(StringUtils.isEmpty(cfCarParkPackage.getSpecialCarId())){
            CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery = new CfCarParkSpecialCarQuery();
            cfCarParkSpecialCarQuery.setCarParkId(cfCarParkPackage.getCarParkId());
            cfCarParkSpecialCarQuery.setNumberPlate(cfCarParkPackage.getNumberPlate());
            cfCarParkSpecialCarService.deleteByQuery(cfCarParkSpecialCarQuery);
        }
        return i;
    }

    @Override
    public Integer deleteByQuery(CfCarParkPackageQuery cfCarParkPackageQuery) throws Exception {
        int delete = cfCarParkPackageMapper.deleteByExample(getExampleByQuery(cfCarParkPackageQuery));
        cfCarParkPackageQuery.setIssuedWhitelist((byte)1);
        List<CfCarParkPackage> cfCarParkPackageList = getListByQuery(cfCarParkPackageQuery);
        if(cfCarParkPackageList!=null && cfCarParkPackageList.size()>0){
            synchronizePackageDataToDevice((byte)1, cfCarParkPackageList);
        }
        return delete;
    }

    @Override
    public CfCarParkPackage findById(String id) {
        return cfCarParkPackageMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCarParkPackage findById(String id, boolean expectEmpty) {
        CfCarParkPackage cfCarParkPackage = findById(id);
        if(expectEmpty && cfCarParkPackage!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }else if(!expectEmpty && cfCarParkPackage==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfCarParkPackage;
    }

    @Override
    public CfCarParkPackage addOrUpdate(CfCarParkPackage cfCarParkPackage) {
        CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
        cfCarParkPackageQuery.setCarParkId(cfCarParkPackage.getCarParkId());
        cfCarParkPackageQuery.setUid(cfCarParkPackage.getUid());
        cfCarParkPackageQuery.setNumberPlate(cfCarParkPackage.getNumberPlate());
        List<CfCarParkPackage> listByQuery = getListByQuery(cfCarParkPackageQuery);
        if(listByQuery!=null && listByQuery.size()>0){
            CfCarParkPackage carParkPackage = listByQuery.get(0);
            carParkPackage.setStartTime(cfCarParkPackage.getStartTime());
            carParkPackage.setEndTime(cfCarParkPackage.getEndTime());
            update(carParkPackage);
            return carParkPackage;
        }
        return add(cfCarParkPackage);
    }

    @Override
    public List<CfCarParkPackage> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT cpp.*,cp.name carpark_name,u.user_name,cppp.title cppp_title,cppp.current_price cppp_current_price " +
                "FROM cf_car_park_package cpp " +
                "LEFT JOIN cf_car_park cp ON(cpp.car_park_id=cp.id) " +
                "LEFT JOIN cf_car_park_package_price cppp ON(cppp.id=cpp.package_price_id) "+
                "LEFT JOIN cf_user u ON(cpp.uid=u.id) ";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCarParkPackageMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_car_park_package cpp";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCarParkPackageMapper.selectListByConditionCounts(sql);
    }

    @Override
    public CfCarParkPackage checkPackeEffectiveness(String numberPlate, String carParkId, String uid) {
        CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
        cfCarParkPackageQuery.setMaxStartTime(System.currentTimeMillis());
        cfCarParkPackageQuery.setMinEndTime(System.currentTimeMillis());
        if(numberPlate.equals("临A88888")){
            cfCarParkPackageQuery.setUid(uid);
        }
        cfCarParkPackageQuery.setNumberPlate(numberPlate);
        cfCarParkPackageQuery.setCarParkId(carParkId);
        cfCarParkPackageQuery.setMinStatus((byte)1);
        List<CfCarParkPackage> cfCarParkPackages = getListByQuery(cfCarParkPackageQuery);
        if(cfCarParkPackages!=null && cfCarParkPackages.size()>0){
            return cfCarParkPackages.get(0);
        }
        return null;
    }

    @Override
    public Integer updateByQuery(CfCarParkPackage cfCarParkPackage, CfCarParkPackageQuery cfCarParkPackageQuery) {
        return cfCarParkPackageMapper.updateByExampleSelective(cfCarParkPackage, getExampleByQuery(cfCarParkPackageQuery));
    }

    @Override
    public Integer batchBindUserByPhone(String uid, String phone) {
        return cfCarParkPackageMapper.batchBindUserByPhone(uid, phone);
    }

    @Override
    public Integer updateGroupFlagTime(CfCarParkPackage cfCarParkPackage) {
        if(StringUtils.isEmpty(cfCarParkPackage.getGroupFlag())){
            return 0;
        }
        CfCarParkPackage updateCarParkPackage = new CfCarParkPackage();
        updateCarParkPackage.setStartTime(cfCarParkPackage.getStartTime());
        updateCarParkPackage.setEndTime(cfCarParkPackage.getEndTime());

        CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
        cfCarParkPackageQuery.setCarParkId(cfCarParkPackage.getCarParkId());
        cfCarParkPackageQuery.setGroupFlag(cfCarParkPackage.getGroupFlag());
        cfCarParkPackageQuery.setMaxEndTime(cfCarParkPackage.getEndTime()-1000);
        Integer integer = countsByQuery(cfCarParkPackageQuery);
        if(integer==0 || integer>20){
            //如果命中条数太多，可能存在风险，暂停同步操作
            return 0;
        }
        return updateByQuery(updateCarParkPackage, cfCarParkPackageQuery);
    }

    public void synchronizePackageDataToDevice(byte operateType, List<CfCarParkPackage> cfCarParkPackages) throws Exception {

        for(CfCarParkPackage cfCarParkPackage: cfCarParkPackages){
            //找到该套餐所有停车场的设备
            CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
            cfCarParkDeviceQuery.setCarParkId(cfCarParkPackage.getCarParkId());
            cfCarParkDeviceQuery.setType((byte)2);
            cfCarParkDeviceQuery.setStatus((byte)1);
            List<CfCarParkDevice> cfCarParkDeviceList = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
            if(cfCarParkDeviceList==null || cfCarParkDeviceList.size()==0){
                continue;
            }
            for (CfCarParkDevice cfCarParkDevice: cfCarParkDeviceList){
                if(!cfCarParkDevice.getLinkMode().equals("mqtt")){
                    continue;
                }
                ArrayList<CfCarParkPackage> carParkPackages = new ArrayList<>();
                carParkPackages.add(cfCarParkPackage);
                //判断是否在本机，在本机直接mqtt与客户端交互，否则动态寻找
                boolean local = false;
                if(ClientCache.channels.size()>0){
                    ConcurrentHashMap<String, ClientDTO> channels = ClientCache.channels;
                    for (Map.Entry channelEntry: channels.entrySet()) {
                        ClientDTO clientDTO = (ClientDTO)channelEntry.getValue();
                        if(!clientDTO.getFlagKey().equals(cfCarParkDevice.getBarCode())){
                            continue;
                        }
                        local = true;

                        iMqttDataService.synchronizePackageDataToDevice(clientDTO.getChannel(), cfCarParkDevice.getBarCode(), clientDTO.getPacketId(), operateType, carParkPackages, cfCarParkDevice);
                        break;
                    }
                }
                if(!local){
                    //改用Dubbo内置RPC远程服务调用
                    String deviceLinkIp = cfCarParkReleaseLogService.getDeviceLinkLocalServerIp(cfCarParkDevice.getBarCode());
                    if(StringUtils.isNotEmpty(deviceLinkIp)){
                        String url = "dubbo://"+deviceLinkIp+":20890/com.cf.carpark.service.CfCarParkPackageService?version=1.0.0";//更改不同的Dubbo服务暴露的ip地址&端口
                        ReferenceBean<IMqttDataService> referenceBean = new ReferenceBean<IMqttDataService>();
                        referenceBean.setApplicationContext(applicationContext);
                        referenceBean.setInterface(IMqttDataService.class);
                        referenceBean.setUrl(url);
                        referenceBean.afterPropertiesSet();
                        IMqttDataService iMqttDataService = referenceBean.get();
                        iMqttDataService.synchronizePackageDataToDevice(null, cfCarParkDevice.getBarCode(), 0, operateType, carParkPackages, cfCarParkDevice);
                    }
                }
            }
        }
    }
}
