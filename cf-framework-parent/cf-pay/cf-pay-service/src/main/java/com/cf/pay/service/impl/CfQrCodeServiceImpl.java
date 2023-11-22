package com.cf.pay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.request.CfCarParkQuery;
import com.cf.carpark.service.CfCarParkService;
import com.cf.framework.domain.pay.QrCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.response.CouponActivityCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfQrCodeMapper;
import com.cf.pay.domain.*;
import com.cf.pay.domain.request.CfCouponActivityLinkShopQuery;
import com.cf.pay.domain.request.CfQrCodeQuery;
import com.cf.pay.domain.request.CfStaffCouponLogQuery;
import com.cf.pay.domain.request.CfStaffCouponSettingQuery;
import com.cf.pay.domain.type.CouponType;
import com.cf.pay.service.*;
import com.cf.ucenter.domain.CfSystemConfig;
import com.cf.ucenter.request.CfSystemConfigQuery;
import com.cf.ucenter.service.CfStaffService;
import com.cf.ucenter.service.CfSystemConfigService;
import com.github.pagehelper.PageHelper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;
import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfQrCodeServiceImpl implements CfQrCodeService {

    @Autowired
    private CfQrCodeMapper cfQrCodeMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfCouponActivityService cfCouponActivityService;
    @Autowired
    private CfCouponActivityCouponTypeService cfCouponActivityCouponTypeService;
    @Autowired
    private CfCouponActivityLinkShopService cfCouponActivityLinkShopService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfStaffService cfStaffService;
    @Autowired
    private CfStaffCouponSettingService cfStaffCouponSettingService;
    @Autowired
    private CfStaffCouponLogService cfStaffCouponLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkService cfCarParkService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfSystemConfigService cfSystemConfigService;

    private void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    @Override
    public byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 1);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

    @Override
    public CfQrCode add(CfQrCode cfQrCode) {
        cfQrCode.setId(idWorker.nextId());
        cfQrCode.setCreateTime(System.currentTimeMillis());
        cfQrCodeMapper.insert(cfQrCode);
        return cfQrCode;
    }

    @Override
    public CfQrCode update(CfQrCode cfQrCode) {
        cfQrCodeMapper.updateByPrimaryKey(cfQrCode);
        return cfQrCode;
    }

    @Override
    public CfQrCode updateByPrimaryKeySelective(CfQrCode cfQrCode) {
        cfQrCodeMapper.updateByPrimaryKeySelective(cfQrCode);
        return cfQrCode;
    }

    @Override
    public Integer delete(String id) {
        return cfQrCodeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfQrCode findById(String id) {
        return cfQrCodeMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfQrCode findById(String id, boolean expectEmpty) {
        CfQrCode cfQrCode = findById(id);
        if(expectEmpty && cfQrCode!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfQrCode==null){
            ExceptionCast.cast(QrCode.QR_CODE_NOT_EXIST);
        }
        return cfQrCode;
    }

    @Override
    public CfQrCodeExample getExampleByQuery(CfQrCodeQuery cfQrCodeQuery) {
        CfQrCodeExample cfQrCodeExample = new CfQrCodeExample();
        CfQrCodeExample.Criteria criteria = cfQrCodeExample.createCriteria();
        if(StringUtils.isNotEmpty(cfQrCodeQuery.getCodeType())){
            criteria.andCodeTypeEqualTo(cfQrCodeQuery.getCodeType());
        }
        if(StringUtils.isNotEmpty(cfQrCodeQuery.getSourceId())){
            criteria.andSourceIdEqualTo(cfQrCodeQuery.getSourceId());
        }
        if(StringUtils.isNotEmpty(cfQrCodeQuery.getCreaterId())){
            criteria.andCreaterIdEqualTo(cfQrCodeQuery.getCreaterId());
        }
        if(StringUtils.isNotEmpty(cfQrCodeQuery.getFromUid())){
            criteria.andFromUidEqualTo(cfQrCodeQuery.getFromUid());
        }
        if(StringUtils.isNotEmpty(cfQrCodeQuery.getToUid())){
            criteria.andToUidEqualTo(cfQrCodeQuery.getToUid());
        }
        if(cfQrCodeQuery.getMinCreateTime()!=null){
            criteria.andCreateTimeGreaterThanOrEqualTo(cfQrCodeQuery.getMinCreateTime());
        }
        if(cfQrCodeQuery.getMaxCreateTime()!=null){
            criteria.andCreateTimeLessThanOrEqualTo(cfQrCodeQuery.getMaxCreateTime());
        }
        if(cfQrCodeQuery.getMinEffectiveTime()!=null){
            criteria.andEffectiveTimeGreaterThanOrEqualTo(cfQrCodeQuery.getMinEffectiveTime());
        }
        if(cfQrCodeQuery.getMaxEffectiveTime()!=null){
            criteria.andEffectiveTimeLessThanOrEqualTo(cfQrCodeQuery.getMaxEffectiveTime());
        }
        if(StringUtils.isNotEmpty(cfQrCodeQuery.getOrderBy())){
            cfQrCodeExample.setOrderByClause(cfQrCodeQuery.getOrderBy());
        }

        if(cfQrCodeQuery.getPage()!=null && cfQrCodeQuery.getSize()!=null){
            PageHelper.startPage(cfQrCodeQuery.getPage(), cfQrCodeQuery.getSize());
        }
        return cfQrCodeExample;
    }

    @Override
    public List<CfQrCode> getListByQuery(CfQrCodeQuery cfQrCodeQuery) {
        return cfQrCodeMapper.selectByExample(getExampleByQuery(cfQrCodeQuery));
    }

    @Override
    public Integer countByQuery(CfQrCodeQuery cfQrCodeQuery) {
        cfQrCodeQuery.setPage(null);
        return cfQrCodeMapper.countByExample(getExampleByQuery(cfQrCodeQuery));
    }

    @Override
    public CfQrCode staffCreateCouponQrCode(CfQrCode cfQrCode) throws Exception {
        if(cfQrCode.getQuantity().longValue()<=0){
            ExceptionCast.cast(CouponActivityCode.MISSING_QUANTITY);
        }
        //获取活动数据信息
        CfCouponActivity cfCouponActivity = cfCouponActivityService.findById(cfQrCode.getSourceId(), false);
        cfQrCode.setFromUid(cfCouponActivity.getMainBodyId());

        //检查该活动状态，额度是否足够
        if(cfCouponActivity.getStatus()!=(byte)1){
            ExceptionCast.cast(CouponActivityCode.ACTIVITY_TO_BE_OPENED);
        }
        long longValue = cfQrCode.getQuantity().longValue();
        //判断额度是否足够
        switch (cfQrCode.getSourceType()){
            case CouponType.TIMES_COUPON:   //次数券
                if(cfCouponActivity.getRemainingTimes().intValue()<=0){
                    ExceptionCast.cast(CouponActivityCode.YOU_ACTIVITY_COUPON_BALANCE_INSUFFICIENT);
                }
                //次数券强制每次只能发一次
                cfQrCode.setQuantity(1l);
                longValue = 1l;
                break;
            case CouponType.AMOUNT_COUPON:  //金额券
                if(cfCouponActivity.getIssuedQuota().add(new BigDecimal(cfQrCode.getQuantity())).doubleValue()>cfCouponActivity.getTotalIssueQuota().add(cfCouponActivity.getAutoGiveAwayOverageQuota()).doubleValue()){
                    ExceptionCast.cast(CouponActivityCode.YOU_ACTIVITY_COUPON_BALANCE_INSUFFICIENT);
                }
                break;
            case CouponType.TIME_COUPON:    //时长券
                if(cfQrCode.getQuantity().longValue()*3600000l>cfCouponActivity.getRemainingTime().longValue()){
                    ExceptionCast.cast(CouponActivityCode.YOU_ACTIVITY_COUPON_BALANCE_INSUFFICIENT);
                }
                cfQrCode.setQuantity(longValue*3600000l);
                break;
            default:
                ExceptionCast.cast(CouponActivityCode.ACTIVITY_NOT_MATCH_COUPON_TYPE);
                break;
        }


        if(!cfQrCode.getCreaterId().equals(cfCouponActivity.getMainBodyId())){
            //校验员工身份
            cfStaffService.checkStaffExistByEmployerIdAndStaffId(cfCouponActivity.getMainBodyId(), cfQrCode.getCreaterId(), "no");
            //判断该员工当日活动发券量是否已达到上限
            CfStaffCouponSettingQuery cfStaffCouponSettingQuery = new CfStaffCouponSettingQuery();
            cfStaffCouponSettingQuery.setCouponActivityId(cfQrCode.getSourceId());
            cfStaffCouponSettingQuery.setStaffId(cfQrCode.getCreaterId());
            List<CfStaffCouponSetting> cfStaffCouponSettings = cfStaffCouponSettingService.getListByQuery(cfStaffCouponSettingQuery);
            if(cfStaffCouponSettings==null || cfStaffCouponSettings.size()==0){
//                ExceptionCast.cast(CouponActivityCode.YOU_ACTIVITY_COUPON_BALANCE_INSUFFICIENT);
                //自动给其创建一个当日额度为0的
                CfStaffCouponSetting cfStaffCouponSetting = new CfStaffCouponSetting();
                cfStaffCouponSetting.setStaffId(cfQrCode.getCreaterId());
                cfStaffCouponSetting.setCouponActivityId(cfQrCode.getSourceId());
                cfStaffCouponSetting.setSameDayQuota(new BigDecimal(0.00));
                CfStaffCouponSetting couponSetting = cfStaffCouponSettingService.add(cfStaffCouponSetting);
                cfStaffCouponSettings.add(couponSetting);
            }
            CfStaffCouponLogQuery cfStaffCouponLogQuery = new CfStaffCouponLogQuery();
            cfStaffCouponLogQuery.setStaffId(cfQrCode.getCreaterId());
            cfStaffCouponLogQuery.setCouponActivityId(cfQrCode.getSourceId());
            cfStaffCouponLogQuery.setMinCreateTime(DateUtil.getSameDayMinOrMaxTimestamp("min"));
            cfStaffCouponLogQuery.setMaxCreateTime(DateUtil.getSameDayMinOrMaxTimestamp("max"));
            BigDecimal sameDayBalance = cfStaffCouponLogService.countDenominationByQuery(cfStaffCouponLogQuery);
            if(sameDayBalance==null){
                sameDayBalance = new BigDecimal(0.00);
            }

            //如果未0则为不限制
            if(cfStaffCouponSettings!=null && cfStaffCouponSettings.size()>0 && (cfStaffCouponSettings.get(0).getSameDayQuota()).doubleValue()>0 && sameDayBalance.add(new BigDecimal(cfQrCode.getQuantity())).compareTo(cfStaffCouponSettings.get(0).getSameDayQuota())==1){
                ExceptionCast.cast(CouponActivityCode.YOU_ACTIVITY_COUPON_BALANCE_INSUFFICIENT);
            }
        }else{
            //校验店主与活动的合法性
            cfCouponActivityService.checkActivityAscription(cfCouponActivity.getMainBodyId(), cfQrCode.getSourceId());
        }
        cfQrCode.setCodeType("coupon");
        cfQrCode.setToUid("");
        //领券二维码有效期统一为30天
        cfQrCode.setEffectiveTime(System.currentTimeMillis() + 2592000000L);

        cfQrCode.setImage("");
        CfQrCode qrCode = add(cfQrCode);

        //制作二维码内容
        JSONObject jsonObject = new JSONObject();
        //二维码有效期
        jsonObject.put("effective_duration", cfQrCode.getEffectiveTime()-System.currentTimeMillis());
        //二维码类型
        jsonObject.put("code_type", qrCode.getCodeType());
        //资源类型(例如资源类型为优惠券时1-次数全/2-金额券/3-时长券)
        jsonObject.put("source_type", qrCode.getSourceType());
        //二维码id
        jsonObject.put("qr_code_id", cfQrCode.getId());
        jsonObject.put("available_stores", "");
        jsonObject.put("denomination", longValue);
        jsonObject.put("coupon_validity_period", 2592000000L);
        if(StringUtils.isNotEmpty(cfQrCode.getCouponActivityTypeId())){
            jsonObject.put("coupon_type_id", cfQrCode.getCouponActivityTypeId());
            CfCouponActivityCouponType cfCouponActivityCouponType = cfCouponActivityCouponTypeService.findById(cfQrCode.getCouponActivityTypeId());
            if(cfCouponActivityCouponType!=null){
                jsonObject.put("coupon_validity_period", cfCouponActivityCouponType.getFixedExtensionTime());
            }
        }
        //可用的范围，如果是停车券
        if(qrCode.getSourceType().byteValue()>=1 && qrCode.getSourceType().byteValue()<=3){
            CfCouponActivityLinkShopQuery cfCouponActivityLinkShopQuery = new CfCouponActivityLinkShopQuery();
            cfCouponActivityLinkShopQuery.setCouponActivityId(cfQrCode.getSourceId());
            List<CfCouponActivityLinkShop> cfCouponActivityLinkShops = cfCouponActivityLinkShopService.getListByQuery(cfCouponActivityLinkShopQuery);
            if(cfCouponActivityLinkShops!=null && cfCouponActivityLinkShops.size()>0){
                CfCarParkQuery cfCarParkQuery = new CfCarParkQuery();
                cfCarParkQuery.setIds(new ArrayList<>());
                for(CfCouponActivityLinkShop cfCouponActivityLinkShop: cfCouponActivityLinkShops){
                    cfCarParkQuery.getIds().add(cfCouponActivityLinkShop.getShopId());
                }
                List<CfCarPark> cfCarParkList = cfCarParkService.getListByQuery(cfCarParkQuery);
                if(cfCarParkList!=null && cfCarParkList.size()>0){
                    String parks = "";
                    for(CfCarPark cfCarPark: cfCarParkList){
                        parks += ","+cfCarPark.getName();
                    }
                    jsonObject.put("available_stores", parks.substring(1));
                }
            }
        }
        String getCouponsUrl = cfSystemConfigService.getValueByKey("get_coupons_url", "https://park.cfeng.wang");
        String couponTypeIdString = StringUtils.isNotEmpty(cfQrCode.getCouponActivityTypeId()) ? "&coupon_type_id="+jsonObject.getString("coupon_type_id") : "";
        byte[] qrCodeImage = getQRCodeImage(
                getCouponsUrl+"/denomination="+jsonObject.getString("denomination")
                        +"&effective_duration="+jsonObject.getString("effective_duration")
                        +"&code_type="+jsonObject.getString("code_type")
                        +"&source_type="+jsonObject.getString("source_type")
                        +"&qr_code_id="+jsonObject.getString("qr_code_id")
                        +"&coupon_validity_period="+jsonObject.getString("coupon_validity_period")
                        +couponTypeIdString
                        +"&available_stores="+ URLEncoder.encode(jsonObject.getString("available_stores"),"UTF-8")
                ,350, 350);
        cfQrCode.setImage(Base64.getEncoder().encodeToString(qrCodeImage));
        return cfQrCode;
    }


}
