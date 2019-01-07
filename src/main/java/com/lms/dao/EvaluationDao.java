package com.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationDao extends JpaRepository<Evaluation,Integer> {

    List<Evaluation> findEvaluationsByEvaluationPlayerIdAndCourseIdAndClazzNum(String evaluationPlayerId, Integer courseId, Integer clazzNum);

    Integer countEvaluationsByCourseIdAndClazzNum(Integer courseId, Integer clazzNum);

    Evaluation findEvaluationByCourseIdAndClazzNumAndEvaluationJudgesId(Integer courseId, Integer clazzNum, String EvaluationJudgesId);

    Evaluation findEvaluationByEvaluationJudgesIdAndEvaluationPlayerIdAndEvaluationTremId(String evaluationJudgesId, String evaluationPlayerId, Integer termId);
}
