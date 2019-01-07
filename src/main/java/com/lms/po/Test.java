package com.lms.po;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Test") //指定表名为users

public class Test {
    @Id         //主键
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //自动增量
    private Integer id;

    private String name;

    @Temporal(TemporalType.DATE)    //设置为时间类型
    private Date data;

    @Column(name="age",columnDefinition = "int default 19") //设置默认值12345890
    private Integer age;

    private String tet;

    public String getTet() {
        return tet;
    }

    public void setTet(String tet) {
        this.tet = tet;
    }

    public Test() {
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
        this.name = name;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
