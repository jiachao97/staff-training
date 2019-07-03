package com.jc.demo.controller;

import com.jc.demo.entity.Plan;
import com.jc.demo.service.PlanService;
import com.jc.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    PlanService planService;

    /**
     * 管理员查询成绩列表（只有培训状态cstate=1(即已结课)的课程才有成绩）
     * @param model
     * @return
     */
    @GetMapping("/scores")
    public String getScoresList(Model model) {

        List<Plan> scoreList = scoreService.findScoresList();
        model.addAttribute("scoreList",scoreList);
        return "admin/score/list";
    }

    /**
     * 员工查看成绩列表（只有属于当前员工且培训状态cstate=1(即已结课)的课程才有成绩）
     * @param model
     * @return
     */
    @GetMapping("/staff/score")
    public String getScoreList(HttpSession session,Model model) {

        Object scode = session.getAttribute("scode");
        List<Plan> scoreList = scoreService.findScoreList(String.valueOf(scode));
        model.addAttribute("scoreList",scoreList);
        return "staffs/score/list";
    }

    /**
     * 教师查询成绩列表（只有由当前教师培训的培训状态cstate=1(即已结课)的课程才有成绩）
     * @param model
     * @return
     */
    @GetMapping("/score")
    public String getScore(HttpSession session,Model model) {

        Object tname = session.getAttribute("tname");
        List<Plan> scoreList = scoreService.findScore(String.valueOf(tname));
        model.addAttribute("scoreList",scoreList);
        return "teacher/score/list";
    }

    /**
     * 来到录入成绩页
     * @param pid
     * @param model
     * @return
     */
    @GetMapping("/score/{pid}")
    public String toEditScorePage(@PathVariable("pid") Integer pid,Model model) {

        Plan plan = scoreService.findByPid(pid);
        model.addAttribute("plan",plan);
        return "teacher/score/edit";
    }

    /**
     * 保存成绩
     * @param plan
     * @return
     */
    @PutMapping("/score")
    public String saveScore(Plan plan) {

        scoreService.saveScore(plan);
        //编辑完成后，重定向至查询成绩列表
        return "redirect:/score";
    }

}
