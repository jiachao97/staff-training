package com.jc.demo.entity;

import javax.persistence.*;

//管理员表
@Entity
public class Admin {

    @Id  //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增
    private Integer aid;  //管理员自增编号

    @Column
    private String aname;  //姓名

    @Column
    private String apassword;  //密码

    @Column(length = 2)
    private Integer asex;  //性别

    public Admin() {
    }

    public Admin(String aname, String apassword, Integer asex) {
        this.aname = aname;
        this.apassword = apassword;
        this.asex = asex;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public Integer getAsex() {
        return asex;
    }

    public void setAsex(Integer asex) {
        this.asex = asex;
    }
}
