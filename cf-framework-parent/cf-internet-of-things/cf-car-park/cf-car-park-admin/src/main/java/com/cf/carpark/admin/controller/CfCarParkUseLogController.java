package com.cf.carpark.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkUseLogSwagger;
import com.cf.carpark.domain.*;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.*;
import com.cf.carpark.domain.type.FeeQueryMode;
import com.cf.carpark.domain.type.ReleaseType;
import com.cf.carpark.service.*;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.report.CountByDay;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.FileUtils;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.pay.domain.CfCoupon;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.type.CouponStatus;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.CfCouponService;
import com.cf.pay.service.CfOrderService;
import com.cf.ucenter.service.CfSystemConfigService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkUseLogController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/26/026 7:34
 * @Version 1.0
 **/
@RestController
@RequestMapping("carparkUseLogAdmin/")
@Validated
public class CfCarParkUseLogController implements CfCarParkUseLogSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkService cfCarParkService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfOrderService cfOrderService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkReleaseLogService cfCarParkReleaseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkDeviceService cfCarParkDeviceService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkChargingRulesService cfCarParkChargingRulesService;
    @Autowired
    protected HttpServletRequest request;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkLinkUserService cfCarParkLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfSystemConfigService cfSystemConfigService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkCarTypeService cfCarParkCarTypeService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCouponService cfCouponService;

    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfCarParkUseLogForm cfCarParkUseLogForm) {
        CfCarParkUseLog cfCarParkUseLog = new CfCarParkUseLog();
        BeanUtils.copyProperties(cfCarParkUseLogForm, cfCarParkUseLog);
        CfCarParkUseLog carParkUseLog = cfCarParkUseLogService.add(cfCarParkUseLog);
        return new ResponseResult(CommonCode.SUCCESS, carParkUseLog);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfCarParkUseLogForm cfCarParkUseLogForm) {
        CfCarParkUseLog cfCarParkUseLog = new CfCarParkUseLog();
        BeanUtils.copyProperties(cfCarParkUseLogForm, cfCarParkUseLog);
        CfCarParkUseLog carParkUseLog = cfCarParkUseLogService.update(cfCarParkUseLog);
        return new ResponseResult(CommonCode.SUCCESS, carParkUseLog);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-updateLogAndOrder')")
    @Override
    @RequestMapping(value = "updateLogAndOrder", method = RequestMethod.PUT)
    public ResponseResult updateLogAndOrder(@RequestBody @Validated UpdateLogAndOrderForm updateLogAndOrderForm) throws Exception {
        if(StringUtils.isEmpty(updateLogAndOrderForm.getActionType())){
            ExceptionCast.cast(CommonCode.INVALID_PARAM, "miss actionType");
        }
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCarParkUseLog cfCarParkUseLog = cfCarParkUseLogService.findById(updateLogAndOrderForm.getCarParkUseLogId(), false);

        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setGoodsId(updateLogAndOrderForm.getCarParkUseLogId());
        List<CfOrder> cfOrderList = cfOrderService.getListByQuery(cfOrderQuery);
        if(cfOrderList==null || cfOrderList.size()==0){
            return new ResponseResult(PayCode.ORDER_DOES_NOT_EXIST);
        }
        //禁止操作非停车账单
        if(cfOrderList.get(0).getGoodsType()!= GoodsType.CARPARK_PAYMENT){
            return new ResponseResult(CommonCode.FAIL, null,"该账单并非停车账单");
        }
        if(cfOrderList.get(0).getStatus()==PayStatus.PAID){
            return new ResponseResult(CommonCode.FAIL, null,"该订单已支付");
        }
        if(StringUtils.isNotEmpty(cfOrderList.get(0).getUid()) && (System.currentTimeMillis()-cfOrderList.get(0).getUpdateTime()<10000)){
            return new ResponseResult(CommonCode.FREQUENT_OPERATION);
        }

        if(!userBasicInfo.getId().equals(cfCarParkUseLog.getInHandleUid()) && !userBasicInfo.getId().equals(cfCarParkUseLog.getOutHandleUid())){
            return new ResponseResult(CarParkCode.NO_PERMISSION);
        }

        if(updateLogAndOrderForm.getActionType().equals("cash_pay") || updateLogAndOrderForm.getActionType().equals("abnormal_termination_of_order")){
            cfCarParkUseLog.setPayTime(System.currentTimeMillis());
        }else if(updateLogAndOrderForm.getActionType().equals("cancel_release")){
            cfCarParkUseLog.setPayTime(0L);
        }
        cfCarParkUseLog.setOutReleaseType(ReleaseType.ARTIFICIAL);
        cfCarParkUseLogService.update(cfCarParkUseLog);

//        CfOrder cfOrder = cfOrderService.findById(orderId, false);

        //计算应付金额
        CfCarParkOrder cfCarParkOrder = cfCarParkChargingRulesService.calculateTheAmounPayable(updateLogAndOrderForm.getCarParkUseLogId(), null, FeeQueryMode.QUERY_MODE_QUERY_ONLY);
        CfOrder cfOrder = cfCarParkOrder.getCfOrder();

        if(cfOrder.getStatus()==PayStatus.PAID){
            return new ResponseResult(CommonCode.FAIL, null,"该订单已支付");
        }

        if((updateLogAndOrderForm.getActionType().equals("cash_pay") || updateLogAndOrderForm.getActionType().equals("abnormal_termination_of_order")) && StringUtils.isNotEmpty(updateLogAndOrderForm.getAmountOfMoney()) && (new BigDecimal(updateLogAndOrderForm.getAmountOfMoney())).doubleValue()>=0){
            //暂时不允许收费自己修改金额
//            cfOrder.setAmountActuallyPaid(new BigDecimal(amountOfMoney).add(cfOrder.getCollectionAmount()));
//            if(cfOrder.getCollectionAmount().doubleValue()>0){
//                cfOrder.setAmountActuallyPaid(cfOrder.getCollectionAmount().add(cfOrder.getAmountsPayable()));
//            }
//            if(cfOrder.getAmountsPayable().doubleValue()==0){
//                cfOrder.setAmountsPayable(cfOrder.getAmountActuallyPaid());
//            }

            if(System.currentTimeMillis()-cfOrder.getManualOfferSetTime()<=900000){
                BigDecimal amountsPayable = cfOrder.getAmountsPayable();
                cfOrder.setAmountsPayable(amountsPayable.subtract(cfOrder.getManualOffer()));
                cfOrder.setAmountActuallyPaid(cfOrder.getAmountsPayable());
            }else if(StringUtils.isNotEmpty(updateLogAndOrderForm.getCouponId())){
                CfCoupon cfCoupon = cfCouponService.findById(updateLogAndOrderForm.getCouponId(), false);
                if(cfCoupon.getCouponType()==(byte)2 && cfCoupon.getStatus()==CouponStatus.NOT_USED){
                    CfCoupon coupon = new CfCoupon();
                    coupon.setId(updateLogAndOrderForm.getCouponId());
                    coupon.setUseTime(System.currentTimeMillis());
                    if(cfOrder.getAmountsPayable().doubleValue()<cfCoupon.getDenomination().doubleValue()){
                        coupon.setAmountUsed(cfOrder.getAmountsPayable());
                    }else{
                        coupon.setAmountUsed(cfCoupon.getDenomination());
                    }
                    coupon.setStatus(CouponStatus.USED);
                    cfCouponService.updateByPrimaryKeySelective(coupon);

                    cfOrder.setCouponId(updateLogAndOrderForm.getCouponId());

                    if(cfOrder.getAmountsPayable().doubleValue()<cfCoupon.getDenomination().doubleValue()){
                        cfOrder.setCouponPaid(cfOrder.getAmountsPayable());
                        cfOrder.setAmountActuallyPaid(new BigDecimal(0.00));
                    }else{
                        cfOrder.setCouponPaid(cfCoupon.getDenomination());
                        cfOrder.setAmountActuallyPaid(cfOrder.getAmountsPayable().subtract(cfCoupon.getDenomination()));
                    }
                }
            }else{
                cfOrder.setAmountActuallyPaid(cfOrder.getAmountsPayable());
            }
            cfOrder.setStatus(PayStatus.PAID);
            cfOrder.setPayTime(System.currentTimeMillis());
            if(updateLogAndOrderForm.getActionType().equals("cash_pay")){
                cfOrder.setPaymentAgencyShortName("cash_pay_cny");
                if(StringUtils.isNotEmpty(cfCarParkUseLog.getOutCheckPointId())){
                    cfCarParkReleaseLogService.executeReleaseByCarParkUseLog(cfCarParkUseLog,"岗亭人员确认现金收费手动放行",(byte)1);
                }
            }else{
                cfOrder.setPaymentAgencyShortName("abnormal_termination_of_order");
                //异常放行 实付金额为0
                cfOrder.setAmountActuallyPaid(new BigDecimal(0.00));
                if(StringUtils.isNotEmpty(cfCarParkUseLog.getOutCheckPointId())){
                    cfCarParkReleaseLogService.executeReleaseByCarParkUseLog(cfCarParkUseLog,"岗亭人员确认后异常放行",(byte)2);
                }
            }

            if(cfOrder.getCollectionAmount().doubleValue()>0){
                //更新停车记录支付时间(因为存在代付金额时，当前停车记录支付时间会被临时置为0)
                CfCarParkUseLog carParkUseLog = new CfCarParkUseLog();
                carParkUseLog.setId(cfCarParkUseLog.getId());
                carParkUseLog.setPayTime(System.currentTimeMillis());
                cfCarParkUseLogService.updateByPrimaryKeySelective(carParkUseLog);
            }
        }else if(updateLogAndOrderForm.getActionType().equals("cancel_release")){
            cfOrder.setPayTime(0L);
            cfOrder.setStatus(PayStatus.TO_BE_PAID);
            CfCarParkUseLog carParkUseLog = new CfCarParkUseLog();
            carParkUseLog.setId(cfCarParkUseLog.getId());
            carParkUseLog.setPayTime(0l);
            cfCarParkUseLogService.updateByPrimaryKeySelective(carParkUseLog);
        }else if(updateLogAndOrderForm.getActionType().equals("change_amount") && cfCarParkOrder.getCfCarPark().getAllowEditUseLog()==(byte)1){
            cfOrder.setManualOffer(new BigDecimal(updateLogAndOrderForm.getAmountOfMoney()));
            cfOrder.setManualOfferSetTime(System.currentTimeMillis());
            cfOrder.setAmountsPayable(cfOrder.getManualOffer());
        }else{
            return new ResponseResult(CommonCode.FAIL, null,"更新订单失败");
        }
        CfOrder order = cfOrderService.update(cfOrder);
        if(order==null || order.getId()==null){
            return new ResponseResult(CommonCode.FAIL, null,"更新订单失败");
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-dutyerUpdateUseLog')")
    @Override
    @RequestMapping(value = "dutyerUpdateUseLog", method = RequestMethod.PUT)
    public ResponseResult dutyerUpdateUseLog(UpdateLogAndOrderForm updateLogAndOrderForm) throws Exception {
        if(StringUtils.isEmpty(updateLogAndOrderForm.getCarParkUseLogId()) || StringUtils.isEmpty(updateLogAndOrderForm.getNumberPlate())){
            ExceptionCast.cast(CommonCode.INVALID_PARAM, "miss carParkUseLogId or numberPlate");
        }
        CfCarParkUseLog carParkUseLog = cfCarParkUseLogService.findById(updateLogAndOrderForm.getCarParkUseLogId(), false);
        CfCarPark cfCarPark = cfCarParkService.findById(carParkUseLog.getCarParkId(), false);
        if(cfCarPark.getAllowEditUseLog()==(byte)0){
            return new ResponseResult(CommonCode.FAIL, "该停车禁止修改停车数据");
        }
        if(carParkUseLog.getOutTime()>0){
            return new ResponseResult(CommonCode.FAIL, "只能修改入场数据");
        }
        CfCarParkUseLog cfCarParkUseLog = new CfCarParkUseLog();
        cfCarParkUseLog.setId(updateLogAndOrderForm.getCarParkUseLogId());
        cfCarParkUseLog.setNumberPlate(updateLogAndOrderForm.getNumberPlate());
        cfCarParkUseLogService.updateByPrimaryKeySelective(cfCarParkUseLog);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-selectListByCondition')")
    @Override
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions)throws Exception {
        Map<String, Object> map = makeAllowData(conditions, false);
        ArrayList<String> allowFileds = (ArrayList<String>)map.get("allowFileds");
        Map<String, String> allowFiledsMap = (Map<String, String>)map.get("allowFiledsMap");
        Map conditionsMap = (Map)map.get("conditionsMap");
        Integer counts = 0;
        if(((Map<String,Integer>)conditionsMap.get("limit")).get("limit")>3000){
            ((Map<String,Integer>)conditionsMap.get("limit")).put("limit",3000);
        }
        List<CfCarParkUseLog> cfCarParks = cfCarParkUseLogService.selectListByCondition(conditionsMap, allowFiledsMap,allowFileds);
        if(((Map<String,Integer>)conditionsMap.get("limit")).get("page")==1){
            counts = cfCarParkUseLogService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        }
        if(cfCarParks!=null && cfCarParks.size()>0){
            String fileSourceAddress = cfSystemConfigService.getValueByKey("file_source_address", "http://file.cfeng.wang/");
            for (CfCarParkUseLog cfCarParkUseLog: cfCarParks){
                FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "inSmallImage");
                FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "outSmallImage");
                FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "inBigImage");
                FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "outBigImage");
            }
            return new ResponseResult(CommonCode.SUCCESS, cfCarParks, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-selectListByCondition')")
    @Override
    @RequestMapping(value = "exportUseLogExcel", method = RequestMethod.GET)
    public void exportUseLogExcel(HttpServletResponse response, String conditions) throws Exception {
        Map<String, Object> map = makeAllowData(conditions, false);
        ArrayList<String> allowFileds = (ArrayList<String>)map.get("allowFileds");
        Map<String, String> allowFiledsMap = (Map<String, String>)map.get("allowFiledsMap");
        Map conditionsMap = (Map)map.get("conditionsMap");

        List<CfCarParkUseLog> cfCarParks = cfCarParkUseLogService.selectListByCondition(conditionsMap, allowFiledsMap,allowFileds);

        //声明输出流
        OutputStream os = null;
        //设置响应头
        setResponseHeader(response,"停车记录");
        try {
            //获取输出流
            os = response.getOutputStream();
            //内存中保留3000条数据，以免内存溢出，其余写入硬盘
            SXSSFWorkbook wb = new SXSSFWorkbook(3000);
            //获取该工作区的第一个sheet
            Sheet sheet1 = wb.createSheet("sheet1");
            int excelRow = 0;
            //创建标题行
            Row titleRow = sheet1.createRow(excelRow++);
            ArrayList<String> columnList = new ArrayList<>();
            columnList.add("序号");
            columnList.add("车牌号");
            columnList.add("停车场");
            columnList.add("姓名/楼栋");
            columnList.add("车辆类型");
            columnList.add("状态");
            columnList.add("应付金额");
            columnList.add("实付金额");
            columnList.add("支付方式");
            columnList.add("到期时间");
            columnList.add("入场时间");
            columnList.add("出场时间");
            columnList.add("停车时间");
            columnList.add("入场关卡");
            columnList.add("出场关卡");
            for(int i = 0;i<columnList.size();i++){
                //创建该行下的每一列，并写入标题数据
                Cell cell = titleRow.createCell(i);
                cell.setCellValue(columnList.get(i));
            }
            //设置内容行
            if(cfCarParks!=null && cfCarParks.size()>0){
                //序号是从1开始的
                int count = 1;
                //外层for循环创建行
                for(CfCarParkUseLog cfCarParkUseLog: cfCarParks){
                    Row dataRow = sheet1.createRow(excelRow++);
                    //序号
                    Cell serialNumberCell = dataRow.createCell(0);
                    serialNumberCell.setCellValue(count);
                    //车牌号
                    Cell numberPlateCell = dataRow.createCell(1);
                    numberPlateCell.setCellValue(cfCarParkUseLog.getNumberPlate());
                    //停车场
                    Cell carParkCell = dataRow.createCell(2);
                    if(cfCarParkUseLog.getCfCarPark()!=null){
                        carParkCell.setCellValue(cfCarParkUseLog.getCfCarPark().getName());
                    }else{
                        carParkCell.setCellValue("");
                    }
                    //姓名/楼栋
                    Cell carOwnerNameCell = dataRow.createCell(3);
                    carOwnerNameCell.setCellValue(cfCarParkUseLog.getVisitUnit());
                    //车辆类型
                    Cell carTypeCell = dataRow.createCell(4);
                    CfCarParkCarType cfCarParkCarType = cfCarParkCarTypeService.findByKey(cfCarParkUseLog.getCarType());
                    if(cfCarParkCarType!=null){
                        carTypeCell.setCellValue(cfCarParkCarType.getName());
                    }else{
                        carTypeCell.setCellValue("临时车");
                    }
                    //车辆状态
                    Cell carStatus = dataRow.createCell(5);
                    switch (cfCarParkUseLog.getCarStatus()){
                        case (byte)0:
                            carStatus.setCellValue("禁用");
                            break;
                        case (byte)1:
                            carStatus.setCellValue("正常");
                            break;
                        case (byte)2:
                            carStatus.setCellValue("已过期");
                            break;
                    }

                    //应付金额
                    Cell amountsPayableCell = dataRow.createCell(6);
                    if(cfCarParkUseLog.getCfOrder()!=null){
                        amountsPayableCell.setCellValue(cfCarParkUseLog.getCfOrder().getAmountsPayable().toString());
                    }else{
                        amountsPayableCell.setCellValue("");
                    }
                    //实付金额
                    Cell amountActuallyPaidCell = dataRow.createCell(7);
                    if(cfCarParkUseLog.getCfOrder()!=null){
                        amountActuallyPaidCell.setCellValue(cfCarParkUseLog.getCfOrder().getAmountActuallyPaid().toString());
                    }else{
                        amountActuallyPaidCell.setCellValue("");
                    }
                    //支付方式
                    Cell paymentAgencyShortNameCell = dataRow.createCell(8);
                    if(cfCarParkUseLog.getCfPaymentAgency()!=null){
                        paymentAgencyShortNameCell.setCellValue(cfCarParkUseLog.getCfPaymentAgency().getName());
                    }else{
                        paymentAgencyShortNameCell.setCellValue("");
                    }
                    //到期时间
                    Cell packageEndTimeCell = dataRow.createCell(9);
                    if(cfCarParkUseLog.getCfCarParkPackage()!=null){
                        packageEndTimeCell.setCellValue(DateUtil.stampToDate(cfCarParkUseLog.getCfCarParkPackage().getEndTime(),"yyyy-MM-dd HH:mm:ss"));
                    }else{
                        packageEndTimeCell.setCellValue("");
                    }
                    //入场时间
                    Cell inTimeCell = dataRow.createCell(10);
                    if(cfCarParkUseLog.getInTime()>0){
                        inTimeCell.setCellValue(DateUtil.stampToDate(cfCarParkUseLog.getInTime(),"yyyy-MM-dd HH:mm:ss"));
                    }else{
                        inTimeCell.setCellValue("");
                    }
                    //出场时间
                    Cell outTimeCell = dataRow.createCell(11);
                    if(cfCarParkUseLog.getOutTime()>0){
                        outTimeCell.setCellValue(DateUtil.stampToDate(cfCarParkUseLog.getOutTime(),"yyyy-MM-dd HH:mm:ss"));
                    }else{
                        outTimeCell.setCellValue("");
                    }

                    //停车时间
                    Cell useTimeCell = dataRow.createCell(12);
                    if(cfCarParkUseLog.getInTime()>0 && cfCarParkUseLog.getOutTime()>cfCarParkUseLog.getInTime()){
                        useTimeCell.setCellValue(DateUtil.getDifferenceByTimeStamp(cfCarParkUseLog.getInTime(),cfCarParkUseLog.getOutTime()));
                    }else{
                        useTimeCell.setCellValue("");
                    }
                    //入场关卡
                    Cell inCheckPointCell = dataRow.createCell(13);
                    if(cfCarParkUseLog.getCfCarParkCheckpointIn()!=null){
                        inCheckPointCell.setCellValue(cfCarParkUseLog.getCfCarParkCheckpointIn().getName());
                    }else{
                        inCheckPointCell.setCellValue("");
                    }
                    //出场关卡
                    Cell outCheckPointCell = dataRow.createCell(14);
                    if(cfCarParkUseLog.getCfCarParkCheckpointOut()!=null){
                        outCheckPointCell.setCellValue(cfCarParkUseLog.getCfCarParkCheckpointOut().getName());
                    }else{
                        outCheckPointCell.setCellValue("");
                    }

                    count++;
                }
            }
            //将整理好的excel数据写入流中
            wb.write(os);
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                // 关闭输出流
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                throw e;
            }
        }

    }

    /*
        设置浏览器下载响应头
     */
    private static void setResponseHeader(HttpServletResponse response, String fileName) throws Exception {
        fileName = new String(fileName.getBytes(),"ISO8859-1");
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");

    }

    @Override
    @RequestMapping(value = "dutySelectListByCondition", method = RequestMethod.GET)
    public ResponseResult dutySelectListByCondition(String conditions) throws Exception {
        Map<String, Object> map = makeAllowData(conditions, true);
        ArrayList<String> allowFileds = (ArrayList<String>)map.get("allowFileds");
        Map<String, String> allowFiledsMap = (Map<String, String>)map.get("allowFiledsMap");
        Map conditionsMap = (Map)map.get("conditionsMap");

        List<CfCarParkUseLog> cfCarParks = cfCarParkUseLogService.selectListByCondition(conditionsMap, allowFiledsMap,allowFileds);
        Integer counts = cfCarParkUseLogService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfCarParks!=null && cfCarParks.size()>0){
            String fileSourceAddress = cfSystemConfigService.getValueByKey("file_source_address", "http://file.cfeng.wang/");
            for (CfCarParkUseLog cfCarParkUseLog: cfCarParks){
                FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "inSmallImage");
                FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "outSmallImage");
                FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "inBigImage");
                FileUtils.handleFileSourcePrefix(cfCarParkUseLog, fileSourceAddress, "outBigImage");
            }
            return new ResponseResult(CommonCode.SUCCESS, cfCarParks, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    /**
     * 制作条件搜索合法数据
     * @param conditions
     * @param isDuty    是否为值班人员擦好像
     * @return
     * @throws Exception
     */
    private Map<String,Object> makeAllowData(String conditions, boolean isDuty)throws Exception{
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("number_plate");
        allowFileds.add("car_park_id");
        allowFileds.add("in_time");
        allowFileds.add("out_time");
        allowFileds.add("in_release_type");
        allowFileds.add("out_release_type");
        allowFileds.add("in_check_point_id");
        allowFileds.add("out_check_point_id");
        allowFileds.add("create_position");
        allowFileds.add("pay_time");
        allowFileds.add("create_time");
        allowFileds.add("in_handle_uid");
        allowFileds.add("out_handle_uid");
        allowFileds.add("status");
        allowFileds.add("car_owner_name");
        allowFileds.add("car_park_id$in");
        allowFileds.add("payment_agency_short_name$in");
        allowFileds.add("car_type");
        allowFileds.add("car_status");
        allowFileds.add("visit_unit");
        allowFileds.add("payment_agency_short_name");
        allowFileds.add("amounts_payable");
        allowFileds.add("amount_actually_paid");
        allowFileds.add("or_and");
        allowFileds.add("or_eq");
        allowFileds.add("like");
        allowFileds.add("group");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","cpul");
        allowFiledsMap.put("number_plate","cpul");
        allowFiledsMap.put("car_park_id","cpul");
        allowFiledsMap.put("in_time","cpul");
        allowFiledsMap.put("out_time","cpul");
        allowFiledsMap.put("in_release_type","cpul");
        allowFiledsMap.put("out_release_type","cpul");
        allowFiledsMap.put("in_check_point_id","cpul");
        allowFiledsMap.put("out_check_point_id","cpul");
        allowFiledsMap.put("create_position","cpul");
        allowFiledsMap.put("pay_time","cpul");
        allowFiledsMap.put("create_time","cpul");
        allowFiledsMap.put("in_handle_uid","cpul");
        allowFiledsMap.put("out_handle_uid","cpul");
        allowFiledsMap.put("status","ord");
        allowFiledsMap.put("car_owner_name","cpp");
        allowFiledsMap.put("car_park_id$in","cpul");
        allowFiledsMap.put("car_type","cpul");
        allowFiledsMap.put("car_status","cpul");
        allowFiledsMap.put("visit_unit","cpul");
        allowFiledsMap.put("payment_agency_short_name","ord");
        allowFiledsMap.put("payment_agency_short_name$in","ord");
        allowFiledsMap.put("amounts_payable","ord");
        allowFiledsMap.put("amount_actually_paid","ord");
        allowFiledsMap.put("or_and","");
        allowFiledsMap.put("or_eq","");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("group","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");

        Map<String, Object> map = new HashMap<>();
        map.put("allowFileds",allowFileds);
        map.put("allowFiledsMap",allowFiledsMap);

        Map conditionsMap = (JSONObject.parseObject(conditions));

        Map<String, String> paymentAgencyShortNameMap = (Map) conditionsMap.get("payment_agency_short_name");
        Map<String, String> feeMap = (Map) conditionsMap.get("is_fee");
        Map<String, String> typeKeyMap = (Map) conditionsMap.get("type_key");

        if(conditionsMap.containsKey("payment_agency_short_name") && paymentAgencyShortNameMap!=null){
            if(StringUtils.isNotEmpty(paymentAgencyShortNameMap.get("value")) && !paymentAgencyShortNameMap.get("value").equals("cash_pay_cny") && !paymentAgencyShortNameMap.get("value").equals("abnormal_termination_of_order")){
                HashMap<String, String> valueMap = new HashMap<>();
                valueMap.put("operator","in");
                valueMap.put("value","'wei_xin_pay_cny','ali_pay_cny','wei_xin_h5_pay_cny','ali_h5_pay_cny'");
                conditionsMap.put("payment_agency_short_name$in", valueMap);
                //干掉它
                conditionsMap.remove("payment_agency_short_name");
            }else if(StringUtils.isNotEmpty(paymentAgencyShortNameMap.get("value")) && paymentAgencyShortNameMap.get("value").equals("abnormal_termination_of_order") && conditionsMap.containsKey("or_and")){
                ((Map<String,Object>)conditionsMap.get("payment_agency_short_name")).put("or","1");
                ((Map<String, Object>) conditionsMap.get("or_and")).put("and","1");
            }
        }

        if(conditionsMap.containsKey("type_key") && typeKeyMap!=null && typeKeyMap.get("value").equals("temporary_car")){
            if(StringUtils.isNotEmpty(typeKeyMap.get("value")) && !typeKeyMap.get("value").equals("cash_pay_cny")){
                //干掉它
                conditionsMap.remove("type_key");
                //重制
                HashMap<String, String> valueMap = new HashMap<>();
                valueMap.put("operator","is");
                valueMap.put("value","null");
                conditionsMap.put("type_key", valueMap);
            }
        }

        if(isDuty && conditionsMap.containsKey("is_fee") && feeMap!=null){
            if(StringUtils.isNotEmpty(feeMap.get("value")) && feeMap.get("value").equals("fee")){
                HashMap<String, String> valueMap = new HashMap<>();
                valueMap.put("operator","in");
                valueMap.put("value","'wei_xin_pay_cny','ali_pay_cny','wei_xin_h5_pay_cny','ali_h5_pay_cny','cash_pay_cny'");
                conditionsMap.put("payment_agency_short_name$in", valueMap);

                HashMap<String, String> valueMap2 = new HashMap<>();
                valueMap2.put("operator","=");
                valueMap2.put("value","1");
                conditionsMap.put("status", valueMap2);
                //干掉它
                conditionsMap.remove("fee");
            }else if(StringUtils.isNotEmpty(feeMap.get("value")) && feeMap.get("value").equals("free")){
                HashMap<String, String> valueMap = new HashMap<>();
                valueMap.put("operator","in");
                valueMap.put("value","'system_free_time','coupon','package'");
                conditionsMap.put("payment_agency_short_name$in", valueMap);

                HashMap<String, String> valueMap2 = new HashMap<>();
                valueMap2.put("operator","=");
                valueMap2.put("value","1");
                conditionsMap.put("status", valueMap2);
                //干掉它
                conditionsMap.remove("fee");
            }
        }

        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0 && StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "finance")<0){
            CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
            cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
            List<CfCarParkLinkUser> cfCarParkLinkUsers = cfCarParkLinkUserService.getListByQuery(cfCarParkLinkUserQuery);
            if(cfCarParkLinkUsers==null || cfCarParkLinkUsers.size()==0){
                ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
            }
            String carParkIds = "";
            for (CfCarParkLinkUser cfCarParkLinkUser: cfCarParkLinkUsers){
                carParkIds += ",'"+cfCarParkLinkUser.getCarParkId()+"'";
            }
            carParkIds = carParkIds.substring(1);
            if(StringUtils.isNotEmpty(carParkIds)){
                HashMap<String, String> valueMap = new HashMap<>();
                valueMap.put("operator","in");
                valueMap.put("value",carParkIds);
                conditionsMap.put("car_park_id$in", valueMap);
            }
        }

        if(isDuty && StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0){
            HashMap<String, Object> valueMap1 = new HashMap<>();
            HashMap<String, Object> valueMap2 = new HashMap<>();
//            valueMap2.put("cpul.in_handle_uid",userBasicInfo.getId());
//            valueMap2.put("cpul.out_handle_uid",userBasicInfo.getId());

            valueMap1.put("operator","or_eq");
            valueMap1.put("value",valueMap2);
            conditionsMap.put("or_eq", valueMap1);
        }

        map.put("conditionsMap",conditionsMap);

        return map;
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-getCarParkUseLogListByQuery')")
    @Override
    @RequestMapping(value = "getCarParkUseLogListByQuery", method = RequestMethod.GET)
    public ResponseResult getCarParkUseLogListByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery) throws Exception {
//        cfCarParkUseLogQuery.setOrderBy("cpul.create_time desc");
        List<CfCarParkUseLog> cfCarParkUseLogs = cfCarParkUseLogService.selectByQuery(cfCarParkUseLogQuery);
        if(cfCarParkUseLogs!=null && cfCarParkUseLogs.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParkUseLogs);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        Integer delete = 0;
        if(id.indexOf(",")>-1){
            String[] ids = id.split(",");
            CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
            cfCarParkUseLogQuery.setIds(new ArrayList<>());
            for(int i = 0; i< ids.length; i++){
                cfCarParkUseLogQuery.getIds().add(ids[i]);
            }
            delete = cfCarParkUseLogService.deleteByQuery(cfCarParkUseLogQuery);
        }else{
            delete = cfCarParkUseLogService.delete(id);
        }
        if(delete==0){
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @Override
    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-countUseLogs')")
    @RequestMapping(value = "countUseLogs", method = RequestMethod.GET)
    public ResponseResult countUseLogs(CfCountCarParkUseLogQuery cfCountCarParkUseLogQuery) {
        if(cfCountCarParkUseLogQuery.getDate().equals("") || cfCountCarParkUseLogQuery.getDate().equals("null")){
            cfCountCarParkUseLogQuery.setDate(null);
        }
        if(cfCountCarParkUseLogQuery.getEndDate().equals("") || cfCountCarParkUseLogQuery.getEndDate().equals("null")){
            cfCountCarParkUseLogQuery.setEndDate(null);
        }
        if(cfCountCarParkUseLogQuery.getYear().equals("") || cfCountCarParkUseLogQuery.getYear().equals("null")){
            cfCountCarParkUseLogQuery.setYear(null);
        }
        if(cfCountCarParkUseLogQuery.getMonth().equals("") || cfCountCarParkUseLogQuery.getMonth().equals("null")){
            cfCountCarParkUseLogQuery.setMonth(null);
        }
        if(cfCountCarParkUseLogQuery.getDay().equals("") || cfCountCarParkUseLogQuery.getDay().equals("null")){
            cfCountCarParkUseLogQuery.setDay(null);
        }
        if(cfCountCarParkUseLogQuery.getCarparkId().equals("") || cfCountCarParkUseLogQuery.getCarparkId().equals("null")){
            cfCountCarParkUseLogQuery.setCarparkId(null);
        }

        if(cfCountCarParkUseLogQuery.getNumberPlate().equals("") || cfCountCarParkUseLogQuery.getNumberPlate().equals("null")){
            cfCountCarParkUseLogQuery.setNumberPlate(null);
        }
        if(cfCountCarParkUseLogQuery.getCountryId().equals("") || cfCountCarParkUseLogQuery.getCountryId().equals("null")){
            cfCountCarParkUseLogQuery.setCountryId(null);
        }
        if(cfCountCarParkUseLogQuery.getProvinceId().equals("") || cfCountCarParkUseLogQuery.getProvinceId().equals("null")){
            cfCountCarParkUseLogQuery.setProvinceId(null);
        }
        if(cfCountCarParkUseLogQuery.getStateOrCityId().equals("") || cfCountCarParkUseLogQuery.getStateOrCityId().equals("null")){
            cfCountCarParkUseLogQuery.setStateOrCityId(null);
        }
        if(cfCountCarParkUseLogQuery.getZoneOrCountyId().equals("") || cfCountCarParkUseLogQuery.getZoneOrCountyId().equals("null")){
            cfCountCarParkUseLogQuery.setZoneOrCountyId(null);
        }
        if(cfCountCarParkUseLogQuery.getTownshipId().equals("") || cfCountCarParkUseLogQuery.getTownshipId().equals("null")){
            cfCountCarParkUseLogQuery.setTownshipId(null);
        }
        List<CountByDay> list = null;
        switch (cfCountCarParkUseLogQuery.getCountType()){
            case "before_day_count_by_day":
                list = cfCarParkUseLogService.limitDaysCountByDay(cfCountCarParkUseLogQuery);
                break;
            case "month_count_by_day":
                list = cfCarParkUseLogService.yearMonthCountByDay(cfCountCarParkUseLogQuery);
                break;
            case "year_count_by_month":
                list = cfCarParkUseLogService.yearCountByMonth(cfCountCarParkUseLogQuery);
                break;
        }

        if(list==null || list.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, list, cfCarParkUseLogService.getCountByQuery(new CfCarParkUseLogQuery()));
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-countPayAmountByDuty')")
    @Override
    @RequestMapping(value = "countPayAmountByDuty", method = RequestMethod.GET)
    public ResponseResult countPayAmountByDuty(CountPayAmountByDutyQuery countPayAmountByDutyQuery) throws Exception {
        if(StringUtils.isEmpty(countPayAmountByDutyQuery.getCountMode())){
            countPayAmountByDutyQuery.setCountMode("real_time");
        }
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));

        if(countPayAmountByDutyQuery.getCountMode().equals("real_time")){
            CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
            cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
            cfCarParkLinkUserQuery.setPage(1);
            cfCarParkLinkUserQuery.setSize(1);
            List<CfCarParkLinkUser> cfCarParkLinkUsers = cfCarParkLinkUserService.getListByQuery(cfCarParkLinkUserQuery);
            if(cfCarParkLinkUsers!=null && cfCarParkLinkUsers.size()>0){
                countPayAmountByDutyQuery.setMinTime(cfCarParkLinkUsers.get(0).getStartDutyTime());
            }else{
                countPayAmountByDutyQuery.setMinTime(System.currentTimeMillis());
            }
        }else if(countPayAmountByDutyQuery.getCountMode().equals("day")){
            countPayAmountByDutyQuery.setMinTime(DateUtil.getSameDayMinOrMaxTimestamp("min"));
        }else{
            countPayAmountByDutyQuery.setMinTime(System.currentTimeMillis());
        }

        countPayAmountByDutyQuery.setHandleUid(userBasicInfo.getId());
        countPayAmountByDutyQuery.setMaxTime(DateUtil.maxMillisecondBaseOnTheDayToTimestamp(System.currentTimeMillis()));
        BigDecimal countPayAmountByDuty = cfCarParkUseLogService.countPayAmountByDuty(countPayAmountByDutyQuery);
        return new ResponseResult(CommonCode.SUCCESS, countPayAmountByDuty);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-capture')")
    @Override
    @RequestMapping(value = "capture", method = RequestMethod.GET)
    public ResponseResult capture(String sn) {
        CfCarParkDevice cfCarParkDevice = cfCarParkDeviceService.findByCode(sn, false);
        Object capture = cfCarParkReleaseLogService.capture(sn, cfCarParkDevice.getBrand(), 0);
        return new ResponseResult(CommonCode.SUCCESS, capture);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-countByQuery')")
    @Override
    @RequestMapping(value = "countByQuery", method = RequestMethod.GET)
    public ResponseResult countByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0){
            CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
            cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
            List<CfCarParkLinkUser> cfCarParkLinkUsers = cfCarParkLinkUserService.getListByQuery(cfCarParkLinkUserQuery);
            if(cfCarParkLinkUsers==null || cfCarParkLinkUsers.size()==0){
                ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
            }
            List<String> carParkIds = new ArrayList<>();
            for (CfCarParkLinkUser cfCarParkLinkUser: cfCarParkLinkUsers){
                carParkIds.add(cfCarParkLinkUser.getCarParkId());
            }
            cfCarParkUseLogQuery.setCarParkIds(carParkIds);
        }

        Integer countByQuery = cfCarParkUseLogService.countByQuery(cfCarParkUseLogQuery);
        return new ResponseResult(CommonCode.SUCCESS, null, countByQuery);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkUseLogController-mergeCarUseLog')")
    @Override
    @RequestMapping(value = "mergeCarUseLog", method = RequestMethod.PUT)
    public ResponseResult mergeCarUseLog(String beforeCfCarParkUseLogId, String nowcfCarParkUseLogId, String numberPlate) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCarParkUseLog beforeCfCarParkUseLog = cfCarParkUseLogService.findById(beforeCfCarParkUseLogId, false);
        CfCarParkUseLog nowcfCarParkUseLog = cfCarParkUseLogService.findById(nowcfCarParkUseLogId, false);
        if(!beforeCfCarParkUseLog.getCarParkId().equals(nowcfCarParkUseLog.getCarParkId()) ||
                !nowcfCarParkUseLog.getOutHandleUid().equals(userBasicInfo.getId())){
            return new ResponseResult(CommonCode.UNAUTHORISE);
        }

        beforeCfCarParkUseLog.setOutTime(nowcfCarParkUseLog.getOutTime());
        beforeCfCarParkUseLog.setOutSmallImage(nowcfCarParkUseLog.getOutSmallImage());
        beforeCfCarParkUseLog.setOutBigImage(nowcfCarParkUseLog.getOutBigImage());
        beforeCfCarParkUseLog.setOutCheckPointId(nowcfCarParkUseLog.getOutCheckPointId());
        beforeCfCarParkUseLog.setOutHandleUid(nowcfCarParkUseLog.getOutHandleUid());
        if(StringUtils.isNotEmpty(numberPlate)){
            beforeCfCarParkUseLog.setNumberPlate(numberPlate);
        }else{
            beforeCfCarParkUseLog.setNumberPlate(nowcfCarParkUseLog.getNumberPlate());
        }
        CfCarParkUseLog newcfCarParkUseLog = cfCarParkUseLogService.update(beforeCfCarParkUseLog);

        cfCarParkUseLogService.delete(nowcfCarParkUseLogId);

        return new ResponseResult(CommonCode.SUCCESS, newcfCarParkUseLog);
    }
}
