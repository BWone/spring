package com.spring.annotation.bean.initbean.processor;

import com.spring.annotation.bean.Animal;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: BWone
 * @Date: 2021/2/8 16:56
 * @Description: 对Bean定义进行拦截的后置处理器,其实该接口实现了BeanFactoryPostProcessor接口
 */
@Component
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("CustomBeanDefinitionRegistryPostProcessor.postProcessBeanFactory()被执行......");
        // 获取所有已经加载到BeanFactory的bean定义，但是bean实例还没创建
        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        int count = beanFactory.getBeanDefinitionCount();
        System.out.println("当前BeanFactory中有" + count + "个bean\n" + Arrays.toString(definitionNames));
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("CustomBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()被执行");
        String[] definitionNames = registry.getBeanDefinitionNames();
        int count = registry.getBeanDefinitionCount();
        System.out.println("当前BeanFactory中有" + count + "个bean\n" + Arrays.toString(definitionNames));

        // 创建bean定义,如果这里被执行,我们beanFactory中bean定义的数量会加1
        // 方式一
        RootBeanDefinition beanDefinition1 = new RootBeanDefinition(Animal.class);
        // 方式二
        AbstractBeanDefinition beanDefinition2 = BeanDefinitionBuilder.rootBeanDefinition(Animal.class).getBeanDefinition();
        registry.registerBeanDefinition("customAnimal1", beanDefinition1);
        registry.registerBeanDefinition("customAnimal2", beanDefinition2);
    }
}
