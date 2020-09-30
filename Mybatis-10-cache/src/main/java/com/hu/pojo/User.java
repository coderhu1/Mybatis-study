package com.hu.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author coderhu1
 * @create 2020-09-29 13:11
 */
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;
}
