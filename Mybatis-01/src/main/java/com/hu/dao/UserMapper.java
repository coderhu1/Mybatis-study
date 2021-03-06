package com.hu.dao;

import com.hu.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author coderhu1
 * @create 2020-09-26 16:43
 */
public interface UserMapper {
    List<User> selectUser();

    User getUserById(int id);

    User getUserById2(Map<String,Object> map);

    User getUserLike(String name);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int user);

    int addUser2(Map<String,Object> map);
}
