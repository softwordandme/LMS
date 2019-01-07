package com.lms.dao;

import com.lms.po.Term;

public interface TermMapper {
    int deleteByPrimaryKey(Integer termId);

    int insert(Term record);

    int insertSelective(Term record);

    Term selectByPrimaryKey(Integer termId);

    int updateByPrimaryKeySelective(Term record);

    int updateByPrimaryKey(Term record);
}