package com.clx.orderservice.client;

import com.clx.orderservice.config.LoadBalancedConfig;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-service")
@LoadBalancerClient(name = "CONSUL-TEST",configuration = LoadBalancedConfig.class)
@Component
public interface ProductClient {

    @LoadBalanced
    @RequestMapping("/product/list")
    String list();

    @RequestMapping("/product/find")
    String findById(@RequestParam(value = "id") int id);

    @RequestMapping("/product/testCircuitBreaker")
    String testCircuitBreaker();

    @RequestMapping("/product/testTimeLimiter")
    String testTimeLimiter();
}
