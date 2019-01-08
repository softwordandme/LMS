package com.lms.services;

import com.alibaba.fastjson.JSON;
import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    public Department findDepartmentByDepartmentId(Integer departmentId){
        return  departmentDao.findDepartmentByDepartmentId(departmentId);
    }

    public String findDepartmentNameById(Integer departmentId){
        Department department;
        department = departmentDao.selectByPrimaryKey(departmentId);
        return department.getDepartmentName();
    }

    /**
     * 查询所有部门转为json格式
     */
    public String findDepartmentList(){
        String DepartmentList = JSON.toJSONString(departmentDao.findAll());
        return DepartmentList;
    }

    /**
     * 查询所有部门
     */
    public List<Department> findAll(){
        return departmentDao.findAll();
    }

    /**
     * 根据上级parentId增加部门*/
    public String saveDepartment(String parentId,String departmentName){
        Department department = new Department();
        String x = "no";
        if(!parentId.equals(x)){
            Integer cParent = Integer.parseInt(parentId);
            department.setParentId(cParent);
        }
        department.setDepartmentName(departmentName);
        departmentDao.insert(department);
        return "true";
    }

    /**
     * 根据departmentId修改部门departmentName
     */
    public String saveDepartmentByDepartmentId(String departmentId,String departmentName){
        Department department = departmentDao.selectByPrimaryKey(Integer.parseInt(departmentId));
        department.setParentId(Integer.parseInt(departmentId));
        department.setDepartmentName(departmentName);
        System.out.print(department);
        departmentDao.updateByPrimaryKeySelective(department);
        return "true";
    }

    @Transactional
    public String delDepartment(String departmentId){
        departmentDao.deleteByPrimaryKey(Integer.parseInt(departmentId));
        departmentDao.deleteDepartmentsByParentId(Integer.parseInt(departmentId));

            return "true";
    }
}
