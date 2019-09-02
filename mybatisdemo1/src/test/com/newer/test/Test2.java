package com.newer.test;

import com.newer.domain.Author;
import com.newer.mapper.AuthorMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;

public class Test2 {

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
    public  void  test1(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        AuthorMapper authorMapper=sqlSession.getMapper(AuthorMapper.class);
       Author author=new Author();
        author.setName("luo");
        author.setSex("男");
        author.setBirthday(Date.valueOf("1998-01-15"));
        authorMapper.addAuthor(author);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public  void test2(){
       SqlSession sqlSession=SqlSessionUtil.getSqlSession();
       AuthorMapper authorMapper=sqlSession.getMapper(AuthorMapper.class);
       Author author=authorMapper.finByid(3);
        System.out.println(author);
        author.setBirthday(Date.valueOf("1997-12-17"));
        System.out.println(authorMapper.updateAuthor(author));
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);

    }
    @Test
    public void test3(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
         AuthorMapper authorMapper=sqlSession.getMapper(AuthorMapper.class);


        System.out.println(authorMapper.deleteAuthor(2));

        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);

    }

    @Test
    public void test4(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        //获取mybatis工厂生产的映射器接口实现实例
        AuthorMapper authorMapper=sqlSession.getMapper(AuthorMapper.class);


        authorMapper.findAll().forEach(author-> System.out.println(author));

        SqlSessionUtil.close(sqlSession);

    }


}
