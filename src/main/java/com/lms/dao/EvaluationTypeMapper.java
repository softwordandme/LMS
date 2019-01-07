package com.lms.dao;

import com.lms.po.EvaluationType;

public interface EvaluationTypeMapper {
    int deleteByPrimaryKey(Integer evaluationTypeId);

    int insert(EvaluationType record);

    int insertSelective(EvaluationType record);

    EvaluationType selectByPrimaryKey(Integer evaluationTypeId);

    int updateByPrimaryKeySelective(EvaluationType record);

    int updateByPrimaryKey(EvaluationType record);
}