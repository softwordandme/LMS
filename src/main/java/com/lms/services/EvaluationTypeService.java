package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationTypeService {
    @Autowired
    EvaluationTypeDao evaluationTypeDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    EvaluationTimeDao evaluationTimeDao;
    /**
     * 查找EvaluationType的所有信息
     */
    public EvaluationType findEvaluationTypeAllByevaluationTypeId(Integer evaluationTypeId){
        EvaluationType evaluationType;
        evaluationType = evaluationTypeDao.selectByPrimaryKey(evaluationTypeId);
        return evaluationType;
    }
    public List<EvaluationType> findAll(){
        List<EvaluationType> evaluationTypes;
        evaluationTypes = evaluationTypeDao.findAll();
        return evaluationTypes;
    }

    /**
     * 根据roleId查找EvaluationType的所有信息
     */
    public EvaluationType findAllByRoleId(Integer roleId){
        return evaluationTypeDao.findAllByRoleId(roleId);
    }


    public int updateStatus(EvaluationType evaluationType){
        return evaluationTypeDao.insert(evaluationType);
    }
}
