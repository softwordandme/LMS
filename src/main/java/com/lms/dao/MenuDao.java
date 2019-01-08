package com.lms.dao;


import com.lms.po.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface MenuDao{

    List<Menu> findAll();

    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

}
