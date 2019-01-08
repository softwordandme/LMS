package com.lms.dao;

import com.lms.po.Role;

import java.util.List;

public interface RoleDao {


    Role findRoleByRoleName(String roleName);


    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> findAll();
}
