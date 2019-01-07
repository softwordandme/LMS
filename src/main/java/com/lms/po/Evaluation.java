package com.lms.po;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Evaluation")     //评教表，用来存评教的结果
public class Evaluation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //自动增量
    private Integer id;                         //ID

    private String evaluationJudgesId;         //评教人ID

    private String evaluationPlayerId;         //被评人ID

    /**
     * 课程Id
     */
    private Integer courseId;

    /**
     * 班级Num
     */
    private Integer clazzNum;

    private BigDecimal score;                    //分数

    private Integer evaluationTremId;              //评测学期 2017-2018学年第二学期

    public Integer getClazzNum() {
        return clazzNum;
    }

    public void setClazzNum(Integer clazzNum) {
        this.clazzNum = clazzNum;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }


    public Integer getEvaluationTremId() {
        return evaluationTremId;
    }

    public void setEvaluationTremId(Integer evaluationTremId) {
        this.evaluationTremId = evaluationTremId;
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

    public Evaluation() {
    }

    public String getEvaluationJudgesId() {
        return evaluationJudgesId;
    }

    public void setEvaluationJudgesId(String evaluationJudgesId) {
        this.evaluationJudgesId = evaluationJudgesId;
    }

    public String getEvaluationPlayerId() {
        return evaluationPlayerId;
    }

    public void setEvaluationPlayerId(String evaluationPlayerId) {
        this.evaluationPlayerId = evaluationPlayerId;
    }
}
