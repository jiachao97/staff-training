package com.jc.demo.controller;

import com.jc.demo.entity.Course;
import com.jc.demo.entity.Teacher;
import com.jc.demo.repository.CourseRepository;
import com.jc.demo.service.CourseService;
import com.jc.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseRepository courseRepository;

    /**
     * 查询课程列表
     * @param start
     * @param limit
     * @param model
     * @return
     */
    @GetMapping("/courses")
    public String getCourseList(@RequestParam(value = "start",defaultValue = "0") Integer start,
                                @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                Model model) {
        start = start<0 ? 0:start;
        Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "cid");
        Pageable pageable = PageRequest.of(start,limit,sort);
        Page<Course> page = courseRepository.findAll(pageable);

        model.addAttribute("page",page);
        return "admin/course/list";
    }

    /**
     * 来到课程添加页
     * @param model
     * @return
     */
    @GetMapping("/course")
    public String toAddCoursePage(Model model) {

        //查询出教师列表，在课程添加页显示
        List<Teacher> teacherList = teacherService.findAll();
        model.addAttribute("teacherList",teacherList);
        //查询当前课程最大的自增编号
        Long maxCid = courseService.finMaxCid();
        model.addAttribute("maxCid",maxCid);
        return "admin/course/add";
    }

    /**
     * 添加课程
     * @param course
     * @return
     */
    @PostMapping("/course")
    public String addCourse(Course course) {
        //持久化到数据库
        courseService.addCourse(course);
        //添加完成后，重定向至查询课程列表
        return "redirect:/courses";
    }

    /**
     * 来到课程编辑页
     * @param cid
     * @param model
     * @return
     */
    @GetMapping("/course/{cid}")
    public String toEditCoursePage(@PathVariable("cid") Integer cid,
                                   Model model) {

        //查询该课程信息并回显到课程编辑页
        Course course = courseService.getOne(cid);
        model.addAttribute("course",course);
        //查询出教师列表，在课程编辑页进行回显
        List<Teacher> teacherList = teacherService.findAll();
        model.addAttribute("teacherList",teacherList);
        return "admin/course/edit";
    }

    /**
     * 编辑课程
     * @param course
     * @return
     */
    @PutMapping("/course")
    public String saveCourse(Course course) {
        courseService.saveCourse(course);
        //编辑完成后，重定向至查询课程列表
        return "redirect:/courses";
    }

    /**
     * 删除课程
     * @param cid
     * @return
     */
    @DeleteMapping("/course/{cid}")
    public String delCourse(@PathVariable("cid") Integer cid) {
        courseService.delCourse(cid);
        //成功删除后，重定向至查询课程列表
        return "redirect:/courses";
    }

}
