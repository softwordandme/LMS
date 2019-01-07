package com.lms.dao;

import com.lms.po.EvaluationTime;

public interface EvaluationTimeMapper {
    int deleteByPrimaryKey(Integer evaluationTimeId);

    int insert(EvaluationTime record);

    int insertSelective(EvaluationTime record);

    EvaluationTime selectByPrimaryKey(Integer evaluationTimeId);

    int updateByPrimaryKeySelective(EvaluationTime record);

    int updateByPrimaryKey(EvaluationTime record);
}