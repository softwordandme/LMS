package com.lms.po;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EvaluationTime")
public class EvaluationTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer evaluationTimeId;

    /**
     * 评教类型Id
     */
    private Integer evaluationTypeId;

    /**
     * 评教学期的Id ,与term学期表关联
     */
    private Integer termId;

    //开始评教时间
    private Date evaluationStart;

    //结束评教时间
    private Date evaluationEnd;
    /**
     * 不用管，借用此字段显示
     */
    private String roleName;
    /**
     * 不用管,借用此字段显示
     */
    private String termName;

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

    public Integer getTermId() {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    public Date getEvaluationStart() {
        return evaluationStart;
    }

    public void setEvaluationStart(Date evaluationStart) {
        this.evaluationStart = evaluationStart;
    }

    public Date getEvaluationEnd() {
        return evaluationEnd;
    }

    public void setEvaluationEnd(Date evaluationEnd) {
        this.evaluationEnd = evaluationEnd;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }
}