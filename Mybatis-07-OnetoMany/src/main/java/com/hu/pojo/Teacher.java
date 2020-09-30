package com.hu.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author coderhu1
 * @create 2020-09-28 19:23
 */
@Data
public class Teacher {
    private int id;
    private String name;
    //一对多概念
    private List<Student> students;
}
