package com.heyq.mybatisplusdata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heyq.mybatisplusdata.mapper.ProductMapper;
import com.heyq.mybatisplusdata.pojo.Product;
import com.heyq.mybatisplusdata.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author heyq
 * @create 2022-10-31-17:48
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
