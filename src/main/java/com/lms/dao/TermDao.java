package com.lms.dao;

import com.lms.po.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermDao extends JpaRepository<Term,Integer> {

    Term findAllByTermName(String termName);

    Term findAllByTermId(Integer termId);

    /**
     * 获取评教学期是否为当前学期
     */
    Term findTermByStatus(Integer stutas);
}
