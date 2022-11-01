package com.heyq.mybatisplusdemo;

import com.heyq.mybatisplusdemo.mapper.ProductMapper;
import com.heyq.mybatisplusdemo.mapper.UserMapper;
import com.heyq.mybatisplusdemo.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author heyq
 * @create 2022-10-31-16:19
 */
@SpringBootTest
public class MybatisPlusProductTest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;

    @Test
    public void testProduct01() {
        //小李查询商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的商品价格：" + productLi.getPrice());
        //小王查询商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小李查询的商品价格：" + productWang.getPrice());
        //小李将商品价格+50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);
        //小王将商品价格-30
        productWang.setPrice(productWang.getPrice() - 30);
        productMapper.updateById(productWang);

        //老板查询商品价格
        Product productboss = productMapper.selectById(1);
        System.out.println("老板查询的商品价格：" + productboss.getPrice());

    }


    @Test
    public void testProduct02() {

        //小李取数据
        Product p1 = productMapper.selectById(1);
        //小王取数据
        Product p2 = productMapper.selectById(1);
        //小李修改 + 50
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改的结果：" + result1);
        //小王修改 - 30
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        System.out.println("小王修改的结果：" + result2);
        if (result2 == 0) {
            //失败重试，重新获取version并更新
            p2 = productMapper.selectById(1);
            p2.setPrice(p2.getPrice() - 30);
            result2 = productMapper.updateById(p2);
        }
        System.out.println("小王修改重试的结果：" + result2);
        //老板看价格
        Product p3 = productMapper.selectById(1L);
        System.out.println("老板看价格：" + p3.getPrice());
    }

}


