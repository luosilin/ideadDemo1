package com.newer.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

public class SqlSessionUtil {
    private  static SqlSessionFactory sqlSessionFactory;
    static {
        try {Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
             sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);




        }catch ( IOException e){
            e.printStackTrace();
        }

    }
    public  static  SqlSession getSqlSession(){
        return  sqlSessionFactory.openSession();

    }
    public  static  void close(SqlSession sqlSession){
        if (sqlSession!=null){
            sqlSession.close();


        }

    }

}
