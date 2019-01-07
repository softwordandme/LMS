package com.lms.po;

public class Course {
    private Integer courseId;

    private String courseName;

    private String teacherNo;

    private Integer termId;

    private Integer courseid;

    private String coursename;

    private String teacherno;

    private Integer termid;

    public Course(Integer courseId, String courseName, String teacherNo, Integer termId, Integer courseid, String coursename, String teacherno, Integer termid) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherNo = teacherNo;
        this.termId = termId;
        this.courseid = courseid;
        this.coursename = coursename;
        this.teacherno = teacherno;
        this.termid = termid;
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

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(String teacherno) {
        this.teacherno = teacherno == null ? null : teacherno.trim();
    }

    public Integer getTermid() {
        return termid;
    }

    public void setTermid(Integer termid) {
        this.termid = termid;
    }
}