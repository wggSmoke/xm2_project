package com.igeek.filter;

import com.igeek.core.MyRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/*")
public class RequestWarpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //创建自定义请求对象
        MyRequest request = new MyRequest(httpServletRequest, httpServletResponse);
        //使用自定义的请求替换掉原本的请求
        filterChain.doFilter(request, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
