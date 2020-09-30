package com.hu.utils;

import java.util.UUID;

/**
 * @author coderhu1
 * @create 2020-09-29 9:11
 */
public class IDUtil {
    public static String genId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}