package com.lms.controller;

import com.alibaba.fastjson.JSON;
import com.lms.po.*;
import com.lms.services.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author x_admin
 * @date 2018/10/8 11:41
 **/
@Controller
public class QuotaController {

    @Autowired
    QuotaService quotaService;
    @Autowired
    RoleService roleService;
    /**
     * 指标展示
     * */
    @RequestMapping("/quotaManagement")
    public String showQuota(Model model){
        List<Role> roleList=roleService.findAllRole();
        model.addAttribute("roleList",roleList);
        return "teachManagement/quotaManagement";
    }
    /**
     * 获取所有指标信息
     * */
    @RequestMapping("/quotaList")
    @ResponseBody
    public String quotaList(@RequestParam(value = "quotaType")Integer quotaType){
        List<Quota> quotas=quotaService.findQuotasByQuotaType(quotaType);
        String quotaList= JSON.toJSONString(quotas);
        return quotaList;
    }
    /**
     * 指标增加页面跳转
     * */
    @RequestMapping("/addQuota")
    public  String addQuota(@RequestParam(value = "quotaParentId")Integer quotaParentId, Model model){
        if(quotaParentId!=null){
            Quota quotaParent=quotaService.findQuotaByQuotaId(quotaParentId);
            model.addAttribute("quotaParent",quotaParent);
        }else {
            List<Role> roleList=roleService.findAllRole();
            model.addAttribute("roleList",roleList);
        }
        return "teachManagement/addQuota";
    }
    /**
     * 指标增加执行
     * */
    @RequestMapping("/addQuotaDo")
    @ResponseBody
    public  String addQuotaDo(Quota quota){

        Quota qt=quotaService.addQuota(quota);
        if (qt!=null){
            return "1";
        }else {
            return "0";
        }
    }
    /**
     * 指标修改跳转
     * */
    @RequestMapping("/editQuota")
    public String editQuota(@RequestParam(value = "quotaId")Integer quotaId, Model model){
        Quota quota=quotaService.findQuotaByQuotaId(quotaId);
        Quota quotaParent=quotaService.findQuotaByQuotaId(quota.getQuotaParentId());
        model.addAttribute("quotaParent",quotaParent);
        model.addAttribute("quota",quota);
        return "teachManagement/editQuota";
    }
    /**
     * 执行指标修改
     * */
    @RequestMapping("/editQuotaDo")
    @ResponseBody
    public  String editQuotaDo(Quota quota){
        int qt=quotaService.editQuota(quota);
        if (qt!=0){
            return "1";
        }else {
            return "0";
        }
    }
    /**
     * 指标删除
     * */
    @RequestMapping("/delQuota")
    @ResponseBody
    public String delQuota(Integer quotaId){
        Integer state=quotaService.delQuota(quotaId);
        if(state>0){
            return "1";
        }
        return "0";
    }
    /**
     *指标导入
     **/
    @RequestMapping("/importExcelQuota")
    @ResponseBody
    public String  importExcel(@RequestParam("doc-form-file") MultipartFile file, @RequestParam("qType")Integer qType){
        if (file == null) {
            return "1";
        }
        List<Quota> quotas=new ArrayList<>();
        try {
            if(file.getOriginalFilename().endsWith(".xlsx")){
                XSSFWorkbook workbook=new XSSFWorkbook(file.getInputStream());
                //获取表中第一个sheet
                XSSFSheet sheet = workbook.getSheetAt(0);
                //获取多少行
                int rows = sheet.getPhysicalNumberOfRows();
                //判断导入指标类型
                if(qType==1){
                    quotas=importStudentQuota(rows,sheet,qType,quotas);
                }
                if(qType==2){
                    quotas=importTeacherQuota(rows,sheet,qType,quotas);
                }
                if (qType==3){
                    quotas=importDepartmentHeadQuota(rows,sheet,qType,quotas);
                }

            }else {
                return  "0";
            }
            if(quotas.isEmpty()){
                return "2";
            }else {
                for (Quota list:quotas){
                    quotaService.addQuota(list);
                }
                return "3";
            }
        } catch (IOException e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "0";
    }

    private List<Quota> importStudentQuota(int rows,XSSFSheet sheet,Integer qType,List<Quota> quotas){
        Quota quota;
        Quota firstLevelIndex;
        //遍历一级指标及其权重，注意：第 0 行为标题。一级指标及其权重都占4行
        for(int i=1;i<rows;i+=4){
            quota=new Quota();
            XSSFRow row = sheet.getRow(i);
            row.getCell(0).setCellType(CellType.STRING);
            quota.setQuotaName( row.getCell(0).getStringCellValue());
            quota.setQuotaWeight(new BigDecimal(row.getCell(1).getNumericCellValue()) );
            quota.setQuotaType(qType);
            //将一级指标存入数据库
            firstLevelIndex=quotaService.addQuota(quota);
            //遍历二级指标及其权重
            for (int j=i;j<i+4;j++){
                quota=new Quota();
                XSSFRow row1 = sheet.getRow(j);
                row1.getCell(3).setCellType(CellType.STRING);
                quota.setQuotaName( row1.getCell(3).getStringCellValue());
                quota.setQuotaWeight(new BigDecimal(row1.getCell(4).getNumericCellValue()));
                quota.setQuotaParentId(firstLevelIndex.getQuotaId());
                quota.setQuotaType(qType);
                quotas.add(quota);
            }

        }
        return quotas;
    }
    private List<Quota> importTeacherQuota(int rows,XSSFSheet sheet,Integer qType,List<Quota> quotas){
        Quota quota;
        Quota firstLevelIndex;
        //遍历一级指标及其权重，注意：第 0 行为标题。一级指标及其权重都占4行
        for(int i=1;i<rows;i+=4){
            quota=new Quota();
            XSSFRow row = sheet.getRow(i);
            row.getCell(0).setCellType(CellType.STRING);
            quota.setQuotaName( row.getCell(0).getStringCellValue());
            quota.setQuotaWeight(new BigDecimal(row.getCell(1).getNumericCellValue()) );
            quota.setQuotaType(qType);
            //将一级指标存入数据库
            firstLevelIndex=quotaService.addQuota(quota);
            //遍历二级指标及其权重
            for (int j=i;j<i+4;j++){
                quota=new Quota();
                XSSFRow row1 = sheet.getRow(j);
                row1.getCell(2).setCellType(CellType.STRING);
                quota.setQuotaName( row1.getCell(2).getStringCellValue());
                quota.setQuotaWeight(new BigDecimal(row1.getCell(4).getNumericCellValue()));
                quota.setQuotaParentId(firstLevelIndex.getQuotaId());
                quota.setQuotaType(qType);
                quotas.add(quota);
            }

        }
        return quotas;
    }
    private List<Quota> importDepartmentHeadQuota(int rows,XSSFSheet sheet,Integer qType,List<Quota> quotas){
        Quota quota;
        Quota firstLevelIndex;
        Quota secondLevelIndex;
        Quota thirdLevelIndex;
        Quota fourthLevelIndex;
        //遍历一级指标及其权重，注意：第 0 行为标题。一级指标及其权重都占4行
        for(int i=1;i<14;i+=12){
            quota=new Quota();
            XSSFRow row = sheet.getRow(i);
            row.getCell(0).setCellType(CellType.STRING);
            quota.setQuotaName( row.getCell(0).getStringCellValue());
            XSSFRow row1=sheet.getRow(i+1);
            quota.setQuotaWeight(new BigDecimal(row1.getCell(0).getNumericCellValue()) );
            quota.setQuotaType(qType);
            //将一级指标存入数据库
            firstLevelIndex=quotaService.addQuota(quota);
            if(i<13){
                //遍历二级指标及其权重
                for (int j=i;j<i+12;j+=4){
                    quota=new Quota();
                    XSSFRow row2 = sheet.getRow(j);
                    quota=putPropertyToQuota(row2,quota,qType,1,2,firstLevelIndex.getQuotaId());
                    //将二级指标存入数据库
                    secondLevelIndex=quotaService.addQuota(quota);
                    //遍历三级指标
                    for(int k=j;k<j+4;k++){
                        quota=new Quota();
                        XSSFRow row3= sheet.getRow(k);
                        quota=putPropertyToQuota(row3,quota,qType,3,9,secondLevelIndex.getQuotaId());
                        quotas.add(quota);
                    }
                }
            }else{
                //存储二级指标
                quota=new Quota();
                XSSFRow row2= sheet.getRow(i);
                quota=putPropertyToQuota(row2,quota,qType,1,2,firstLevelIndex.getQuotaId());
                //将二级指标存入数据库
                secondLevelIndex=quotaService.addQuota(quota);
                //遍历三级指标
                for (int j=i;j<i+5;j+=4){
                    quota=new Quota();
                    XSSFRow row3= sheet.getRow(j);
                    quota=putPropertyToQuota(row3,quota,qType,3,5,secondLevelIndex.getQuotaId());
                    //将三级指标存入数据库
                    thirdLevelIndex=quotaService.addQuota(quota);
                   //四级指标遍历
                    if(j<i+4){
                        for(int k=j;k<j+4;k++){
                            quota=new Quota();
                            XSSFRow row4= sheet.getRow(k);
                            quota=putPropertyToQuota(row4,quota,qType,6,9,thirdLevelIndex.getQuotaId());
                            quotas.add(quota);
                        }
                    }else {
                        for (int n=j;n<rows;n+=4){
                            quota=new Quota();
                            XSSFRow row4= sheet.getRow(n);
                            quota=putPropertyToQuota(row4,quota,qType,6,7,thirdLevelIndex.getQuotaId());
                            //将四级级指标存入数据库
                            fourthLevelIndex=quotaService.addQuota(quota);
                            //遍历五级指标
                            for (int m=n;m<n+4;m++){
                                quota=new Quota();
                                XSSFRow row5= sheet.getRow(m);
                                quota=putPropertyToQuota(row5,quota,qType,8,9,fourthLevelIndex.getQuotaId());
                                quotas.add(quota);
                            }
                        }
                    }
                }
            }

        }
        return quotas;
    }

    private Quota putPropertyToQuota(XSSFRow row,Quota quota,Integer qType,Integer nameIndex,Integer weightIndex,Integer partentId){
        row.getCell(nameIndex).setCellType(CellType.STRING);
        quota.setQuotaName( row.getCell(nameIndex).getStringCellValue());
        quota.setQuotaWeight(new BigDecimal(row.getCell(weightIndex).getNumericCellValue()));
        quota.setQuotaParentId(partentId);
        quota.setQuotaType(qType);
        return  quota;
    }
}
