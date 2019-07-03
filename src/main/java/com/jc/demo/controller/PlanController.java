package com.jc.demo.controller;

import com.jc.demo.entity.Plan;
import com.jc.demo.repository.PlanRepository;
import com.jc.demo.service.PlanService;
import com.jc.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PlanController {

    @Autowired
    PlanService planService;
    @Autowired
    PlanRepository planRepository;
    @Autowired
    TeacherService teacherService;

    /**
     * 查询个人培训计划列表
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/plan")
    public String getPersonalPlan(HttpSession session,Model model) {

        //根据session里的工号查询个人培训计划列表
        Object scode = session.getAttribute("scode");
        List<Plan> planPersonalList = planService.findByScode(String.valueOf(scode));
        //页面回显
        model.addAttribute("planPersonalList",planPersonalList);
        return "staffs/plan/planList";
    }

    /**
     * 查看培训计划列表
     * @param start
     * @param limit
     * @param model
     * @return
     */
    @GetMapping("/plans")
    public String getPlanList(@RequestParam(value = "start",defaultValue = "0") Integer start,
                              @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                              Model model) {

        start = start<0 ? 0:start;
        Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "pid");
        Pageable pageable = PageRequest.of(start,limit,sort);
        Page<Plan> page = planRepository.findAll(pageable);

        model.addAttribute("page",page);
        return "admin/plan/planList";
    }

    /**
     * 结课
     * @param pid
     * @return
     */
    @PutMapping("/plan/{pid}")
    public String overPlan(@PathVariable("pid") Integer pid) {

        planRepository.updateOne(pid);
        //校验完成后，重定向至查询培训计划列表
        return "redirect:/plans";
    }

    /**
     * 教师查看培训课表
     * @param model
     * @return
     */
    @GetMapping("/schedule")
    public String getSchedule(HttpSession session,Model model) {

        //培训课表为培训计划中，cstate=0(培训中)且培训教师为当前登录的教师的课程
        //获取当前登录教师的tname
        Object tname = session.getAttribute("tname");
        //获取属于该教师且cstate=0的课程
        List<Plan> scheduleList = planService.findSchedule(String.valueOf(tname));
        model.addAttribute("scheduleList",scheduleList);
        return "teacher/plan/planList";
    }

}
