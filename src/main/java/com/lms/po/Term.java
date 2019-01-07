package com.lms.po;

public class Term {
    private Integer termId;

    private String termName;

    private Integer status;

    public Term(Integer termId, String termName, Integer status) {
        this.termId = termId;
        this.termName = termName;
        this.status = status;
    }

    public Term() {
        super();
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
        this.termName = termName == null ? null : termName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}