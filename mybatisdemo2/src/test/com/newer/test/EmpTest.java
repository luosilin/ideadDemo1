package com.newer.test;

import com.newer.domain.Dept;
import com.newer.domain.Emp;
import com.newer.mapper.EmpMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class EmpTest {
    @Test
    public void test(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        try {
            System.out.println(sqlSession.getConnection().getMetaData().getDatabaseProductName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlSessionUtil.close(sqlSession);

    }

    @Test
    public void  testAdd(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        Emp emp=new Emp();
        emp.setEname("江都");
        emp.setSal(4499f);
        emp.setHiredate(Date.valueOf("2018-09-22"));
        Dept dept=new Dept();
        dept.setDeptno(5);
        emp.setDept(dept);
        emp.setJob("程序员");
        empMapper.addEmp(emp);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);

    }
    @Test
    public void  testUpdate(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        Emp emp=new Emp();
        emp.setEmpno(9906);
        emp.setEname("江小都");
        emp.setSal(4488f);
        emp.setHiredate(Date.valueOf("2018-09-22"));
        Dept dept=new Dept();
        dept.setDeptno(5);
        emp.setDept(dept);
        emp.setJob("厨师长");
        empMapper.updateEmp(emp);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);

    }
    @Test
    public void  testDelete(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        empMapper.deleteEmp(9906);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);

    }
    @Test
    public void  testFindByNo(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
          Emp emp = empMapper.findByNo(7512);
          System.out.println(emp);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);

    }
    @Test
    public void  testFindAll(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);

        empMapper.findAll().forEach(emp -> System.out.println(emp));
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);

    }




}
