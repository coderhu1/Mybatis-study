import com.hu.dao.UserMapper;
import com.hu.pojo.User;
import com.hu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;

/**
 * @author coderhu1
 * @create 2020-09-29 13:15
 */
public class Test {

    //缓存失效情况一：sqlsession不同
    @org.junit.Test
    public void testQueryUserById() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        SqlSession session2 = MybatisUtils.getSession();
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);

        System.out.println(user == user2);

        sqlSession.close();
        session2.close();
    }

    //缓存失效情况二：SqlSession相同，查询条件不同，不存在这个数据
    @org.junit.Test
    public void testQueryUserById2() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        User user2 = mapper2.queryUserById(2);
        System.out.println(user2);

        System.out.println(user==user2);

        session.close();
    }

    //缓存失效情况三：两次查询之间进行了增删改，影响了数据
    @org.junit.Test
    public void testQueryUserById3() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        HashMap<String, Object> map = new HashMap
                <String, Object>();
        map.put("name", "huzong222");
        map.put("id", 3);
        mapper.updateUser(map);

        User user1 = mapper.queryUserById(1);
        System.out.println(user1);

        System.out.println(user == user1);

        sqlSession.close();
    }

    //缓存失效情况四：手动清除一级缓存，一级缓存就是一个map
    @org.junit.Test
    public void testQueryUserById4() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        sqlSession.clearCache();

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user == user2);

        sqlSession.close();
    }

    //测试二级缓存
    @org.junit.Test
    public void testQueryUserById5(){
        SqlSession session = MybatisUtils.getSession();
        SqlSession session2 = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        session.close();

        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);
        session2.close(); }
}
