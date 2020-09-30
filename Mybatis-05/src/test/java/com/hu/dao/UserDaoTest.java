package com.hu.dao;

import com.hu.pojo.User;
import com.hu.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author coderhu1
 * @create 2020-09-26 16:52
 */
public class UserDaoTest {

    @Test
    public void selectTest2() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void selectTest() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = new User(4, "sldfj", "sldjgs");
        mapper.addUser(user1);


        sqlSession.close();
    }

    @Test
    public void selectTest3() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(4);

        sqlSession.close();
    }

    @Test
    public void selectTest4() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(3,"woshihuzong");

        sqlSession.close();
    }
}
