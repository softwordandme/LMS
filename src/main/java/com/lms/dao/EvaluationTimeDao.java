package com.lms.dao;


import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationTimeDao extends JpaRepository<EvaluationTime,Integer> {
    EvaluationTime findEvaluationTimeByEvaluationTimeId(Integer evaluationTimeId);
    Integer deleteEvaluationTimeByEvaluationTimeId(Integer evaluationTimeId);

}
