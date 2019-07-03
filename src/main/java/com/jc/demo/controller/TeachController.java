package com.jc.demo.controller;

import com.jc.demo.entity.Teacher;
import com.jc.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class TeachController {

    @Autowired
    TeacherService teacherService;

    /**
     * 教师登录验证
     * @param tname
     * @param tpassword
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/teacher/login")
    public String teachLogin(@RequestParam("tname") String tname,
                             @RequestParam("tpassword") String tpassword,
                             HttpSession session, Model model) {
        Teacher teacher = teacherService.checkLogin(tname, tpassword);
        if (teacher == null) {
            model.addAttribute("msg","请输入正确的姓名和密码");
            return "teacher/login";
        } else {
            //姓名和密码正确，验证通过，保存tname到session中
            session.setAttribute("tname",tname);
            //重定向到首页，防止表单重复提交
            return "redirect:/thome.html";
        }
    }

    /**
     * 教师注销
     * @param session
     * @return
     */
    @GetMapping("/teacher/logout")
    public String teachLogout(HttpSession session) {

        //清空session，重定向至管理员登陆页
        session.invalidate();
        return "redirect:/teach";
    }


}
