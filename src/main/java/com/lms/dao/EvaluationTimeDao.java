package com.lms.dao;


import com.lms.po.EvaluationTime;

import java.util.List;

public interface EvaluationTimeDao {

    List<EvaluationTime> findAll();

    int deleteByPrimaryKey(Integer evaluationTimeId);

    int insert(EvaluationTime record);

    int insertSelective(EvaluationTime record);

    EvaluationTime selectByPrimaryKey(Integer evaluationTimeId);

    int updateByPrimaryKeySelective(EvaluationTime record);

    int updateByPrimaryKey(EvaluationTime record);

}
