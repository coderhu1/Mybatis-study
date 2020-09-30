package com.hu.pojo;

import lombok.*;

/**
 * @author coderhu1
 * @create 2020-09-26 16:38
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
}
