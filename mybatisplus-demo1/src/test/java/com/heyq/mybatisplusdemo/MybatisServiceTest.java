package com.heyq.mybatisplusdemo;

import com.heyq.mybatisplusdemo.pojo.User;
import com.heyq.mybatisplusdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heyq
 * @create 2022-10-30-18:02
 */
@SpringBootTest
public class MybatisServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testGetCount(){
        //查询总记录数
        //SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println("总记录数："+count);
    }


    @Test
    public void testInsetMore(){
        //批量添加
        /*User user1 = new User(null,"小何", 22, "541545@dfas");
        User user2 = new User(null,"小王", 22, "541545@dfas");
        User user3 = new User(null,"小夏", 22, "541545@dfas");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);*/
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user=new User();
            user.setName("hyq"+i);
            user.setAge(i);
            user.setEmail("safjisaj"+i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }
}
