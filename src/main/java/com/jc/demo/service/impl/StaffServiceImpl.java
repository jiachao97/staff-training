package com.jc.demo.service.impl;

import com.jc.demo.entity.Staff;
import com.jc.demo.repository.StaffRepository;
import com.jc.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;

    //员工登陆，根据工号和密码查询
    @Override
    public Staff checkLogin(String scode, String spassword) {
        return staffRepository.queryByScodeAndSpassword(scode,spassword);
    }
    //查询员工列表
    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }
    //查询当前员工最大的自增编号（socde=部门类别编号depid+员工自增编号sid）
    @Override
    public Long findMaxSid() {
        return staffRepository.findBySidOrderBySid();
    }
    //查询个人信息
    @Override
    public Staff getPersonalInfo(String scode) {
        return staffRepository.findByScode(scode);
    }

    //添加员工
    @Override
    public void addStaff(Staff staff) {
        staffRepository.save(staff);
    }
    //根据指定sid查询员工信息进行回显
    @Override
    public Staff getOne(Integer sid) {
        return staffRepository.getOne(sid);
    }
    //编辑员工信息
    @Override
    public void saveStaff(Staff staff) {
        staffRepository.save(staff);
    }
    //删除员工
    @Override
    public void delStaff(Integer sid) {
        staffRepository.deleteById(sid);
    }
    //根据工号查询员工
    @Override
    public Staff getStaffByScode(String scode) {
        return staffRepository.findByScode(scode);
    }
}
