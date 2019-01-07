package com.lms.dao;


import com.lms.po.Power;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerDao extends JpaRepository<Power,Integer> {

       Power findPowerByPowerIt(Integer power);
}
