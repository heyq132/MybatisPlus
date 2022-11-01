package com.heyq.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heyq.mybatisplusdemo.mapper.UserMapper;
import com.heyq.mybatisplusdemo.pojo.User;
import com.heyq.mybatisplusdemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author heyq
 * @create 2022-10-30-17:56
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
