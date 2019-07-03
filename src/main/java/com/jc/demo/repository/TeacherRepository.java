package com.jc.demo.repository;

import com.jc.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    //查询当前数据库中，最大的教师编号
    @Query("select max(tid) from Teacher ")
    Long findByTidOOrderByTid();
    //教师登陆，根据姓名和密码查询
    Teacher queryByTnameAndTpassword(String tname,String tpassword);
    //查询个人信息,根据tname查
    Teacher findByTname(String tname);
}
