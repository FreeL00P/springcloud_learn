package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyselfRule
 * 修改ribbon负载均衡规则
 * 不能放在主启动类@ComponentScan 扫描路径下
 * 还要主启动类加上RibbonClient
 * @author fj
 * @date 2022/11/18 20:16
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();//随机规则
    }

}
