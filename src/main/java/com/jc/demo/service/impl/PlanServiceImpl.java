package com.jc.demo.service.impl;

import com.jc.demo.entity.Plan;
import com.jc.demo.repository.PlanRepository;
import com.jc.demo.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanRepository planRepository;

    //生成培训计划
    @Override
    public Plan savePlan(Plan plan) {
        return planRepository.save(plan);
    }

    //查询培训计划列表
    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    //查询个人培训计划
    @Override
    public List<Plan> findByScode(String scode) {
        return planRepository.findByScode(scode);
    }

    //查看培训课表
    @Override
    public List<Plan> findSchedule(String tname) {
        return planRepository.findScheduleByTname(tname);
    }
}
