package com.jc.demo.entity;

import javax.persistence.*;
import java.util.List;

//员工表
@Entity
public class Staff {

    @Id  //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增
    private Integer sid;  //员工自增编号(pk)

    @Column
    private String scode;  //员工工号（sid+depid）
    @Column
    private String sname;  //员工姓名
    @Column
    private String spassword;  //员工密码
    @Column(length = 2)
    private Integer sex;  //员工性别（0：男|1：女）
    @Column
    private Integer sage;  //员工年龄
    @Column
    private String stel;  //员工电话

    @JoinColumn(name = "depid")  //外键
    @ManyToOne  //多对一映射（一个部门包含多个员工）
    private Dept dept;  //员工所属部门

    public Staff() {
    }

    public Staff(String scode, String sname, String spassword, Integer sex, Integer sage, String stel, Dept dept) {
        this.scode = scode;
        this.sname = sname;
        this.spassword = spassword;
        this.sex = sex;
        this.sage = sage;
        this.stel = stel;
        this.dept = dept;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "sid=" + sid +
                ", scode='" + scode + '\'' +
                ", sname='" + sname + '\'' +
                ", spassword='" + spassword + '\'' +
                ", sex=" + sex +
                ", sage=" + sage +
                ", stel='" + stel + '\'' +
                ", dept=" + dept +
                '}';
    }
}
