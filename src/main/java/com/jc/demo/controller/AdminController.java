package com.jc.demo.controller;

import com.jc.demo.entity.Admin;
import com.jc.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    /**
     * 管理员登录验证
     * @param aname
     * @param apassword
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/admin/login")
    public String adminLogin(@RequestParam("aname") String aname,
                             @RequestParam("apassword") String apassword,
                             HttpSession session,Model model) {
        Admin admin = adminService.checkLogin(aname, apassword);
        if (admin == null) {
            model.addAttribute("msg","请输入正确的姓名和密码");
            return "admin/login";
        } else {
            //姓名和密码正确，验证通过，保存aname到session中
            session.setAttribute("aname",aname);
            //重定向到首页，防止表单重复提交
            return "redirect:/admin/home.html";
        }
    }

    /**
     * 管理员注销
     * @param session
     * @return
     */
    @GetMapping("/admin/logout")
    public String adminLogout(HttpSession session) {

        //清空session，重定向至管理员登陆页
        session.invalidate();
        return "redirect:/admin";
    }


}
