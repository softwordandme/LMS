package com.lms.po;

public class Menu {
    private Integer menuId;

    private String menuName;

    private Integer menuNum;

    private Integer menuParentId;

    private Integer menuPower;

    private String menuUrl;

    private String pname;

    public Menu(Integer menuId, String menuName, Integer menuNum, Integer menuParentId, Integer menuPower, String menuUrl, String pname) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuNum = menuNum;
        this.menuParentId = menuParentId;
        this.menuPower = menuPower;
        this.menuUrl = menuUrl;
        this.pname = pname;
    }

    public Menu() {
        super();
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getMenuNum() {
        return menuNum;
    }

    public void setMenuNum(Integer menuNum) {
        this.menuNum = menuNum;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public Integer getMenuPower() {
        return menuPower;
    }

    public void setMenuPower(Integer menuPower) {
        this.menuPower = menuPower;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }
}