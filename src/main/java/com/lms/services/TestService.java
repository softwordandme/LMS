package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明
 *
 * @author zz
 * @date ${date} ${time}
 **/
@Service
public class TestService {
    @Autowired
    private  TestDao testDao;


    public List<Clazz> findTest(){
        return testDao.findTest();
    }
    public List<Clazz> findT(){
        return testDao.findTest();
    }
}
