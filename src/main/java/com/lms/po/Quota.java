package com.lms.po;

public class Quota {
    private Integer quotaId;

    private String quotaName;

    private Integer quotaParentId;

    private Integer quotaRank;

    private Integer quotaSure;

    private Float quotaWeight;

    private Integer quotaType;

    public Quota(Integer quotaId, String quotaName, Integer quotaParentId, Integer quotaRank, Integer quotaSure, Float quotaWeight, Integer quotaType) {
        this.quotaId = quotaId;
        this.quotaName = quotaName;
        this.quotaParentId = quotaParentId;
        this.quotaRank = quotaRank;
        this.quotaSure = quotaSure;
        this.quotaWeight = quotaWeight;
        this.quotaType = quotaType;
    }

    public Quota() {
        super();
    }

    public Integer getQuotaId() {
        return quotaId;
    }

    public void setQuotaId(Integer quotaId) {
        this.quotaId = quotaId;
    }

    public String getQuotaName() {
        return quotaName;
    }

    public void setQuotaName(String quotaName) {
        this.quotaName = quotaName == null ? null : quotaName.trim();
    }

    public Integer getQuotaParentId() {
        return quotaParentId;
    }

    public void setQuotaParentId(Integer quotaParentId) {
        this.quotaParentId = quotaParentId;
    }

    public Integer getQuotaRank() {
        return quotaRank;
    }

    public void setQuotaRank(Integer quotaRank) {
        this.quotaRank = quotaRank;
    }

    public Integer getQuotaSure() {
        return quotaSure;
    }

    public void setQuotaSure(Integer quotaSure) {
        this.quotaSure = quotaSure;
    }

    public Float getQuotaWeight() {
        return quotaWeight;
    }

    public void setQuotaWeight(Float quotaWeight) {
        this.quotaWeight = quotaWeight;
    }

    public Integer getQuotaType() {
        return quotaType;
    }

    public void setQuotaType(Integer quotaType) {
        this.quotaType = quotaType;
    }
}