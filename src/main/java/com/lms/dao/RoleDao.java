package com.lms.dao;

import com.lms.po.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role,Integer> {
    Role findAllByRoleId(Integer roleId);

    Role findByRoleId(Integer roleId);

    Role findRoleByRoleName(String roleName);
}
