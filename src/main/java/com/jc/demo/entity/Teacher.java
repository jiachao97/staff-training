package com.jc.demo.entity;

import javax.persistence.*;
import java.util.List;

//教师表
@Entity
public class Teacher {

    @Id  //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增
    private Integer tid;  //教师自增编号(pk)

    @Column
    private String tname;  //姓名
    @Column
    private String tpassword;  //密码
    @Column(length = 2)
    private Integer tsex;  //性别(0:男|1:女)
    @Column
    private Integer tage;  //年龄
    @Column
    private String tel;  //电话

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //一端，mappedBy注解的实体类为关系被维护端，值是多端里维护关系的属性（teacher是关系维护端[Course表]中的teacher属性）
    //级联操作权限为ALL，即主表的增删改查都会级联到从表（删除一位教师，则该教师培训的所有课程也会被删除）
    //懒加载：调用getCourseList()方法时，才会读取相关联的级联表数据
    private List<Course> courseList;  //授课教师培训的课程列表

    public Teacher() {
    }

    public Teacher(String tname, String tpassword, Integer tsex, Integer tage, String tel, List<Course> courseList) {
        this.tname = tname;
        this.tpassword = tpassword;
        this.tsex = tsex;
        this.tage = tage;
        this.tel = tel;
        this.courseList = courseList;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    public Integer getTsex() {
        return tsex;
    }

    public void setTsex(Integer tsex) {
        this.tsex = tsex;
    }

    public Integer getTage() {
        return tage;
    }

    public void setTage(Integer tage) {
        this.tage = tage;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
