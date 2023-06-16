package com.clx.orderservice.service;

import com.clx.orderservice.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ProductClient productClient;

    public Object getProductList() {
        return productClient.list();
    }

    public Object getProduct(int id) {
        return productClient.findById(id);
    }
}
