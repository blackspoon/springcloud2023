package com.clx.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Configuration
public class KeyResolverConfiguration {

    @Primary
    @Bean
    public KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono
                .just(Objects.requireNonNull(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()))
                        .getAddress().getHostAddress());
    }

    @Bean
    public KeyResolver pathKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getURI().getPath());
    }

    @Bean
    public KeyResolver parameterKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getHeaders().get("username").get(0));
    }

    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getURI().getHost());
    }
}
