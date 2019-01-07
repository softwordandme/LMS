package com.lms.po;

import java.util.Date;

public class EvaluationTime {
    private Integer evaluationTimeId;

    private Integer evaluationTypeId;

    private Date evaluationtimeBg;

    private Date evaluationtimeEn;

    private Integer termId;

    private Date evaluationEnd;

    private Date evaluationStart;

    private String roleName;

    private String termName;

    public EvaluationTime(Integer evaluationTimeId, Integer evaluationTypeId, Date evaluationtimeBg, Date evaluationtimeEn, Integer termId, Date evaluationEnd, Date evaluationStart, String roleName, String termName) {
        this.evaluationTimeId = evaluationTimeId;
        this.evaluationTypeId = evaluationTypeId;
        this.evaluationtimeBg = evaluationtimeBg;
        this.evaluationtimeEn = evaluationtimeEn;
        this.termId = termId;
        this.evaluationEnd = evaluationEnd;
        this.evaluationStart = evaluationStart;
        this.roleName = roleName;
        this.termName = termName;
    }

    public EvaluationTime() {
        super();
    }

    public Integer getEvaluationTimeId() {
        return evaluationTimeId;
    }

    public void setEvaluationTimeId(Integer evaluationTimeId) {
        this.evaluationTimeId = evaluationTimeId;
    }

    public Integer getEvaluationTypeId() {
        return evaluationTypeId;
    }

    public void setEvaluationTypeId(Integer evaluationTypeId) {
        this.evaluationTypeId = evaluationTypeId;
    }

    public Date getEvaluationtimeBg() {
        return evaluationtimeBg;
    }

    public void setEvaluationtimeBg(Date evaluationtimeBg) {
        this.evaluationtimeBg = evaluationtimeBg;
    }

    public Date getEvaluationtimeEn() {
        return evaluationtimeEn;
    }

    public void setEvaluationtimeEn(Date evaluationtimeEn) {
        this.evaluationtimeEn = evaluationtimeEn;
    }

    public Integer getTermId() {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    public Date getEvaluationEnd() {
        return evaluationEnd;
    }

    public void setEvaluationEnd(Date evaluationEnd) {
        this.evaluationEnd = evaluationEnd;
    }

    public Date getEvaluationStart() {
        return evaluationStart;
    }

    public void setEvaluationStart(Date evaluationStart) {
        this.evaluationStart = evaluationStart;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName == null ? null : termName.trim();
    }
}