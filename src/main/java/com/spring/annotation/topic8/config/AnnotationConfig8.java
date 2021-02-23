package com.spring.annotation.topic8.config;

import com.spring.annotation.bean.Person;
import com.spring.annotation.bean.initbean.Protozoa;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: BWone
 * @Date: 2021/2/2 11:17
 * @Description: @Value直接使用和配置类使用
 */
@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class AnnotationConfig8 {

    @Bean
    public Person person(){
        return new Person();
    }

}
