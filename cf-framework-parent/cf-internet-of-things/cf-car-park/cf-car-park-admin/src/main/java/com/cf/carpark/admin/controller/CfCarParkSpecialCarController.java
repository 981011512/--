package com.cf.carpark.admin.controller;

import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkSpecialCarSwagger;
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
import com.cf.pay.domain.request.CfAccountQuery;
import com.cf.pay.service.CfAccountService;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.service.CfUserService;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("carParkSpecialCarAdmin/")
@Validated
public class CfCarParkSpecialCarController implements CfCarParkSpecialCarSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkSpecialCarService cfCarParkSpecialCarService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkService cfCarParkService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkCarTypeService cfCarParkCarTypeService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkLinkUserService cfCarParkLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfUserService cfUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfAccountService cfAccountService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkCarService cfCarParkCarService;

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected CarParkController carParkController;

    @PreAuthorize("hasAuthority('carpark-CfCarParkSpecialCarController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfCarParkSpecialCarForm cfCarParkSpecialCarForm) {
        CfCarParkSpecialCar cfCarParkSpecialCar = new CfCarParkSpecialCar();
        BeanUtils.copyProperties(cfCarParkSpecialCarForm,cfCarParkSpecialCar);
        CfCarParkSpecialCar carParkSpecialCar = cfCarParkSpecialCarService.add(cfCarParkSpecialCar);
        return new ResponseResult(CommonCode.SUCCESS, carParkSpecialCar);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkSpecialCarController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfCarParkSpecialCarForm cfCarParkSpecialCarForm) {
        CfCarParkSpecialCar cfCarParkSpecialCar = new CfCarParkSpecialCar();
        BeanUtils.copyProperties(cfCarParkSpecialCarForm,cfCarParkSpecialCar);
        CfCarParkSpecialCar carParkSpecialCar = cfCarParkSpecialCarService.update(cfCarParkSpecialCar);
        return new ResponseResult(CommonCode.SUCCESS, carParkSpecialCar);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkSpecialCarController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        Integer delete = cfCarParkSpecialCarService.delete(id);
        return delete>0 ? new ResponseResult(CommonCode.SUCCESS) : new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkSpecialCarController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery) throws Exception {
        limitQuery(cfCarParkSpecialCarQuery);
        List<CfCarParkSpecialCar> cfCarParkSpecialCars = cfCarParkSpecialCarService.getListByQuery(cfCarParkSpecialCarQuery);
        return cfCarParkSpecialCars!=null && cfCarParkSpecialCars.size()>0 ? new ResponseResult(CommonCode.SUCCESS, cfCarParkSpecialCars) : new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkSpecialCarController-selectContinCarParkByQuery')")
    @Override
    @RequestMapping(value = "selectContinCarParkByQuery", method = RequestMethod.GET)
    public ResponseResult selectContinCarParkByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery) throws Exception {
        limitQuery(cfCarParkSpecialCarQuery);
        List<CfCarParkSpecialCar> cfCarParkSpecialCars = cfCarParkSpecialCarService.selectContinCarParkByQuery(cfCarParkSpecialCarQuery);
        Integer total = 0;
        if(cfCarParkSpecialCarQuery.getPage()==1){
            total = cfCarParkSpecialCarService.countByQuery(cfCarParkSpecialCarQuery);
        }
        return cfCarParkSpecialCars!=null && cfCarParkSpecialCars.size()>0 ? new ResponseResult(CommonCode.SUCCESS, cfCarParkSpecialCars, total) : new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    /**
     * 限制查询条件(非管理人员只能查询自己名下的停车场相关数据)
     * @param cfCarParkSpecialCarQuery
     * @throws Exception
     */
    private void limitQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery) throws Exception{
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));

        List<CfCarParkLinkUser> linkUsers = carParkController.getLinkUsersAndCheck(userBasicInfo);
        if(linkUsers!=null && linkUsers.size()>0){
            if(cfCarParkSpecialCarQuery.getCarParkIds()==null){
                cfCarParkSpecialCarQuery.setCarParkIds(new ArrayList<>());
            }
            for (CfCarParkLinkUser cfCarParkLinkUser: linkUsers){
                cfCarParkSpecialCarQuery.getCarParkIds().add(cfCarParkLinkUser.getCarParkId());
            }
        }
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkSpecialCarController-importExcelParkSpecialCar')")
    @Override
    @RequestMapping(value = "importExcelParkSpecialCar", method = RequestMethod.POST, headers = "content-type=multipart/form-data;charset=utf-8")
    public ResponseResult importExcelParkSpecialCar(MultipartFile file) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));

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

        CfCarParkSpecialCar cfCarParkSpecialCar = new CfCarParkSpecialCar();
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
                cfCarParkSpecialCar.setCarParkId(cfCarParks.get(0).getId());
            }

            Cell cell2 = row.getCell(2);
            cell2.setCellType(CellType.STRING);
            String cell4Value = cell2.getStringCellValue();
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
                cfCarParkSpecialCar.setTypeKey(cfCarParkCarTypes.get(0).getFlagKey());
            }
            Cell cell3 = row.getCell(3);
            Object cell6Value = null;
            boolean startTimeIsData = false;
            if(cell3.getCellType().equals(CellType.NUMERIC)){
                cell6Value = cell3.getDateCellValue();
                startTimeIsData = true;
            }else{
                cell3.setCellType(CellType.STRING);
                cell6Value = cell3.getStringCellValue();
            }
            if(i==0 && !cell6Value.equals("开始时间")){
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第6例标题名称应为\"开始时间\"");
            }else if(i>0){
                if(startTimeIsData){
                    cfCarParkSpecialCar.setStartTime(((Date)cell6Value).getTime());
                }else{
                    cfCarParkSpecialCar.setStartTime(DateUtil.dateToStamp(cell6Value.toString(), "yyyy-MM-dd HH:mm:ss"));
                }
            }
            Cell cell4 = row.getCell(4);
            Object cell7Value = null;
            boolean endTimeIsData = false;
            if(cell4.getCellType().equals(CellType.NUMERIC)){
                cell7Value = cell4.getDateCellValue();
                endTimeIsData = true;
            }else{
                cell4.setCellType(CellType.STRING);
                cell7Value = cell4.getStringCellValue();
            }
            if(i==0 && !cell7Value.equals("结束时间")){
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第7例标题名称应为\"结束时间\"");
            }else if(i>0){
                if(endTimeIsData){
                    cfCarParkSpecialCar.setEndTime(((Date)cell7Value).getTime());
                }else{
                    cfCarParkSpecialCar.setEndTime(DateUtil.dateToStamp(cell7Value.toString(), "yyyy-MM-dd HH:mm:ss"));
                }
            }
            Cell cell5 = row.getCell(5);
            cell5.setCellType(CellType.STRING);
            String cell8Value = cell5.getStringCellValue();
            if(i==0 && !cell8Value.equals("车牌号")){
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第8例标题名称应为\"车牌号\"");
            }else if(i>0){
                cfCarParkSpecialCar.setNumberPlate(cell8Value);
            }

            Cell cell6 = row.getCell(6);
            if(cell6==null && i>0){
                cfCarParkSpecialCar.setCarOwnerName("");
            }else {
                cell6.setCellType(CellType.STRING);
                String cell10Value = cell6.getStringCellValue();
                if (i == 0 && !cell10Value.equals("车主姓名")) {
                    ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第10例标题名称应为\"车主姓名\"");
                } else if (i > 0) {
                    cfCarParkSpecialCar.setCarOwnerName(cell10Value);
                }
            }
            Cell cell7 = row.getCell(7);
            if(cell7==null && i>0){
                cfCarParkSpecialCar.setPhone("");
            }else {
                cell7.setCellType(CellType.STRING);
                String cell11Value = cell7.getStringCellValue();
                if (i == 0 && !cell11Value.equals("手机号")) {
                    ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第11例标题名称应为\"手机号\"");
                } else if (i > 0) {
                    cfCarParkSpecialCar.setPhone(cell11Value);
                }
            }
            Cell cell8 = row.getCell(8);
            if(cell8==null && i>0){
                cfCarParkSpecialCar.setRemarks("");
            }else {
                cell8.setCellType(CellType.STRING);
                String cell12Value = cell8.getStringCellValue();
                if (i == 0 && !cell12Value.equals("备注")) {
                    ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第12例标题名称应为\"备注\"");
                } else if (i > 0) {
                    cfCarParkSpecialCar.setRemarks(cell12Value);
                }
            }
            Cell cell9 = row.getCell(9);
            if(cell9==null && i>0){
                cfCarParkSpecialCar.setGroupFlag("");
            }else{
                cell9.setCellType(CellType.STRING);
                String cell13Value = cell9.getStringCellValue();
                if(i==0 && !cell13Value.equals("家庭组")){
                    ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第13例标题名称应为\"家庭组\"");
                }else if(i>0){
                    cfCarParkSpecialCar.setGroupFlag(cell13Value);
                }
            }

            //充值金额
            Cell cell10 = row.getCell(10);
            if(cell10!=null && i>0 && cell7!=null){
                cell10.setCellType(CellType.STRING);
                String cell13Value = cell10.getStringCellValue();
                //判断是否有用户绑定过此手机号
                cell7.setCellType(CellType.STRING);
                CfUser cfUser = cfUserService.findByPhone(cell7.getStringCellValue());
                if(cfUser==null){
                    //创建新用户
                    String userName = cfUserService.randomMakeUserName("", 16);
                    String password = cfUserService.randomMakeUserName("", 16);
                    String nickName = cfUserService.randomMakeUserName("", 16);
                    CfUser newUser = new CfUser("", userName, password, "", (byte)0,
                            nickName, "", cell7.getStringCellValue(),"", 0L, (byte)0, "",
                            System.currentTimeMillis(), null, new BigDecimal(0),0l);
                    cfUser = cfUserService.add(newUser);
                }

                //绑定该手机号用户已经存在，给其相关账户进行充值
                CfAccountQuery cfAccountQuery = new CfAccountQuery();
                cfAccountQuery.setUid(cfUser.getId());
                cfAccountQuery.setScoreType("cny");
                cfAccountQuery.setChangeValue(new BigDecimal(cell13Value));
                cfAccountQuery.setHandleUid(userBasicInfo.getId());
                cfAccountQuery.setType((byte)0);
                cfAccountQuery.setShopId(cfCarParkSpecialCar.getCarParkId());
                Integer integer = cfAccountService.checkAndAddBalanceByQuery(cfAccountQuery);   //充值结果

                //判断其车辆是否已经绑定过，并且是否已经通过审核
                CfCarParkCar cfCarParkCar = new CfCarParkCar();
                cfCarParkCar.setStatus((byte)2);

                CfCarParkCarQuery cfCarParkCarQuery = new CfCarParkCarQuery();
                cfCarParkCarQuery.setUid(cfUser.getId());
                cfCarParkCarQuery.setNumberPlate(cell5.getStringCellValue());
                List<CfCarParkCar> cfCarParkCars = cfCarParkCarService.getMyCarsByCondition(cfCarParkCarQuery);
                if(cfCarParkCars!=null && cfCarParkCars.size()>0 && cfCarParkCars.get(0).getStatus()!=(byte)2){
                    //设置为正常绑定车牌号
                    cfCarParkCar.setId(cfCarParkCars.get(0).getId());
                    cfCarParkCarService.update(cfCarParkCar);
                }else{
                    //增加车辆绑定
                    cfCarParkCar.setUid(cfUser.getId());
                    cfCarParkCar.setNumberPlate(cell5.getStringCellValue());
                    cfCarParkCar.setCarTypeKey(cell2.getStringCellValue());
                    cfCarParkCar.setCarTypeStartTime(cfCarParkSpecialCar.getStartTime());
                    cfCarParkCar.setCarTypeEndTime(cfCarParkSpecialCar.getEndTime());
                    cfCarParkCar.setCreateTime(System.currentTimeMillis());
                    cfCarParkCarService.add(cfCarParkCar);
                }
            }


            if(i>0){
                //判断是否存在重复的特殊，如果存在的，进行覆盖
                CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery = new CfCarParkSpecialCarQuery();
                cfCarParkSpecialCarQuery.setCarParkId(cfCarParkSpecialCar.getCarParkId());
                cfCarParkSpecialCarQuery.setNumberPlate(cfCarParkSpecialCar.getNumberPlate());
                cfCarParkSpecialCarQuery.setTypeKey(cfCarParkSpecialCar.getTypeKey());
                cfCarParkSpecialCarQuery.setPage(1);
                cfCarParkSpecialCarQuery.setSize(1);
                List<CfCarParkSpecialCar> cfCarParkSpecialCars = cfCarParkSpecialCarService.getListByQuery(cfCarParkSpecialCarQuery);
                if(cfCarParkSpecialCars != null && cfCarParkSpecialCars.size() > 0){
                    cfCarParkSpecialCars.get(0).setStartTime(cfCarParkSpecialCar.getStartTime());
                    cfCarParkSpecialCars.get(0).setEndTime(cfCarParkSpecialCar.getEndTime());
                    cfCarParkSpecialCars.get(0).setPhone(cfCarParkSpecialCar.getPhone());
                    cfCarParkSpecialCars.get(0).setCarOwnerName(cfCarParkSpecialCar.getCarOwnerName());
                    if(cfCarParkSpecialCar.getGroupFlag()!=null){
                        cfCarParkSpecialCars.get(0).setGroupFlag(cfCarParkSpecialCar.getGroupFlag());
                    }
                    cfCarParkSpecialCar = cfCarParkSpecialCarService.update(cfCarParkSpecialCars.get(0));
                }else{
                    if(cfCarParkSpecialCar.getUid()==null){
                        cfCarParkSpecialCar.setUid("");
                    }
                    if(cfCarParkSpecialCar.getStatus()==null){
                        cfCarParkSpecialCar.setStatus((byte)1);
                    }
                    if(cfCarParkSpecialCar.getGroupFlag()==null){
                        cfCarParkSpecialCar.setGroupFlag("");
                    }
                    cfCarParkSpecialCar = cfCarParkSpecialCarService.add(cfCarParkSpecialCar);
                }
            }
        }

        return new ResponseResult(CommonCode.SUCCESS, null);
    }
}
