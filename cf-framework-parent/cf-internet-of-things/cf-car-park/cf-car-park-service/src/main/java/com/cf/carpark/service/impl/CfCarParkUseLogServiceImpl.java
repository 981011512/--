package com.cf.carpark.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cf.carpark.dao.mapper.CfCarParkUseLogMapper;
import com.cf.carpark.device.camera.HuaXia.GpioData;
import com.cf.carpark.device.camera.HuaXia.HuaXia;
import com.cf.carpark.device.camera.HuaXia.HuaXiaResponse;
import com.cf.carpark.device.camera.HuaXia.TrigerData;
import com.cf.carpark.device.camera.ZhenShi.Response_AlarmInfoPlate;
import com.cf.carpark.device.camera.ZhenShi.SeriaDataUtils;
import com.cf.carpark.device.camera.ZhenShi911202002050;
import com.cf.carpark.device.camera.ZhenShiResponse911202002050;
import com.cf.carpark.device.camera.hk.HkRequestParam;
import com.cf.carpark.device.camera.hk.HkResponse;
import com.cf.carpark.device.led.PlayRule;
import com.cf.carpark.device.led.ShowContent;
import com.cf.carpark.device.led.TextPlay;
import com.cf.carpark.domain.*;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.*;
import com.cf.carpark.domain.type.*;
import com.cf.carpark.service.*;
import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.service.CfUserMessageService;
import com.cf.file.domain.FileSystem;
import com.cf.file.service.FileSystemService;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.report.CountByDay;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.*;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.CfCouponService;
import com.cf.pay.service.CfOrderService;
import com.cf.pay.service.CfQrCodeService;
import com.cf.ucenter.domain.CfRole;
import com.cf.ucenter.domain.CfUserRole;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.request.CfRoleQuery;
import com.cf.ucenter.request.CfUserRoleQuery;
import com.cf.ucenter.request.CfWeixinConfigQuery;
import com.cf.ucenter.service.CfRoleService;
import com.cf.ucenter.service.CfSystemConfigService;
import com.cf.ucenter.service.CfUserRoleService;
import com.cf.ucenter.service.CfWeixinConfigService;
import com.cf.ucenter.wxtools.WeiXinConfigUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 停车记录管理服务
 *
 * @ClassName CfCarParkUseLogServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/1/001 15:26
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkUseLogServiceImpl implements CfCarParkUseLogService {
    @Autowired
    CfCarParkUseLogMapper cfCarParkUseLogMapper;
    @Autowired
    IdWorker idWorker;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private FileSystemService fileSystemService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfOrderService cfOrderService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfRoleService cfRoleService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserRoleService cfUserRoleService;
    @Autowired
    private CfCarParkDeviceService cfCarParkDeviceService;
    @Autowired
    private CfCarParkService cfCarParkService;
    @Autowired
    private CfCarParkCheckpointService cfCarParkCheckpointService;
    @Autowired
    private CfCarParkReleaseLogService cfCarParkReleaseLogService;
    @Autowired
    private CfCarParkChargingRulesService cfCarParkChargingRulesService;
    @Autowired
    private CfCarParkOcrService cfCarParkOcrService;
    @Autowired
    private CfCarParkCarLimitService cfCarParkCarLimitService;
    @Autowired
    private CfCarParkCarTypeService cfCarParkCarTypeService;
    @Autowired
    private CfCarParkSpecialCarService cfCarParkSpecialCarService;
    @Autowired
    private CfCarParkVisitService cfCarParkVisitService;
    @Autowired
    private CfCarParkPackageService cfCarParkPackageService;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponService cfCouponService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserMessageService cfUserMessageService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfWeixinConfigService cfWeixinConfigService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfQrCodeService cfQrCodeService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfSystemConfigService cfSystemConfigService;

    @Override
    public CfCarParkUseLog add(CfCarParkUseLog cfCarParkUseLog) {
//        forbidRepeatLog(cfCarParkUseLog);
        cfCarParkUseLog.setCreateTime(System.currentTimeMillis());
        if(cfCarParkUseLog.getRemarks()==null){
            cfCarParkUseLog.setRemarks("");
        }

        //检查是否存在代收停车费停车场
        CfCarPark cfCarPark = cfCarParkService.findById(cfCarParkUseLog.getCarParkId(), false);

        if(StringUtils.isNotEmpty(cfCarPark.getCollectionCarparkId())){
            cfCarParkUseLog.setCountFeeStatus((byte)1);
        }
        if(cfCarParkUseLog.getId()==null || cfCarParkUseLog.getId().length()<16){
            cfCarParkUseLog.setId(idWorker.nextId());
        }
        cfCarParkUseLogMapper.insertSelective(cfCarParkUseLog);
        CfOrder cfOrder = makeCfOrderData(cfCarParkUseLog);


        if(StringUtils.isNotEmpty(cfCarPark.getCollectionCarparkId())){
            cfOrder.setCollectionShopId(cfCarPark.getCollectionCarparkId());
        }else{
            cfOrder.setCollectionShopId("");
        }

        cfOrder.setUserPaymentAgencyId("");
        cfOrderService.add(cfOrder);
        return cfCarParkUseLog;
    }

    @Override
    public Integer delete(String id) {
        int delete = cfCarParkUseLogMapper.deleteByPrimaryKey(id);
        if(delete>0){
            CfOrderQuery cfOrderQuery = new CfOrderQuery();
            cfOrderQuery.setGoodsId(id);
            cfOrderService.deleteByQuery(cfOrderQuery);
        }
        return delete;
    }

    @Override
    public Integer deleteByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery) {
        List<CfCarParkUseLog> cfCarParkUseLogList = getListByQuery(cfCarParkUseLogQuery);
        if(cfCarParkUseLogList==null || cfCarParkUseLogList.size()==0){
            return 0;
        }
        int delete= cfCarParkUseLogMapper.deleteByExample(getExampleByQuery(cfCarParkUseLogQuery));
        if(delete>0){
            CfOrderQuery cfOrderQuery = new CfOrderQuery();
            cfOrderQuery.setGoodsIds(new ArrayList<>());
            for(CfCarParkUseLog cfCarParkUseLog: cfCarParkUseLogList){
                cfOrderQuery.getGoodsIds().add(cfCarParkUseLog.getId());
            }
            cfOrderService.deleteByQuery(cfOrderQuery);
        }
        return delete;
    }

    @Override
    public CfCarParkUseLog forbidRepeatLog(CfCarParkUseLog cfCarParkUseLog) {
        CfCarParkUseLogExample cfCarParkUseLogExample = new CfCarParkUseLogExample();
        CfCarParkUseLogExample.Criteria criteria = cfCarParkUseLogExample.createCriteria();
        criteria.andNumberPlateEqualTo(cfCarParkUseLog.getNumberPlate())
                .andInTimeEqualTo(cfCarParkUseLog.getInTime())
                .andPayTimeEqualTo(0L);
        int i = cfCarParkUseLogMapper.countByExample(cfCarParkUseLogExample);
        if(i>0){
            //最新的记录直接覆盖旧记录
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        return cfCarParkUseLog;

    }

    @Override
    public List<CfCarParkUseLog> getListByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery) {
        return cfCarParkUseLogMapper.selectByExample(getExampleByQuery(cfCarParkUseLogQuery));
    }

    @Override
    public Integer getCountByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery) {
        cfCarParkUseLogQuery.setPage(null);
        return cfCarParkUseLogMapper.countByExample(getExampleByQuery(cfCarParkUseLogQuery));
    }

    @Override
    public Integer countByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery) {
        cfCarParkUseLogQuery.setPage(null);
        return cfCarParkUseLogMapper.countByQuery(cfCarParkUseLogQuery);
    }

    @Override
    public List<CfCarParkUseLog> selectByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery) {
        if(cfCarParkUseLogQuery.getPage()==null || cfCarParkUseLogQuery.getSize()==null){
            cfCarParkUseLogQuery.setPage(1);
            cfCarParkUseLogQuery.setSize(10);
        }
        return cfCarParkUseLogMapper.selectByQuery(cfCarParkUseLogQuery);
    }

    @Override
    public List<CfCarParkUseLog> selectByQueryContainOrder(CfCarParkUseLogQuery cfCarParkUseLogQuery) {
        if(cfCarParkUseLogQuery.getPage()==null || cfCarParkUseLogQuery.getSize()==null){
            cfCarParkUseLogQuery.setPage(1);
            cfCarParkUseLogQuery.setSize(10);
        }
        return cfCarParkUseLogMapper.selectByQueryContainOrder(cfCarParkUseLogQuery);
    }

    @Override
    public CfCarParkUseLogExample getExampleByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery) {
        CfCarParkUseLogExample cfCarParkUseLogExample = new CfCarParkUseLogExample();
        CfCarParkUseLogExample.Criteria criteria = cfCarParkUseLogExample.createCriteria();
        if(cfCarParkUseLogQuery.getIds()!=null && cfCarParkUseLogQuery.getIds().size()>0){
            criteria.andIdIn(cfCarParkUseLogQuery.getIds());
        }
        if(StringUtils.isNotEmpty(cfCarParkUseLogQuery.getNumberPlate())){
            criteria.andNumberPlateEqualTo(cfCarParkUseLogQuery.getNumberPlate());
        }
        if(StringUtils.isNotEmpty(cfCarParkUseLogQuery.getNumberPlateLK())){
            criteria.andNumberPlateLike("%"+cfCarParkUseLogQuery.getNumberPlateLK()+"%");
        }
        if(StringUtils.isNotEmpty(cfCarParkUseLogQuery.getUid())){
            criteria.andUidEqualTo(cfCarParkUseLogQuery.getUid());
        }
        if(cfCarParkUseLogQuery.getNumberPlates()!=null && cfCarParkUseLogQuery.getNumberPlates().size()>0){
            criteria.andNumberPlateIn(cfCarParkUseLogQuery.getNumberPlates());
        }
        if(StringUtils.isNotEmpty(cfCarParkUseLogQuery.getCarParkId())){
            criteria.andCarParkIdEqualTo(cfCarParkUseLogQuery.getCarParkId());
        }
        if(cfCarParkUseLogQuery.getCarParkIds()!=null && cfCarParkUseLogQuery.getCarParkIds().size()>0){
            criteria.andCarParkIdIn(cfCarParkUseLogQuery.getCarParkIds());
        }
        if(cfCarParkUseLogQuery.getMinSubscribeTime()!=null){
            criteria.andSubscribeTimeGreaterThanOrEqualTo(cfCarParkUseLogQuery.getMinSubscribeTime());
        }
        if(cfCarParkUseLogQuery.getMaxSubscribeTime()!=null){
            criteria.andSubscribeTimeLessThanOrEqualTo(cfCarParkUseLogQuery.getMaxSubscribeTime());
        }
        if(cfCarParkUseLogQuery.getMinCancelSubscribeTime()!=null){
            criteria.andCancelSubscribeTimeGreaterThanOrEqualTo(cfCarParkUseLogQuery.getMinCancelSubscribeTime());
        }
        if(cfCarParkUseLogQuery.getMaxCancelSubscribeTime()!=null){
            criteria.andCancelSubscribeTimeLessThanOrEqualTo(cfCarParkUseLogQuery.getMaxCancelSubscribeTime());
        }
        if(cfCarParkUseLogQuery.getInTime()!=null && cfCarParkUseLogQuery.getInTime()>0){
            criteria.andInTimeEqualTo(cfCarParkUseLogQuery.getInTime());
        }
        if(cfCarParkUseLogQuery.getMinInTime()!=null && cfCarParkUseLogQuery.getMinInTime()>0){
            criteria.andInTimeGreaterThanOrEqualTo(cfCarParkUseLogQuery.getMinInTime());
        }
        if(cfCarParkUseLogQuery.getMaxInTime()!=null && cfCarParkUseLogQuery.getMaxInTime()>0){
            criteria.andInTimeLessThanOrEqualTo(cfCarParkUseLogQuery.getMaxInTime());
        }
        if(cfCarParkUseLogQuery.getOutTime()!=null){
            criteria.andOutTimeEqualTo(cfCarParkUseLogQuery.getOutTime());
        }
        if(cfCarParkUseLogQuery.getMinOutTime()!=null && cfCarParkUseLogQuery.getMinOutTime()>0){
            criteria.andOutTimeGreaterThanOrEqualTo(cfCarParkUseLogQuery.getMinOutTime());
        }
        if(cfCarParkUseLogQuery.getMaxOutTime()!=null && cfCarParkUseLogQuery.getMaxOutTime()>0){
            criteria.andOutTimeLessThanOrEqualTo(cfCarParkUseLogQuery.getMaxOutTime());
        }
        if(cfCarParkUseLogQuery.getInReleaseType()!=null){
            criteria.andInReleaseTypeEqualTo(cfCarParkUseLogQuery.getInReleaseType());
        }
        if(cfCarParkUseLogQuery.getOutReleaseType()!=null){
            criteria.andOutReleaseTypeEqualTo(cfCarParkUseLogQuery.getOutReleaseType());
        }
        if(StringUtils.isNotEmpty(cfCarParkUseLogQuery.getInCheckPointId())){
            criteria.andInCheckPointIdEqualTo(cfCarParkUseLogQuery.getInCheckPointId());
        }
        if(StringUtils.isNotEmpty(cfCarParkUseLogQuery.getOutCheckPointId())){
            criteria.andOutCheckPointIdEqualTo(cfCarParkUseLogQuery.getOutCheckPointId());
        }
        if(cfCarParkUseLogQuery.getCreateTime()!=null && cfCarParkUseLogQuery.getCreateTime()>0){
            criteria.andCreateTimeEqualTo(cfCarParkUseLogQuery.getCreateTime());
        }
        if(cfCarParkUseLogQuery.getMinCreateTime()!=null && cfCarParkUseLogQuery.getMinCreateTime()>0){
            criteria.andCreateTimeGreaterThanOrEqualTo(cfCarParkUseLogQuery.getMinCreateTime());
        }
        if(cfCarParkUseLogQuery.getMaxCreateTime()!=null && cfCarParkUseLogQuery.getMaxCreateTime()>0){
            criteria.andCreateTimeLessThanOrEqualTo(cfCarParkUseLogQuery.getMaxCreateTime());
        }
        if(cfCarParkUseLogQuery.getPayTime()!=null){
            criteria.andPayTimeEqualTo(cfCarParkUseLogQuery.getPayTime());
        }
        if(cfCarParkUseLogQuery.getMinPayTime()!=null && cfCarParkUseLogQuery.getMinPayTime()>0){
            criteria.andPayTimeGreaterThanOrEqualTo(cfCarParkUseLogQuery.getMinPayTime());
        }
        if(cfCarParkUseLogQuery.getMaxPayTime()!=null && cfCarParkUseLogQuery.getMaxPayTime()>0){
            criteria.andPayTimeLessThanOrEqualTo(cfCarParkUseLogQuery.getMaxPayTime());
        }
        if(cfCarParkUseLogQuery.getCreatePosition()!=null){
            criteria.andCreatePositionEqualTo(cfCarParkUseLogQuery.getCreatePosition());
        }
        if(cfCarParkUseLogQuery.getCountFeeStatus()!=null){
            criteria.andCountFeeStatusEqualTo(cfCarParkUseLogQuery.getCountFeeStatus());
        }
        if(cfCarParkUseLogQuery.getCarNumberPlateColor()!=null){
            criteria.andCarNumberPlateColorEqualTo(cfCarParkUseLogQuery.getCarNumberPlateColor());
        }
        if(cfCarParkUseLogQuery.getVisitUnit()!=null){
            criteria.andVisitUnitEqualTo(cfCarParkUseLogQuery.getVisitUnit());
        }
        if(StringUtils.isNotEmpty(cfCarParkUseLogQuery.getOrderBy())){
            cfCarParkUseLogExample.setOrderByClause(cfCarParkUseLogQuery.getOrderBy());
        }
        if(cfCarParkUseLogQuery.getPage()!=null && cfCarParkUseLogQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkUseLogQuery.getPage(), cfCarParkUseLogQuery.getSize());
        }
        return cfCarParkUseLogExample;
    }

    @Override
    public CfCarParkUseLog update(CfCarParkUseLog cfCarParkUseLog) {
        if(cfCarParkUseLog.getInHandleUid()==null){
            cfCarParkUseLog.setInHandleUid("");
        }
        if(cfCarParkUseLog.getOutHandleUid()==null){
            cfCarParkUseLog.setOutHandleUid("");
        }
        if(cfCarParkUseLog.getUid()==null){
            cfCarParkUseLog.setUid("");
        }
        cfCarParkUseLogMapper.updateByPrimaryKey(cfCarParkUseLog);
        if(StringUtils.isNotEmpty(cfCarParkUseLog.getOutHandleUid())){
            CfOrder cfOrder = new CfOrder();
            cfOrder.setHandleUid(cfCarParkUseLog.getOutHandleUid());
            CfOrderQuery cfOrderQuery = new CfOrderQuery();
            cfOrderQuery.setGoodsId(cfCarParkUseLog.getId());
            cfOrderService.updateByQuery(cfOrder,cfOrderQuery);
        }
        return cfCarParkUseLog;
    }

    @Override
    public CfCarParkUseLog updateByPrimaryKeySelective(CfCarParkUseLog cfCarParkUseLog) {
        cfCarParkUseLogMapper.updateByPrimaryKeySelective(cfCarParkUseLog);
        return cfCarParkUseLog;
    }

    @Override
    public CfCarParkUseLog findById(String id) {
        return cfCarParkUseLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCarParkUseLog findById(String id, Boolean expectEmpty) {
        CfCarParkUseLog cfCarParkUseLog = findById(id);
        if(expectEmpty && cfCarParkUseLog!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }else if(!expectEmpty && cfCarParkUseLog==null){
            ExceptionCast.cast(CarParkCode.PARKING_LOT_RECORD_DOES_NOT_EXIST);
        }
        return cfCarParkUseLog;
    }

    @Override
    public CfCarParkUseLog checkIsZhenShi911202002050(Map carLogMap) throws Exception
    {
        //处理臻识相机数据处理解析，自己根据实际情况处理一下
        return null;
    }

    @Override
    public CfCarParkUseLog checkIsHuaXia(Map carLogMap) throws Exception {
        //处理华夏相机数据处理解析，自己根据实际情况处理一下
        return null;
    }

    @Override
    public CfCarParkUseLog deviceDataToCarParkUseLog(Map carLogMap) throws Exception {
        String deviceBrand = carLogMap.get("deviceBrand").toString();
        CfCarParkUseLog cfCarParkUseLog = new CfCarParkUseLog();
        String smallImage = "";
        String bigImage = "";
        String barCode = null;
        Long inOrOutTime = 0l;

        if(deviceBrand.equals(DeviceBrand.ZHEN_SHI) || deviceBrand.equals(DeviceBrand.QIAN_YI)){
            //判断是否为臻识相机传入的数据
            ZhenShi911202002050 zhenShi911202002050C = ZhenShi911202002050.class.newInstance();
            ZhenShi911202002050 zhenShi911202002050 = BeanUtils.deepMapToBean(zhenShi911202002050C.getClass(), carLogMap);

            if( StringUtils.isNotEmpty(zhenShi911202002050.getAlarmInfoPlate().getResult().getPlateResult().getLicense())){

                barCode = zhenShi911202002050.getAlarmInfoPlate().getSerialno();

                cfCarParkUseLog.setNumberPlate(zhenShi911202002050.getAlarmInfoPlate().getResult().getPlateResult().getLicense());
                if(StringUtils.isNotEmpty(zhenShi911202002050.getAlarmInfoPlate().getResult().getPlateResult().getImageFragmentFile())){
                    try{
                        smallImage = uploadNumberPlateImage(zhenShi911202002050.getAlarmInfoPlate().getResult().getPlateResult().getImageFragmentFile(), "Decoder");
                    }catch (Exception e){
                        //如果图片上传失败，继续执行
                    }
                }
                if(StringUtils.isNotEmpty(zhenShi911202002050.getAlarmInfoPlate().getResult().getPlateResult().getImageFile())){
                    try{
                        bigImage = uploadNumberPlateImage(zhenShi911202002050.getAlarmInfoPlate().getResult().getPlateResult().getImageFile(), "Decoder");
                    }catch (Exception e){
                        //如果图片上传失败，继续执行
                    }
                }

                inOrOutTime = (Integer.valueOf(zhenShi911202002050.getAlarmInfoPlate().getResult().getPlateResult().getTimeStamp().getTimeval().getSec()))*1000L;
            }else{
                return null;
            }
        }else if(deviceBrand.equals(DeviceBrand.HUA_XIA)){
            HuaXia huaXia = BeanUtils.deepMapToBean(HuaXia.class.newInstance().getClass(), carLogMap);

            barCode = StringUtils.isNotEmpty(huaXia.getCamera_id()) ? huaXia.getCamera_id() : huaXia.getCam_id();

            if( StringUtils.isNotEmpty(huaXia.getCar_plate()) || StringUtils.isNotEmpty(huaXia.getPlate_num()) ){
                if(StringUtils.isNotEmpty(huaXia.getCar_plate())){
                    cfCarParkUseLog.setNumberPlate(huaXia.getCar_plate());
                }else{
                    cfCarParkUseLog.setNumberPlate(huaXia.getPlate_num());
                }
                if(StringUtils.isNotEmpty(huaXia.getCloseup_pic())){
                    try{
                        smallImage = uploadNumberPlateImage(huaXia.getCloseup_pic(), "UrlDecoder");
                    }catch (Exception e){
                        e.printStackTrace();
                        //如果图片上传失败，继续执行
                    }
                }
                if(StringUtils.isNotEmpty(huaXia.getPicture())){
                    try{
                        bigImage = uploadNumberPlateImage(huaXia.getPicture(), "UrlDecoder");
                    }catch (Exception e){
                        e.printStackTrace();
                        //如果图片上传失败，继续执行
                    }
                }

                inOrOutTime = (Integer.valueOf(huaXia.getStart_time()))*1000L;
            }else{
                return null;
            }
        }else if(deviceBrand.equals(DeviceBrand.HK) || deviceBrand.equals(DeviceBrand.DH)){
            HkRequestParam hkRequestParam = BeanUtils.deepMapToBean(HkRequestParam.class.newInstance().getClass(), carLogMap);
            barCode = hkRequestParam.getSerialNo();

            if( StringUtils.isNotEmpty(hkRequestParam.getCarNo()) ){
                cfCarParkUseLog.setNumberPlate(hkRequestParam.getCarNo());
                if(StringUtils.isNotEmpty(hkRequestParam.getSmallImagePath())){
                    smallImage = hkRequestParam.getSmallImagePath();
                }else if(StringUtils.isNotEmpty(hkRequestParam.getSmallImage())){
                    try{
                        smallImage = uploadNumberPlateImage(hkRequestParam.getSmallImage(), "Decoder");
                    }catch (Exception e){
                        e.printStackTrace();
                        //如果图片上传失败，继续执行
                    }
                }
                if(StringUtils.isNotEmpty(hkRequestParam.getBigImagePath())){
                    bigImage = hkRequestParam.getBigImagePath();
                }else if(StringUtils.isNotEmpty(hkRequestParam.getSmallImage())){
                    try{
                        bigImage = uploadNumberPlateImage(hkRequestParam.getBigImage(), "Decoder");
                    }catch (Exception e){
                        e.printStackTrace();
                        //如果图片上传失败，继续执行
                    }
                }

                inOrOutTime = System.currentTimeMillis();
            }else{
                return null;
            }
        }else{
            ExceptionCast.cast(CarParkCode.DEVICE_BRAND_IS_NOT_SPECIFIED);
        }

        //如果车硬件牌号被加密，进行内部车牌识别算法二次识别
        if(cfCarParkUseLog.getNumberPlate().length()>15 && StringUtils.isNotEmpty(bigImage)){
            List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("ali_oss");
            String endpoint = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("endpoint", cfWeixinConfigs);
            String bucketName = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("bucket_name", cfWeixinConfigs);
            String numberPlateOcr = cfCarParkOcrService.AliNumberPlateOcr("https://" + bucketName + "." + endpoint + "/" + bigImage);
            cfCarParkUseLog.setNumberPlate(numberPlateOcr);
        }

        CfCarParkDevice cfCarParkDevice = null;
        if(carLogMap.containsKey("cfCarParkDeviceId")){
            cfCarParkDevice = cfCarParkDeviceService.findById(carLogMap.get("cfCarParkDeviceId").toString(), false);
        }else{
            cfCarParkDevice = cfCarParkDeviceService.findByCode(barCode, false);
        }

        cfCarParkUseLog.setCfCarParkDevice(cfCarParkDevice);
        if(cfCarParkDevice.getDirection().equals(CarDirection.IN)){
            cfCarParkUseLog.setInCheckPointId(cfCarParkDevice.getCheckpointId());
        }else if(cfCarParkDevice.getDirection().equals(CarDirection.OUT)){
            cfCarParkUseLog.setOutCheckPointId(cfCarParkDevice.getCheckpointId());
        }
        return handleUseLogByDevicePushData(cfCarParkUseLog, cfCarParkDevice, inOrOutTime, smallImage, bigImage);
    }

    @Override
    public String uploadNumberPlateImage(String base64, String decoderType) throws Exception {
        byte[] base64Bt = decoderType.equals("Decoder") ? Base64.getDecoder().decode(base64) : Base64.getDecoder().decode(base64.replace("-", "+").replace("_", "/").replace(".", "="));
        FileSystem fileSystem = fileSystemService.upload(base64Bt, "jpg", "image/jpeg", "number_plate", "carPark", "","ali_oss");
        return fileSystem.getFilePath();
    }

    @Override
    public Object parseCarParkUseLogForm(Map carLogMap) throws Exception{
        CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
        cfCarParkDeviceQuery.setType((byte)2);
        CfCarParkUseLog cfCarParkUseLog = null;

        //判断相机品牌
        String deviceBrand = carLogMap.get("deviceBrand").toString();
        //入场相机(如果不为空，表示该相机被多个停车场同时当作出入口)
        CfCarParkDevice inCfCarParkDevice = null;
        CfCarParkDevice cfCarParkDevice = null;
        //处理臻识，千熠
        if(deviceBrand.equals(DeviceBrand.ZHEN_SHI) || deviceBrand.equals(DeviceBrand.QIAN_YI)){
            //普通停车场相机
            if(carLogMap.containsKey("AlarmInfoPlate")){
                Map alarmInfoPlate = (Map) carLogMap.get("AlarmInfoPlate");
                String serialno = alarmInfoPlate.get("serialno").toString();
                if(alarmInfoPlate!=null && StringUtils.isNotEmpty(serialno)){
                    cfCarParkDeviceQuery.setBarCode(serialno);
                    List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
                    cfCarParkDevice = cfCarParkDevices.get(0);
                    if(cfCarParkDevices!=null && cfCarParkDevices.size()>=2){
                        if(cfCarParkDevices.get(0).getDirection().equals("out")){
                            carLogMap.put("cfCarParkDeviceId",cfCarParkDevices.get(0).getId());
                            inCfCarParkDevice = cfCarParkDevices.get(1);
                        }else{
                            carLogMap.put("cfCarParkDeviceId",cfCarParkDevices.get(1).getId());
                            inCfCarParkDevice = cfCarParkDevices.get(0);
                        }
                    }
                }
                cfCarParkUseLog = checkIsZhenShi911202002050(carLogMap);
                ZhenShiResponse911202002050 zhenShiResponse911202002050 = (ZhenShiResponse911202002050) handleCameraData(cfCarParkUseLog, carLogMap, DeviceBrand.ZHEN_SHI);
                if(inCfCarParkDevice!=null){
                    //新增入场记录
                    carLogMap.put("cfCarParkDeviceId",inCfCarParkDevice.getId());
                    CfCarParkUseLog cfCarParkUseLog2 = checkIsZhenShi911202002050(carLogMap);
                    ZhenShiResponse911202002050 zhenShiResponse = (ZhenShiResponse911202002050) handleCameraData(cfCarParkUseLog2, carLogMap, DeviceBrand.ZHEN_SHI);
                    if(zhenShiResponse911202002050.getResponse_AlarmInfoPlate().getInfo().equals("ok") && zhenShiResponse.getResponse_AlarmInfoPlate().getInfo().equals("ok")){
                        zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setInfo("ok");
                    }else{
                        zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setInfo("fail");
                    }
                }
                String model = cfCarParkDevice.getModel();
                if( model!=null && cfCarParkDevice.getLinkMode().equals("mqtt") && StringUtils.isNumeric(model.substring((model.indexOf("-"))+1)) && new Integer(model.substring((model.indexOf("-"))+1)).intValue()>=202210285 ){
                    //说明是较新的SDK版本，mqtt要单独做处理
                    //新版臻识相机下发 mqtt  485数据，请自己根据实际情况处理
                }
                return zhenShiResponse911202002050;
            }else if(carLogMap.containsKey("alarm_info") && carLogMap.containsKey("bg_img") && carLogMap.containsKey("device_info")){
                //路内相机

                cfCarParkDeviceQuery.setBarCode(carLogMap.get("sn").toString());
                List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
                if(cfCarParkDevices==null || cfCarParkDevices.size()==0){
                    ExceptionCast.cast(CarParkCode.DEVICE_IS_NOT_REGISTERED);
                }

                cfCarParkUseLog = new CfCarParkUseLog();
                cfCarParkUseLog.setCfCarParkDevice(cfCarParkDevices.get(0));
                cfCarParkUseLog.setNumberPlate( StringTools.getDecodeBase64(((Map)(((Map)carLogMap.get("product_h")).get("plate"))).get("plate").toString()) );
                cfCarParkUseLog.setCarNumberPlateColor(Byte.parseByte(((Map)(((Map)carLogMap.get("product_h")).get("plate"))).get("color").toString()));;
                cfCarParkUseLog.setUid("");
                cfCarParkUseLog.setCarParkId(cfCarParkDevices.get(0).getCarParkId());

                JSONArray fetureImgs = (JSONArray) carLogMap.get("feture_img");
                String smallImage = "";
                String bigImage = "";

                if(StringUtils.isNotEmpty(((Map)fetureImgs.get(0)).get("image").toString())){
                    try{
                        smallImage = uploadNumberPlateImage(((Map)fetureImgs.get(0)).get("image").toString(), "Decoder");
                    }catch (Exception e){
                        //如果图片上传失败，继续执行
                    }
                }
                if(StringUtils.isNotEmpty(((Map)fetureImgs.get(1)).get("image").toString())){
                    try{
                        bigImage = uploadNumberPlateImage(((Map)fetureImgs.get(1)).get("image").toString(), "Decoder");
                    }catch (Exception e){
                        //如果图片上传失败，继续执行
                    }
                }

                //车位状态： 1:入场; 2:在场; 4:出场; 8:空场; 16:异常; 128:预入场; 256:预出场; 512:入场修正; 1024:道路过车抓拍;
                int parkingState = Integer.parseInt(((Map) (((Map) carLogMap.get("product_h")).get("parking"))).get("parking_state").toString());

                if(parkingState==1){
                    cfCarParkUseLog.setInCheckPointId(cfCarParkDevices.get(0).getCheckpointId());
                    cfCarParkUseLog.getCfCarParkDevice().setDirection(CarDirection.IN);
                }else if(parkingState==4){
                    cfCarParkUseLog.setOutCheckPointId(cfCarParkDevices.get(0).getCheckpointId());
                    cfCarParkUseLog.getCfCarParkDevice().setDirection(CarDirection.OUT);
                }else{
                    //不处理
                    return null;
                }
                cfCarParkUseLog.setPayTime(0l);
                cfCarParkUseLog.setCreatePosition("out");
                cfCarParkUseLog.setParkingSpaceNumber(StringTools.getDecodeBase64(((Map) (((Map) carLogMap.get("product_h")).get("parking"))).get("zone_name").toString()));

                cfCarParkUseLog = handleUseLogByDevicePushData(cfCarParkUseLog, cfCarParkUseLog.getCfCarParkDevice(), Long.parseLong(carLogMap.get("time_s").toString()) * 1000, smallImage, bigImage);

                ZhenShiResponse911202002050 zhenShiResponse911202002050 = (ZhenShiResponse911202002050) handleCameraData(cfCarParkUseLog, carLogMap, DeviceBrand.ZHEN_SHI);
                return zhenShiResponse911202002050;
            }else{
                //无法识别
                return null;
            }
        }
        //处理华夏
        else if(deviceBrand.equals(DeviceBrand.HUA_XIA)){
            if(carLogMap.get("sn")!=null){
                //高位相机
                System.out.println(carLogMap);
                if(carLogMap.get("cmd").toString().equals("parkingData")){
                    Map<String, Object> resultData = (Map<String, Object>) (((Map) (carLogMap.get("body"))).get("resultData"));
                    Map<String, String> huaXia = new HashMap<>();
                    huaXia.put("car_plate",resultData.get("plateNo").toString());
                    huaXia.put("plate_num",resultData.get("plateNo").toString());
                    huaXia.put("color",resultData.get("plateColor").toString());
                    huaXia.put("start_time",((Map)resultData.get("iDentifyTime")).get("second").toString());
                    huaXia.put("camera_id",carLogMap.get("sn").toString());
                    huaXia.put("cam_id",carLogMap.get("sn").toString());
                    huaXia.put("berthcode",resultData.get("berthcode").toString());

                    cfCarParkUseLog = checkIsHuaXia(huaXia);

                    cfCarParkDeviceQuery.setBarCode(carLogMap.get("sn").toString());
                    List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
                    if(cfCarParkDevices==null || cfCarParkDevices.size()==0){
                        ExceptionCast.cast(CarParkCode.DEVICE_IS_NOT_REGISTERED);
                    }

                    cfCarParkUseLog.setCfCarParkDevice(cfCarParkDevices.get(0));
                    cfCarParkUseLog.setUid("");
                    cfCarParkUseLog.setCarParkId(cfCarParkDevices.get(0).getCarParkId());

                    String smallImage = "";
                    String bigImage = "";

                    //车位状态： 0:未知; 1:离场; 2:入场;
                    int parkingState = Integer.parseInt(resultData.get("carStatus").toString());

                    if(parkingState==2){
                        cfCarParkUseLog.setInCheckPointId(cfCarParkDevices.get(0).getCheckpointId());
                        cfCarParkUseLog.getCfCarParkDevice().setDirection(CarDirection.IN);
                    }else if(parkingState==1){
                        cfCarParkUseLog.setOutCheckPointId(cfCarParkDevices.get(0).getCheckpointId());
                        cfCarParkUseLog.getCfCarParkDevice().setDirection(CarDirection.OUT);
                    }else{
                        //不处理
                        return null;
                    }
                    cfCarParkUseLog.setPayTime(0l);
                    cfCarParkUseLog.setCreatePosition("out");

                    cfCarParkUseLog = handleUseLogByDevicePushData(cfCarParkUseLog, cfCarParkUseLog.getCfCarParkDevice(), Long.parseLong(huaXia.get("start_time").toString()) * 1000, smallImage, bigImage);
                    return (HuaXiaResponse) handleCameraData(cfCarParkUseLog, carLogMap, DeviceBrand.HUA_XIA);
                }
            }else{
                String serialno = carLogMap.get("camera_id")!=null && StringUtils.isNotEmpty(carLogMap.get("camera_id").toString()) ? carLogMap.get("camera_id").toString() : carLogMap.get("cam_id").toString();

                //判断是否为心跳
                if(carLogMap.containsKey("type") && carLogMap.get("type").equals("heartbeat")){
                    //处理心跳业务
                    Map<String, Object> stringObjectMap = cfCarParkReleaseLogService.releaseMonitoring(serialno, deviceBrand);
                    if(stringObjectMap.get("prefix")!=null && stringObjectMap.get("carParkReleaseLog")!=null){
                        cfCarParkReleaseLogService.cleanReleaseRedis(stringObjectMap.get("prefix").toString(), (CfCarParkReleaseLog) stringObjectMap.get("carParkReleaseLog"));
                    }else if(stringObjectMap.get("capture")!=null){
                        cfCarParkReleaseLogService.cleanCaptureRedis(stringObjectMap.get("prefix").toString());
                    }
                    return stringObjectMap.get("object");
                }
                if(StringUtils.isNotEmpty(serialno)){
                    cfCarParkDeviceQuery.setBarCode(serialno);
                    List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
                    if(cfCarParkDevices!=null && cfCarParkDevices.size()>=2){
                        if(cfCarParkDevices.get(0).getDirection().equals("out")){
                            carLogMap.put("cfCarParkDeviceId",cfCarParkDevices.get(0).getId());
                            inCfCarParkDevice = cfCarParkDevices.get(1);
                        }else{
                            carLogMap.put("cfCarParkDeviceId",cfCarParkDevices.get(1).getId());
                            inCfCarParkDevice = cfCarParkDevices.get(0);
                        }
                    }
                }

                //正常处理相机识别推送业务
                cfCarParkUseLog = checkIsHuaXia(carLogMap);
                HuaXiaResponse huaXiaResponse = (HuaXiaResponse) handleCameraData(cfCarParkUseLog, carLogMap, DeviceBrand.HUA_XIA);
                if(inCfCarParkDevice!=null){
                    //新增入场记录
                    carLogMap.put("cfCarParkDeviceId",inCfCarParkDevice.getId());
                    CfCarParkUseLog cfCarParkUseLog3 = checkIsHuaXia(carLogMap);
                    HuaXiaResponse huaXiaResponse1 = (HuaXiaResponse) handleCameraData(cfCarParkUseLog3, carLogMap, DeviceBrand.HUA_XIA);
                    if(huaXiaResponse.getGpio_data().get(0).getAction().equals("on") && huaXiaResponse1.getGpio_data().get(0).getAction().equals("on")){
                        huaXiaResponse.getGpio_data().get(0).setAction("on");
                    }else{
                        huaXiaResponse.getGpio_data().get(0).setAction("off");
                    }
                }
                return huaXiaResponse;
            }
        }
        //处理海康
        else if(deviceBrand.equals(DeviceBrand.HK)){
            String serialno = carLogMap.get("serialNo").toString();
            if(StringUtils.isNotEmpty(serialno)){
                cfCarParkDeviceQuery.setBarCode(serialno);
                List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
                if(cfCarParkDevices!=null && cfCarParkDevices.size()>=2){
                    if(cfCarParkDevices.get(0).getDirection().equals("out")){
                        carLogMap.put("cfCarParkDeviceId",cfCarParkDevices.get(0).getId());
                        inCfCarParkDevice = cfCarParkDevices.get(1);
                    }else{
                        carLogMap.put("cfCarParkDeviceId",cfCarParkDevices.get(1).getId());
                        inCfCarParkDevice = cfCarParkDevices.get(0);
                    }
                }
            }

            //正常处理相机识别推送业务
            cfCarParkUseLog = deviceDataToCarParkUseLog(carLogMap);
            HkResponse hkResponse = (HkResponse) handleCameraData(cfCarParkUseLog, carLogMap, DeviceBrand.HK);
            if(inCfCarParkDevice!=null){
                //新增入场记录
                carLogMap.put("cfCarParkDeviceId",inCfCarParkDevice.getId());
                CfCarParkUseLog cfCarParkUseLog3 = checkIsHuaXia(carLogMap);
                HkResponse hkResponse1 = (HkResponse) handleCameraData(cfCarParkUseLog3, carLogMap, DeviceBrand.HK);
                if(hkResponse.getOpenDoor().equals("on") && hkResponse1.getOpenDoor().equals("on")){
                    hkResponse.setOpenDoor("on");
                }else{
                    hkResponse.setOpenDoor("off");
                }
            }
            return hkResponse;
        }
        //处理大华
        else if(deviceBrand.equals(DeviceBrand.DH)){
            String serialno = carLogMap.get("serialNo").toString();
            if(StringUtils.isNotEmpty(serialno)){
                cfCarParkDeviceQuery.setBarCode(serialno);
                List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
                if(cfCarParkDevices!=null && cfCarParkDevices.size()>=2){
                    if(cfCarParkDevices.get(0).getDirection().equals("out")){
                        carLogMap.put("cfCarParkDeviceId",cfCarParkDevices.get(0).getId());
                        inCfCarParkDevice = cfCarParkDevices.get(1);
                    }else{
                        carLogMap.put("cfCarParkDeviceId",cfCarParkDevices.get(1).getId());
                        inCfCarParkDevice = cfCarParkDevices.get(0);
                    }
                }
            }

            //正常处理相机识别推送业务
            cfCarParkUseLog = deviceDataToCarParkUseLog(carLogMap);
            HkResponse hkResponse = null;
            try{
                hkResponse = (HkResponse) handleCameraData(cfCarParkUseLog, carLogMap, DeviceBrand.DH);
            }catch (Exception e){
                e.printStackTrace();
                throw e;
            }

            if(inCfCarParkDevice!=null){
                //新增入场记录
                carLogMap.put("cfCarParkDeviceId",inCfCarParkDevice.getId());
                CfCarParkUseLog cfCarParkUseLog3 = checkIsHuaXia(carLogMap);
                HkResponse hkResponse1 = (HkResponse) handleCameraData(cfCarParkUseLog3, carLogMap, DeviceBrand.DH);
                if(hkResponse.getOpenDoor().equals("on") && hkResponse1.getOpenDoor().equals("on")){
                    hkResponse.setOpenDoor("on");
                }else{
                    hkResponse.setOpenDoor("off");
                }
            }
            return hkResponse;
        }else{
            ExceptionCast.cast(CarParkCode.DEVICE_BRAND_IS_NOT_SPECIFIED);
        }
        return null;
    }

    @Override
    public void setCameraOpenOrClose(ZhenShiResponse911202002050 zhenShiResponse911202002050, String value)
    {
        if(zhenShiResponse911202002050.getResponse_AlarmInfoPlate()==null){
            Response_AlarmInfoPlate response_alarmInfoPlate = new Response_AlarmInfoPlate();
            zhenShiResponse911202002050.setResponse_AlarmInfoPlate(response_alarmInfoPlate);
            zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setChannelNum(0);
        }
        String action = value.equals("on")?"ok":"fail";
        zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setInfo(action);
    }

    public void setCameraOpenOrClose(HuaXiaResponse huaXiaResponse, String value)
    {
        if(huaXiaResponse.getTriger_data()==null){
            TrigerData trigerData = new TrigerData();
            huaXiaResponse.setTriger_data(trigerData);
            huaXiaResponse.setError_str("noerror");
            huaXiaResponse.getTriger_data().setAction(value);
        }
        if(huaXiaResponse.getGpio_data()==null){
            huaXiaResponse.setError_num(0);
            GpioData gpioData = new GpioData();
            gpioData.setIonum("io1");
            gpioData.setAction("off");
            ArrayList<GpioData> gpioDataArrayList = new ArrayList<>();
            gpioDataArrayList.add(gpioData);
            huaXiaResponse.setGpio_data(gpioDataArrayList);
        }
        huaXiaResponse.getGpio_data().get(0).setAction(value);

    }

    @Override
    public Object handleCameraData(CfCarParkUseLog cfCarParkUseLog, Map carLogMap, String cameraBrand) throws Exception {
        String newestCarParkId = idWorker.nextId();
        //臻识/千熠
        ZhenShiResponse911202002050 zhenShiResponse911202002050 = new ZhenShiResponse911202002050();
        setCameraOpenOrClose(zhenShiResponse911202002050, "off");
        //华夏
        HuaXiaResponse huaXiaResponse = new HuaXiaResponse();
        setCameraOpenOrClose(huaXiaResponse, "off");
        //海康/大华
        HkResponse hkResponse = new HkResponse();
        hkResponse.setOpenDoor("off");

        CfCarParkCarLimit cfCarParkCarLimit = null;

        //根据甲方需求，处理你获取停车记录之后的业务

        ExceptionCast.cast(CarParkCode.UNABLE_TO_PARSE_DEVICE_DATA);
        return null;
    }

    /**
     * 制作车辆入场提示(LED显示,岗亭端提示等)
     * @param cfCarPark
     * @param cfCarParkUseLog
     * @param cfCarParkPackageList
     * @param cfCarParkCarLimit
     * @param cfCarParkPackageQuery
     * @param playRule
     * @param cfCarParkCheckpoint
     * @param showCarTypeName
     * @param voiceCarTypeName
     * @param cameraBrand
     * @param zhenShiResponse911202002050
     * @param huaXiaResponse
     * @return
     * @throws Exception
     */
    private PlayRule makeCarInNotice(CfCarPark cfCarPark,CfCarParkUseLog cfCarParkUseLog,List<CfCarParkPackage> cfCarParkPackageList,CfCarParkCarLimit cfCarParkCarLimit,
                                     CfCarParkPackageQuery cfCarParkPackageQuery,PlayRule playRule,CfCarParkCheckpoint cfCarParkCheckpoint,String showCarTypeName,
                                     String voiceCarTypeName,String cameraBrand,ZhenShiResponse911202002050 zhenShiResponse911202002050,HuaXiaResponse huaXiaResponse) throws Exception {
        if(cfCarParkPackageList!=null && cfCarParkPackageList.size()>0 && cfCarParkPackageList.get(0).getEndTime()>System.currentTimeMillis()){
            cfCarParkCarLimit = null;
            //判断是否有多车多位
            Map<String,List<CfCarParkPackage>> groupCarParkPackageList = new HashMap<>();
            for(CfCarParkPackage cfCarParkPackage: cfCarParkPackageList){
                if(StringUtils.isEmpty(cfCarParkPackage.getGroupFlag())){
                    continue;
                }
                if(groupCarParkPackageList.get(cfCarParkPackage.getGroupFlag())==null){
                    groupCarParkPackageList.put(cfCarParkPackage.getGroupFlag(),new ArrayList<>());
                }
                groupCarParkPackageList.get(cfCarParkPackage.getGroupFlag()).add(cfCarParkPackage);
            }
            //判断是否存在家庭组套餐
            if(groupCarParkPackageList.size()>0){
                for(Map.Entry<String,List<CfCarParkPackage>> entry: groupCarParkPackageList.entrySet()){
                    cfCarParkPackageQuery.setNumberPlate(null);
                    cfCarParkPackageQuery.setGroupFlag(entry.getKey());
                    cfCarParkPackageQuery.setMinStatus((byte)1);
                    List<CfCarParkPackage> cfCarParkUsingPackages = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
                    if(cfCarParkUsingPackages!=null && cfCarParkUsingPackages.size()>0){

                        List<String> inNumberPlates = new ArrayList<>();
                        for (CfCarParkPackage cfCarParkPackage: cfCarParkUsingPackages){
                            //排除当前车牌
                            if(cfCarParkPackage.getNumberPlate().equals(cfCarParkUseLog.getNumberPlate()) || cfCarParkPackage.getStatus()==(byte)2){
                                continue;
                            }
                            inNumberPlates.add(cfCarParkPackage.getNumberPlate());
                        }
                        if(inNumberPlates!=null && inNumberPlates.size()>0){
                            List<CfCarParkUseLog> notOutCfCarParkUseLogs = new ArrayList<>();
                            //查询还在场内的家庭组车辆最晚的停车记录
                            CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
                            cfCarParkUseLogQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
                            for(String numberPlate: inNumberPlates){
                                cfCarParkUseLogQuery.setNumberPlate(numberPlate);
                                cfCarParkUseLogQuery.setVisitUnit(entry.getKey());
                                cfCarParkUseLogQuery.setPage(1);
                                cfCarParkUseLogQuery.setSize(1);
                                cfCarParkUseLogQuery.setOrderBy("in_time desc");
                                List<CfCarParkUseLog> useLogs = getListByQuery(cfCarParkUseLogQuery);
                                if(useLogs!=null && useLogs.size()>0 && useLogs.get(0).getPayTime()==0){
                                    notOutCfCarParkUseLogs.add(useLogs.get(0));
                                }
                            }

                            if(notOutCfCarParkUseLogs!=null && notOutCfCarParkUseLogs.size()>0){
                                //showCarTypeName = "月卡车暂时禁用";
                                //当前车辆套餐资格暂时禁用
                                if(entry.getValue().get(0).getStatus()==(byte)1){
                                    entry.getValue().get(0).setStatus((byte)2);
                                    cfCarParkPackageService.onlyUpdate(entry.getValue().get(0));
                                }
                                //如果停车场禁止家庭组同时入场，当前车辆禁止入内
                                if(cfCarPark.getForbidGroupFlagSameTimeIn()==(byte)1){
                                    if(cfCarParkCarLimit==null){
                                        cfCarParkCarLimit = new CfCarParkCarLimit();
                                    }
                                    cfCarParkCarLimit.setAutoOpenDoor((byte)0);
                                    cfCarParkCarLimit.setForbidIn((byte)0);
                                }
                            }else if((cfCarParkUsingPackages!=null || cfCarParkUsingPackages.size()>0) && entry.getValue().get(0).getStatus()!=(byte)1){
                                //恢复其套餐资格
                                entry.getValue().get(0).setStatus((byte)1);
                                cfCarParkPackageService.onlyUpdate(entry.getValue().get(0));
                            }
                        }else{
                            //恢复其套餐资格
                            entry.getValue().get(0).setStatus((byte)1);
                            cfCarParkPackageService.onlyUpdate(entry.getValue().get(0));
                        }
                    }else if(entry.getValue().get(0).getStatus()!=(byte)1){
                        //恢复其套餐资格
                        entry.getValue().get(0).setStatus((byte)1);
                        cfCarParkPackageService.onlyUpdate(entry.getValue().get(0));
                    }
                    if(entry.getValue().get(0).getStatus()==(byte)1){
                        cfCarParkUseLog.setVisitUnit(entry.getKey());
                        break;
                    }
                }
            }else if(cfCarParkPackageList.get(0).getStatus()!=(byte)1){
                //恢复其套餐资格
                cfCarParkPackageList.get(0).setStatus((byte)1);
                cfCarParkPackageService.onlyUpdate(cfCarParkPackageList.get(0));
                cfCarParkUseLog.setVisitUnit(cfCarParkPackageList.get(0).getGroupFlag());
            }
        }

        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, showCarTypeName, "text", "plaintext");
        if(cfCarPark.getLimitParkingSpaceNumber()==(byte)1 && cfCarPark.getUsedParkingSpaceNumber()>=cfCarPark.getParkingSpaceNumber() && ((cfCarParkPackageList.size()>0 && cfCarParkPackageList.get(0).getEndTime()<System.currentTimeMillis()) || showCarTypeName.equals("临时车"))){
            playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, "车位不足，请稍后再来", "text", "plaintext");
            cfCarPark.setStatus((byte)1);
        }
        else if((cfCarParkCheckpoint.getAllowTemporaryCar()==(byte)0 && showCarTypeName.equals("临时车")) || (cfCarParkCheckpoint.getAllowExpiredCar()==(byte)0 && cfCarParkPackageList.size()>0 && cfCarParkPackageList.get(0).getEndTime()<=System.currentTimeMillis()) || (cfCarParkCarLimit!=null && cfCarParkCarLimit.getAutoOpenDoor()==(byte)0)){
            playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, "请待确认", "text", "plaintext");
        }else if(cfCarParkCarLimit!=null && cfCarParkCarLimit.getForbidIn()==(byte)1){
            playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, "禁止入内，请速离开", "text", "plaintext");
        }else{
            playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, "欢迎光临", "text", "plaintext");
        }
        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, "剩余车位:"+(cfCarPark.getParkingSpaceNumber()-cfCarPark.getUsedParkingSpaceNumber()), "text", "plaintext");
        if(cfCarParkPackageList!=null && cfCarParkPackageList.size()>0 && cfCarParkPackageList.get(0).getEndTime()>System.currentTimeMillis()){
            //计算月卡剩余天数
            if(cfCarParkPackageList.get(0).getEndTime()>System.currentTimeMillis()){
                int days = (int)Math.ceil((cfCarParkPackageList.get(0).getEndTime() - System.currentTimeMillis()) / 86400000);
                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, "剩余"+days+"天", "text", "plaintext");
            }else{
                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, "减速慢行注意安全", "text", "plaintext");
            }
        }else{
            playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, "减速慢行注意安全", "text", "plaintext");
        }
        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, cfCarParkUseLog.getNumberPlate(), "voice", "plaintext");

        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, voiceCarTypeName, "voice", "plaintext");

        if((cfCarParkCheckpoint.getAllowTemporaryCar()==(byte)0 && showCarTypeName.equals("临时车")) || (cfCarParkCheckpoint.getAllowExpiredCar()==(byte)0 && cfCarParkPackageList.size()>0 && cfCarParkPackageList.get(0).getEndTime()<=System.currentTimeMillis()) || (cfCarParkCarLimit!=null && cfCarParkCarLimit.getAutoOpenDoor()==(byte)0)){
            playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, "请稍等", "voice", "plaintext");
        }if(cfCarParkCarLimit!=null && cfCarParkCarLimit.getForbidIn()==(byte)1){
            playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, "禁止入内", "voice", "plaintext");
        }else{
            playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.APPROACH, "欢迎光临", "voice", "plaintext");
        }

        if(cameraBrand.equals(DeviceBrand.ZHEN_SHI) || cameraBrand.equals(DeviceBrand.QIAN_YI)){
            showByDeviceRows(playRule, cfCarParkUseLog.getCfCarParkDevice(), SeriaDataUtils.APPROACH);
            SeriaDataUtils.setSerialDataZhenshiByPlayRule(zhenShiResponse911202002050, playRule, SeriaDataUtils.APPROACH,"");
        }else if(cameraBrand.equals(DeviceBrand.HUA_XIA)){
            SeriaDataUtils.setSerialDataHuaXiaByPlayRule(huaXiaResponse, playRule, SeriaDataUtils.APPROACH,"");
        }else if(cameraBrand.equals(DeviceBrand.HK) || cameraBrand.equals(DeviceBrand.DH)){
            //不做任何操作
        }else{
            ExceptionCast.cast(CarParkCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
        }
        cfCarParkUseLog.setCfCarParkCarLimit(cfCarParkCarLimit);
        return playRule;
    }

    /**
     * 车辆正常出场业务处理
     * @param cfCarParkUseLog
     * @param fixFeeCfCarParkUseLog
     * @param cfCarParkCarLimit
     * @param cfOrder
     * @param cameraBrand
     * @param zhenShiResponse911202002050
     * @param huaXiaResponse
     * @param hkResponse
     * @param playRule
     * @param showCarTypeName
     * @param voiceCarTypeName
     * @param cfCarParkPackageList
     * @throws Exception
     */
    private PlayRule normalOutHandle(CfCarParkUseLog cfCarParkUseLog,CfCarParkUseLog fixFeeCfCarParkUseLog,CfCarParkCarLimit cfCarParkCarLimit,
                                     CfOrder cfOrder,String cameraBrand,ZhenShiResponse911202002050 zhenShiResponse911202002050,HuaXiaResponse huaXiaResponse,
                                     HkResponse hkResponse,PlayRule playRule,String showCarTypeName,String voiceCarTypeName,List<CfCarParkPackage> cfCarParkPackageList) throws Exception{
        cfCarParkUseLog.setCfCarParkCarLimit(cfCarParkCarLimit);
        CfOrder feeOrder = cfCarParkChargingRulesService.automaticPayment(cfCarParkUseLog, cfCarParkUseLog.getNumberPlate());
        org.springframework.beans.BeanUtils.copyProperties(feeOrder,cfOrder);
        if(cfOrder.getPayTime()>0){
            if(cfCarParkUseLog.getGiveAwayParkTime()>0){
                Long remainingParkTime = cfCarParkUseLog.getCfCarParkCarLimit().getCfCarParkSpecialCar().getRemainingParkTime();
                //说明赠送的停车时长足够抵扣本次停车时长
                CfCarParkSpecialCar cfCarParkSpecialCar = new CfCarParkSpecialCar();
                cfCarParkSpecialCar.setId(cfCarParkUseLog.getCfCarParkCarLimit().getCfCarParkSpecialCar().getId());
                cfCarParkSpecialCar.setRemainingParkTime(remainingParkTime-cfCarParkUseLog.getGiveAwayParkTime());
                cfCarParkSpecialCarService.update(cfCarParkSpecialCar);
            }
            //发送推送消息
            if(StringUtils.isNotEmpty(cfOrder.getCouponId()) || StringUtils.isNotEmpty(cfOrder.getScoreKeyFlag())){
                cfCarParkUseLog.setPayTime(System.currentTimeMillis());
                cfCarParkUseLog.setReleaseNotice(cfCarParkUseLog.getNumberPlate()+" 车辆优惠券或积分满减出场");

                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, cfCarParkUseLog.getNumberPlate(), "text", "plaintext");
                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, showCarTypeName, "text", "plaintext");
                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "优惠券或积分满减出场", "text", "plaintext");
                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "祝您一路顺风", "text", "plaintext");

                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, cfCarParkUseLog.getNumberPlate(), "voice", "plaintext");
                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, voiceCarTypeName, "voice", "plaintext");
                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "祝您一路顺风", "voice", "plaintext");

                if(cameraBrand.equals(DeviceBrand.ZHEN_SHI) || cameraBrand.equals(DeviceBrand.QIAN_YI)){
                    showByDeviceRows(playRule, cfCarParkUseLog.getCfCarParkDevice(), SeriaDataUtils.FREEOUT);
                    SeriaDataUtils.setSerialDataZhenshiByPlayRule(zhenShiResponse911202002050, playRule, SeriaDataUtils.FREEOUT,"");
                }else if(cameraBrand.equals(DeviceBrand.HUA_XIA)){
                    SeriaDataUtils.setSerialDataHuaXiaByPlayRule(huaXiaResponse, playRule, SeriaDataUtils.FREEOUT,"");
                }else if(cameraBrand.equals(DeviceBrand.HK) || cameraBrand.equals(DeviceBrand.DH)){
                    //不做任何操作
                }else{
                    ExceptionCast.cast(CarParkCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
                }

            }else if(cfOrder.getPaymentAgencyShortName().equals("package")){
                cfCarParkUseLog.setPayTime(System.currentTimeMillis());
                cfCarParkUseLog.setReleaseNotice(cfCarParkUseLog.getNumberPlate()+" "+showCarTypeName+" 车辆出场");

                //判断场内是否还有家庭组车辆停留
//                        if(cfCarParkPackageList.size()>0 && StringUtils.isNotEmpty(cfCarParkPackageList.get(0).getGroupFlag()) && cfCarParkPackageList.get(0).getEndTime()>System.currentTimeMillis()){
//                            cfCarParkPackageQuery.setNumberPlate(null);
//                            cfCarParkPackageQuery.setGroupFlag(cfCarParkPackageList.get(0).getGroupFlag());
////                                cfCarParkPackageQuery.setStatus((byte)1);
//                            List<CfCarParkPackage> cfCarParkUsingPackages = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
//
//                            if(cfCarParkUsingPackages!=null && cfCarParkUsingPackages.size()>0){
//                                List<String> inNumberPlates = new ArrayList<>();
//                                List<String> carParkUseLogIds = new ArrayList<>();
//                                for (CfCarParkPackage cfCarParkPackage: cfCarParkUsingPackages){
//                                    //排除当前车牌
//                                    if(cfCarParkPackage.getNumberPlate().equals(cfCarParkUseLog.getNumberPlate())){
//                                        continue;
//                                    }
//                                    //查询还在场内的家庭组车辆最早停车记录
//                                    CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
//                                    cfCarParkUseLogQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
//                                    cfCarParkUseLogQuery.setNumberPlate(cfCarParkUseLog.getNumberPlate());
//                                    cfCarParkUseLogQuery.setMinInTime(1L);
////                                    cfCarParkUseLogQuery.setPayTime(0L);
//                                    cfCarParkUseLogQuery.setPage(1);
//                                    cfCarParkUseLogQuery.setSize(1);
//                                    cfCarParkUseLogQuery.setOrderBy("in_time desc");
//                                    List<CfCarParkUseLog> notOutCfCarParkUseLogList = getListByQuery(cfCarParkUseLogQuery);
//                                    if(notOutCfCarParkUseLogList!=null && notOutCfCarParkUseLogList.size()>0 && notOutCfCarParkUseLogList.get(0).getPayTime()==0){
//                                        carParkUseLogIds.add(notOutCfCarParkUseLogList.get(0).getId());
//                                    }
//                                }
//                                if(carParkUseLogIds!=null && carParkUseLogIds.size()>0){
//                                    CfCarParkUseLogQuery usingCfCarParkUseLogQuery = new CfCarParkUseLogQuery();
//                                    usingCfCarParkUseLogQuery.setIds(carParkUseLogIds);
//                                    usingCfCarParkUseLogQuery.setPage(1);
//                                    usingCfCarParkUseLogQuery.setSize(1);
//                                    usingCfCarParkUseLogQuery.setOrderBy("in_time asc");
//                                    List<CfCarParkUseLog> notOutCfCarParkUseLogs = getListByQuery(usingCfCarParkUseLogQuery);
//                                    if(notOutCfCarParkUseLogs!=null && notOutCfCarParkUseLogs.size()>0){
//                                        //还停留的场内的第一辆家庭车状态变为临界车
//                                        CfCarParkPackageQuery updateQuery = new CfCarParkPackageQuery();
//                                        updateQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
//                                        updateQuery.setNumberPlate(notOutCfCarParkUseLogs.get(0).getNumberPlate());
//                                        updateQuery.setGroupFlag(cfCarParkPackageList.get(0).getGroupFlag());
//                                        CfCarParkPackage updatePackage = new CfCarParkPackage();
//                                        updatePackage.setStatus((byte)2);
//                                        cfCarParkPackageService.updateByQuery(updateQuery, updatePackage);
//
//                                        //产生固冻结状态的停车记录(费用已固定)，新增新的免停记录
//                                        notOutCfCarParkUseLogs.get(0).setCountFeeStatus((byte)1);
//                                        notOutCfCarParkUseLogs.get(0).setOutTime(System.currentTimeMillis());
//                                        update(notOutCfCarParkUseLogs.get(0));
//                                        CfCarParkUseLog carParkUseLog = new CfCarParkUseLog();
//                                        org.springframework.beans.BeanUtils.copyProperties(notOutCfCarParkUseLogs.get(0), carParkUseLog);
//                                        carParkUseLog.setInTime(System.currentTimeMillis());
//                                        carParkUseLog.setCreatePosition(CarParkUseLogCreatePosition.IN);
//                                        carParkUseLog.setId(null);
//                                        carParkUseLog.setCountFeeStatus((byte)0);
//                                        add(carParkUseLog);
//                                    }
//                                }
//                            }
//                        }

                boolean needFee = false;

                //判断当且车辆套餐是否为临界套餐，如果为临界套餐，查询起临界停车记录，并计算相关费用
//                        if(cfCarParkPackageList!=null && cfCarParkPackageList.size()>0 && cfCarParkPackageList.get(0).getStatus()==(byte)2){
//                            //查询临界停车记录
//                            CfCarParkUseLogQuery fixFeeCfCarParkUseLogQuery = new CfCarParkUseLogQuery();
//                            fixFeeCfCarParkUseLogQuery.setNumberPlate(cfCarParkUseLog.getNumberPlate());
//                            fixFeeCfCarParkUseLogQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
//                            fixFeeCfCarParkUseLogQuery.setCountFeeStatus((byte)1);
//                            fixFeeCfCarParkUseLogQuery.setPayTime(0L);
//                            fixFeeCfCarParkUseLogQuery.setPage(1);
//                            fixFeeCfCarParkUseLogQuery.setSize(1);
//                            fixFeeCfCarParkUseLogQuery.setOrderBy("out_time desc");
//
//                            List<CfCarParkUseLog> fixFeeCfCarParkUseLogs = getListByQuery(fixFeeCfCarParkUseLogQuery);
//
//                            if(fixFeeCfCarParkUseLogs!=null && fixFeeCfCarParkUseLogs.size()>0){
//                                fixFeeCfCarParkUseLogs.get(0).setUid("0");
//                                CfCarParkOrder cfCarParkOrder = cfCarParkChargingRulesService.calculateTheAmounPayable(fixFeeCfCarParkUseLogs.get(0), "0", FeeQueryMode.QUERY_MODE_QUERY_AND_UPDATE);
//                                if(cfCarParkOrder.getCfOrder().getAmountsPayable().doubleValue()>0){
//                                    fixFeeCfCarParkUseLog = fixFeeCfCarParkUseLogs.get(0);
//                                    fixFeeCfCarParkUseLog.setOutHandleUid(cfCarParkCheckpoint.getDutyUid());
//                                    cfOrder = cfCarParkOrder.getCfOrder();
//                                    //费用补缴纳
//                                    needFee = true;
//                                    fixFeeCfCarParkUseLog.setReleaseNotice(fixFeeCfCarParkUseLog.getNumberPlate()+"家庭组车辆换停费用补缴");
//                                    if(cfOrder.getStatus()==PayStatus.TO_BE_PAID){
//                                        //更新订单的应付金额
//                                        CfOrder order = new CfOrder();
//                                        order.setId(cfOrder.getId());
//                                        order.setAmountsPayable(cfOrder.getAmountsPayable());
//                                        cfOrderService.updateByPrimaryKeySelective(order);
//                                    }
//                                }else{
//                                    //免停
//                                    String logId = fixFeeCfCarParkUseLogs.get(0).getId();
//                                    org.springframework.beans.BeanUtils.copyProperties(fixFeeCfCarParkUseLogs.get(0), cfCarParkUseLog, new String[]{"cfCarParkDevice"});
//                                    fixFeeCfCarParkUseLogs.get(0).setId(logId);
//                                    //更新订单
//                                    CfOrderQuery cfOrderQuery = new CfOrderQuery();
//                                    cfOrderQuery.setGoodsId(fixFeeCfCarParkUseLogs.get(0).getId());
//                                    List<CfOrder> cfOrders = cfOrderService.getListByQuery(cfOrderQuery);
//                                    if(cfOrders!=null && cfOrders.size()>0){
//                                        cfOrders.get(0).setPayTime(System.currentTimeMillis());
//                                        cfOrders.get(0).setStatus(PayStatus.PAID);
//                                        cfOrders.get(0).setPaymentAgencyShortName("system_free_time");
//                                        cfOrders.get(0).setAmountsPayable(new BigDecimal(0.00));
//                                        cfOrderService.update(cfOrders.get(0));
//                                    }
//                                }
//                            }
//                        }else{
//
//                        }

                if(needFee){
                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.PAYOUT, cfCarParkUseLog.getNumberPlate(), "text", "plaintext");
                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.PAYOUT, showCarTypeName, "text", "plaintext");
                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.PAYOUT, cfOrder.getAmountsPayable()+"", "text", "fee");
                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.PAYOUT, DateUtil.getDifferenceByTimeStamp(fixFeeCfCarParkUseLog.getInTime(),fixFeeCfCarParkUseLog.getOutTime()), "text", "duration");

                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.PAYOUT, cfCarParkUseLog.getNumberPlate(), "voice", "plaintext");
                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.PAYOUT, voiceCarTypeName, "voice", "plaintext");
                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.PAYOUT, cfOrder.getAmountsPayable()+"", "voice", "fee");

                    if(cameraBrand.equals(DeviceBrand.ZHEN_SHI) || cameraBrand.equals(DeviceBrand.QIAN_YI)){
                        showByDeviceRows(playRule, cfCarParkUseLog.getCfCarParkDevice(), SeriaDataUtils.PAYOUT);
                        SeriaDataUtils.setSerialDataZhenshiByPlayRule(zhenShiResponse911202002050, playRule, SeriaDataUtils.PAYOUT,"");
                    }else if(cameraBrand.equals(DeviceBrand.HUA_XIA)){
                        SeriaDataUtils.setSerialDataHuaXiaByPlayRule(huaXiaResponse, playRule, SeriaDataUtils.PAYOUT,"");
                    }else if(cameraBrand.equals(DeviceBrand.HK) || cameraBrand.equals(DeviceBrand.DH)){
                        //不做任何操作
                    }else{
                        ExceptionCast.cast(CarParkCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
                    }

                }else{
                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, cfCarParkUseLog.getNumberPlate(), "text", "plaintext");
                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, showCarTypeName, "text", "plaintext");
                    if(cfCarParkPackageList.size()>0 && cfCarParkPackageList.get(0).getEndTime()>System.currentTimeMillis()){
                        int days = (int)(Math.ceil((cfCarParkPackageList.get(0).getEndTime() - System.currentTimeMillis()) / 86400000));
                        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "剩余"+days+"天", "text", "plaintext");
                        //如果是家庭组在免停期出去，停车场设置为启动切换，将其它最早进来的家庭组车辆恢复正常
                        if(cfCarParkUseLog.getCfCarPark().getPackageGroupFlagFreeTimeChange()==(byte)1 && StringUtils.isNotEmpty(cfCarParkPackageList.get(0).getGroupFlag()) && (cfCarParkUseLog.getOutTime()-cfCarParkUseLog.getInTime()<=cfCarParkUseLog.getCfCarPark().getFreeTime())){
                            List<String> inNumberPlates = new ArrayList<>();
                            CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
                            cfCarParkPackageQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
                            cfCarParkPackageQuery.setNumberPlate(null);
                            cfCarParkPackageQuery.setGroupFlag(cfCarParkUseLog.getVisitUnit());
                            cfCarParkPackageQuery.setStatus((byte)2);
                            List<CfCarParkPackage> cfCarParkUsingPackages = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
                            if(cfCarParkUsingPackages!=null && cfCarParkUsingPackages.size()>0){
                                for (CfCarParkPackage cfCarParkPackage: cfCarParkUsingPackages){
                                    //排除当前车牌
                                    if(cfCarParkPackage.getNumberPlate().equals(cfCarParkUseLog.getNumberPlate())){
                                        continue;
                                    }
                                    if(!inNumberPlates.contains(cfCarParkPackage.getNumberPlate())){
                                        inNumberPlates.add(cfCarParkPackage.getNumberPlate());
                                    }
                                }
                            }
                            if(inNumberPlates!=null && inNumberPlates.size()>0){
                                //查询还在场内的家庭组车辆最晚的停车记录
                                CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
                                cfCarParkUseLogQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
                                cfCarParkUseLogQuery.setPayTime(0l);
                                cfCarParkUseLogQuery.setMinInTime(cfCarParkUseLog.getInTime()+1000l);
                                cfCarParkUseLogQuery.setNumberPlates(inNumberPlates);
                                cfCarParkUseLogQuery.setPage(1);
                                cfCarParkUseLogQuery.setSize(1);
                                cfCarParkUseLogQuery.setOrderBy("in_time asc");
                                List<CfCarParkUseLog> useLogs = getListByQuery(cfCarParkUseLogQuery);
                                if(useLogs!=null && useLogs.size()>0){
                                    for(CfCarParkPackage cfCarParkPackage: cfCarParkUsingPackages){
                                        if(cfCarParkPackage.getNumberPlate().equals(useLogs.get(0).getNumberPlate())){
                                            //更改对应套餐为正常套餐
                                            CfCarParkPackage updateCarParkPackage = new CfCarParkPackage();
                                            updateCarParkPackage.setId(cfCarParkPackage.getId());
                                            updateCarParkPackage.setStatus((byte)1);
                                            cfCarParkPackageService.onlyUpdate(updateCarParkPackage);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "减速慢行注意安全", "text", "plaintext");
                    }

                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "祝您一路顺风", "text", "plaintext");

                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, cfCarParkUseLog.getNumberPlate(), "voice", "plaintext");
                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, voiceCarTypeName, "voice", "plaintext");
                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "祝您一路顺风", "voice", "plaintext");

                    if(cameraBrand.equals(DeviceBrand.ZHEN_SHI) || cameraBrand.equals(DeviceBrand.QIAN_YI)){
                        showByDeviceRows(playRule, cfCarParkUseLog.getCfCarParkDevice(), SeriaDataUtils.FREEOUT);
                        SeriaDataUtils.setSerialDataZhenshiByPlayRule(zhenShiResponse911202002050, playRule, SeriaDataUtils.FREEOUT,"");
                    }else if(cameraBrand.equals(DeviceBrand.HUA_XIA)){
                        SeriaDataUtils.setSerialDataHuaXiaByPlayRule(huaXiaResponse, playRule, SeriaDataUtils.FREEOUT,"");
                    }else if(cameraBrand.equals(DeviceBrand.HK) || cameraBrand.equals(DeviceBrand.DH)){
                        //不做任何操作
                    }else{
                        ExceptionCast.cast(CarParkCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
                    }

                }
            }else{
                cfCarParkUseLog.setPayTime(System.currentTimeMillis());
                cfCarParkUseLog.setReleaseNotice(cfCarParkUseLog.getNumberPlate()+" 车辆免停出场");

                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, cfCarParkUseLog.getNumberPlate(), "text", "plaintext");
                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, showCarTypeName, "text", "plaintext");

                //计算月卡剩余天数
                if(cfCarParkPackageList!=null && cfCarParkPackageList.size()>0 && cfCarParkPackageList.get(0).getEndTime()>System.currentTimeMillis()){
                    int days = (int)Math.ceil((cfCarParkPackageList.get(0).getEndTime() - System.currentTimeMillis()) / 86400000);
                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "剩余"+days+"天", "text", "plaintext");
                }else{
                    playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "车辆免停出场", "text", "plaintext");
                }
                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "祝您一路顺风", "text", "plaintext");

                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, cfCarParkUseLog.getNumberPlate(), "voice", "plaintext");
                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, voiceCarTypeName, "voice", "plaintext");
                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "祝您一路顺风", "voice", "plaintext");

                if(cameraBrand.equals(DeviceBrand.ZHEN_SHI) || cameraBrand.equals(DeviceBrand.QIAN_YI)){
                    showByDeviceRows(playRule, cfCarParkUseLog.getCfCarParkDevice(), SeriaDataUtils.FREEOUT);
                    SeriaDataUtils.setSerialDataZhenshiByPlayRule(zhenShiResponse911202002050, playRule, SeriaDataUtils.FREEOUT,"");
                }else if(cameraBrand.equals(DeviceBrand.HUA_XIA)){
                    SeriaDataUtils.setSerialDataHuaXiaByPlayRule(huaXiaResponse, playRule, SeriaDataUtils.FREEOUT,"");
                }else if(cameraBrand.equals(DeviceBrand.HK) || cameraBrand.equals(DeviceBrand.DH)){
                    //不做任何操作
                }else{
                    ExceptionCast.cast(CarParkCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
                }

            }
            if(cameraBrand.equals(DeviceBrand.ZHEN_SHI) || cameraBrand.equals(DeviceBrand.QIAN_YI)){
                setCameraOpenOrClose(zhenShiResponse911202002050, "on");
            }else if(cameraBrand.equals(DeviceBrand.HUA_XIA)){
                setCameraOpenOrClose(huaXiaResponse, "on");
            }else if(cameraBrand.equals(DeviceBrand.HK) || cameraBrand.equals(DeviceBrand.DH)){
                hkResponse.setOpenDoor("on");
            }else{
                ExceptionCast.cast(CarParkCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
            }
        }else{
            if(cfOrder.getStatus()==PayStatus.TO_BE_PAID){
                //更新订单的应付金额
                CfOrder order = new CfOrder();
                order.setId(cfOrder.getId());
                order.setAmountsPayable(cfOrder.getAmountsPayable());
                cfOrderService.updateByPrimaryKeySelective(order);
            }

            BigDecimal amountsPayable = cfOrder.getAmountsPayable();
            cfOrder.setAmountsPayable(amountsPayable.subtract(cfOrder.getCouponPaid()));

            if(cameraBrand.equals(DeviceBrand.ZHEN_SHI) || cameraBrand.equals(DeviceBrand.QIAN_YI)){
                setCameraOpenOrClose(zhenShiResponse911202002050, "off");
            }else if(cameraBrand.equals(DeviceBrand.HUA_XIA)){
                setCameraOpenOrClose(huaXiaResponse, "off");
            }else if(cameraBrand.equals(DeviceBrand.HK) || cameraBrand.equals(DeviceBrand.DH)){
                hkResponse.setOpenDoor("off");
            }else{
                ExceptionCast.cast(CarParkCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
            }
        }
        return playRule;
    }

    @Override
    public PlayRule showByDeviceRows(PlayRule playRule, CfCarParkDevice cfCarParkDevice, String scenes) throws Exception {
        if(cfCarParkDevice.getRows().byteValue()==(byte)2){
            ShowContent showContent = null;
            //将第一行和第二行合到第一行显示，将第三和第四行合到第二行显示
            switch (scenes){
                case "approach":
                    //入场
                    showContent = playRule.getApproach();
                    break;
                case "payOut":
                    //缴费出场
                    showContent = playRule.getPayOut();
                    break;
                case "freeOut":
                    //免停出场
                    showContent = playRule.getFreeOut();
                    break;
                case "abnormalOut":
                    //异常出场
                    showContent = playRule.getAbnormalOut();
                    break;
                default:
                    ExceptionCast.cast(CommonCode.INVALID_PARAM,"传入的命令场景不支持:"+scenes);
            }
            Map<String, TextPlay> textPlayList = showContent.getTextPlay();
            if(textPlayList!=null){
                TextPlay textPlay1 = BeanUtils.deepMapToBean(TextPlay.class.newInstance().getClass(), (Map) (textPlayList.get("1")));
                TextPlay textPlay2 = BeanUtils.deepMapToBean(TextPlay.class.newInstance().getClass(), (Map) (textPlayList.get("2")));
                TextPlay textPlay3 = BeanUtils.deepMapToBean(TextPlay.class.newInstance().getClass(), (Map) (textPlayList.get("3")));
                TextPlay textPlay4 = BeanUtils.deepMapToBean(TextPlay.class.newInstance().getClass(), (Map) (textPlayList.get("4")));
                textPlay1.setValue(textPlay1.getValue()+textPlay2.getValue());
                textPlay2.setValue(textPlay3.getValue()+textPlay4.getValue());
                textPlay3.setValue("");
                textPlay4.setValue("");
                Map<String, TextPlay> playHashMap = new HashMap<>();
                playHashMap.put("1",textPlay1);
                playHashMap.put("2",textPlay2);
                playHashMap.put("3",textPlay3);
                playHashMap.put("4",textPlay4);

                showContent.setTextPlay(playHashMap);
            }

        }
        return playRule;
    }

    @Override
    public void sendMessage(CfCarParkUseLog cfCarParkUseLog, String dutyUid, Integer messageType) throws Exception{
        CfCarParkCheckpoint nullParkCheckpoint = new CfCarParkCheckpoint();
        if(StringUtils.isNotEmpty(cfCarParkUseLog.getInCheckPointId())){
            CfCarParkCheckpoint cfCarParkCheckpointIn = cfCarParkCheckpointService.findById(cfCarParkUseLog.getInCheckPointId());
            if(cfCarParkCheckpointIn!=null){
                cfCarParkUseLog.setCfCarParkCheckpointIn(cfCarParkCheckpointIn);
            }else{
                cfCarParkUseLog.setCfCarParkCheckpointIn(nullParkCheckpoint);
            }
        }else{
            cfCarParkUseLog.setCfCarParkCheckpointIn(nullParkCheckpoint);
        }
        if(StringUtils.isNotEmpty(cfCarParkUseLog.getOutCheckPointId())){
            CfCarParkCheckpoint cfCarParkCheckpointOut = cfCarParkCheckpointService.findById(cfCarParkUseLog.getOutCheckPointId());
            if(cfCarParkCheckpointOut!=null){
                cfCarParkUseLog.setCfCarParkCheckpointOut(cfCarParkCheckpointOut);
            }else{
                cfCarParkUseLog.setCfCarParkCheckpointOut(nullParkCheckpoint);
            }
        }else{
            cfCarParkUseLog.setCfCarParkCheckpointOut(nullParkCheckpoint);
        }
        String fileSourceAddress = cfSystemConfigService.getValueByKey("file_source_address", "http://file.cfeng.wang/");
        FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "inBigImage");
        FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "outBigImage");
        FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "inSmallImage");
        FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "outSmallImage");
        executeMessage(cfCarParkUseLog, dutyUid, messageType);
    }

    private void executeMessage(Object messageContents, String dutyUid, Integer messageType) throws Exception{
        CfUserMessage cfUserMessage = new CfUserMessage();
        cfUserMessage.setFromUid("0");
        cfUserMessage.setToUid(dutyUid);
        cfUserMessage.setGroupId("");
        cfUserMessage.setContents(JSONObject.toJSONString(messageContents, SerializerFeature.DisableCircularReferenceDetect));
        cfUserMessage.setType(messageType);
        cfUserMessage.setIp("");
        try {
            cfUserMessageService.sendMessage(cfUserMessage);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void sendLcdMessage(String toUid, Integer messageType, String contents) throws Exception {
        CfUserMessage cfUserMessage = new CfUserMessage();
        cfUserMessage.setFromUid("0");
        cfUserMessage.setToUid(toUid);
        cfUserMessage.setGroupId("");
        cfUserMessage.setContents(contents);
        cfUserMessage.setType(messageType);
        cfUserMessage.setIp("");
        try{
            cfUserMessageService.sendMessage(cfUserMessage);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public CfCarParkUseLog handleUseLogByDevicePushData(CfCarParkUseLog cfCarParkUseLog, CfCarParkDevice cfCarParkDevice, Long inOrOutTime, String smallImage, String bigImage) {

        cfCarParkUseLog.setCarParkId(cfCarParkDevice.getCarParkId());
        if(cfCarParkDevice.getDirection().equals(CarDirection.IN)){
            cfCarParkUseLog.setInSmallImage(smallImage);
            cfCarParkUseLog.setInBigImage(bigImage);
            cfCarParkUseLog.setOutSmallImage("");
            cfCarParkUseLog.setOutBigImage("");
            cfCarParkUseLog.setInTime(inOrOutTime);
            cfCarParkUseLog.setInCheckPointId(cfCarParkDevice.getCheckpointId());
            cfCarParkUseLog.setOutCheckPointId("");
            cfCarParkUseLog.setCreatePosition(CarParkUseLogCreatePosition.OUT);
            cfCarParkUseLog.setPayTime(0L);
            cfCarParkUseLog.setCreateTime(System.currentTimeMillis());
            cfCarParkUseLog.setInReleaseType(ReleaseType.UNKNOWN);
            cfCarParkUseLog.setOutReleaseType(ReleaseType.UNKNOWN);
        }else if(cfCarParkDevice.getDirection().equals(CarDirection.OUT)){

            //先找到它最后一个出场时间
            CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
            cfCarParkUseLogQuery.setNumberPlate(cfCarParkUseLog.getNumberPlate());
            cfCarParkUseLogQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
            cfCarParkUseLogQuery.setMinPayTime(1L);
            cfCarParkUseLogQuery.setPage(1);
            cfCarParkUseLogQuery.setSize(1);
            cfCarParkUseLogQuery.setOrderBy("out_time DESC");
            List<CfCarParkUseLog> cfCarParkUseLogs = getListByQuery(cfCarParkUseLogQuery);
            if(cfCarParkUseLogs!=null && cfCarParkUseLogs.size()>0){
                cfCarParkUseLogQuery.setMinInTime(cfCarParkUseLogs.get(0).getOutTime());
            }else{
                cfCarParkUseLogQuery.setMinInTime(1L);
            }
            cfCarParkUseLogQuery.setMinPayTime(null);
            cfCarParkUseLogQuery.setPayTime(0L);
            cfCarParkUseLogQuery.setOrderBy("create_time DESC");
            cfCarParkUseLogs = getListByQuery(cfCarParkUseLogQuery);
            if(cfCarParkUseLogs==null || cfCarParkUseLogs.size()==0){
                //TODO 缺少入场记录，此处结果后会自动补增出场记录，推送IM给指定群组人员进行相关处理
                cfCarParkUseLog.setInSmallImage("");
                cfCarParkUseLog.setInBigImage("");
                cfCarParkUseLog.setOutSmallImage(smallImage);
                cfCarParkUseLog.setOutBigImage(bigImage);
                cfCarParkUseLog.setInTime(0L);
                cfCarParkUseLog.setOutTime(inOrOutTime);
                cfCarParkUseLog.setInCheckPointId("");
                cfCarParkUseLog.setOutCheckPointId(cfCarParkDevice.getCheckpointId());
                cfCarParkUseLog.setCreatePosition(CarParkUseLogCreatePosition.IN);
                cfCarParkUseLog.setPayTime(0L);
                cfCarParkUseLog.setCreateTime(System.currentTimeMillis());
                cfCarParkUseLog.setInReleaseType(ReleaseType.UNKNOWN);
                cfCarParkUseLog.setOutReleaseType(ReleaseType.AUTO);
                return cfCarParkUseLog;
            }else if(cfCarParkUseLogs!=null && cfCarParkUseLogs.size()>1){
                //TODO 进入此分支说明之前可能存在人工放行该车辆出场但是未作记录，推送IM给指定群组人员进行相关处理
            }
            CfCarParkDevice carParkDevice = cfCarParkUseLog.getCfCarParkDevice();
            cfCarParkUseLog = cfCarParkUseLogs.get(0);
            cfCarParkUseLog.setCfCarParkDevice(carParkDevice);
            cfCarParkUseLog.setOutCheckPointId(cfCarParkDevice.getCheckpointId());

            cfCarParkUseLog.setOutTime(inOrOutTime);
            cfCarParkUseLog.setOutSmallImage(smallImage);
            cfCarParkUseLog.setOutBigImage(bigImage);
            CfCarPark cfCarPark = cfCarParkService.findById(cfCarParkDevice.getCarParkId());
            if(cfCarPark==null){
                ExceptionCast.cast(CarParkCode.CAR_PARK_NOT_EXISTS);
            }

            CfOrderQuery cfOrderQuery = new CfOrderQuery();
            cfOrderQuery.setGoodsId(cfCarParkUseLog.getId());
            cfOrderQuery.setGoodsType(GoodsType.CARPARK_PAYMENT);
            List<CfOrder> cfOrders = cfOrderService.getListByQuery(cfOrderQuery);
            CfOrder cfOrder = null;
            if(cfOrders!=null || cfOrders.size()==0){
                cfOrder = cfOrders.get(0);
            }
//            if(inOrOutTime-cfCarParkUseLog.getInTime()<=cfCarPark.getFreeTime()){
//                //在免费时间内出场(放行)，同时更新对应订单，更新订车记录出场时间
//                cfOrder.setAmountsPayable(BigDecimal.valueOf(0.00));
//                cfOrder.setAmountActuallyPaid(BigDecimal.valueOf(0.00));
//                cfOrder.setStatus(PayStatus.PAID);
//                cfOrder.setPayTime(System.currentTimeMillis());
//                cfOrder.setPaymentAgencyShortName("system_free_time");
//                cfOrderService.update(cfOrder);
//                cfCarParkUseLog.setPayTime(System.currentTimeMillis());
//                cfCarParkUseLog.setOutTime(inOrOutTime);
//                cfCarParkUseLog.setOutReleaseType(ReleaseType.AUTO);
//            }
            return cfCarParkUseLog;
        }
        return cfCarParkUseLog;
    }

    @Override
    public CfCarParkUseLog checkExistsSubscribeLog(CfCarParkUseLog cfCarParkUseLog) {
        CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
        cfCarParkUseLogQuery.setNumberPlate(cfCarParkUseLog.getNumberPlate());
        cfCarParkUseLogQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
        cfCarParkUseLogQuery.setInTime(0L);
        cfCarParkUseLogQuery.setMinSubscribeTime(System.currentTimeMillis());
        cfCarParkUseLogQuery.setCancelSubscribeTime(0L);
        List<CfCarParkUseLog> cfCarParkUseLogs = getListByQuery(cfCarParkUseLogQuery);
        if(cfCarParkUseLogs!=null && cfCarParkUseLogs.size()>0 && cfCarParkUseLogs.get(0).getPayTime()>0){
            //存在预定
            cfCarParkUseLogs.get(0).setInTime(cfCarParkUseLog.getInTime());
            cfCarParkUseLogs.get(0).setInReleaseType(ReleaseType.AUTO);
            cfCarParkUseLogs.get(0).setInSmallImage(cfCarParkUseLog.getInSmallImage());
            cfCarParkUseLogs.get(0).setInBigImage(cfCarParkUseLog.getInBigImage());
            return cfCarParkUseLogs.get(0);
        }
        return null;
    }

    @Override
    public CfOrder makeCfOrderData(CfCarParkUseLog cfCarParkUseLog) {
        CfOrder cfOrder = new CfOrder();
        cfOrder.setRandomId(idWorker.nextId());
        cfOrder.setUid("");
        cfOrder.setUserPaymentAgencyId("");
        cfOrder.setEffectObject(cfCarParkUseLog.getNumberPlate());
        cfOrder.setGoodsName("停车缴费:"+cfCarParkUseLog.getNumberPlate());
        cfOrder.setGoodsId(cfCarParkUseLog.getId());
        if(StringUtils.isNotEmpty(cfCarParkUseLog.getInSmallImage())){
            cfOrder.setGoodsImage(cfCarParkUseLog.getInSmallImage());
        }else{
            cfOrder.setGoodsImage(cfCarParkUseLog.getOutSmallImage());
        }
        cfOrder.setGoodsType(GoodsType.CARPARK_PAYMENT);
        cfOrder.setAmountsPayable(BigDecimal.valueOf(0.00));
        cfOrder.setAmountActuallyPaid(BigDecimal.valueOf(0.00));
        cfOrder.setRefundAmount(BigDecimal.valueOf(0.00));
        cfOrder.setCouponId("");
        cfOrder.setStatus(PayStatus.TO_BE_PAID);
        cfOrder.setPayTime(0L);
        cfOrder.setRefundTime(0L);
        cfOrder.setCancelTime(0L);
        cfOrder.setPaymentAgencyShortName("");
        cfOrder.setThirdPartyOrderId("");
        cfOrder.setShopId(cfCarParkUseLog.getCarParkId());
        if(cfOrder.getScorePaid()==null){
            cfOrder.setScorePaid(new BigDecimal(0.00));
        }
        if(StringUtils.isEmpty(cfOrder.getScoreKeyFlag())){
            cfOrder.setScoreKeyFlag("");
        }
        if(cfOrder.getCouponPaid()==null){
            cfOrder.setCouponPaid(new BigDecimal(0.00));
        }
        if(cfOrder.getScoreMoney()==null){
            cfOrder.setScoreMoney(new BigDecimal(0.00));
        }
        return cfOrder;
    }

    @Override
    public PlayRule paySuccessfulPushDeviceMessage(CfCarParkUseLog cfCarParkUseLog) throws Exception {
        if(cfCarParkUseLog.getCfCarParkDevice()==null){
            CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
            cfCarParkDeviceQuery.setCheckpointId(cfCarParkUseLog.getOutCheckPointId());
            cfCarParkDeviceQuery.setDirection(CarDirection.OUT);
            cfCarParkDeviceQuery.setType((byte)2);
            cfCarParkDeviceQuery.setPage(1);
            cfCarParkDeviceQuery.setSize(1);
            List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
            if(cfCarParkDevices!=null && cfCarParkDevices.size()>0){
                cfCarParkUseLog.setCfCarParkDevice(cfCarParkDevices.get(0));
            }else{
                return null;
            }
        }

        if(cfCarParkUseLog.getCfOrder()==null){
            return null;
        }

        PlayRule playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(cfCarParkUseLog.getCfCarParkDevice().getPlayContents(), SeriaDataUtils.FREEOUT, cfCarParkUseLog.getNumberPlate(), "text", "plaintext");
        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "电子支付", "text", "plaintext");
        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "已缴费"+cfCarParkUseLog.getCfOrder().getAmountsPayable()+"元", "text", "plaintext");
        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "祝您一路顺风", "text", "plaintext");

        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, cfCarParkUseLog.getNumberPlate(), "voice", "plaintext");
        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "已缴费"+cfCarParkUseLog.getCfOrder().getAmountsPayable()+"元", "voice", "plaintext");
        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), SeriaDataUtils.FREEOUT, "祝您一路顺风", "voice", "plaintext");
        return playRule;
    }

    @Override
    public List<CfCarParkUseLog> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) throws Exception {
        String sql = "SELECT cpul.*,cp.id cp_id,cp.name cp_name," +
                "cpckin.id cpckin_id,cpckin.name cpckin_name," +
                "cpckout.id cpckout_id,cpckout.name cpckout_name," +
                "ord.id ord_id,ord.uid ord_uid,ord.amounts_payable ord_amounts_payable,ord.amount_actually_paid ord_amount_actually_paid," +
                "ord.refund_amount ord_refund_amount,ord.payment_agency_short_name ord_payment_agency_short_name,ord.score_paid ord_score_paid,ord.coupon_paid ord_coupon_paid,ord.manual_offer ord_manual_offer," +
                "ord.collection_amount ord_collection_amount "+
                "FROM cf_car_park_use_log cpul " +
                "LEFT JOIN cf_car_park cp ON(cpul.car_park_id=cp.id) " +
                "LEFT JOIN cf_car_park_checkpoint cpckin ON(cpul.in_check_point_id=cpckin.id) "+
                "LEFT JOIN cf_car_park_checkpoint cpckout ON(cpul.out_check_point_id=cpckout.id) "+
//                "LEFT JOIN cf_car_park_package cpp ON(cpul.number_plate=cpp.number_plate and cpp.car_park_id=cpul.car_park_id) "+
//                "LEFT JOIN cf_car_park_car_type cpct ON(cpct.flag_key=cpul.car_type) "+
                "LEFT JOIN cf_order ord ON(cpul.id=ord.goods_id) ";
//                "LEFT JOIN cf_payment_agency pa ON(ord.payment_agency_short_name=pa.short_name) ";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        List<CfCarParkUseLog> cfCarParkUseLogs = cfCarParkUseLogMapper.selectListByCondition(sql);
        return cfCarParkUseLogs;
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_car_park_use_log cpul";
        //判断是否含有账单相关搜索
        if(conditions.containsKey("payment_agency_short_name") || conditions.containsKey("payment_agency_short_name$in")
                || conditions.containsKey("amounts_payable") ||conditions.containsKey("amount_actually_paid") ||conditions.containsKey("status")){
            sql += " LEFT JOIN cf_order ord ON(cpul.id=ord.goods_id)";
        }

        conditions.remove("group");
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, true);
        return cfCarParkUseLogMapper.selectListByConditionCounts(sql);
    }

    @Override
    public CfCarParkUseLog applyForAccess(String uid, String direction, String checkPointId, byte type, String deviceNo) throws Exception {
        //校验停车场和关卡是否存在
        CfCarParkCheckpoint cfCarParkCheckpoint = cfCarParkCheckpointService.findById(checkPointId, false);
        //设备
        CfCarParkDevice cfCarParkDevice = null;
        //如果没有传入设备编号，判断一下是否为地锁关卡误扫
        CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
        cfCarParkDeviceQuery.setCheckpointId(checkPointId);
        if(StringUtils.isEmpty(deviceNo)){

            cfCarParkDeviceQuery.setPage(1);
            cfCarParkDeviceQuery.setSize(1);
            List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
            if(cfCarParkDevices==null || cfCarParkDevices.size()==0){
                ExceptionCast.cast(CarParkCode.DEVICE_IS_NOT_REGISTERED);
            }else if(cfCarParkDevices.get(0).getType().byteValue()!=(byte)2){
                ExceptionCast.cast(CarParkCode.MISS_DEVICE_NO);
            }
        }else{
            //说明是扫码地锁之类的设备
            cfCarParkDeviceQuery.setDeviceNo(deviceNo);
            cfCarParkDeviceQuery.setType((byte)3);
            cfCarParkDeviceQuery.setDirection(null);
            List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
            if(cfCarParkDevices==null || cfCarParkDevices.size()==0){
                ExceptionCast.cast(CarParkCode.DEVICE_IS_NOT_REGISTERED);
            }
            //禁止该设备车位未空闲时他人二次扫入
            if(cfCarParkDevices.get(0).getStatus().byteValue()==(byte)3){
                //判断是否为同一个人扫
                CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
                cfCarParkUseLogQuery.setUid(uid);
                cfCarParkUseLogQuery.setCarParkId(cfCarParkCheckpoint.getCarParkId());
                cfCarParkUseLogQuery.setPayTime(0l);
                cfCarParkUseLogQuery.setPage(1);
                cfCarParkUseLogQuery.setSize(1);
                List<CfCarParkUseLog> cfCarParkUseLogList = getListByQuery(cfCarParkUseLogQuery);
                if(cfCarParkUseLogList==null || cfCarParkUseLogList.size()==0){
                    ExceptionCast.cast(CarParkCode.DEVICE_OCCUPIED);
                }
                direction = CarDirection.OUT;
            }else{
                direction = CarDirection.IN;
            }
            cfCarParkDevice = cfCarParkDevices.get(0);
        }
        //若停车场车位已满禁止入场
        CfCarPark cfCarPark = cfCarParkService.findById(cfCarParkCheckpoint.getCarParkId(), false);
        if(cfCarPark.getUsedParkingSpaceNumber()>=cfCarPark.getParkingSpaceNumber() && direction.equals(CarDirection.IN)){
            ExceptionCast.cast(CarParkCode.INSUFFICIENT_PARKING_SPACES);
        }
        //暂停营业时禁止入场
        if(cfCarPark.getStatus()==2 && direction.equals(CarDirection.IN)){
            ExceptionCast.cast(CarParkCode.SUSPEND_BUSINESS);
        }

        CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
        cfCarParkUseLogQuery.setUid(uid);
        cfCarParkUseLogQuery.setPayTime(0L);
        cfCarParkUseLogQuery.setCarParkId(cfCarParkCheckpoint.getCarParkId());
        List<CfCarParkUseLog> cfCarParkUseLogs = getListByQuery(cfCarParkUseLogQuery);
        if(direction.equals(CarDirection.IN)){
            if(cfCarParkUseLogs!=null && cfCarParkUseLogs.size()>0){
                ExceptionCast.cast(CarParkCode.REPEAT_APPLY_FORACCESS);
            }
            CfCarParkUseLog cfCarParkUseLog = new CfCarParkUseLog("",CarParkConfig.TEMPORARY_NUMBER_PLATE,uid,"","","",""
                    ,cfCarParkCheckpoint.getCarParkId(),0L,0L,System.currentTimeMillis(),0L,ReleaseType.AUTO,ReleaseType.UNKNOWN,checkPointId,"",CarParkUseLogCreatePosition.OUT,
                    0L,System.currentTimeMillis(), "无牌车扫码入场", cfCarParkCheckpoint.getDutyUid(), "", (byte)0,"","temporary_car",(byte)1,"");
            cfCarParkUseLog.setParkingSpaceNumber(deviceNo);
            CfCarParkUseLog carParkUseLog = add(cfCarParkUseLog);
            cfCarParkUseLog.setCfCarParkDevice(cfCarParkDevice);
            releaseTemporaryCar(carParkUseLog, direction, type);
            sendMessage(cfCarParkUseLog, cfCarParkUseLog.getInHandleUid(), 1);
            //TODO 通知相机抓拍 后期完善
            cfCarParkService.updateUsedParkingSpaceNumber(cfCarParkUseLog.getCarParkId(),1);
            if(StringUtils.isNotEmpty(deviceNo) && cfCarParkDevice!=null && cfCarParkDevice.getType().byteValue()==(byte)3){
                //说明设备类型是地锁，通知对应的地扫开闸
                cfCarParkDeviceService.controlledLockUpAndDown("down",cfCarParkDevice.getBarCode());
                //将地锁状态设置为占用
                CfCarParkDevice updateCarParkDevice = new CfCarParkDevice();
                updateCarParkDevice.setId(cfCarParkDevice.getId());
                updateCarParkDevice.setStatus((byte)3);
                cfCarParkDeviceService.updateByPrimaryKeySelective(updateCarParkDevice);
            }
            return carParkUseLog;
        }else if(direction.equals(CarDirection.OUT)){
            if(cfCarParkUseLogs==null || cfCarParkUseLogs.size()==0){
                ExceptionCast.cast(CarParkCode.APPLY_FORACCESS_NOT_FOUND);
            }
            CfCarParkUseLog cfCarParkUseLog = cfCarParkUseLogs.get(0);
            if(cfCarParkUseLog.getPayTime()>0){
                ExceptionCast.cast(CarParkCode.REPEAT_APPLY_FORACCESS);
            }
            CfCarParkUseLog carParkUseLog = new CfCarParkUseLog();
            CfCarParkOrder cfCarParkOrder = cfCarParkChargingRulesService.calculateTheAmounPayable(cfCarParkUseLog.getId(), uid, FeeQueryMode.QUERY_MODE_QUERY_AND_UPDATE);
            if(cfCarParkOrder.getCfOrder().getPayTime()>0){
                cfCarParkOrder.getCfCarParkUseLog().setPayTime(cfCarParkOrder.getCfOrder().getPayTime());
                carParkUseLog.setPayTime(cfCarParkOrder.getCfOrder().getPayTime());
                carParkUseLog.setOutTime(cfCarParkOrder.getCfOrder().getPayTime());
            }
            cfCarParkUseLog = cfCarParkOrder.getCfCarParkUseLog();

            carParkUseLog.setId(cfCarParkUseLog.getId());
            carParkUseLog.setOutCheckPointId(checkPointId);
            cfCarParkUseLog.setOutCheckPointId(checkPointId);
            carParkUseLog.setParkingSpaceNumber(deviceNo);
            updateByPrimaryKeySelective(carParkUseLog);

            if(cfCarParkUseLog.getPayTime()==0){
                return cfCarParkUseLog;
            }
            cfCarParkUseLog.setCfCarParkDevice(cfCarParkDevice);
            releaseTemporaryCar(cfCarParkUseLog, direction, type);
            cfCarParkService.updateUsedParkingSpaceNumber(cfCarParkUseLog.getCarParkId(),-1);
            //将地锁状态设置为正常
            CfCarParkDevice updateCarParkDevice = new CfCarParkDevice();
            updateCarParkDevice.setId(cfCarParkDevice.getId());
            updateCarParkDevice.setStatus((byte)1);
            cfCarParkDeviceService.updateByPrimaryKeySelective(updateCarParkDevice);
            return cfCarParkUseLog;
        }
        return null;
    }

    @Override
    public void releaseTemporaryCar(CfCarParkUseLog cfCarParkUseLog, String direction, byte type) throws Exception {
        if(cfCarParkUseLog.getCfCarParkDevice()==null){
            CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
            if(direction.equals(CarDirection.IN)){
                cfCarParkDeviceQuery.setCheckpointId(cfCarParkUseLog.getInCheckPointId());
            }else{
                cfCarParkDeviceQuery.setCheckpointId(cfCarParkUseLog.getOutCheckPointId());
            }
            cfCarParkDeviceQuery.setDirection(direction);
            cfCarParkDeviceQuery.setType((byte)2);
            List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
            if(cfCarParkDevices==null || cfCarParkDevices.size()==0){
                ExceptionCast.cast(CarParkCode.DEVICE_IS_NOT_REGISTERED);
            }
            cfCarParkUseLog.setCfCarParkDevice(cfCarParkDevices.get(0));
        }
        if(cfCarParkUseLog.getUid()==null){
            cfCarParkUseLog.setUid("");
        }
        CfCarParkReleaseLog cfCarParkReleaseLog = new CfCarParkReleaseLog("", cfCarParkUseLog.getCarParkId(), cfCarParkUseLog.getId(), cfCarParkUseLog.getNumberPlate()
                , cfCarParkUseLog.getUid(), cfCarParkUseLog.getCfCarParkDevice().getBarCode(), System.currentTimeMillis(), CarParkConfig.TEMPORARY_NUMBER_PLATE_RELEASE,
                System.currentTimeMillis(), (byte) 0, type);
        cfCarParkReleaseLog.setCfCarParkDevice(cfCarParkUseLog.getCfCarParkDevice());
        cfCarParkReleaseLogService.add(cfCarParkReleaseLog, "release_");
    }

    @Override
    public CfCarParkOrder subscribeParkingSpace(CfCarParkUseLog cfCarParkUseLog, String payTypeId, String ip) throws Exception {
        CfCarPark cfCarPark = cfCarParkService.findById(cfCarParkUseLog.getCarParkId(), false);
        if(cfCarPark.getUsedParkingSpaceNumber()>=cfCarPark.getParkingSpaceNumber()){
            ExceptionCast.cast(CarParkCode.INSUFFICIENT_PARKING_SPACES);
        }
        if(cfCarPark.getStatus()==2){
            ExceptionCast.cast(CarParkCode.SUSPEND_BUSINESS);
        }
        if(cfCarParkUseLog.getSubscribeTime()-cfCarPark.getMinAdvanceSubscribeTime()<System.currentTimeMillis()){
            ExceptionCast.cast(CarParkCode.TOO_CLOSE_TO_SUBSCRIPTION_TIME);
        }
        if(cfCarParkUseLog.getSubscribeTime()-cfCarPark.getMaxAdvanceSubscribeTime()>System.currentTimeMillis()){
            ExceptionCast.cast(CarParkCode.TOO_LONG_TO_SUBSCRIBE);
        }
        cfCarParkUseLog.setInSmallImage("");
        cfCarParkUseLog.setInBigImage("");
        cfCarParkUseLog.setOutSmallImage("");
        cfCarParkUseLog.setOutBigImage("");
        cfCarParkUseLog.setInSmallImage("");
        cfCarParkUseLog.setCancelSubscribeTime(0L);
        cfCarParkUseLog.setInTime(0L);
        cfCarParkUseLog.setOutTime(0L);
        cfCarParkUseLog.setInReleaseType(ReleaseType.UNKNOWN);
        cfCarParkUseLog.setOutReleaseType(ReleaseType.UNKNOWN);
        cfCarParkUseLog.setInCheckPointId("");
        cfCarParkUseLog.setOutCheckPointId("");
        cfCarParkUseLog.setCreatePosition(CarParkUseLogCreatePosition.OUT);
        cfCarParkUseLog.setPayTime(0L);
        CfCarParkUseLog carParkUseLog = add(cfCarParkUseLog);

        CfCarParkOrder cfCarParkOrder = new CfCarParkOrder();
        if(cfCarPark.getSubscribeFee().doubleValue()>0){
            CfOrder cfOrder = new CfOrder();
            cfOrder.setUid(cfCarParkUseLog.getUid());
            cfOrder.setGoodsName("停车缴费:"+cfCarParkUseLog.getNumberPlate()+"[含预约]");
            cfOrder.setGoodsId(carParkUseLog.getId());
            cfOrder.setGoodsImage("");
            cfOrder.setGoodsType(GoodsType.PARKING_SUBSCRIPTION);
            cfOrder.setAmountsPayable(cfCarPark.getSubscribeFee());
            cfOrder.setAmountActuallyPaid(new BigDecimal("0.00"));
            cfOrder.setRefundAmount(new BigDecimal("0.00"));
            cfOrder.setCouponId("");
            cfOrder.setStatus(PayStatus.TO_BE_PAID);
            cfOrder.setPayTime(0L);
            cfOrder.setRefundTime(0L);
            cfOrder.setCancelTime(0L);
            cfOrder.setPaymentAgencyShortName("");
            cfOrder.setThirdPartyOrderId("");
            cfOrder.setEffectObject("");
            cfOrder.setUserPaymentAgencyId(payTypeId);
            cfOrder.setShopId(cfCarParkUseLog.getCarParkId());
            CfOrder order = cfOrderService.add(cfOrder);
            cfCarParkOrder.setCfCarPark(cfCarPark);
            cfCarParkOrder.setCfCarParkUseLog(carParkUseLog);
            cfCarParkOrder.setCfOrder(order);
            cfCarParkOrder.setResultMap(cfOrderService.payForOrder(order, payTypeId, ip));
        }
        return cfCarParkOrder;
    }

    @Override
    public List<CountByDay> limitDaysCountByDay(CfCountCarParkUseLogQuery cfCountCarParkUseLogQuery) {
        return cfCarParkUseLogMapper.limitDaysCountByDay(cfCountCarParkUseLogQuery);
    }

    @Override
    public List<CountByDay> yearMonthCountByDay(CfCountCarParkUseLogQuery cfCountCarParkUseLogQuery) {
        cfCountCarParkUseLogQuery.setDate(cfCountCarParkUseLogQuery.getYear()+"-"+cfCountCarParkUseLogQuery.getMonth()+"-16"+" 00:00:00");
        return cfCarParkUseLogMapper.yearMonthCountByDay(cfCountCarParkUseLogQuery);
    }

    @Override
    public List<CountByDay> yearCountByMonth(CfCountCarParkUseLogQuery cfCountCarParkUseLogQuery) {
        cfCountCarParkUseLogQuery.setDate(cfCountCarParkUseLogQuery.getYear()+"-01-01 00:00:00");
        cfCountCarParkUseLogQuery.setEndDate(cfCountCarParkUseLogQuery.getYear()+"-12-31 23:59:59");
        return cfCarParkUseLogMapper.yearCountByMonth(cfCountCarParkUseLogQuery);
    }

    @Override
    public BigDecimal countPayAmountByDuty(CountPayAmountByDutyQuery countPayAmountByDutyQuery) {
        return cfCarParkUseLogMapper.countPayAmountByDuty(countPayAmountByDutyQuery);
    }

    @Override
    public CfCarParkOrder manuallyUpload(byte[] numberPlateImage, String originalFilename, String carParkCheckPointId, Long timeStamp, String uid, String platform) throws Exception {
        //检查通道是否合法
        CfCarParkCheckpoint cfCarParkCheckpoint = cfCarParkCheckpointService.findById(carParkCheckPointId, false);

        CfCarPark cfCarPark = cfCarParkService.findById(cfCarParkCheckpoint.getCarParkId(), false);
        //文件上传
        FileSystem upload = fileSystemService.upload(numberPlateImage, originalFilename, "image/jpeg", "number_plate", "carPark", "", platform);
        List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("ali_oss");
        String endpoint = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("endpoint", cfWeixinConfigs);
        String bucketName = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("bucket_name", cfWeixinConfigs);
        //使用阿里云OCR云端识别车牌
        String numberPlateOcr = cfCarParkOcrService.AliNumberPlateOcr("https://" + bucketName + "." + endpoint + "/" + upload.getFileId());

        CfCarParkUseLog cfCarParkUseLog = null;
        CfCarParkOrder cfCarParkOrder = new CfCarParkOrder();

        if(cfCarParkCheckpoint.getDirection().equals(CarDirection.IN)){
            //添加停车记录
            cfCarParkUseLog = new CfCarParkUseLog();
            cfCarParkUseLog .setNumberPlate(numberPlateOcr);
            cfCarParkUseLog .setUid("");
            cfCarParkUseLog.setInSmallImage(upload.getFileId());
            cfCarParkUseLog.setOutSmallImage("");
            cfCarParkUseLog.setInBigImage(upload.getFileId());
            cfCarParkUseLog.setOutBigImage(upload.getFileId());
            cfCarParkUseLog.setCarParkId(cfCarParkCheckpoint.getCarParkId());
            cfCarParkUseLog.setSubscribeTime(0L);
            cfCarParkUseLog.setCancelSubscribeTime(0L);
            cfCarParkUseLog.setInTime(System.currentTimeMillis());
            cfCarParkUseLog.setOutTime(0L);
            cfCarParkUseLog.setInReleaseType(ReleaseType.ARTIFICIAL);
            cfCarParkUseLog.setOutReleaseType(ReleaseType.UNKNOWN);
            cfCarParkUseLog.setInCheckPointId(carParkCheckPointId);
            cfCarParkUseLog.setOutCheckPointId("");
            cfCarParkUseLog.setCreatePosition(CarParkUseLogCreatePosition.OUT);
            cfCarParkUseLog.setPayTime(0L);
            cfCarParkUseLog.setInHandleUid(uid);
            cfCarParkUseLog.setOutHandleUid("");
            cfCarParkUseLog = add(cfCarParkUseLog);

            cfCarParkOrder.setInCheckpoint(cfCarParkCheckpoint);

        }else{
            //先找到它最后一个出场时间
            CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
            cfCarParkUseLogQuery.setNumberPlate(numberPlateOcr);
            cfCarParkUseLogQuery.setCarParkId(cfCarParkCheckpoint.getCarParkId());
            cfCarParkUseLogQuery.setMinPayTime(1L);
            cfCarParkUseLogQuery.setPage(1);
            cfCarParkUseLogQuery.setSize(1);
            cfCarParkUseLogQuery.setOrderBy("out_time DESC");
            List<CfCarParkUseLog> cfCarParkUseLogs = getListByQuery(cfCarParkUseLogQuery);
            if(cfCarParkUseLogs!=null && cfCarParkUseLogs.size()>0){
                cfCarParkUseLogQuery.setMinInTime(cfCarParkUseLogs.get(0).getOutTime());
            }else{
                cfCarParkUseLogQuery.setMinInTime(1L);
            }
            cfCarParkUseLogQuery.setMinPayTime(null);
            cfCarParkUseLogQuery.setPayTime(0L);
            cfCarParkUseLogQuery.setOrderBy("create_time DESC");
            cfCarParkUseLogs = getListByQuery(cfCarParkUseLogQuery);
            if(cfCarParkUseLogs!=null && cfCarParkUseLogs.size()>0){
                cfCarParkUseLog = cfCarParkUseLogs.get(0);
                cfCarParkUseLog.setOutReleaseType(ReleaseType.ARTIFICIAL);
                cfCarParkUseLog.setOutHandleUid(uid);
                cfCarParkUseLog.setOutSmallImage(upload.getFileId());
                cfCarParkUseLog.setOutBigImage(upload.getFileId());
                cfCarParkUseLog.setOutCheckPointId(carParkCheckPointId);

                CfCarParkCheckpoint inCarParkCheckpoint = cfCarParkCheckpointService.findById(cfCarParkUseLog.getInCheckPointId(), false);
                cfCarParkOrder.setInCheckpoint(inCarParkCheckpoint);

                if(System.currentTimeMillis()-cfCarParkUseLog.getInTime()<=cfCarPark.getFreeTime()){
                    CfOrderQuery cfOrderQuery = new CfOrderQuery();
                    cfOrderQuery.setGoodsId(cfCarParkUseLog.getId());
                    cfOrderQuery.setGoodsType(GoodsType.CARPARK_PAYMENT);
                    List<CfOrder> cfOrders = cfOrderService.getListByQuery(cfOrderQuery);
                    //在免费时间内出场(放行)，同时更新对应订单，更新订车记录出场时间
                    cfOrders.get(0).setAmountsPayable(BigDecimal.valueOf(0.00));
                    cfOrders.get(0).setAmountActuallyPaid(BigDecimal.valueOf(0.00));
                    cfOrders.get(0).setStatus(PayStatus.PAID);
                    cfOrders.get(0).setPayTime(System.currentTimeMillis());
                    cfOrders.get(0).setPaymentAgencyShortName("system_free_time");
                    cfOrderService.update(cfOrders.get(0));
                    cfCarParkUseLog.setPayTime(System.currentTimeMillis());
                    cfCarParkUseLog.setOutTime(System.currentTimeMillis());
                    cfCarParkUseLog.setOutReleaseType(ReleaseType.AUTO);
                    cfCarParkOrder.setCfOrder(cfOrders.get(0));
                    update(cfCarParkUseLog);
                }else{
                    CfOrder cfOrder = cfCarParkChargingRulesService.automaticPayment(cfCarParkUseLog, cfCarParkUseLog.getNumberPlate());
                    cfCarParkOrder.setCfOrder(cfOrder);
                    if(cfOrder.getPayTime()==0){
                        update(cfCarParkUseLog);
                        //需要支付
                        cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("h5_login");
                        String redirectUrl = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("h5_login_success_redirect_url", cfWeixinConfigs);
                        byte[] qrCodeImage = cfQrCodeService.getQRCodeImage(redirectUrl + "?carpark_checkpoint_id=" + carParkCheckPointId, 450, 450);
                        cfCarParkOrder.setQrCode(Base64.getEncoder().encodeToString(qrCodeImage));
                    }
                }

            }else{
                ExceptionCast.cast(CarParkCode.CAR_NOT_IN_CARPARK, numberPlateOcr+" 该车牌没有入场记录");
            }
        }

        cfCarParkOrder.setCfCarPark(cfCarPark);
        cfCarParkOrder.setCfCarParkUseLog(cfCarParkUseLog);
        return cfCarParkOrder;
    }

    @Override
    public Long countByField(CfCarParkUseLogQuery cfCarParkUseLogQuery) {
        return cfCarParkUseLogMapper.countByField(cfCarParkUseLogQuery);
    }

    @Override
    public void lVGEMSmartConstructionPlatform(CfCarParkUseLog cfCarParkUseLog, Map<String, String> config) throws Exception {

        if(cfCarParkUseLog==null){
            return;
        }

        //先获取token
        CfWeixinConfigQuery cfWeixinConfigQuery = new CfWeixinConfigQuery();
        cfWeixinConfigQuery.setEnName("lVGEMSmartConstructionPlatform");
        List<CfWeixinConfig> weixinConfigs = cfWeixinConfigService.getListByQuery(cfWeixinConfigQuery);
        String token = "";
        if(weixinConfigs==null || weixinConfigs.size()==0){
            JSONObject params = new JSONObject();
            params.put("appKey",config.get("appKey"));
            params.put("appSecret",config.get("appSecret"));
            params.put("timeStamp",System.currentTimeMillis());
            params.put("rand",StringTools.getRandomString("", 12));
            Map<String, String> header = new HashMap<>();
            header.put("Content-Type","application/json");
            JSONObject result = (JSONObject)HttpClient.doPost(params, "http://127.0.0.1:16007/authority/api/getAuthenticate", header, true);
            if(result.containsKey("code") && result.getString("code").equals("0")){
                token = ((Map<String, String>)result.get("data")).get("token").toString();
                CfWeixinConfig cfWeixinConfig = new CfWeixinConfig();
                cfWeixinConfig.setEnName("lVGEMSmartConstructionPlatform");
                cfWeixinConfig.setZhName("深圳绿景智慧建造平台token");
                cfWeixinConfig.setUseScenes("parking_data_platform");
                cfWeixinConfig.setValue(token);
                cfWeixinConfig.setDescription("用于上传停车数据到深圳绿景智慧建造平台");
                cfWeixinConfig.setExpireTime(System.currentTimeMillis()+252000000);
                CfWeixinConfig weixinConfig = cfWeixinConfigService.add(cfWeixinConfig);
            }else{
                return;
            }
        }else if(weixinConfigs.get(0).getExpireTime()+300000<System.currentTimeMillis()){
            JSONObject params = new JSONObject();
            params.put("appKey",config.get("appKey"));
            params.put("appSecret",config.get("appSecret"));
            params.put("timeStamp",System.currentTimeMillis());
            params.put("rand",StringTools.getRandomString("", 12));
            Map<String, String> header = new HashMap<>();
            JSONObject result = (JSONObject)HttpClient.doPost(params, "http://127.0.0.1:16007/authority/api/getAuthenticate", header, true);
            if(result.containsKey("code") && result.getString("code").equals("0")){
                token = ((Map<String, String>)result.get("data")).get("token").toString();
                weixinConfigs.get(0).setValue(token);
                weixinConfigs.get(0).setExpireTime(System.currentTimeMillis()+252000000);
                cfWeixinConfigService.update(weixinConfigs.get(0));
            }else{
                return;
            }
        }else{
            token = weixinConfigs.get(0).getValue();
        }

        //开始向平台推送数据

        JSONObject params = new JSONObject();
        params.put("recordId",cfCarParkUseLog.getId());
        params.put("barrierType","01");
        params.put("projectId",cfCarParkUseLog.getCarParkId());
        String fileSourceAddress = cfSystemConfigService.getValueByKey("file_source_address", "http://file.cfeng.wang/");
        if(cfCarParkUseLog.getOutTime()>0){
            params.put("barrierId",cfCarParkUseLog.getOutCheckPointId());
            if(cfCarParkUseLog.getCfCarParkCheckpointOut()!=null){
                params.put("barrierName",cfCarParkUseLog.getCfCarParkCheckpointOut().getName());
            }else{
                params.put("barrierName","出口");
            }

            params.put("passDirection","2");

            if(StringUtils.isNotEmpty(cfCarParkUseLog.getOutBigImage())){
                FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "outBigImage");
                params.put("vehicleImageUrl",cfCarParkUseLog.getOutBigImage());
            }
        }else{
            params.put("barrierId",cfCarParkUseLog.getInCheckPointId());
            if(cfCarParkUseLog.getCfCarParkCheckpointIn()!=null){
                params.put("barrierName",cfCarParkUseLog.getCfCarParkCheckpointIn().getName());
            }else{
                params.put("barrierName","入口");
            }

            params.put("passDirection","1");

            if(StringUtils.isNotEmpty(cfCarParkUseLog.getInBigImage())){
                FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "inBigImage");
                params.put("vehicleImageUrl",cfCarParkUseLog.getInBigImage());
            }
        }
        params.put("passTime",DateUtil.stampToDate(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss"));
        params.put("vehicleImageStr","");
        params.put("vehiclePlateNumber",cfCarParkUseLog.getNumberPlate());

        Map<String, String> header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Authorization","Bearer "+token);
        JSONObject[] paramsList = new JSONObject[1];
        paramsList[0] = params;
        JSONObject result = (JSONObject)HttpClient.doPostByString(JSONObject.toJSONString(paramsList), "http://202.105.146.194:16007/vehicle/api/barrier/batchInsert", header, true);
    }

    @Override
    public void ShanghaiPublicParkingInformationPlatform(CfCarParkUseLog cfCarParkUseLog, Map<String, String> config) throws Exception {
        cfCarParkUseLog = findById("1527900033538396160");
        if(cfCarParkUseLog==null){
            return;
        }
        JSONObject params = new JSONObject();
        params.put("seq",(DateUtil.stampToDate(System.currentTimeMillis(),"yyyyMMdd")+config.get("parking_id")+(cfCarParkUseLog.getId().substring(cfCarParkUseLog.getId().length()-7))).toUpperCase());
        params.put("plateId",cfCarParkUseLog.getNumberPlate());
        params.put("vehicleType",1);
        params.put("laneType",9);
        if(cfCarParkUseLog.getCfCarPark()!=null){
            params.put("freeBerth",(cfCarParkUseLog.getCfCarPark().getParkingSpaceNumber()-cfCarParkUseLog.getCfCarPark().getUsedParkingSpaceNumber()));
        }else{
            params.put("freeBerth",5);
        }
        if(cfCarParkUseLog.getCarType().equals("temporary_car")){
            params.put("parkType",1);
        }else{
            params.put("parkType",2);
        }
        params.put("dataTime",System.currentTimeMillis());

        //制作签名sign
        System.out.println("参与加密的字符串："+config.get("appSecret") + "|" + params.toJSONString());
        String sign = BCryptUtil.MD5(config.get("appSecret") + "|" + params.toJSONString());

        String serverUrl = "";

        if(cfCarParkUseLog.getOutTime()>0){
            //出场
            serverUrl = "https://parking.jtcx.sh.cn:38080/parking/data/parkplot/leave/"+config.get("parking_id");
        }else{
            //入场
            serverUrl = "https://parking.jtcx.sh.cn:38080/parking/data/parkplot/arrive/"+config.get("parking_id");
        }

        Map<String, String> header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("sign",sign);

        JSONObject result = (JSONObject)HttpClient.doPost(params, serverUrl, header, true);
        System.out.println("推送地址："+"https://parking.jtcx.sh.cn:38080/parking/data/parkplot/arrive/"+config.get("parking_id"));
        System.out.println("请求头："+JSONObject.toJSONString(header));
        System.out.println("提交参数："+JSONObject.toJSONString(params));
        System.out.println("推送结果："+result);
    }
}
