package com.lms.po;

public class Power {
    private Integer powerId;

    private Integer rloeId;

    private Integer menuId;

    private Integer powerIt;

    private String powerName;

    public Power(Integer powerId, Integer rloeId, Integer menuId, Integer powerIt, String powerName) {
        this.powerId = powerId;
        this.rloeId = rloeId;
        this.menuId = menuId;
        this.powerIt = powerIt;
        this.powerName = powerName;
    }

    public Power() {
        super();
    }

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    public Integer getRloeId() {
        return rloeId;
    }

    public void setRloeId(Integer rloeId) {
        this.rloeId = rloeId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getPowerIt() {
        return powerIt;
    }

    public void setPowerIt(Integer powerIt) {
        this.powerIt = powerIt;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName == null ? null : powerName.trim();
    }
}