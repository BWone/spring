package com.spring.annotation.topic1;

import com.spring.annotation.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: bwone
 * @Date: 2021/1/29 17:51
 * @Description: 单注解注入
**/
@Configuration
public class AnnotationConfig1 {

    @Bean
    public Person person(){
        return new Person("bwone", 18);
    }
}
