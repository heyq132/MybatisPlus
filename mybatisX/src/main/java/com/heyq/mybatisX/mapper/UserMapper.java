package com.heyq.mybatisX.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.heyq.mybatisX.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-10-31 18:32:22
* @Entity com.heyq.mybatisX.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    int insertSelective(User user);

    int deleteByUidAndUserName(@Param("uid") Long uid, @Param("userName") String userName);


    int updateAgeAndSexByUid(@Param("age") Integer age, @Param("sex") Integer sex, @Param("uid") Long uid);

    List<User> selectAgeAndUserNameByUid(@Param("uid") Long uid);

    List<User> selectAgeAndUserNameByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);



}




