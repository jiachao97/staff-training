package com.jc.demo.service;

import com.jc.demo.entity.Teacher;

import java.util.List;

public interface TeacherService {
    //查询教师列表
    List<Teacher> findAll();
    //查询当前教师最大的自增编号
    Long findMaxTid();
    //添加教师
    void addTeacher(Teacher teacher);
    //查询教师信息进行回显
    Teacher getOne(Integer tid);
    //编辑教师
    void saveTeacher(Teacher teacher);
    //删除教师
    void delTeacher(Integer tid);
    //教师登陆，根据姓名和密码查询
    Teacher checkLogin(String tname, String tpassword);
    //查询个人信息,根据tname查
    Teacher getPersonalInfo(String tname);
}
