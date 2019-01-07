package com.lms.po;

import javax.persistence.*;

@Entity
@Table(name = "Menu")       //菜单表
public class Menu {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //自动增量
    private Integer menuId;             //菜单Id  唯一自增

    private Integer menuNum;            //菜单排序，数字小的在前面

    private String menuName;            //菜单名字

    private Integer menuParentId;        //菜单父ID

    private String menuUrl;             //菜单地址

    private Integer menuPower;          //菜单权限      1,2,3,4,5分别为学生，老师，教研室，系主任，管理员

    private String pname;               //放着耍

    public Menu() {
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuNum() {
        return menuNum;
    }

    public void setMenuNum(Integer menuNum) {
        this.menuNum = menuNum;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getMenuPower() {
        return menuPower;
    }

    public void setMenuPower(Integer menuPower) {
        this.menuPower = menuPower;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
