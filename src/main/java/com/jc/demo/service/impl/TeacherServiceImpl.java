package com.jc.demo.service.impl;

import com.jc.demo.entity.Teacher;
import com.jc.demo.repository.TeacherRepository;
import com.jc.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    //查询教师列表
    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    //查询当前教师最大的自增编号
    @Override
    public Long findMaxTid() {
        return teacherRepository.findByTidOOrderByTid();
    }

    //添加教师
    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    //查询教师信息进行回显
    @Override
    public Teacher getOne(Integer tid) {
        return teacherRepository.getOne(tid);
    }

    //编辑教师
    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    //删除教师
    @Override
    public void delTeacher(Integer tid) {
        teacherRepository.deleteById(tid);
    }

    //教师登陆，根据姓名和密码查询
    @Override
    public Teacher checkLogin(String tname, String tpassword) {
        return teacherRepository.queryByTnameAndTpassword(tname,tpassword);
    }

    //查询个人信息,根据tname查
    @Override
    public Teacher getPersonalInfo(String tname) {
        return teacherRepository.findByTname(tname);
    }
}
