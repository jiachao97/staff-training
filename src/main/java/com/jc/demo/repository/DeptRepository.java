package com.jc.demo.repository;

import com.jc.demo.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept,String> {
}
