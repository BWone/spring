package com.spring.annotation.bean.initbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: BWone
 * @Date: 2021/2/2 18:08
 * @Description: 通过这个上下文环境对象得到Spring容器中的Bean
 */
@Component
public class CustomApplicationContextAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public CustomApplicationContextAware() {
        System.out.println("------> Protozoa constructor <------");
    }

    @PostConstruct
    public void init(){
        System.out.println("------>  Protozoa init <------");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("------>  Protozoa destroy <------");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 可以拿到从后置器返回的数据
        this.applicationContext = applicationContext;
    }
}
