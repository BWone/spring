package com.spring.annotation.topic7.config;

import com.spring.annotation.bean.Person;
import com.spring.annotation.bean.initbean.Protozoa;
import org.springframework.context.annotation.*;

/**
 * @Author: BWone
 * @Date: 2021/2/2 11:17
 * @Description: 实例中定义bean生命周期
 */
@Configuration
@ComponentScan(value = "com.spring.annotation.bean")
public class AnnotationConfig7 {

    @Bean
    public Person person(){
        return new Person("bwone", 18);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Protozoa protozoaSingleton(){
        return new Protozoa();
    }

    @Scope(value = "prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Protozoa protozoaMultiInstance(){
        return new Protozoa();
    }

}
