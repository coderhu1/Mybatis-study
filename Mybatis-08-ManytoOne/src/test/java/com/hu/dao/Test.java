package com.hu.dao;

import com.hu.pojo.Student;
import com.hu.pojo.Teacher;
import com.hu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.util.List;

/**
 * @author coderhu1
 * @create 2020-09-28 19:30
 */
public class Test {

    @org.junit.Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        List<Teacher> teachers = mapper.selectTeacher();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }

        sqlSession.close();
    }

    @org.junit.Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudents();
        for (Student student : students){ System.out.println( "学生名:"+ student.getName()
                +"\t老师:"+student.getTeacher().getName()); }

        sqlSession.close();
    }

    @org.junit.Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudents2();
        for (Student student : students){ System.out.println( "学生名:"+ student.getName()
                +"\t老师:"+student.getTeacher().getName()); }

        sqlSession.close();
    }
}
