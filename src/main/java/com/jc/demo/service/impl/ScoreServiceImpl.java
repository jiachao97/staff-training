package com.jc.demo.service.impl;

import com.jc.demo.entity.Plan;
import com.jc.demo.repository.PlanRepository;
import com.jc.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    PlanRepository planRepository;

    //管理员查询成绩列表
    @Override
    public List<Plan> findScoresList() {
        return planRepository.findScoresList();
    }

    //员工查看成绩列表
    @Override
    public List<Plan> findScoreList(String scode) {
        return planRepository.findScoreList(scode);
    }

    //教师查看成绩列表
    @Override
    public List<Plan> findScore(String tname) {
        return planRepository.findScore(tname);
    }

    //查询指定成绩信息回显到页面
    @Override
    public Plan findByPid(Integer pid) {
        return planRepository.findByPid(pid);
    }

    //保存成绩
    @Override
    public void saveScore(Plan plan) {
        planRepository.save(plan);
    }
}
