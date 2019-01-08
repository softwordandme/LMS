package com.lms.dao;

import com.lms.po.Evaluation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationDao{

    List<Evaluation> findEvaluationsByEvaluationPlayerIdAndCourseIdAndClazzNum(String evaluationPlayerId, Integer courseId, Integer clazzNum);

    Integer countEvaluationsByCourseIdAndClazzNum(Integer courseId, Integer clazzNum);

    Evaluation findEvaluationByCourseIdAndClazzNumAndEvaluationJudgesId(Integer courseId, Integer clazzNum, String evaluationJudgesId);

    Evaluation findEvaluationByEvaluationJudgesIdAndEvaluationPlayerIdAndEvaluationTremId(String evaluationJudgesId, String evaluationPlayerId, Integer evaluationTremId);


    int deleteByPrimaryKey(Integer id);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}
