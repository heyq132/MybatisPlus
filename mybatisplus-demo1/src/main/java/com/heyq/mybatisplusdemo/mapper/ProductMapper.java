package com.heyq.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heyq.mybatisplusdemo.pojo.Product;
import org.springframework.stereotype.Repository;

/**
 * @author heyq
 * @create 2022-10-31-16:15
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
