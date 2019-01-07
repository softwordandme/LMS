package com.lms.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationTypeDao extends JpaRepository<EvaluationType,Integer> {
    /**
     * 通过评教类型ID查找EvaluationType表里的所有字段
     */
   EvaluationType findEvaluationTypeAllByEvaluationTypeId(Integer evaluationTypeId);

   EvaluationType findAllByRoleId(Integer roleId);

}
