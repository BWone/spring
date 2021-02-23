package com.spring.annotation.topic6.config;

import com.spring.annotation.bean.Animal;
import com.spring.annotation.bean.Person;
import com.spring.annotation.bean.foundbean.CustomFactoryBean;
import com.spring.annotation.bean.foundbean.CustomImportBeanDefinitionRegistrar;
import com.spring.annotation.bean.foundbean.CustomImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: BWone
 * @Date: 2021/2/1 11:45
 * @Description: 包扫描的配置类,创建bean(foundbean包下)
 */
@Configuration
@Import(value = {Animal.class, Person.class, CustomImportSelector.class, CustomImportBeanDefinitionRegistrar.class})
public class AnnotationConfig6 {

    @Bean
    public Person youngPerson(){
        return new Person("bwone", 18);
    }

    @Bean
    public CustomFactoryBean factoryBean(){
        return new CustomFactoryBean();
    }

}
