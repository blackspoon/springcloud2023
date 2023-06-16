package com.clx.orderservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {
    @Value("${config.name}")
    private String name;

    @Value("${config.age}")
    private int age;

    @GetMapping("/testConfig")
    public String testConfig() {
        return "name: " + name + ", age: " + age;
    }
}
