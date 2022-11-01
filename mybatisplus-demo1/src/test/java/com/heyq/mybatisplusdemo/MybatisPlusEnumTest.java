package com.heyq.mybatisplusdemo;

import com.heyq.mybatisplusdemo.enums.SexEnum;
import com.heyq.mybatisplusdemo.mapper.UserMapper;
import com.heyq.mybatisplusdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author heyq
 * @create 2022-10-31-17:05
 */
@SpringBootTest
public class MybatisPlusEnumTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void insertTest(){
        User user = new User(null,"小白",20,null,null, SexEnum.MALE);
        userMapper.insert(user);
    }
}
