package com.heyq.mybatisplusdata;

import com.heyq.mybatisplusdata.service.ProductService;
import com.heyq.mybatisplusdata.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author heyq
 * @create 2022-10-31-17:50
 */
@SpringBootTest
public class MybatisDataApplicationTest {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;


    @Test
    public void test(){
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }
}
