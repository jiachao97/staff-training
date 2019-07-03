package com.jc.demo.service;

import com.jc.demo.entity.Admin;

public interface AdminService {

    //管理员登陆，根据姓名和密码查询
    Admin checkLogin(String aname, String apassword);
}
