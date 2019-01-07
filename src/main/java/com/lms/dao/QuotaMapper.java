package com.lms.dao;

import com.lms.po.Quota;

public interface QuotaMapper {
    int deleteByPrimaryKey(Integer quotaId);

    int insert(Quota record);

    int insertSelective(Quota record);

    Quota selectByPrimaryKey(Integer quotaId);

    int updateByPrimaryKeySelective(Quota record);

    int updateByPrimaryKey(Quota record);
}