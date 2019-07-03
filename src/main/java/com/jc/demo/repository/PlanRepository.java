package com.jc.demo.repository;

import com.jc.demo.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan,Integer> {
    //结课，改变cstate=1（0:培训中?1:培训结束）
    @Transactional
    @Modifying  //在@Query中编写JPQL语句，必须使用@Modifying通知SpringData，这是一个update或delete操作
    @Query(value = "update Plan p set p.cstate=1 where p.pid = :pid")
    void updateOne(Integer pid);

    //查询个人培训计划，根据scode查询
    List<Plan> findByScode(String scode);

    //查看培训课表，即查询cstate=0（培训中）的培训计划
    @Query(value = "select p from Plan p where p.cstate=0 and p.tname=:tname")
    List<Plan> findScheduleByTname(String tname);

    //管理员查询成绩列表
    @Query(value = "select p from Plan p where p.cstate=1")
    List<Plan> findScoresList();

    //员工查询成绩列表
    @Query(value = "select p from Plan p where cstate=1 and scode=:scode")
    List<Plan> findScoreList(String scode);

    //教师查询成绩列表
    @Query(value = "select p from Plan p where cstate=1 and tname=:tname")
    List<Plan> findScore(String tname);

    //查询指定成绩信息回显到页面
    Plan findByPid(Integer pid);
}
