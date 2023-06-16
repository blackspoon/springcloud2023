package com.clx.orderservice.controller;

import com.clx.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * http://localhost:7002/order/getProductList
     * 调用商品服务，获取商品列表
     * @return
     */
    @RequestMapping("/getProductList")
    public Object getProductList() {
        return orderService.getProductList();
    }

    /**
     * http://localhost:7002/order/getProduct?id=4
     * 调用商品服务，根据Id获取商品
     * @param id
     * @return
     */
    @RequestMapping("/getProduct")
    public Object getProduct(int id) {
        return orderService.getProduct(id);
    }
}
