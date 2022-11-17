package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ApplicationContextConfig
 *
 * @author fj
 * @date 2022/11/15 23:02
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced//开启Template负载均衡
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }

}
