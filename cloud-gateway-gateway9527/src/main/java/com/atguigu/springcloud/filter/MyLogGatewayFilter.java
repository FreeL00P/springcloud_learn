package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * MyLogGatewayFilter
 * 自定义全局过滤器
 * @author fj
 * @date 2022/11/20 18:49
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       log.info("**********come in 全局过滤器 {}",new Date());
       //获取请求参数
       String uname = exchange.getRequest().getQueryParams().getFirst("uname");
       if (uname != null) {
           log.info("用户名为null非法用户(灬ꈍ ꈍ灬)");
           //返回不被接收的状态信息
           exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
       }
        return chain.filter(exchange);//传到下一个过滤器进行验证
    }

    @Override
    public int getOrder() {
        return 0;//优先级
    }
}
