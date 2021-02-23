package com.spring.annotation.topic14.web;

import com.spring.annotation.topic14.config.CustomRootConfig;
import com.spring.annotation.topic14.config.CustomServletConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author: BWone
 * @Date: 2021/2/22 15:32
 * @Description: web容器启动时创建,在容器初始化之前的一个控制器
 */
public class CustomWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 根容器(root)
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{CustomRootConfig.class};
    }

    /**
     * 子容器(Servlet)
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{CustomServletConfig.class};
    }

    /**
     * 获取DispatcherServlet相关映射信息
     * 可以拦截所有请求,包括静态资源,但不包括jsp页面
     * jsp页面在Tomcat的jsp解析引擎中解析
     */
    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
