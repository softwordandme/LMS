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
                    n=menuDao.findMenuByMenuId(Integer.parseInt(rn[j])).getMenuName();
                }else {
                    n=n+","+menuDao.findMenuByMenuId(Integer.parseInt(rn[j])).getMenuName();
                }

            }
            roleList.get(i).setPowerName(n);
            n="";
        }
        return roleList;
    }

    public Role findByRoleId(Integer roleId){
        return roleDao.findByRoleId(roleId);
    }

    public void deleteRole(Integer roleId){
        roleDao.deleteById(roleId);
        EvaluationType evaluationType = evaluationTypeDao.findAllByRoleId(roleId);
        evaluationTypeDao.delete(evaluationType);
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
            Role role1 = roleDao.save(role);
        }else {
            Role role1 = roleDao.save(role);
            EvaluationType evaluationType = new EvaluationType();
            evaluationType.setRoleId(role1.getRoleId());
            evaluationType.setStatus(0);
            evaluationTypeDao.save(evaluationType);
        }
    }
}
