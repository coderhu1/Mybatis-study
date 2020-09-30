package com.hu.utils;

import org.apache.ibatis.cache.Cache;

/**
 * @author coderhu1
 * @create 2020-09-29 21:34
 */

//很难自己写，底层太复杂
public class MyCache implements Cache {
    public String getId() {
        return null;
    }

    public void putObject(Object key, Object value) {

    }

    public Object getObject(Object key) {
        return null;
    }

    public Object removeObject(Object key) {
        return null;
    }

    public void clear() {

    }

    public int getSize() {
        return 0;
    }
}
