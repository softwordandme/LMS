package com.lms.po;

public class Course {
    private Integer courseId;

    private String courseName;

    private String teacherNo;

    private Integer termId;

    public Course(Integer courseId, String courseName, String teacherNo, Integer termId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherNo = teacherNo;
        this.termId = termId;
    }

    public Course() {
        super();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo == null ? null : teacherNo.trim();
    }

    public Integer getTermId() {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }
}