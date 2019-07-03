package com.jc.demo.service;

import com.jc.demo.entity.Plan;

import java.util.List;

public interface ScoreService {

    //管理员查询成绩列表
    List<Plan> findScoresList();

    //员工查看成绩列表
    List<Plan> findScoreList(String scode);

    //教师查看成绩列表
    List<Plan> findScore(String tname);

    //查询指定成绩信息回显到页面
    Plan findByPid(Integer pid);

    //保存成绩
    void saveScore(Plan plan);
}
