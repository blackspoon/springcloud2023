package com.clx.productservice.service;

import com.clx.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private static final Map<Integer, Product> daoMap = new HashMap<>();

    static {

        Product p1 = new Product(1,"iphonex",9999);
        Product p2 = new Product(2,"冰箱",5342);
        Product p3 = new Product(3,"洗衣机",523);
        Product p4 = new Product(4,"电话",64345);
        Product p5 = new Product(5,"汽车",2345);
        Product p6 = new Product(6,"椅子",253);
        Product p7 = new Product(7,"java编程思想",2341);

        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
        daoMap.put(p3.getId(),p3);
        daoMap.put(p4.getId(),p4);
        daoMap.put(p5.getId(),p5);
        daoMap.put(p6.getId(),p6);
        daoMap.put(p7.getId(),p7);
    }

    /**
     * 列出所有商品
     * @return
     */
    public List<Product> listProduct() {
        Collection<Product> collection = daoMap.values();
        List<Product> list = new ArrayList<>(collection);
        return list;
    }

    /**
     * 根据具体id去查找商品
     * @param id
     * @return
     */
    public Product findById(int id) {
        return daoMap.get(id);
    }
}
