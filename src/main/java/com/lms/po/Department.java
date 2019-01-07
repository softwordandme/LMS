package com.lms.po;

import javax.persistence.*;

@Entity
@Table(name = "Department")  //系部表
public class Department {

    /**
     * 自动增量
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    /**
     * 系部ID，唯一，自增
     */
    private Integer departmentId;

    /**
     * 系部名称
     */
    private String  departmentName;

    /**
    * 不写数据
    */
    private Integer teacherId;

    /**
     * 上一级部门的id
     */
    private Integer parentId;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }



    public Department() {
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
