package com.hu.dao;

import com.hu.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author coderhu1
 * @create 2020-09-28 19:24
 */
public interface TeacherMapper {


    List<Teacher> selectTeacher();
}
