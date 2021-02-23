package com.spring.annotation.topic4.config;

import com.spring.annotation.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @Author: BWone
 * @Date: 2021/2/1 11:45
 * @Description: 包扫描的配置类
 **/
@Configuration
public class AnnotationConfig4 {

    /**
     * 主要针对单实例（默认），仅当第一次使用bean时才被创建初始化
     */
    @Lazy
    @Bean
    public Person person(){
        System.out.println("给容器中添加person");
        return new Person("bwone", 18);
    }

}
