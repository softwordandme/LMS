package com.lms.po;

import javax.persistence.*;

@Entity
@Table(name = "Role")       //角色表
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //自动增量
    private Integer roleId;         //角色id 唯一，自增

    private String roleName;        //角色名称  学生，教师，系主任，教研室，管理员，教师管理员，教研室管理员，系主任管理员，教研室系主任管理员

    private String rolePower;       //存菜单id

    private String powerName;       //你们不管


    public Role() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRolePower() {
        return rolePower;
    }

    public void setRolePower(String rolePower) {
        this.rolePower = rolePower;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }
}
