package com.jc.demo.service;

import com.jc.demo.entity.Dept;

import java.util.List;

public interface DeptService {
    //查询部门列表
    List<Dept> findAll();
}
