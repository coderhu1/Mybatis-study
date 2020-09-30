package com.hu.pojo;

/**
 * @author coderhu1
 * @create 2020-09-29 9:18
 */
import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
    //set，get....
}
