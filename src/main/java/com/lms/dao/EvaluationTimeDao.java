package com.lms.dao;


import com.lms.po.EvaluationTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationTimeDao extends JpaRepository<EvaluationTime,Integer> {
    EvaluationTime findEvaluationTimeByEvaluationTimeId(Integer evaluationTimeId);
    Integer deleteEvaluationTimeByEvaluationTimeId(Integer evaluationTimeId);

}
