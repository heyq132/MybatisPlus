package com.heyq.mybatisX.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heyq.mybatisX.pojo.User;
import com.heyq.mybatisX.service.UserService;
import com.heyq.mybatisX.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-10-31 18:32:22
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




