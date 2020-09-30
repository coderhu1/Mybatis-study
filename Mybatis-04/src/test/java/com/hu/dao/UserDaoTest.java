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

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void selectTest2() {
        logger.info("info: 进入方法");
        logger.debug("debug:进入方法");
        logger.error("error:进入方法");
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("key1", 1);
        map.put("key2", 2);

        List<User> users = mapper.selectUser(map);
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    //增删改需要提交事务
    //可能是Mybatis框架这些功能设置自动提交事务false

    @Test
    public void testUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSession();
        int currentPage = 1;
        int pageSize = 2;

        RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize, pageSize);

        List<User> users = sqlSession.selectList("com.hu.dao.UserMapper.getUserByRowBounds", null, rowBounds);

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
