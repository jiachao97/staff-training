package com.jc.demo.repository;

import com.jc.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    //查询当前数据库中，最大的课程编号
    @Query("select max(cid) from Course ")
    Long findByCidOrderByCid();
}
