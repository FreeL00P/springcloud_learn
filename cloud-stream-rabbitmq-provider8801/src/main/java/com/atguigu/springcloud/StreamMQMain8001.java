package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * StreamMQMain8001
 *
 * @author fj
 * @date 2022/11/21 19:57
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8001.class, args);
    }

}
