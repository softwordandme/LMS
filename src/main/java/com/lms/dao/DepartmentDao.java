package com.lms.dao;


import com.lms.po.Department;

import java.util.List;

public interface DepartmentDao {

    void deleteDepartmentsByParentId(Integer parentId);

    int deleteByPrimaryKey(Integer departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> findAll();

}
