package com.jc.demo.config;

import com.jc.demo.controller.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //请求classpath:/ 和 classpath:/index.html都会跳转到/login.html
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");

        //请求classpath:/admin会跳转到/admin/login.html
        registry.addViewController("/admin").setViewName("admin/login");
        //请求classpath:/teach会跳转到/teacher/login.html
        registry.addViewController("/teach").setViewName("teacher/login");

        //员工登陆放行，页面重定向至员工首页
        registry.addViewController("/home.html").setViewName("home");
        //管理员登陆放行，页面重定向至管理员首页
        registry.addViewController("/admin/home.html").setViewName("admin/home");
        //教师登陆放行，页面重定向至教师首页
        registry.addViewController("/thome.html").setViewName("thome");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns()添加拦截路径
        //excludePathPatterns()排除拦截路径
            //classpath: /** 为拦截所有请求的路径
            //放行员工请求首页（/和/index.html）的路径和请求登陆（/staff.login）的路径
            //放行管理员请求首页（/admin）的路径和请求登陆（/admin.login）的路径
            //放行教师请求首页（/teach）的路径和请求登陆（/teacher.login）的路径
            //放行所有静态资源
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/","/index.html","/admin","/teach","/staff/login","/admin/login","/teacher/login","/static/**","/webjars/**");
    }
}
