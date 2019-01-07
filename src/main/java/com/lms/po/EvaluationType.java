package com.lms.po;

import javax.persistence.*;

@Entity
@Table(name = "EvaluationType")
public class EvaluationType {

    /**
     * 评教类型Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer evaluationTypeId;

    /**
     * 评教对象，与role表关联
     */
    private Integer roleId;

    /**
    * 状态，0为关闭，1为开启
    */
    private Integer status;

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

    public Integer getEvaluationTypeId() {
        return evaluationTypeId;
    }

    public void setEvaluationTypeId(Integer evaluationTypeId) {
        this.evaluationTypeId = evaluationTypeId;
    }
}
