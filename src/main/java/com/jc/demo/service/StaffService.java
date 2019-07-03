package com.jc.demo.service;

import com.jc.demo.entity.Staff;

import java.util.List;

public interface StaffService {

    //员工登陆，根据工号和密码查询
    Staff checkLogin(String scode,String spassword);
    //查询员工列表
    List<Staff> findAll();
    //查询当前员工最大的自增编号（socde=部门类别编号depid+员工自增编号sid）
    Long findMaxSid();
    //查询个人信息
    Staff getPersonalInfo(String scode);
    //添加员工
    void addStaff(Staff staff);
    //根据指定sid查询员工信息进行回显
    Staff getOne(Integer sid);
    //编辑员工信息
    void saveStaff(Staff staff);
    //删除员工
    void delStaff(Integer sid);
    //根据工号查询员工
    Staff getStaffByScode(String scode);
}
