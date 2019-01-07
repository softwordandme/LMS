package com.lms.po;

import java.math.BigDecimal;

public class Evaluation {
    private Integer id;

    private BigDecimal score;

    private Integer evaluationTremId;

    private Integer courseId;

    private String clazzNum;

    private String evaluationJudgesId;

    private String evaluationPlayerId;

    public Evaluation(Integer id, BigDecimal score, Integer evaluationTremId, Integer courseId, String clazzNum, String evaluationJudgesId, String evaluationPlayerId) {
        this.id = id;
        this.score = score;
        this.evaluationTremId = evaluationTremId;
        this.courseId = courseId;
        this.clazzNum = clazzNum;
        this.evaluationJudgesId = evaluationJudgesId;
        this.evaluationPlayerId = evaluationPlayerId;
    }

    public Evaluation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getEvaluationTremId() {
        return evaluationTremId;
    }

    public void setEvaluationTremId(Integer evaluationTremId) {
        this.evaluationTremId = evaluationTremId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getClazzNum() {
        return clazzNum;
    }

    public void setClazzNum(String clazzNum) {
        this.clazzNum = clazzNum == null ? null : clazzNum.trim();
    }

    public String getEvaluationJudgesId() {
        return evaluationJudgesId;
    }

    public void setEvaluationJudgesId(String evaluationJudgesId) {
        this.evaluationJudgesId = evaluationJudgesId == null ? null : evaluationJudgesId.trim();
    }

    public String getEvaluationPlayerId() {
        return evaluationPlayerId;
    }

    public void setEvaluationPlayerId(String evaluationPlayerId) {
        this.evaluationPlayerId = evaluationPlayerId == null ? null : evaluationPlayerId.trim();
    }
}