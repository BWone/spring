package com.spring.annotation.topic10.config;

import com.spring.annotation.bean.Person;
import com.spring.annotation.topic10.aop.Aspects;
import com.spring.annotation.topic10.aop.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: BWone
 * @Date: 2021/2/4 09:30
 * @Description: AOP
 */
@Configuration
@EnableAspectJAutoProxy // AOP的开关
public class AnnotationConfig10 {

    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    @Bean
    public Aspects aspects(){
        return new Aspects();
    }

}
