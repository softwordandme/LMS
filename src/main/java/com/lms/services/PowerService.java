package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerService {

    @Autowired
    PowerDao powerDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    MenuDao menuDao;

    @Autowired
    EvaluationTypeDao evaluationTypeDao;

    public List<Role> findAllRole(){
        List<Role> roleList = roleDao.findAll();
        String n = new String();
        for(int i=0;i<roleList.size();i++){
            String rn[] = roleList.get(i).getRolePower().split(",");
            for(int j=0;j<rn.length;j++){
                if(j==0){
                    n=menuDao.selectByPrimaryKey(Integer.parseInt(rn[j])).getMenuName();
                }else {
                    n=n+","+menuDao.selectByPrimaryKey(Integer.parseInt(rn[j])).getMenuName();
                }

            }
            roleList.get(i).setPowerName(n);
            n="";
        }
        return roleList;
    }

    public Role findByRoleId(Integer roleId){
        return roleDao.selectByPrimaryKey(roleId);
    }

    public void deleteRole(Integer roleId){
        roleDao.deleteByPrimaryKey(roleId);
        EvaluationType evaluationType = evaluationTypeDao.findAllByRoleId(roleId);
        evaluationTypeDao.deleteByPrimaryKey(evaluationType.getEvaluationTypeId());
    }

    public List<Power> findAll(){
        return powerDao.findAll();
    }

    public List<Menu> findAllMenu(){
        return menuDao.findAll();
    }

    public void saveRole(Role role){
         //System.out.println(roleDao.save(role));
        if(role.getRoleId()!=null){
            roleDao.updateByPrimaryKey(role);
        }else {
            roleDao.insert(role);
            EvaluationType evaluationType = new EvaluationType();
            evaluationType.setRoleId(role.getRoleId());
            evaluationType.setStatus(0);
            evaluationTypeDao.insert(evaluationType);
        }
    }
}
