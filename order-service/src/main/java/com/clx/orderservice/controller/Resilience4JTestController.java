package com.clx.orderservice.controller;

import com.clx.orderservice.service.Resilience4JTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/resilience4j")
public class Resilience4JTestController {

    @Autowired
    private Resilience4JTestService resilience4JTestService;

    @RequestMapping(value = "/testCircuitBreaker")
    public String testCircuitBreaker() throws Exception{
        return resilience4JTestService.testCircuitBreaker();
    }

    @RequestMapping(value = "/testRetry")
    public String testRetry() throws Exception{
        return resilience4JTestService.testRetry();
    }

    @RequestMapping(value = "/testTimeLimiter")
    public CompletableFuture<String> testTimeLimiter() throws Exception{
        return resilience4JTestService.testTimeLimiter();
    }

}
