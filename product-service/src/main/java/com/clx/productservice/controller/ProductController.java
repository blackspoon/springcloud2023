package com.clx.productservice.controller;

import com.clx.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;

    /**
     * http://localhost:7001/product/list
     * 获取所有商品列表
     * @return
     */
    @RequestMapping("/list")
    public Object list(){
        System.out.println(port + "------list");
        return port + "---"+productService.listProduct().toString();
    }

    /**
     * http://localhost:7001/product/find?id=2
     * 根据具体id去查找商品
     * @param id
     * @return
     */
    @RequestMapping("/find")
    public Object findById(int id){
        System.out.println(port + "------findById");
        return port + "---"+productService.findById(id).toString();
    }

    /**
     * 熔断的下游服务
     * @return
     */
    @RequestMapping("/testCircuitBreaker")
    public String testCircuitBreaker() {
        int i = 1/0;
        return "product";
    }
}
