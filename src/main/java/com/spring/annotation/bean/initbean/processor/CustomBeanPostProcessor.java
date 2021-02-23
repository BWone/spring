package com.spring.annotation.bean.initbean.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: BWone
 * @Date: 2021/2/2 15:37
 * @Description: bean初始化方法调用前进行拦截
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 初始化方法调用之前进行后置处理
        System.out.println("postProcessBeforeInitialization ------> " + beanName + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 初始化方法调用之后进行后置处理
        System.out.println("postProcessAfterInitialization ------> " + beanName + bean);
        return bean;
    }
}
