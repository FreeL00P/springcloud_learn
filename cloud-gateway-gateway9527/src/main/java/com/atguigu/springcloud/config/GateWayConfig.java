package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GateWayConfig
 *
 * @author fj
 * @date 2022/11/20 16:41
 */
//@Configuration
public class GateWayConfig {

    /**
     * 配置了一个id为route-name的路由规则
     * 当访问http://localhost:9527/freeloop时会自动转发到google.com
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customizeRouteLocator(RouteLocatorBuilder builder) {

        RouteLocatorBuilder.Builder routes=builder.routes();
        routes.route("path_route_atguigu",r->r.path("/freeloop").uri("https://www.baidu.com/")).build();
        return routes.build();

    }

}



