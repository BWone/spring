package com.spring.annotation.bean.foundbean;

import com.spring.annotation.bean.Fungus;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: BWone
 * @Date: 2021/2/1 17:23
 * @Description: 实现ImportBeanDefinitionRegistrar接口注入组件
 */
public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param metadata 当前类的注解信息
     * @param registry BeanDefinition注册类,把所有需要添加到容器中的bean加入
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry){
        boolean definition1 = registry.containsBeanDefinition("com.spring.annotation.bean.Animal");
        boolean definition2 = registry.containsBeanDefinition("com.spring.annotation.bean.Plant");
        // 如果Animal和Plant同时存在,则创建Fungus加入到容器
        if (definition1 && definition2) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Fungus.class);
            registry.registerBeanDefinition("fungus", beanDefinition);
        }
    }
}
