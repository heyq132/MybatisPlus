package com.heyq.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.heyq.mybatisplusdemo.mapper.UserMapper;
import com.heyq.mybatisplusdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author heyq
 * @create 2022-10-31-13:52
 */

@SpringBootTest
public class MybatisPlusWrapperTest {


    @Autowired
    UserMapper userMapper;


    @Test
    public void test1() {
        //查询用户名包含a，年龄在20到30之间，邮箱不为null的用户信息
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("user_name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> lists = userMapper.selectList(wrapper);
        lists.forEach(System.out::println);
    }


    @Test
    public void test02() {
        //查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age")
                .orderByAsc("uid");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03() {
        //删除邮箱为null的数据
        //UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNull("email");
        int delete = userMapper.delete(wrapper);
        System.out.println("delete" + delete);

    }

    @Test
    public void test04() {
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        //UPDATE t_user SET user_name=?, age=?, email=? WHERE is_deleted=0 AND (age >= ? AND user_name LIKE ? OR email IS NULL)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("age", 20)
                .like("user_name", "a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("那仨");
        user.setAge(30);
        user.setEmail("shfkusahu@.com");
        int update = userMapper.update(user, wrapper);
        System.out.println("update" + update);
    }


    @Test
    public void test05() {
        //将用户名中包含a并且(年龄大于20或邮箱为null）的用户信息修改
        //lambda中的条件优先执行
        //UPDATE t_user SET user_name=?, age=?, email=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age >= ? OR email IS NULL))
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("user_name", "a")
                .and(i -> i.ge("age", 20).or().isNull("email"));
        User user = new User();
        user.setName("那仨个");
        user.setAge(30);
        user.setEmail("s15615sahu@.com");
        int update = userMapper.update(user, wrapper);
        System.out.println("update" + update);
    }

    @Test
    public void test06() {
        //查询用的用户名，年龄，邮箱
        //SELECT user_name,age,email FROM t_user WHERE is_deleted=0
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("user_name", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }


    @Test
    public void test07() {
        //查询id小于等于5的用户信息
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (uid IN (select uid from t_user where uid<=5))
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("uid", "select uid from t_user where uid<=5");
        List<User> lists = userMapper.selectList(wrapper);
        lists.forEach(System.out::println);
    }

    @Test
    public void test08() {
        //将用户名中包含a并且(年龄大于20或邮箱为null）的用户信息修改
        //UPDATE t_user SET user_name=?,email=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age >= ? OR email IS NULL))
        UpdateWrapper<User> wrapper=new UpdateWrapper<>();
        wrapper.like("user_name","a")
                .and(i->i.ge("age",20).or().isNull("email"));
        wrapper.set("user_name","小明").set("email","abc@.com");
        int update = userMapper.update(null, wrapper);
        System.out.println("update" + update);
    }


    @Test
    public void test09() {
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        String username="";
        Integer ageBegin=20;
        Integer ageEnd=30;
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)){
            //isNotBlank判断某个字符串是否不为空，不为null，不为空白符
            wrapper.like("user_name",username);
        }
        if (ageBegin !=null){
            wrapper.ge("age",ageBegin);
        }
        if (ageEnd !=null){
            wrapper.le("age",ageEnd);
        }
        List<User> lists = userMapper.selectList(wrapper);
        lists.forEach(System.out::println);
    }


    @Test
    public void test10() {
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        String username="";
        Integer ageBegin=20;
        Integer ageEnd=30;
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(username),"user_name",username)
                .ge(ageBegin != null,"age",ageBegin)
                .le(ageEnd != null,"age", ageEnd);
        List<User> lists = userMapper.selectList(wrapper);
        lists.forEach(System.out::println);
    }

    @Test
    public void test11() {
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        String username="";
        Integer ageBegin=20;
        Integer ageEnd=30;
        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(ageBegin != null,User::getAge,ageBegin)
                .le(ageEnd != null,User::getAge, ageEnd);
        List<User> lists = userMapper.selectList(wrapper);
        lists.forEach(System.out::println);
    }


    @Test
    public void test12() {
        //将用户名中包含a并且(年龄大于20或邮箱为null）的用户信息修改
        //UPDATE t_user SET user_name=?,email=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age >= ? OR email IS NULL))
        LambdaUpdateWrapper<User> wrapper=new LambdaUpdateWrapper<>();
        wrapper.like(User::getName,"a")
                .and(i->i.ge(User::getAge,20).or().isNull(User::getEmail));
        wrapper.set(User::getName,"小明").set(User::getEmail,"abc@.com");
        int update = userMapper.update(null, wrapper);
        System.out.println("update" + update);
    }


}
