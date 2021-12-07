package com.example.demo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author laogao
 * @date 2021/12/6 14:40
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean customerFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();

        // 设置过滤器
        registration.setFilter(new CustomerFilter());

        // 拦截路由规则
        registration.addUrlPatterns("/intercept/*");

        // 设置初始化参数
        registration.addInitParameter("name", "customFilter");

        registration.setName("CustomerFilter");
        registration.setOrder(1);
        return registration;
    }
}
