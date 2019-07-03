package com.jc.demo.service.impl;

import com.jc.demo.entity.Course;
import com.jc.demo.repository.CourseRepository;
import com.jc.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    //查询课程列表
    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    //查询当前课程最大的自增编号
    @Override
    public Long finMaxCid() {
        return courseRepository.findByCidOrderByCid();
    }

    //添加课程
    @Override
    public void addCourse(Course course) {
       courseRepository.save(course);
    }

    //查询指定课程信息，进行回显
    @Override
    public Course getOne(Integer cid) {
        return courseRepository.getOne(cid);
    }

    //编辑课程
    @Override
    public Course saveCourse(Course course) {
       return courseRepository.save(course);
    }

    //删除课程
    @Override
    public void delCourse(Integer cid) {
        courseRepository.deleteById(cid);
    }
}
