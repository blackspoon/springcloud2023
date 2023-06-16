package com.clx.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    /**
     * 商品id
     */
    private int id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格,分为单位
     */
    private int price;

}
