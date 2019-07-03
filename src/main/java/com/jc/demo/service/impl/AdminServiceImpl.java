package com.jc.demo.service.impl;

import com.jc.demo.entity.Admin;
import com.jc.demo.repository.AdminRepository;
import com.jc.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    //管理员登陆，根据姓名和密码查询
    @Override
    public Admin checkLogin(String aname, String apassword) {
        return adminRepository.queryByAnameAndApassword(aname,apassword);
    }
}
