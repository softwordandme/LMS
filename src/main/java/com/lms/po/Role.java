package com.lms.po;

public class Role {
    private Integer roleId;

    private String roleName;

    private String rolePower;

    private String powerName;

    public Role(Integer roleId, String roleName, String rolePower, String powerName) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.rolePower = rolePower;
        this.powerName = powerName;
    }

    public Role() {
        super();
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
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRolePower() {
        return rolePower;
    }

    public void setRolePower(String rolePower) {
        this.rolePower = rolePower == null ? null : rolePower.trim();
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName == null ? null : powerName.trim();
    }
}