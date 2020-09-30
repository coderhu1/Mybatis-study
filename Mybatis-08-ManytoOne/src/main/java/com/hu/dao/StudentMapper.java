package com.hu.dao;

import com.hu.pojo.Student;

import java.util.List;

/**
 * @author coderhu1
 * @create 2020-09-28 19:23
 */
public interface StudentMapper {
    public List<Student> getStudents();

    public List<Student> getStudents2();
}
