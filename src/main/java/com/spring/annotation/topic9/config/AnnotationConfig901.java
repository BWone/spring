package com.spring.annotation.topic9.config;

import com.spring.annotation.topic9.dao.Topic9Dao;
import org.springframework.context.annotation.*;

/**
 * @Author: BWone
 * @Date: 2021/2/2 11:17
 * @Description: 基础注入注解
 */
@Configuration
@ComponentScan(value = {"com.spring.annotation.topic9.controller"
        , "com.spring.annotation.topic9.dao", "com.spring.annotation.topic9.service"})
public class AnnotationConfig901 {

    @Primary
    @Bean(value = "topic9Dao2")
    public Topic9Dao topic9Dao(){
        Topic9Dao dao = new Topic9Dao();
        dao.setFlag("2");
        return dao;
    }

}
