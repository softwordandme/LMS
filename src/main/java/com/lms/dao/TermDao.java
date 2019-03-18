package com.lms.dao;

import com.lms.po.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermDao{

    int deleteByPrimaryKey(Integer termId);

    int insert(Term record);

    int insertSelective(Term record);

    Term selectByPrimaryKey(Integer termId);

    int updateByPrimaryKeySelective(Term record);

    int updateByPrimaryKey(Term record);



    Term findAllByTermName(String termName);

    /**
     * 获取评教学期是否为当前学期
     */
    Term findTermByStatus(Integer stutas);

    List<Term> findTerms();
}
