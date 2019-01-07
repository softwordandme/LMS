package com.lms.controller;

import com.lms.po.*;
import com.lms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * DeparmentManagementController class
 *
 * @author ZZ
 * @date 2018/9/26
 */
@Controller
public class DepartmentManagementController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("departmentManagement")
    public String departmentManagement(){
        return "basicManagement/departmentManagement";
    }

    @RequestMapping("departmentManagementList")
    @ResponseBody
    public String departmentManagementList(){
        return departmentService.findDepartmentList();
    }

    /**
     * 增加部门页面
     */
    @RequestMapping("addDepartment")
    public String addDepartment(@RequestParam(value = "parentId")String parentId, HttpServletRequest request){
        String t = "no";
        if (!parentId.equals(t)){
            request.setAttribute("parentId",parentId);
            request.setAttribute("parentNameByParentId",departmentService.findDepartmentNameById(Integer.parseInt(parentId)));
        }else {
            request.setAttribute("parentId",parentId);
            request.setAttribute("parentNameByParentId",null);
        }
        return "basicManagement/departmentEditor/addDepartment";
    }

    /**
     * 增加部门
     */
    @RequestMapping("addDepartmentDo")
    public String addDepartmentDo(@RequestParam(value = "departmentName")String departmentName, @RequestParam(value = "parentId")String parentId){
        departmentService.saveDepartment(parentId,departmentName);
        return "redirect:"+"/departmentManagement";
    }

    /**
     * 删除部门
     */
    @RequestMapping("delDepartmentDo")
    @ResponseBody
    public String delDepartmentDo(@RequestParam(value = "departmentId")String departmentId){
       return departmentService.delDepartment(departmentId);
    }

    /**
     * 跳转修改部门页面
     */
    @RequestMapping("updateDepartment")
    public String updateDepartment(@RequestParam(value = "departmentId")String departmentId, HttpServletRequest request){
        Department department = departmentService.findDepartmentByDepartmentId(Integer.parseInt(departmentId));
        request.setAttribute("cDepartmentName",department.getDepartmentName());
        request.setAttribute("cDepartmentId",department.getDepartmentId());
        return "basicManagement/departmentEditor/updateDepartment";
    }

    /**
     * 修改部门
     */
    @RequestMapping("updateDepartmentDo")
    @ResponseBody
    public String updateDepartmentDo(String cDepartmentId,String cDepartmentName){
        String result = departmentService.saveDepartmentByDepartmentId(cDepartmentId,cDepartmentName);
        return result;
    }
}
