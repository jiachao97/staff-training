package com.jc.demo.entity;

import javax.persistence.*;

//课程表
@Entity
public class Course {

    @Id  //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增
    private Integer cid;  //课程自增编号（pk）

    @Column
    private String cname;  //课程名称

    @ManyToOne(optional = false)  //多对一映射（一位老师培训多门课程）
    //optional表示对象可有可无，false表示teacher不能为空，即删除课程，不会删除培训这门课程的老师
    @JoinColumn(name = "tid")  //外键
    private Teacher teacher;  //课程由哪一位教师培训

    @Column
    private String cbook;  //培训教材

    public Course() {
    }

    public Course(String cname, Teacher teacher, String cbook) {
        this.cname = cname;
        this.teacher = teacher;
        this.cbook = cbook;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCbook() {
        return cbook;
    }

    public void setCbook(String cbook) {
        this.cbook = cbook;
    }

}
