package com.hu.dao;

import com.hu.pojo.User;
import com.hu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author coderhu1
 * @create 2020-09-26 16:52
 */
public class UserDaoTest {


    //增删改需要提交事务
    //可能是Mybatis框架这些功能设置自动提交事务false
    @Test
    public void selectTest() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.selectUser();

        System.out.println(users);

        sqlSession.close();
    }
}
