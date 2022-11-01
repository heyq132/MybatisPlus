package com.heyq.mybatisplusdemo.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author heyq
 * @create 2022-10-31-16:13
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version//标注乐观锁版本号字段
    private Integer version;
}
