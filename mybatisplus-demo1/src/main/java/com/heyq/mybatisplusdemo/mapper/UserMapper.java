package com.heyq.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyq.mybatisplusdemo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author heyq
 * @create 2022-10-30-16:10
 */
@Repository
//将类或者组件标注称持久层组件
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过年龄查询用户信息并分页
     * @param page MyBatis-Plus所提供的分页对象，必须位于第一个参数的位置
     * @param age
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);


}
