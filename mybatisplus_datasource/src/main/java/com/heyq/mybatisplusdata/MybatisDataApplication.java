package com.heyq.mybatisplusdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heyq
 * @create 2022-10-31-17:31
 */
@SpringBootApplication
@MapperScan("com.heyq.mybatisplusdata.mapper")
public class MybatisDataApplication {
    public static void main(String[] args) {

        SpringApplication.run(MybatisDataApplication.class,args);
    }
}
