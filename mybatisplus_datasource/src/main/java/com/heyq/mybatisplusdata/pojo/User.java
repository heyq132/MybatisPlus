package com.heyq.mybatisplusdata.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author heyq
 * @create 2022-10-31-17:39
 */
@Data
@TableName("t_user")
public class User {

    @TableId
    private Integer uid;
    private String userName;
    private Integer age;
    private Integer sex;
    private String email;
    private Integer isDeleted;
}
