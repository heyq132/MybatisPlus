package com.heyq.mybatisplusdemo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.heyq.mybatisplusdemo.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author heyq
 * @create 2022-10-30-16:03
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@TableName("t_user")
//设置实体类对应的表名
public class User {

    //将属性所对应的字段指定为主键
    //@TableId注解的value属性用于指定主键的字段
    //@TableId(value = "uid" ,type = IdType.AUTO)
    @TableId("uid")
    private Long id;
    //指定属性所对应的字段名
    @TableField("user_name")
    private String name;
    private Integer age;
    private String email;

    @TableLogic
    private Integer isDeleted;
    private SexEnum sex;
}
