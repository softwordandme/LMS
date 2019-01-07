package com.lms.po;

public class Department {
    private Integer departmentId;

    private String departmentName;

    private Integer parentId;

    private Integer teacherId;

    public Department(Integer departmentId, String departmentName, Integer parentId, Integer teacherId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.parentId = parentId;
        this.teacherId = teacherId;
    }

    public Department() {
        super();
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
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}