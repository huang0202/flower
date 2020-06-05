package com.huang.flower.config;

import com.huang.flower.fileter.SysInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/pay/index").setViewName("pay");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String [] pathPatterns={"/admin/**/**","/main/**","/shop/flower/**"};
        registry.addInterceptor(new SysInterceptor()).addPathPatterns(pathPatterns);
    }
}

