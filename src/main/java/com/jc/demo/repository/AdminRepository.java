package com.jc.demo.repository;

import com.jc.demo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    //管理员登陆，根据姓名和密码查询
    Admin queryByAnameAndApassword(String aname,String apassword);
}
