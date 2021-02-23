package com.spring.annotation.topic14.initializer;

import com.spring.annotation.topic14.filter.CustomFilter;
import com.spring.annotation.topic14.listener.CustomListener;
import com.spring.annotation.topic14.service.Topic14Service;
import com.spring.annotation.topic14.servlet.CustomServlet2;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

@HandlesTypes(value = Topic14Service.class) // 可以将类的子类型传入onStartup方法的set参数
public class CustomServletContainerInitializer implements ServletContainerInitializer {

    /**
     * servlet容器初始化
     * @param set 感兴趣的父类的子类型
     * @param servletContext web三大组件
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        // 反射
        for (Class<?> clazz:set) {
            System.out.println(clazz);
        }

        // 注册servlet组件
        ServletRegistration.Dynamic servlet = servletContext.addServlet("CustomServlet2", new CustomServlet2());
        servlet.addMapping("/CustomServlet2");

        //注册监听器
        servletContext.addListener(CustomListener.class);

        //注册过滤器
        FilterRegistration.Dynamic filter = servletContext.addFilter("CustomFilter", CustomFilter.class);
        // 添加filter映射信息,指定拦截哪个Servlet
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
