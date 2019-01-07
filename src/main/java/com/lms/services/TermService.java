package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermService {
    @Autowired
    TermDao termDao;


    public Term findtermIdBytermName(String termName){
        Term term;
        term = termDao.findAllByTermName(termName);
        return term;
    }



    /**
     * 查询所有学期
     */
    public List<Term> findAll(){
        return termDao.findAll();
    }

    /**
     * 根据termId查询学期名称*/
    public Term findAllBytermId(Integer termId){

        return termDao.findAllByTermId(termId);
    }
    public Term updateStatus(Term term){
        return termDao.save(term);
    }
}
