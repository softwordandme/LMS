package com.lms.po;

import javax.persistence.*;

@Entity
@Table(name = "Power")
public class Power {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //自动增量
    private Integer powerId;         //权限id 唯一，自增

    private Integer powerIt;         //权限标识

    private String powerName;           //权限名

    public Power() {
    }

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
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
        this.powerName = powerName;
    }
}
