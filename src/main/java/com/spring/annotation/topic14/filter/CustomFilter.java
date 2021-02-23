package com.spring.annotation.topic14.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: BWone
 * @Date: 2021/2/22 15:02
 * @Description: 自定义过滤器
 */
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter...........");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
