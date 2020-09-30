package com.hu.dao;

import com.hu.pojo.User;
import com.hu.utils.MybatisUtils;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author coderhu1
 * @create 2020-09-26 16:52
 */
public class UserDaoTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();

        for (User user:
             users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    //增删改需要提交事务
    //可能是Mybatis框架这些功能设置自动提交事务false
    @Test
    public void addTest() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void getUserById2() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 3);
        map.put("name", "xq");
        User user = mapper.getUserById2(map);
        System.out.println(user);
    }

    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userLike = mapper.getUserLike("%x%");
        System.out.println(userLike);
    }

    @Test
    public void addUserTest() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int insert = mapper.addUser(new User(4, "klsjf", "ljg"));
        if(insert > 0) {
            System.out.println("插入成功");
        }

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void addUser2() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userid", 5);
        map.put("passWord", "sldjdlskgj");
        mapper.addUser2(map);

        session.commit();
        session.close();
    }

    @Test
    public void uppdateTest() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.updateUser(new User(4, "hudi", "hudidemima"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.deleteUser(4);

        sqlSession.commit();
        sqlSession.close();
    }
}
