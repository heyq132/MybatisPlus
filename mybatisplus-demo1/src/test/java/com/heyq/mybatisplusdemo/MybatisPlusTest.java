package com.heyq.mybatisplusdemo;

import com.heyq.mybatisplusdemo.mapper.UserMapper;
import com.heyq.mybatisplusdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author heyq
 * @create 2022-10-30-16:13
 */
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectList() {
        //通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }


//    @Test
//    public void TestInsert() {
//        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
//        User user = new User(null, "张三", 20, "16854545@qqq.com",0);
//        int insert = userMapper.insert(user);
//        System.out.println("insert:" + insert);
//        System.out.println("User.id:" + user.getId());
//    }


    @Test
    public void TestDelete() {
        //根据用户id删除
        //DELETE FROM user WHERE id=?
        /*int result = userMapper.deleteById(1586639304575143938L);
        System.out.println("result:" + result);*/

        //根据map集合中设置的条件删除用户信息
        //DELETE FROM user WHERE name = ? AND age = ?
        /*Map<String,Object> map=new HashMap<>();
        map.put("name","李四");
        map.put("age",35);
        int result = userMapper.deleteByMap(map);
        System.out.println("result:" + result);*/

        //通过多个id实现批量删除
        //DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(10L, 11L, 12L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result:" + result);

    }

//    @Test
//    public void testUpdate(){
//        //根据用户id进行修改用户信息
//        //UPDATE user SET name=?, age=?, email=? WHERE id=?
//        User user = new User(1L, "张三", 23, "156468@qq.com",0);
//        int result = userMapper.updateById(user);
//        System.out.println("result:" + result);
//    }

    @Test
    public void testSelect(){
        //根据用户id查询信息
        //SELECT id,name,age,email FROM user WHERE id=?
        /*User user = userMapper.selectById(1L);
        System.out.println(user);*/

        //根据多个id查询多个用户信息
        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        /*List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);*/

        //根据map集合的条件查询用户信息
        //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        Map<String , Object> map = new HashMap<>();
        map.put("name","Jack");
        map.put("age",20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }


}
