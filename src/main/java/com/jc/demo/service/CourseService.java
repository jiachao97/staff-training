package com.jc.demo.service;

import com.jc.demo.entity.Course;

import java.util.List;

public interface CourseService {

    //查询课程列表
    List<Course> findAll();
    //查询当前课程最大的自增编号
    Long finMaxCid();
    //添加课程
    void addCourse(Course course);
    //查询指定课程信息，进行回显
    Course getOne(Integer cid);
    //编辑课程
    Course saveCourse(Course course);
    //删除课程
    void delCourse(Integer cid);
}
