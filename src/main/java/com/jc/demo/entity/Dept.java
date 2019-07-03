package com.jc.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//部门表
@Entity
public class Dept {

    @Id
    @Column
    private String depid;  //部门类别编号（pk|员工表fk）
    @Column
    private String depname;  //部门名称

    public Dept() {
    }

    public Dept(String depid, String depname) {
        this.depid = depid;
        this.depname = depname;
    }

    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "depid='" + depid + '\'' +
                ", depname='" + depname + '\'' +
                '}';
    }
}
