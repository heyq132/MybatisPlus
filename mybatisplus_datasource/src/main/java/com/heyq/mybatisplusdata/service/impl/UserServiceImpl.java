package com.heyq.mybatisplusdata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heyq.mybatisplusdata.mapper.UserMapper;
import com.heyq.mybatisplusdata.pojo.User;
import com.heyq.mybatisplusdata.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author heyq
 * @create 2022-10-31-17:45
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
