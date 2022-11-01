package com.heyq.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heyq.mybatisplusdemo.mapper.ProductMapper;
import com.heyq.mybatisplusdemo.pojo.Product;
import com.heyq.mybatisplusdemo.service.ProductService;
import org.springframework.jdbc.core.ParameterMapper;

/**
 * @author heyq
 * @create 2022-10-31-16:16
 */
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
