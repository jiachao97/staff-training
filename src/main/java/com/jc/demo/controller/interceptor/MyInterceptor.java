package com.jc.demo.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    //方法执行前拦截
    //验证用户是否登陆，没有登陆则不放行（return false），重定向到登陆页面；登陆了则放行（return true）
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //从session中获取scode信息
        Object staff = request.getSession().getAttribute("scode");
        //从session中获取aname信息
        Object admin = request.getSession().getAttribute("aname");
        //从session中获取tname信息
        Object teacher = request.getSession().getAttribute("tname");
        //验证staff && admin && teacher是否为空，为空则没有登陆，不放行
        if (staff==null && admin==null && teacher==null) {
            request.setAttribute("msg","无权访问，请先登陆");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        //staff && admin && teacher不为空，则已登陆，放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
