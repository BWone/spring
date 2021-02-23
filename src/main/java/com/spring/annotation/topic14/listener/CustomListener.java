package com.spring.annotation.topic14.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: BWone
 * @Date: 2021/2/22 15:04
 * @Description: 监听项目启动或停止
 */
public class CustomListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Listener.......Initialized.............");
        // 获取ServletContext组件
        ServletContext servletContext = servletContextEvent.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Listenerr.......Destroyed.............");
    }
}
