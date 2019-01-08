package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EvaluationTimeService {
    @Autowired
    EvaluationTimeDao evaluationTimeDao;
    /*查询EvaluationTime里的所有信息*/
    public List<EvaluationTime> findEvaluationTimeAll(){
        List<EvaluationTime> evaluationTime;
        evaluationTime = evaluationTimeDao.findAll();
        return evaluationTime;
    }
    /*根据EvaluationTimeId找对应EvaluationTime的信息*/
    public EvaluationTime findEvaluationTimeByEvaluationTimeId(Integer evaluationTimeId){
        EvaluationTime evaluationTime;
        evaluationTime = evaluationTimeDao.selectByPrimaryKey(evaluationTimeId);
        return evaluationTime;
    }
    /*新增EvaluationTimeManagement*/
    public int addEvaluation(EvaluationTime evaluationTime){
        return evaluationTimeDao.insert(evaluationTime);
    }
    /*修改EvaluationTimeManagement*/
    public int updateEvaluation(EvaluationTime evaluationTime){
        return evaluationTimeDao.updateByPrimaryKey(evaluationTime);
    }
    /*删除EvaluationTimeManagement*/
    @Transactional
    public Integer deleteEvaluationTime(Integer evaluationTimeId){
        return evaluationTimeDao.deleteByPrimaryKey(evaluationTimeId);
    }
}
