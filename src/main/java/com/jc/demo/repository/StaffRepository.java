package com.jc.demo.repository;

import com.jc.demo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepository extends JpaRepository<Staff,Integer> {
    //员工登陆，根据工号和密码查询
    Staff queryByScodeAndSpassword(String scode,String spassword);
    //查询当前数据库中，最大的员工编号（socde=部门类别编号depid+员工自增编号sid）
    @Query("select max(sid) from Staff")
    Long findBySidOrderBySid();
    //员工培训信息校验，根据工号查询
    Staff findByScode(String scode);
}
