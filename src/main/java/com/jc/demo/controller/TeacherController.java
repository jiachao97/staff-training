package com.jc.demo.controller;

import com.jc.demo.entity.Teacher;
import com.jc.demo.repository.TeacherRepository;
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

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    TeacherRepository teacherRepository;

    /**
     * 查询个人信息
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/teacher/personal")
    public String getPersonalInfo(HttpSession session,Model model) {

        //根据登录时提交的tname查询个人信息
        Object tname = session.getAttribute("tname");
        Teacher teacherpersonalInfo = teacherService.getPersonalInfo(String.valueOf(tname));
        //页面回显
        model.addAttribute("teacherpersonalInfo",teacherpersonalInfo);
        return "teacher/tea/list";
    }

    /**
     * 来到个人信息编辑页
     * @param tid
     * @param model
     * @return
     */
    @GetMapping("/teacher/info/{tid}")
    public String toEditPersonalInfoPage(@PathVariable("tid") Integer tid,Model model) {

        //根据tid查询个人信息并回显到个人信息编辑页
        Teacher teacher = teacherService.getOne(tid);
        model.addAttribute("teacher",teacher);
        return "teacher/tea/edit";
    }

    /**
     * 编辑个人信息
     * @param teacher
     * @return
     */
    @PutMapping("/teacher/info")
    public String savePersonalInfo(Teacher teacher) {

        teacherService.saveTeacher(teacher);
        //编辑完成后，重定向至查询个人信息
        return "redirect:/teacher/personal";
    }

    /**
     * 查询教师列表
     * @param start
     * @param limit
     * @param model
     * @return
     */
    @GetMapping("/teachers")
    public String getTeacherList(@RequestParam(value = "start",defaultValue = "0") Integer start,
                                 @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                 Model model) {
        start = start<0 ? 0:start;
        Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "tid");
        Pageable pageable = PageRequest.of(start,limit,sort);
        Page<Teacher> page = teacherRepository.findAll(pageable);

        model.addAttribute("page",page);
        return "admin/teacher/list";
    }

    /**
     * 来到教师添加页
     * @return
     */
    @GetMapping("teacher")
    public String toAddTeacherPage(Model model) {

        //查询当前教师最大的自增编号
        Long maxTid = teacherService.findMaxTid();
        model.addAttribute("maxTid",maxTid);
        return "admin/teacher/add";
    }

    /**
     * 添加教师
     * @param teacher
     * @return
     */
    @PostMapping("/teacher")
    public String addTeacher(Teacher teacher) {
        //持久化到数据库
        teacherService.addTeacher(teacher);
        //添加完成后，重定向至查询教师列表
        return "redirect:/teachers";
    }

    /**
     * 来到教师编辑页
     * @param tid
     * @param model
     * @return
     */
    @GetMapping("/teacher/{tid}")
    public String toEditTeacherPage(@PathVariable("tid") Integer tid,
                                    Model model) {

        //查询该教师信息并回显到教师编辑页
        Teacher teacher = teacherService.getOne(tid);
        model.addAttribute("teacher",teacher);
        return "admin/teacher/edit";
    }

    /**
     * 编辑教师
     * @param teacher
     * @return
     */
    @PutMapping("/teacher")
    public String saveTeacher(Teacher teacher) {
        teacherService.saveTeacher(teacher);
        //编辑完成后，重定向至查询教师列表
        return "redirect:/teachers";
    }

    /**
     * 删除教师
     * @param tid
     * @return
     */
    @DeleteMapping("/teacher/{tid}")
    public String delTeacher(@PathVariable("tid") Integer tid) {

        teacherService.delTeacher(tid);
        //成功删除后，重定向至查询员工列表
        return "redirect:/teachers";
    }

}
