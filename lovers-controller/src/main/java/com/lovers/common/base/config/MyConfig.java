package com.lovers.common.base.config;


import com.lovers.common.interceptor.AuthInterceptor;
import com.lovers.common.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Value("${lovers.rootPath}")
    protected String rootPath;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> addList=new ArrayList<>();
        List<String> excludeList=new ArrayList<>();


        addList.add("/mood/**");
        addList.add("/user/**");
        addList.add("/space/**");

        excludeList.add("/");
        excludeList.add("/index");
        excludeList.add("/login/**");
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(excludeList);
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addList);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploadFileById/**").addResourceLocations("file:"+rootPath);
    }
}
