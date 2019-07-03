package com.jc.demo.controller;

import com.jc.demo.entity.*;
import com.jc.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TrainController {

    @Autowired
    CourseService courseService;
    @Autowired
    StaffService staffService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    ScoreService scoreService;
    @Autowired
    PlanService planService;

    /**
     * 查询课程列表
     * @param model
     * @return
     */
    @GetMapping("/trains")
    public String getCourseList(Model model) {

        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList",courseList);
        return "staffs/train/courseList";
    }

    /**
     * 来到员工课程培训信息校验页
     * @param cid
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/train/{cid}")
    public String toCheckPage(@PathVariable("cid") Integer cid,
                              HttpSession session, Model model) {

        //查询该课程信息并回显到培训课程信息校验页
        Course course = courseService.getOne(cid);
        model.addAttribute("course",course);

        //获取当前员工scode
        Object scode = session.getAttribute("scode");
        //查询该员工个人信息并回显到培训课程信息校验页
        Staff staff = staffService.getStaffByScode((String) scode);
        model.addAttribute("staff",staff);

        return "staffs/train/check";
    }

    /**
     * 结课
     * 提交审核，改变课程状态为0(培训中)
     * @param plan
     * @return
     */
    @PutMapping("/train")
    public String train(Plan plan) {

        planService.savePlan(plan);
        //校验完成后，重定向至查询课程列表
        return "redirect:/trains";
    }

}
