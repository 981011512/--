package com.cf.ucenter.admin.controller;

import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.ucenter.admin.swagger.CfUserDriverLicenseSwagger;
import com.cf.ucenter.admin.swagger.DepartmentSwagger;
import com.cf.ucenter.domain.CfThirdPartyLogin;
import com.cf.ucenter.domain.CfUserDriverLicense;
import com.cf.ucenter.request.CfUserDriverLicenseForm;
import com.cf.ucenter.request.CfUserDriverLicenseQuery;
import com.cf.ucenter.service.CfThirdPartyLoginService;
import com.cf.ucenter.service.CfUserDriverLicenseService;
import com.cf.ucenter.type.ThirdPartyPlatformType;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户驾驶证管理
 *
 * @ClassName CfUserDriverLicenseController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2022/12/21/021 15:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("CfUserDriverLicenseAdmin/")
@Validated
public class CfUserDriverLicenseController implements CfUserDriverLicenseSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfUserDriverLicenseService cfUserDriverLicenseService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfThirdPartyLoginService cfThirdPartyLoginService;

    @PreAuthorize("hasAuthority('ucenter-CfUserDriverLicenseController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfUserDriverLicenseQuery cfUserDriverLicenseQuery) {
        List<CfUserDriverLicense> list = cfUserDriverLicenseService.getListByQuery(cfUserDriverLicenseQuery);
        if(list!=null && list.size()>0){
            Integer integer = cfUserDriverLicenseService.countByQuery(cfUserDriverLicenseQuery);
            return new ResponseResult(CommonCode.SUCCESS, list, integer);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('ucenter-CfUserDriverLicenseController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfUserDriverLicenseForm cfUserDriverLicenseForm) throws Exception {
        CfUserDriverLicense cfUserDriverLicense = new CfUserDriverLicense();
        BeanUtils.copyProperties(cfUserDriverLicenseForm, cfUserDriverLicense);
        
        CfUserDriverLicense department = cfUserDriverLicenseService.add(cfUserDriverLicense);
        if(department!=null){
            return new ResponseResult(CommonCode.SUCCESS, department);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('ucenter-CfUserDriverLicenseController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfUserDriverLicenseForm cfUserDriverLicenseForm) throws Exception {
        CfUserDriverLicense cfUserDriverLicense = new CfUserDriverLicense();
        BeanUtils.copyProperties(cfUserDriverLicenseForm, cfUserDriverLicense);

        CfUserDriverLicense department = cfUserDriverLicenseService.update(cfUserDriverLicense);
        if(department!=null){
            return new ResponseResult(CommonCode.SUCCESS, department);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('ucenter-CfUserDriverLicenseController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) {
        cfUserDriverLicenseService.delete(id);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @PreAuthorize("hasAuthority('ucenter-CfUserDriverLicenseController-manuallySynchronizeTmsSystemData')")
    @Override
    @RequestMapping(value = "manuallySynchronizeTmsSystemData", method = RequestMethod.GET)
    public ResponseResult manuallySynchronizeTmsSystemData() throws Exception {
        List<CfUserDriverLicense> cfUserDriverLicenseList = cfUserDriverLicenseService.synchronizeTmsDriver();
        return new ResponseResult(CommonCode.SUCCESS, cfUserDriverLicenseList);
    }

    @PreAuthorize("hasAuthority('ucenter-CfUserDriverLicenseController-importExcelUserDriverLicense')")
    @Override
    @RequestMapping(value = "importExcelUserDriverLicense", method = RequestMethod.POST, headers = "content-type=multipart/form-data;charset=utf-8")
    public ResponseResult importExcelUserDriverLicense(@RequestParam(value = "file", required = true) MultipartFile file) throws Exception {

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

        //遍历excel每一行
        CfUserDriverLicense cfUserDriverLicense = new CfUserDriverLicense();
        CfUserDriverLicenseQuery cfUserDriverLicenseQuery = new CfUserDriverLicenseQuery();
        ArrayList<String> errorMessageList = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            try {
                Row row = sheet1.getRow(i);
                Cell cell1 = row.getCell(0);
                if(i>0 && cell1==null){
                    break;
                }
                if(cell1!=null){
                    cell1.setCellType(CellType.STRING);
                    String cell1Value = cell1.getStringCellValue();
                    if(i==0 && !cell1Value.equals("NAME")){
                        ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第1例标题名称应为\"NAME\"");
                    }else{
                        cfUserDriverLicense.setUserName(cell1Value);
                    }
                }else{
                    cfUserDriverLicense.setUserName("");
                }


                Cell cell2 = row.getCell(1);
                if(cell2!=null){
                    cell2.setCellType(CellType.STRING);
                    String cell2Value = cell2.getStringCellValue();
                    if(i==0 && !cell2Value.equals("TEL")){
                        ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第2例标题名称应为\"TEL\"");
                    }else{
                        cfUserDriverLicense.setPhone(cell2Value);
                    }
                }else{
                    cfUserDriverLicense.setPhone("");
                }


                Cell cell3 = row.getCell(2);
                if(cell3!=null){
                    cell3.setCellType(CellType.STRING);
                    String cell3Value = cell3.getStringCellValue();
                    if(i==0 && !cell3Value.equals("GENDER")){
                        ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第3例标题名称应为\"GENDER\"");
                    }else{
                        if(StringUtils.isEmpty(cell3Value)){
                            cfUserDriverLicense.setSex((byte)3);
                        }else if(cell3Value.equals("男")){
                            cfUserDriverLicense.setSex((byte)1);
                        }else{
                            cfUserDriverLicense.setSex((byte)2);
                        }
                    }
                }else{
                    cfUserDriverLicense.setSex((byte)3);
                }


                Cell cell4 = row.getCell(3);
                if(cell4!=null){
                    cell4.setCellType(CellType.STRING);
                    String cell4Value = cell4.getStringCellValue();
                    if(i==0 && !cell4Value.equals("IDCARD")){
                        ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第4例标题名称应为\"IDCARD\"");
                    }else{
                        cfUserDriverLicense.setCertificateNumber(cell4Value);
                    }
                }else{
                    cfUserDriverLicense.setCertificateNumber("");
                }


                Cell cell5 = row.getCell(4);
                if(cell5!=null){
                    cell5.setCellType(CellType.STRING);
                    String cell5Value = cell5.getStringCellValue();
                    if(i==0 && !cell5Value.equals("CERTIFICATE")){
                        ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第5例标题名称应为\"CERTIFICATE\"");
                    }else{
                        cfUserDriverLicense.setQualificationCertificateNumber(cell5Value);
                    }
                }else{
                    cfUserDriverLicense.setQualificationCertificateNumber("");
                }


                Cell cell6 = row.getCell(5);
                if(cell6!=null){
                    cell6.setCellType(CellType.STRING);
                    String cell6Value = cell6.getStringCellValue();
                    if(i==0 && !cell6Value.equals("DRIVER_CAR_TYPE")){
                        ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第6例标题名称应为\"DRIVER_CAR_TYPE\"");
                    }else{
                        cfUserDriverLicense.setCarClass(cell6Value);
                    }
                }
                Cell cell7 = row.getCell(6);
                String openid = "";
                if(cell7!=null){
                    cell7.setCellType(CellType.STRING);
                    String cell7Value = cell7.getStringCellValue();
                    if(i==0 && !cell7Value.equals("WECHATID")){
                        ExceptionCast.cast(CommonCode.INVALID_PARAM, "表头第7例标题名称应为\"WECHATID\"");
                    }else{
                        openid = cell7Value;
                    }
                }

                if(i>0){
                    cfUserDriverLicense.setUid("");
                    cfUserDriverLicense.setNationality("");
                    cfUserDriverLicense.setAddress("");
                    cfUserDriverLicense.setBirthdayYear((short)0);
                    cfUserDriverLicense.setBirthdayMonth((byte)0);
                    cfUserDriverLicense.setBirthdayDay((byte)0);
                    cfUserDriverLicense.setFirstIssueYear((short)0);
                    cfUserDriverLicense.setFirstIssueMonth((byte)0);
                    cfUserDriverLicense.setFirstIssueDay((byte)0);
                    cfUserDriverLicense.setStartTime(0l);
                    cfUserDriverLicense.setEndTime(0l);
                    cfUserDriverLicense.setIssuingAuthority("");
                    cfUserDriverLicense.setFileNumber("");
                    cfUserDriverLicense.setInternshipPeriodEnds(0l);
                    cfUserDriverLicense.setCheckStatus((byte)1);
                    //判断是否存在重复的手机号
                    cfUserDriverLicenseQuery.setPhone(cfUserDriverLicense.getPhone());
                    List<CfUserDriverLicense> driverLicenseList = cfUserDriverLicenseService.getListByQuery(cfUserDriverLicenseQuery);
                    if(driverLicenseList!=null && driverLicenseList.size()>0){
                        cfUserDriverLicense.setId(driverLicenseList.get(0).getId());
                        cfUserDriverLicenseService.update(cfUserDriverLicense);
                    }else{
                        cfUserDriverLicenseService.add(cfUserDriverLicense);
                        if(StringUtils.isNotEmpty(openid)){
                            //创建对应的微信公众号用户
                            CfThirdPartyLogin cfThirdPartyLogin = new CfThirdPartyLogin();
                            //TODO 暂时写死，后期动态查询
                            cfThirdPartyLogin.setAppid("wx462c90069807ae19");
                            cfThirdPartyLogin.setOpenid(openid);
                            cfThirdPartyLogin.setUid(cfUserDriverLicense.getUid());
                            cfThirdPartyLogin.setPlatform(ThirdPartyPlatformType.WX_WB);
                            cfThirdPartyLogin.setUnionid("");
                            cfThirdPartyLogin.setMainBodyId("");
                            cfThirdPartyLoginService.add(cfThirdPartyLogin);
                        }
                    }
                }
            } catch (Exception e){
                errorMessageList.add("第"+i+"行:"+e.getMessage());
                continue;
            }
        }
        return new ResponseResult(CommonCode.SUCCESS, errorMessageList);
    }
}
