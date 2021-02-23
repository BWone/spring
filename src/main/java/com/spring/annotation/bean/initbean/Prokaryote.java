package com.spring.annotation.bean.initbean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author: BWone
 * @Date: 2021/2/2 15:14
 * @Description: 实现接口并定义bean的初始化和销毁
 */
@Component
public class Prokaryote implements InitializingBean, DisposableBean {

    public Prokaryote() {
        System.out.println("------> Prokaryote constructor <------");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("------> Prokaryote destroy <------");
    }

    /**
     * bean属性赋值和初始化完成后调用
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("------> Prokaryote afterPropertiesSet <------");
    }
}
