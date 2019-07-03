package com.jc.demo.entity;

import javax.persistence.*;

//培训计划表
@Entity
public class Plan {

    @Id  //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;  //培训计划id

    @Column
    private String cname;  //课程名称

    @Column
    private String tname;  //培训教师

    @Column
    private String cbook;  //培训教材

    @Column
    private String scode;  //参加员工工号

    @Column
    private String sname;  //参加员工

    @Column
    private String depname;  //参加员工所属部门

    @Column(length = 2)
    private Integer cstate;  //课程培训状态[0|1]

    @Column
    private Integer score;  //成绩

    public Plan() {
    }

    public Plan(String cname, String tname, String cbook, String scode, String sname, String depname, Integer cstate, Integer score) {
        this.cname = cname;
        this.tname = tname;
        this.cbook = cbook;
        this.scode = scode;
        this.sname = sname;
        this.depname = depname;
        this.cstate = cstate;
        this.score = score;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCbook() {
        return cbook;
    }

    public void setCbook(String cbook) {
        this.cbook = cbook;
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

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public Integer getCstate() {
        return cstate;
    }

    public void setCstate(Integer cstate) {
        this.cstate = cstate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
