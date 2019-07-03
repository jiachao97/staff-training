package com.jc.demo.service.impl;

import com.jc.demo.entity.Dept;
import com.jc.demo.repository.DeptRepository;
import com.jc.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptRepository deptRepository;

    //查询部门列表
    @Override
    public List<Dept> findAll() {
        return deptRepository.findAll();
    }
}
