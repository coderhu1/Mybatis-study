package com.hu.dao;

import com.hu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author coderhu1
 * @create 2020-09-29 13:12
 */
public interface UserMapper {

    //根据id查询用户
    User queryUserById(@Param("id") int id);

    //修改用户
    int updateUser(Map map);
}
