package com.cf.carpark.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkPackageSwagger;
import com.cf.carpark.domain.*;
import com.cf.carpark.domain.request.*;
import com.cf.carpark.service.*;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkPackageController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/31/031 10:06
 * @Version 1.0
 **/
@RestController
@RequestMapping("carparkpackageAdmin/")
@Validated
public class CfCarParkPackageController implements CfCarParkPackageSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkPackagePriceService cfCarParkPackagePriceService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkPackageService cfCarParkPackageService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkService cfCarParkService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkCarTypeService cfCarParkCarTypeService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkLinkUserService cfCarParkLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkSpecialCarService cfCarParkSpecialCarService;
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected CarParkController carParkController;

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageController-selectCarPackageListByCondition')")
    @Override
    @RequestMapping(value = "selectCarPackageListByCondition", method = RequestMethod.GET)
    public ResponseResult selectCarPackageListByCondition(String conditions) throws Exception {
        Map conditionsMap = (JSONObject.parseObject(conditions));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("car_park_id");
        allowFileds.add("type_key");
        allowFileds.add("start_time");
        allowFileds.add("end_time");
        allowFileds.add("create_time");
        allowFileds.add("uid");
        allowFileds.add("number_plate");
        allowFileds.add("group_flag");
        allowFileds.add("special_give");
        allowFileds.add("package_price_id");
        allowFileds.add("trans_regional");
        allowFileds.add("phone");
        allowFileds.add("car_owner_name");
        allowFileds.add("car_park_id$in");
        allowFileds.add("like");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","cpp");
        allowFiledsMap.put("car_park_id","cpp");
        allowFiledsMap.put("type_key","cpp");
        allowFiledsMap.put("start_time","cpp");
        allowFiledsMap.put("end_time","cpp");
        allowFiledsMap.put("create_time","cpp");
        allowFiledsMap.put("uid","cpp");
        allowFiledsMap.put("number_plate","cpp");
        allowFiledsMap.put("group_flag","cpp");
        allowFiledsMap.put("special_give","cpp");
        allowFiledsMap.put("package_price_id","cpp");
        allowFiledsMap.put("trans_regional","cpp");
        allowFiledsMap.put("phone","cpp");
        allowFiledsMap.put("car_owner_name","cpp");
        allowFiledsMap.put("car_park_id$in","cpp");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
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

        List<CfCarParkPackage> cfCarParkPackagePrices = cfCarParkPackageService.selectListByCondition(conditionsMap, allowFiledsMap,allowFileds);
        Integer counts = cfCarParkPackageService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfCarParkPackagePrices!=null && cfCarParkPackagePrices.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParkPackagePrices, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageController-selectCarPackagePriceListByCondition')")
    @Override
    @RequestMapping(value = "selectCarPackagePriceListByCondition", method = RequestMethod.GET)
    public ResponseResult selectCarPackagePriceListByCondition(String conditions) throws Exception {
        Map conditionsMap = (JSONObject.parseObject(conditions));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("flag_key");
        allowFileds.add("car_park_id");
        allowFileds.add("special_give");
        allowFileds.add("title");
        allowFileds.add("car_park_id$in");
        allowFileds.add("like");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","cppp");
        allowFiledsMap.put("flag_key","cppp");
        allowFiledsMap.put("car_park_id","cppp");
        allowFiledsMap.put("special_give","cppp");
        allowFiledsMap.put("title","cppp");
        allowFiledsMap.put("car_park_id$in","cppp");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
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

        List<CfCarParkPackage> cfCarParkPackagePrices = cfCarParkPackagePriceService.selectPackagePriceListByCondition(conditionsMap, allowFiledsMap,allowFileds);
        Integer counts = cfCarParkPackagePriceService.selectPackagePriceListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfCarParkPackagePrices!=null && cfCarParkPackagePrices.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParkPackagePrices, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfCarParkPackageForm cfCarParkPackageForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCarParkPackage cfCarParkPackage = new CfCarParkPackage();
        BeanUtils.copyProperties(cfCarParkPackageForm, cfCarParkPackage);
        CfCarParkPackage carParkPackage = cfCarParkPackageService.artificialAdd(cfCarParkPackage, userBasicInfo.getId());
        return new ResponseResult(CommonCode.SUCCESS, carParkPackage);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfCarParkPackageForm cfCarParkPackageForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCarParkPackage cfCarParkPackage = new CfCarParkPackage();
        BeanUtils.copyProperties(cfCarParkPackageForm, cfCarParkPackage);
        CfCarParkPackage carParkPackage = cfCarParkPackageService.artificialUpdate(cfCarParkPackage, userBasicInfo.getId());
        return new ResponseResult(CommonCode.SUCCESS, carParkPackage);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        Integer delete = cfCarParkPackageService.delete(id);
        if(delete==0){
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageController-getPackagePriceListByQuery')")
    @Override
    @RequestMapping(value = "getPackagePriceListByQuery", method = RequestMethod.GET)
    public ResponseResult getPackagePriceListByQuery(CfCarParkPackagePriceQuery cfCarParkPackagePriceQuery) throws Exception {

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        List<CfCarParkLinkUser> linkUsers = carParkController.getLinkUsersAndCheck(userBasicInfo);

        if(linkUsers!=null && linkUsers.size()>0){
            if(cfCarParkPackagePriceQuery.getCarParkIds()==null){
                cfCarParkPackagePriceQuery.setCarParkIds(new ArrayList<>());
            }
            for(CfCarParkLinkUser cfCarParkLinkUser: linkUsers){
                cfCarParkPackagePriceQuery.getCarParkIds().add(cfCarParkLinkUser.getCarParkId());
            }
        }

        List<CfCarParkPackagePrice> cfCarParkPackagePrices = cfCarParkPackagePriceService.getListByQuery(cfCarParkPackagePriceQuery);
        if(cfCarParkPackagePrices==null || cfCarParkPackagePrices.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkPackagePrices);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageController-getPackageListByQuery')")
    @Override
    @RequestMapping(value = "getPackageListByQuery", method = RequestMethod.GET)
    public ResponseResult getPackageListByQuery(CfCarParkPackageQuery cfCarParkPackageQuery) {
        List<CfCarParkPackage> cfCarParkPackages = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
        if(cfCarParkPackages==null || cfCarParkPackages.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkPackages);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageController-selectPackageListByQuery')")
    @Override
    @RequestMapping(value = "selectPackageListByQuery", method = RequestMethod.GET)
    public ResponseResult selectPackageListByQuery(CfCarParkPackageQuery cfCarParkPackageQuery) {
        List<CfCarParkPackage> cfCarParkPackages = cfCarParkPackageService.selectByQuery(cfCarParkPackageQuery);
        if(cfCarParkPackages==null || cfCarParkPackages.size()==0){
            CfCarParkPackage cfCarParkPackage = new CfCarParkPackage();
            CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery = new CfCarParkSpecialCarQuery();
            cfCarParkSpecialCarQuery.setCarParkId(cfCarParkPackageQuery.getCarParkId());
            cfCarParkSpecialCarQuery.setNumberPlate(cfCarParkPackageQuery.getNumberPlate());
            List<CfCarParkSpecialCar> cfCarParkSpecialCars = cfCarParkSpecialCarService.getListByQuery(cfCarParkSpecialCarQuery);
            if(cfCarParkSpecialCars!=null && cfCarParkSpecialCars.size()>0){
                CfCarParkCarType cfCarParkCarType = cfCarParkCarTypeService.findByKey(cfCarParkSpecialCars.get(0).getTypeKey(), false);
                cfCarParkPackage.setCfCarParkCarType(cfCarParkCarType);
            }else{
                //没有数据这设置为临时车
                CfCarParkCarType cfCarParkCarType = cfCarParkCarTypeService.findByKey("temporary_car", false);
                cfCarParkPackage.setCfCarParkCarType(cfCarParkCarType);
            }
            cfCarParkPackages = new ArrayList<>();
            cfCarParkPackages.add(cfCarParkPackage);
            return new ResponseResult(CommonCode.SUCCESS, cfCarParkPackages);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkPackages);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageController-addPackagePrice')")
    @Override
    @RequestMapping(value = "addPackagePrice", method = RequestMethod.POST)
    public ResponseResult addPackagePrice(@RequestBody CfCarParkPackagePriceForm cfCarParkPackagePriceForm) {
        CfCarParkPackagePrice cfCarParkPackagePrice = new CfCarParkPackagePrice();
        BeanUtils.copyProperties(cfCarParkPackagePriceForm, cfCarParkPackagePrice);
        CfCarParkPackagePrice parkPackagePrice = cfCarParkPackagePriceService.add(cfCarParkPackagePrice);
        return new ResponseResult(CommonCode.SUCCESS, parkPackagePrice);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageController-updatePackagePrice')")
    @Override
    @RequestMapping(value = "updatePackagePrice", method = RequestMethod.PUT)
    public ResponseResult updatePackagePrice(@RequestBody CfCarParkPackagePriceForm cfCarParkPackagePriceForm) {
        CfCarParkPackagePrice cfCarParkPackagePrice = new CfCarParkPackagePrice();
        BeanUtils.copyProperties(cfCarParkPackagePriceForm, cfCarParkPackagePrice);
        CfCarParkPackagePrice parkPackagePrice = cfCarParkPackagePriceService.update(cfCarParkPackagePrice);
        return new ResponseResult(CommonCode.SUCCESS, parkPackagePrice);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageController-deletePackagePrice')")
    @Override
    @RequestMapping(value = "deletePackagePrice", method = RequestMethod.DELETE)
    public ResponseResult deletePackagePrice(String id) {
        Integer delete = cfCarParkPackagePriceService.delete(id);
        if(delete==0){
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageController-importExcelParkPackage')")
    @Override
    @RequestMapping(value = "importExcelParkPackage", method = RequestMethod.POST, headers = "content-type=multipart/form-data;charset=utf-8")
    public ResponseResult importExcelParkPackage(@RequestParam(value = "file", required = true) MultipartFile file) throws Exception {

        //1.得到上传的表
        Workbook workbook1 = WorkbookFactory.create(file.getInputStream());
        //2、获取test工作表
        Sheet sheet1 = workbook1.getSheet("Sheet1");
        //获取表的总行数
        int num = sheet1.getLastRowNum();

        //判断表头是否正确
        

        //System.out.println(num);
        //总列数
        int col = sheet1.getRow(0).getLastCellNum();

        CfCarParkPackage cfCarParkPackage = new CfCarParkPackage();
        CfCarParkPackagePriceQuery cfCarParkPackagePriceQuery = new CfCarParkPackagePriceQuery();
        CfCarParkQuery cfCarParkQuery = new CfCarParkQuery();
        CfCarParkCarTypeQuery cfCarParkCarTypeQuery = new CfCarParkCarTypeQuery();

        //遍历excel每一行
        for (int i = 0; i <= num; i++) {
            Row row = sheet1.getRow(i);
            Cell cell0 = row.getCell(0);
            cell0.setCellType(CellType.STRING);
            String cell0Value = cell0.getStringCellValue();
            if(i==0 && !cell0Value.equals("序号")){
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第1例标题名称应为\"序号\"");
            }
            Cell cell1 = row.getCell(1);
            cell1.setCellType(CellType.STRING);
            String cell1Value = cell1.getStringCellValue();
            if(i==0 && !cell1Value.equals("停车场")){
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第2例标题名称应为\"停车场\"");
            }else if(i>0){
                if(StringUtils.isEmpty(cell1Value)){
                    break;
                }
                cfCarParkQuery.setName(cell1Value);
                cfCarParkQuery.setPage(1);
                cfCarParkQuery.setSize(1);
                List<CfCarPark> cfCarParks = cfCarParkService.getListByQuery(cfCarParkQuery);
                if(cfCarParks==null || cfCarParks.size()==0){
                    ExceptionCast.cast(CarParkCode.CAR_PARK_NOT_EXISTS,"当前序号:"+cell0Value);
                }
                cfCarParkPackage.setCarParkId(cfCarParks.get(0).getId());
            }
            Cell cell2 = row.getCell(2);
            cell2.setCellType(CellType.STRING);
            String cell2Value = cell2.getStringCellValue();
            if(i==0 && !cell2Value.equals("上级停车场")){
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第3例标题名称应为\"上级停车场\"");
            }else if(i>0){
                cfCarParkQuery.setName(cell2Value);
                cfCarParkQuery.setPage(1);
                cfCarParkQuery.setSize(1);
                List<CfCarPark> cfCarParks = cfCarParkService.getListByQuery(cfCarParkQuery);
                if(cfCarParks==null || cfCarParks.size()==0){
                    ExceptionCast.cast(CarParkCode.CAR_PARK_NOT_EXISTS,"当前序号:"+cell0Value);
                }
                cfCarParkPackage.setMainCarParkId(cfCarParks.get(0).getId());
            }

            //维护是否为跨区停车
            if(cell2Value.equals(cell1Value)){
                cfCarParkPackage.setTransRegional((byte)0);
            }else if(i>0){
                cfCarParkPackage.setTransRegional((byte)1);
            }

            Cell cell4 = row.getCell(3);
            cell4.setCellType(CellType.STRING);
            String cell4Value = cell4.getStringCellValue();
            if(i==0 && !cell4Value.equals("车辆类型")){
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第4例标题名称应为\"车辆类型\"");
            }else if(i>0){
                cfCarParkCarTypeQuery.setName(cell4Value);
                cfCarParkCarTypeQuery.setPage(1);
                cfCarParkCarTypeQuery.setSize(1);
                List<CfCarParkCarType> cfCarParkCarTypes = cfCarParkCarTypeService.getListByQuery(cfCarParkCarTypeQuery);
                if(cfCarParkCarTypes==null || cfCarParkCarTypes.size()==0){
                    ExceptionCast.cast(CarParkCode.CAR_TYPE_NOT_EXISTS,"当前序号:"+cell0Value);
                }
                cfCarParkPackage.setTypeKey(cfCarParkCarTypes.get(0).getFlagKey());
            }
            Cell cell5 = row.getCell(4);
            cell5.setCellType(CellType.STRING);
            String cell5Value = cell5.getStringCellValue();
            if(i==0 && !cell5Value.equals("套餐产品")){
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第5例标题名称应为\"套餐产品\"");
            }else if(i>0){
                cfCarParkPackagePriceQuery.setTitle(cell5Value);
                cfCarParkPackagePriceQuery.setPage(1);
                cfCarParkPackagePriceQuery.setSize(1);
                List<CfCarParkPackagePrice> cfCarParkPackagePrices = cfCarParkPackagePriceService.getListByQuery(cfCarParkPackagePriceQuery);
                if(cfCarParkPackagePrices==null || cfCarParkPackagePrices.size()==0){
                    ExceptionCast.cast(CarParkCode.PACKAGE_PRICE_NOT_EXISTS,"当前序号:"+cell0Value);
                }
                cfCarParkPackage.setPackagePriceId(cfCarParkPackagePrices.get(0).getId());
            }
            Cell cell6 = row.getCell(5);
            Object cell6Value = null;
            boolean startTimeIsData = false;
            if(cell6.getCellType().equals(CellType.NUMERIC)){
                cell6Value = cell6.getDateCellValue();
                startTimeIsData = true;
            }else{
                cell6.setCellType(CellType.STRING);
                cell6Value = cell6.getStringCellValue();
            }
            if(i==0 && !cell6Value.equals("开始时间")){
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第6例标题名称应为\"开始时间\"");
            }else if(i>0){
                if(startTimeIsData){
                    cfCarParkPackage.setStartTime(((Date)cell6Value).getTime());
                }else{
                    cfCarParkPackage.setStartTime(DateUtil.dateToStamp(cell6Value.toString(), "yyyy-MM-dd HH:mm:ss"));
                }
            }
            Cell cell7 = row.getCell(6);
            Object cell7Value = null;
            boolean endTimeIsData = false;
            if(cell7.getCellType().equals(CellType.NUMERIC)){
                cell7Value = cell7.getDateCellValue();
                endTimeIsData = true;
            }else{
                cell7.setCellType(CellType.STRING);
                cell7Value = cell7.getStringCellValue();
            }
            if(i==0 && !cell7Value.equals("结束时间")){
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第7例标题名称应为\"结束时间\"");
            }else if(i>0){
                if(endTimeIsData){
                    cfCarParkPackage.setEndTime(((Date)cell7Value).getTime());
                }else{
                    cfCarParkPackage.setEndTime(DateUtil.dateToStamp(cell7Value.toString(), "yyyy-MM-dd HH:mm:ss"));
                }
            }
            Cell cell8 = row.getCell(7);
            cell8.setCellType(CellType.STRING);
            String cell8Value = cell8.getStringCellValue();
            if(i==0 && !cell8Value.equals("车牌号")){
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第8例标题名称应为\"车牌号\"");
            }else if(i>0){
                cfCarParkPackage.setNumberPlate(cell8Value);
            }
            Cell cell9 = row.getCell(8);
            cell9.setCellType(CellType.STRING);
            String cell9Value = cell9.getStringCellValue();
            if(i==0 && !cell9Value.equals("是否内部指定")){
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第9例标题名称应为\"是否内部指定\"");
            }else if(i>0){
                cfCarParkPackage.setSpecialGive(Byte.parseByte(cell9Value));
            }
            Cell cell10 = row.getCell(9);
            if(cell10==null && i>0){
                cfCarParkPackage.setCarOwnerName("");
            }else {
                cell10.setCellType(CellType.STRING);
                String cell10Value = cell10.getStringCellValue();
                if (i == 0 && !cell10Value.equals("车主姓名")) {
                    ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第10例标题名称应为\"车主姓名\"");
                } else if (i > 0) {
                    cfCarParkPackage.setCarOwnerName(cell10Value);
                }
            }
            Cell cell11 = row.getCell(10);
            if(cell11==null && i>0){
                cfCarParkPackage.setPhone("");
            }else {
                cell11.setCellType(CellType.STRING);
                String cell11Value = cell11.getStringCellValue();
                if (i == 0 && !cell11Value.equals("手机号")) {
                    ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第11例标题名称应为\"手机号\"");
                } else if (i > 0) {
                    cfCarParkPackage.setPhone(cell11Value);
                }
            }
            Cell cell12 = row.getCell(11);
            if(cell12==null && i>0){
                cfCarParkPackage.setRemarks("");
            }else {
                cell12.setCellType(CellType.STRING);
                String cell12Value = cell12.getStringCellValue();
                if (i == 0 && !cell12Value.equals("备注")) {
                    ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第12例标题名称应为\"备注\"");
                } else if (i > 0) {
                    cfCarParkPackage.setRemarks(cell12Value);
                }
            }
            Cell cell13 = row.getCell(12);
            if(cell13==null && i>0){
                cfCarParkPackage.setGroupFlag("");
            }else{
                cell13.setCellType(CellType.STRING);
                String cell13Value = cell13.getStringCellValue();
                if(i==0 && !cell13Value.equals("家庭组")){
                    ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第12例标题名称应为\"家庭组\"");
                }else if(i>0){
                    cfCarParkPackage.setGroupFlag(cell13Value);
                }
            }
            if(i>0){

                if(!cfCarParkPackage.getCarParkId().equals(cfCarParkPackage.getMainCarParkId())){
                    //找到主停车场套餐
                    cfCarParkPackage.setTransRegional((byte)1);
                }

                //判断是否存在重复的车辆套餐，如果存在的，进行覆盖
                CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
                cfCarParkPackageQuery.setCarParkId(cfCarParkPackage.getCarParkId());
                cfCarParkPackageQuery.setNumberPlate(cfCarParkPackage.getNumberPlate());
                cfCarParkPackageQuery.setParentId(cfCarParkPackage.getParentId());
                cfCarParkPackageQuery.setTypeKey(cfCarParkPackage.getTypeKey());
                cfCarParkPackageQuery.setPackagePriceId(cfCarParkPackage.getPackagePriceId());
                cfCarParkPackageQuery.setPage(1);
                cfCarParkPackageQuery.setSize(1);
                List<CfCarParkPackage> cfCarParkPackages = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
                if(cfCarParkPackages != null && cfCarParkPackages.size() > 0){
                    cfCarParkPackages.get(0).setStartTime(cfCarParkPackage.getStartTime());
                    cfCarParkPackages.get(0).setEndTime(cfCarParkPackage.getEndTime());
                    cfCarParkPackages.get(0).setPhone(cfCarParkPackage.getPhone());
                    cfCarParkPackages.get(0).setCarOwnerName(cfCarParkPackage.getCarOwnerName());
                    if(cfCarParkPackage.getParentId()!=null){
                        cfCarParkPackages.get(0).setParentId(cfCarParkPackage.getParentId());
                    }
                    if(cfCarParkPackage.getGroupFlag()!=null){
                        cfCarParkPackages.get(0).setGroupFlag(cfCarParkPackage.getGroupFlag());
                    }
                    cfCarParkPackage = cfCarParkPackageService.update(cfCarParkPackages.get(0));
                }else{
                    if(cfCarParkPackage.getUid()==null){
                        cfCarParkPackage.setUid("");
                    }
                    if(cfCarParkPackage.getStatus()==null){
                        cfCarParkPackage.setStatus((byte)1);
                    }
                    if(cfCarParkPackage.getGroupFlag()==null){
                        cfCarParkPackage.setGroupFlag("");
                    }
                    cfCarParkPackage.setId(null);
                    cfCarParkPackage = cfCarParkPackageService.add(cfCarParkPackage);
                }
                if(!cfCarParkPackage.getCarParkId().equals(cfCarParkPackage.getMainCarParkId())){
                    //找到主停车场套餐
                    cfCarParkPackageQuery.setCarParkId(cfCarParkPackage.getMainCarParkId());
                    cfCarParkPackageQuery.setNumberPlate(cfCarParkPackage.getNumberPlate());
                    cfCarParkPackageQuery.setParentId("");
                    cfCarParkPackageQuery.setTransRegional((byte)0);
                    cfCarParkPackageQuery.setTypeKey(cfCarParkPackage.getTypeKey());
                    cfCarParkPackageQuery.setPackagePriceId(cfCarParkPackage.getPackagePriceId());
                    cfCarParkPackageQuery.setPage(1);
                    cfCarParkPackageQuery.setSize(1);
                    cfCarParkPackages = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
                    if(cfCarParkPackages!=null && cfCarParkPackages.size()>0){
                        cfCarParkPackage.setParentId(cfCarParkPackages.get(0).getId());
                        cfCarParkPackageService.update(cfCarParkPackage);
                    }
                }
            }
        }

        return new ResponseResult(CommonCode.SUCCESS, null);
    }
}
