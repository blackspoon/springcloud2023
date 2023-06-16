package com.clx.orderservice.service;

import com.clx.orderservice.client.ProductClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class Resilience4JTestService {
    @Autowired
    private ProductClient productClient;

    /**
     * 测试熔断
     * @return
     */
    @CircuitBreaker(name = "testCircuitBreaker", fallbackMethod = "testCircuitBreakerError")
    public String testCircuitBreaker() {
        return productClient.testCircuitBreaker();
    }

    /**
     * 熔断回调
     * @param e
     * @return
     */
    public String testCircuitBreakerError(Throwable e) {
        return "testCircuitBreakerError" + e.getMessage();
    }

    /**
     * 测试Retry
     * @return
     */
    @Retry(name = "testRetry", fallbackMethod = "testRetryError")
    public String testRetry() {
        System.out.println("retry");
        return productClient.testCircuitBreaker();
    }

    /**
     * Retry回调
     * @param e
     * @return
     */
    public String testRetryError(Throwable e) {
        return "testRetryError" + e.getMessage();
    }

    /**
     * 测试Time Limiter
     * @return
     */
    @TimeLimiter(name = "testTimeLimiter", fallbackMethod = "testTimeLimiterError")
    public CompletableFuture<String> testTimeLimiter() {
        return CompletableFuture.supplyAsync(() -> productClient.testTimeLimiter());
    }

    /**
     * Time Limiter回调
     * @param e
     * @return
     */
    public CompletableFuture<String> testTimeLimiterError(Throwable e) {
        return CompletableFuture.supplyAsync(() -> "testTimeLimiterError" + e.getMessage());
    }

}
