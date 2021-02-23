package com.spring.annotation.topic3.config;

import com.spring.annotation.bean.Person;
import com.spring.annotation.topic2.config.CustomTypeFilter;
import org.springframework.context.annotation.*;

/**
 * @Author: BWone
 * @Date: 2021/2/1 11:45
 * @Description: 包扫描的配置类
 **/
@Configuration
public class AnnotationConfig3 {

    /**
     * 默认单实例
     */
    @Bean
    public Person personSingleton(){
        return new Person("bwone", 18);
    }

    /**
     * @Scope: 四种方式
     * prototype:多实例
     * singleton:单实例(默认)
     * request:主要针对web应用,发一次请求创建一个实例
     * session:同一个session创建一个实例
     */
    @Scope(value = "prototype")
    @Bean
    public Person personMultiInstance(){
        return new Person("bwone", 18);
    }
}
