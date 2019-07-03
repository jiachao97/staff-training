package com.jc.demo.controller;

import com.jc.demo.entity.Dept;
import com.jc.demo.entity.Staff;
import com.jc.demo.repository.StaffRepository;
import com.jc.demo.service.DeptService;
import com.jc.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StaffController {

    @Autowired
    StaffService staffService;
    @Autowired
    DeptService deptService;
    @Autowired
    StaffRepository staffRepository;

    /**
     * 员工登陆验证
     * @param scode
     * @param spassword
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/staff/login")
    public String login(@RequestParam("scode") String scode,
                        @RequestParam("spassword") String spassword,
                        HttpSession session, Model model) {
        Staff staff = this.staffService.checkLogin(scode, spassword);
        if (StringUtils.isEmpty(scode) || StringUtils.isEmpty(spassword)) {
            model.addAttribute("msg","请输入工号和密码");
            return "login";
        } else if (staff == null) {
            model.addAttribute("msg","请输入正确的工号和密码");
            return "login";
        } else {
            //工号和密码正确，验证通过，保存scode到session中
            session.setAttribute("scode",scode);
            //重定向到首页，防止表单重复提交
            return "redirect:/home.html";
        }
    }

    /**
     * 员工注销
     * @param session
     * @return
     */
    @GetMapping("/staff/logout")
    public String logout(HttpSession session) {

        //清空session，重定向至员工登陆页
        session.invalidate();
        return "redirect:/index.html";
    }

    /**
     * 查询个人信息
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/staff/personal")
    public String getPersonalInfo(HttpSession session,Model model) {

        //根据登录时提交的scode查询个人信息
        Object scode = session.getAttribute("scode");
        Staff staffPersonalInfo = staffService.getPersonalInfo(String.valueOf(scode));
        //页面回显
        model.addAttribute("staffPersonalInfo",staffPersonalInfo);
        return "staffs/staff/list";
    }

    /**
     * 来到个人信息编辑页
     * @param sid
     * @param model
     * @return
     */
    @GetMapping("/staff/info/{sid}")
    public String toEditPersonalInfoPage(@PathVariable("sid") Integer sid,
                                  Model model) {

        //根据sid查询个人信息并回显到个人信息编辑页
        Staff staff = staffService.getOne(sid);
        model.addAttribute("staff",staff);

        return "staffs/staff/edit";
    }

    /**
     * 编辑个人信息
     * @param staff
     * @return
     */
    @PutMapping("/staff/info")
    public String savePersonalInfo(Staff staff) {
        //持久化到数据库
        staffService.saveStaff(staff);
        //编辑完成后，重定向至查询个人信息
        return "redirect:/staff/personal";
    }

    /**
     * 查询员工列表
     * @param start
     * @param limit
     * @param model
     * @return
     */
    @GetMapping("/staffs")
    public String getStaffList(@RequestParam(value = "start",defaultValue = "0") Integer start,
                               @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                               Model model) {

        start = start<0 ? 0:start;
        Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "sid");
        Pageable pageable = PageRequest.of(start,limit,sort);
        Page<Staff> page = staffRepository.findAll(pageable);

        model.addAttribute("page",page);
        return "admin/staff/list";
    }

    /**
     * 来到员工添加页
     * @param model
     * @return
     */
    @GetMapping("/staff")
    public String toAddStaffPage(Model model) {

        //查询出部门列表，在员工添加页显示
        List<Dept> deptList = deptService.findAll();
        model.addAttribute("deptList",deptList);

        //查询当前员工最大的自增编号（socde=部门类别编号depid+员工自增编号sid），在员工添加页显示
        Long maxSid = staffService.findMaxSid();
        model.addAttribute("maxSid",maxSid);

        return "admin/staff/add";
    }

    /**
     * 添加员工
     * @param staff
     * @return
     */
    @PostMapping("/staff")
    public String addStaff(Staff staff) {
        //持久化到数据库
        staffService.addStaff(staff);
        //添加完成后，重定向至查询员工列表
        return "redirect:/staffs";
    }

    /**
     * 来到员工编辑页
     * @param sid
     * @param model
     * @return
     */
    @GetMapping("/staff/{sid}")
    public String toEditStaffPage(@PathVariable("sid") Integer sid,
                                  Model model) {

        //查询该员工信息并回显到员工编辑页
        Staff staff = staffService.getOne(sid);
        //System.out.println("回显的员工信息："+staff);
        model.addAttribute("staff",staff);
        //查询出部门列表，在员工编辑页进行回显
        List<Dept> deptList = deptService.findAll();
        model.addAttribute("deptList",deptList);

        return "admin/staff/edit";
    }

    /**
     * 编辑员工信息
     * @param staff
     * @return
     */
    @PutMapping("/staff")
    public String saveStaff(Staff staff) {
        //持久化到数据库
        staffService.saveStaff(staff);
        //System.out.println("编辑后："+staff);
        //编辑完成后，重定向至查询员工列表
        return "redirect:/staffs";
    }

    /**
     * 删除员工
     * @param sid
     * @return
     */
    @DeleteMapping("/staff/{sid}")
    public String delStaff(@PathVariable("sid") Integer sid) {
        staffService.delStaff(sid);
        //成功删除后，重定向至查询员工列表
        return "redirect:/staffs";
    }

}
