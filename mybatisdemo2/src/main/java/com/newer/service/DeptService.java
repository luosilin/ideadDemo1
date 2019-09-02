package com.newer.service;

import com.newer.domain.Dept;
import com.newer.mapper.DeptMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptService {
    private SqlSession sqlSession;
    private DeptMapper deptMapper;
    private   void  init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        deptMapper=sqlSession.getMapper(DeptMapper.class);

    }
    public List<Dept> findAll(){
        init();
        List<Dept> list=deptMapper.findAll();
        SqlSessionUtil.close(sqlSession);
        return list;

    }




}
