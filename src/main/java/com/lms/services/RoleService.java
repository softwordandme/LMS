package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    MenuDao menuDao;

    /*查找Role表*/
    public List<Role> findAllRole(){
        return roleDao.findAll();
    }

    /*查找所有教师*/
    public List<Teacher> findAllTeacher(){
        return teacherDao.findAll();
    }

    /*保存修改的教师权限*/
    public String saveTeacherRole(String teacherNo,String roleId){
        Teacher teacher = teacherDao.findAllByTeacherNo(teacherNo);
        teacher.setRoleId(roleId);
        teacherDao.save(teacher);
        return "ture";
    }

    /*角色name显示*/
    public StringBuilder loginRoleFind(String roleId){
        Role role;
        StringBuilder roleNameList = new StringBuilder();
        String[] roleIdList = roleId.split(",");
        for (String a:roleIdList){
            Integer intRoleId = Integer.parseInt(a);
            role = roleDao.selectByPrimaryKey(intRoleId);
            roleNameList.append(role.getRoleName() + " ");
        }
        return roleNameList;
    }

    /**
     * 根据角色名获取数据
     */
    public Role findRoleByRoleName(String roleName){
        return roleDao.findRoleByRoleName(roleName);
    }

    public Role findByRoleId(String roleId){
       return roleDao.selectByPrimaryKey(Integer.parseInt(roleId));
    }
    public List<Menu> findByRoleIdString(String roleId){
        String[] roleIdList = roleId.split(",");
        String n = new String();
        for (String a:roleIdList){
            Integer intRoleId = Integer.parseInt(a);
            n =n+","+roleDao.selectByPrimaryKey(intRoleId).getRolePower();
        }
        String[] test1 = n.split(",");
        List<String> list = new ArrayList();
        for (int i = 0; i < test1.length; i++) {
            if (!list.contains(test1[i])){
                list.add(test1[i]);
            }
        }
        List<Menu> menuList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            String mId = list.get(i);
            if(!"".equals(mId)){
                menuList.add(menuDao.selectByPrimaryKey(Integer.parseInt(mId)));
            }
        }
        return menuList;
    }

    public Teacher findByTeacherNo(String teacherNo){
        return teacherDao.findAllByTeacherNo(teacherNo);
    }
}
