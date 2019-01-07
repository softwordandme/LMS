package com.lms.po;

import java.math.BigDecimal;

public class Quota {
    private Integer quotaId;

    private String quotaName;

    private Integer quotaParentId;

    private Integer quotaRank;

    private Integer quotaSure;

    private Float quotaWeight;

    private Integer quotaType;

    private Integer quotaid;

    private String quotaname;

    private Integer quotaparentid;

    private Integer quotasure;

    private Integer quotatype;

    private BigDecimal quotaweight;

    public Quota(Integer quotaId, String quotaName, Integer quotaParentId, Integer quotaRank, Integer quotaSure, Float quotaWeight, Integer quotaType, Integer quotaid, String quotaname, Integer quotaparentid, Integer quotasure, Integer quotatype, BigDecimal quotaweight) {
        this.quotaId = quotaId;
        this.quotaName = quotaName;
        this.quotaParentId = quotaParentId;
        this.quotaRank = quotaRank;
        this.quotaSure = quotaSure;
        this.quotaWeight = quotaWeight;
        this.quotaType = quotaType;
        this.quotaid = quotaid;
        this.quotaname = quotaname;
        this.quotaparentid = quotaparentid;
        this.quotasure = quotasure;
        this.quotatype = quotatype;
        this.quotaweight = quotaweight;
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

    public Integer getQuotaid() {
        return quotaid;
    }

    public void setQuotaid(Integer quotaid) {
        this.quotaid = quotaid;
    }

    public String getQuotaname() {
        return quotaname;
    }

    public void setQuotaname(String quotaname) {
        this.quotaname = quotaname == null ? null : quotaname.trim();
    }

    public Integer getQuotaparentid() {
        return quotaparentid;
    }

    public void setQuotaparentid(Integer quotaparentid) {
        this.quotaparentid = quotaparentid;
    }

    public Integer getQuotasure() {
        return quotasure;
    }

    public void setQuotasure(Integer quotasure) {
        this.quotasure = quotasure;
    }

    public Integer getQuotatype() {
        return quotatype;
    }

    public void setQuotatype(Integer quotatype) {
        this.quotatype = quotatype;
    }

    public BigDecimal getQuotaweight() {
        return quotaweight;
    }

    public void setQuotaweight(BigDecimal quotaweight) {
        this.quotaweight = quotaweight;
    }
}