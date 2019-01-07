package com.lms.po;

import java.util.Date;

public class Student {
    private Integer id;

    private String name;

    private Integer sclass;

    private Date birthday;

    public Student(Integer id, String name, Integer sclass, Date birthday) {
        this.id = id;
        this.name = name;
        this.sclass = sclass;
        this.birthday = birthday;
    }

    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSclass() {
        return sclass;
    }

    public void setSclass(Integer sclass) {
        this.sclass = sclass;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}