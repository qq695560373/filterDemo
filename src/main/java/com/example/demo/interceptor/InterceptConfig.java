package com.example.demo.interceptor;

import com.example.demo.interceptor.CustomHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author laogao
 * @date 2021/12/6 16:27
 */
@Configuration
public class InterceptConfig extends WebMvcConfigurerAdapter {
    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new CustomHandlerInterceptor()).addPathPatterns("/intercept2/**");
        super.addInterceptors(registry);
    }
}
