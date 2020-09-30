package com.hu.dao;

import com.hu.pojo.Student;
import com.hu.pojo.Teacher;
import com.hu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author coderhu1
 * @create 2020-09-28 19:30
 */
public class Test {

    @org.junit.Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());

        sqlSession.close();

    }

    @org.junit.Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());

        sqlSession.close();

    }
}
