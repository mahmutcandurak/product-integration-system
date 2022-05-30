package com.mcd.product_integration_system.config;

import com.mcd.product_integration_system.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mahmutcandurak
 */

@Component
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new
                RequestInterceptor()).addPathPatterns("/*");
        registry.addInterceptor(new RequestInterceptor())
                .addPathPatterns("/home/*", "/userHome/* ");
    }
}

