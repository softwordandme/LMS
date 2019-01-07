package com.lms.po;

import javax.persistence.*;

@Entity
@Table(name = "Term")
public class Term {

    /**
     * 学期Id，自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer termId;

    /**
     * 课程学期，格式为String 2017-2018学年,第一学期
     */
    private String termName;

    /**
     * 是否当前学期（默认为0不是当前学期，1为当前学期）
     */
    @Column(name = "status",columnDefinition = "int default 0")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTermId() {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }
}
