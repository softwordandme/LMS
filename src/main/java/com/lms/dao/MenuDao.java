package com.lms.dao;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao extends JpaRepository<Menu,Integer> {

    @Override
    List<Menu> findAll(Sort sort);

    Menu findMenuByMenuId(Integer id);

}
