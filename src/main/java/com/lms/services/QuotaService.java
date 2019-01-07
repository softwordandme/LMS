package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuotaService {

    @Autowired
    QuotaDao quotaDao;
    /**
     * 增加记录
     * */
    public Quota addQuota(Quota quota){
        return quotaDao.save(quota);
    }
    /**
     * 查询所有指标记录
     * */
    public List<Quota> findAllQuotas(){
        return quotaDao.findAll();
    }
    /**
     * 指标修改
     * */
    public Quota editQuota(Quota quota){
        return quotaDao.save(quota);
    }
    /**
     * 指标删除
     * */
    @Transactional
    public Integer delQuota(Integer quotaId){
        List<Integer> quotaParentIdList=new ArrayList<>();
        quotaParentIdList.add(quotaId);
        List<Quota> quotaList=quotaDao.findQuotasByQuotaParentId(quotaId);
        Integer i=quotaDao.deleteQuotaByQuotaId(quotaId);
        for(Integer dq:rb(quotaParentIdList,quotaList)){
            i+=quotaDao.deleteQuotaByQuotaParentId(dq);
        }
        return i;
    }
    /**
     * 找到需要删除的指标的父指标的Id
     * */
    private List<Integer> rb(List<Integer> quotaParentIdList,List<Quota> quotaList){
        if (!quotaList.isEmpty()){
            for(Quota quota:quotaList){
                List<Quota> quotaList1 =quotaDao.findQuotasByQuotaParentId(quota.getQuotaId());
                if(!quotaList1.isEmpty()){
                    quotaParentIdList.add(quota.getQuotaId());
                    rb(quotaParentIdList,quotaList1);
                }

            }
        }
        return quotaParentIdList;
    }
    public List<Quota> findQuotasByQuotaType(Integer quotaType){
        return quotaDao.findQuotasByQuotaType(quotaType);
    }
    /**
     * 根据quotaId找记录
     * */
    public Quota findQuotaByQuotaId(Integer quotaId){
        return quotaDao.findQuotaByQuotaId(quotaId);
    }
}
