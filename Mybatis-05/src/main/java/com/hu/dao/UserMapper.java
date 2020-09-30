package com.hu.dao;

import com.hu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author coderhu1
 * @create 2020-09-26 16:43
 */
public interface UserMapper {
    @Select("select * from user")
    List<User> selectUser();

    @Select("select * from user where id = #{id}")
    User selectById(@Param("id") int id);

    @Insert("insert into user(id, name, pwd) values (#{id},#{name},#{password})")
    void addUser(User user);

    @Delete("delete from user where id = #{uid}")
    void deleteUser(@Param("uid") int id);

    @Update("update user set name = #{name} where id = #{id} ")
    void updateUser(@Param("id") int id, @Param("name") String name);
}
