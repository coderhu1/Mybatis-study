package com.hu.pojo;

import lombok.Data;

/**
 * @author coderhu1
 * @create 2020-09-28 19:22
 */
@Data
public class Student {
    private int id;
    private String name;
    private Teacher teacher;
}
