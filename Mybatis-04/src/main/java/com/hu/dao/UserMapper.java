package com.hu.dao;

import com.hu.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author coderhu1
 * @create 2020-09-26 16:43
 */
public interface UserMapper {
    List<User> selectUser(Map<String,Integer> map);

    List<User> getUserByRowBounds();
}
