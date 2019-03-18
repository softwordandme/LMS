package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuDao menuDao;

    public List<Menu> findAll(){
        return menuDao.findAll();
    }

    public int save(Menu menu){
        return menuDao.insert(menu);
    }

    public Menu findMenuByMenuId(Integer id){
        return menuDao.selectByPrimaryKey(id);
    }

    public void deleteMenu(Integer id){
        menuDao.deleteByPrimaryKey(id);
    }
}
