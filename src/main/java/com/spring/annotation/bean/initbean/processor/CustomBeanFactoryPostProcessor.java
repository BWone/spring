package com.spring.annotation.bean.initbean.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: BWone
 * @Date: 2021/2/8 15:38
 * @Description: 对BeanFactory进行拦截的后置处理器
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("CustomBeanFactoryPostProcessor.postProcessBeanFactory()被执行......");
        // 获取所有已经加载到BeanFactory的bean定义，但是bean实例还没创建
        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        int count = beanFactory.getBeanDefinitionCount();
        System.out.println("当前BeanFactory中有" + count + "个bean\n" + Arrays.toString(definitionNames));
    }
}
