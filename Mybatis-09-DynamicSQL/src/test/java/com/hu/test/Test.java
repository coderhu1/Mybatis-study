package com.hu.test;

import com.hu.dao.BlogMapper;
import com.hu.pojo.Blog;
import com.hu.utils.IDUtil;
import com.hu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

/**
 * @author coderhu1
 * @create 2020-09-29 9:06
 */
public class Test {
    @org.junit.Test
    public void test1() {
        System.out.println(IDUtil.genId());
    }

    //初始化表格
    @org.junit.Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtil.genId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close(); }
}
