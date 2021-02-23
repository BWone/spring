package com.spring.annotation.bean.gainbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class CustomBeanNameAware implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    /**
     * 获取IOC容器
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean的名字为：" + name);
    }

    /**
     * 获取Bean信息
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的IOC容器：" + applicationContext);
        this.applicationContext = applicationContext;
    }

    /**
     * 解析器
     */
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String result = resolver.resolveStringValue("你好${os.name},计算#{9*9}");
        System.out.println("解析的字符串：" + result);
    }
}
