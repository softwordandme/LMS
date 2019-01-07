package com.lms.po;

public class EvaluationType {
    private Integer evaluationTypeId;

    private Integer roleId;

    private Integer status;

    public EvaluationType(Integer evaluationTypeId, Integer roleId, Integer status) {
        this.evaluationTypeId = evaluationTypeId;
        this.roleId = roleId;
        this.status = status;
    }

    public EvaluationType() {
        super();
    }

    public Integer getEvaluationTypeId() {
        return evaluationTypeId;
    }

    public void setEvaluationTypeId(Integer evaluationTypeId) {
        this.evaluationTypeId = evaluationTypeId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}