package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuDao menuDao;

    public List<Menu> findAll(Sort sort){
        List<Menu> menuList = menuDao.findAll(sort);
        return menuList;
    }

    public Menu save(Menu menu){
        return menuDao.save(menu);
    }

    public Menu findMenuByMenuId(Integer id){
        return menuDao.findMenuByMenuId(id);
    }

    public void deleteMenu(Integer id){
        menuDao.deleteById(id);
    }
}
