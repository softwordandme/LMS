package com.lms.po;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Quota")     //指标表
public class Quota {

    /**
     * 指标ID，自动增量
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer quotaId;

    /**
     * 指标父ID
     */
    private Integer quotaParentId;

    /**
     * 指标名
     */
    private String quotaName;

    /**
     * 指标权重 小数表示 0.12
     */
    private BigDecimal quotaWeight;

    /**
    * 指标类别      学生，教师，系主任
    */
    private Integer quotaType;

    /**
     *表示子节点个数
     */
    private Integer quotaSure;


    public Quota() {
    }

    public Integer getQuotaId() {
        return quotaId;
    }

    public void setQuotaId(Integer quotaId) {
        this.quotaId = quotaId;
    }

    public Integer getQuotaParentId() {
        return quotaParentId;
    }

    public void setQuotaParentId(Integer quotaParentId) {
        this.quotaParentId = quotaParentId;
    }

    public String getQuotaName() {
        return quotaName;
    }

    public void setQuotaName(String quotaName) {
        this.quotaName = quotaName;
    }

    public BigDecimal getQuotaWeight() {
        return quotaWeight;
    }

    public void setQuotaWeight(BigDecimal quotaWeight) {
        this.quotaWeight = quotaWeight;
    }


    public Integer getQuotaType() {
        return quotaType;
    }

    public void setQuotaType(Integer quotaType) {
        this.quotaType = quotaType;
    }

    public Integer getQuotaSure() {
        return quotaSure;
    }

    public void setQuotaSure(Integer quotaSure) {
        this.quotaSure = quotaSure;
    }
}
