package com.jc.demo.service;

import com.jc.demo.entity.Plan;

import java.util.List;

public interface PlanService {

    //生成培训计划
    Plan savePlan(Plan plan);
    //查询培训计划列表
    List<Plan> findAll();
    //查询个人培训计划
    List<Plan> findByScode(String scode);
    //查看培训课表
    List<Plan> findSchedule(String tname);
}
