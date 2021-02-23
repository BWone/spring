package com.spring.annotation.topic2.config;

import com.spring.annotation.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @Author: BWone
 * @Date: 2021/2/1 11:45
 * @Description: 包扫描的配置类
 **/
@Configuration
@ComponentScans(value = {
        /*@ComponentScan(value="com.spring.annotation",includeFilters={
                @ComponentScan.Filter(type= FilterType.ANNOTATION,classes={Controller.class})
        }, useDefaultFilters=false),*/
        /*@ComponentScan(value="com.spring.annotation",includeFilters={
                @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,classes={OrderController.class})
        }, useDefaultFilters=false),*/
        @ComponentScan(value="com.spring.annotation",includeFilters={
                @ComponentScan.Filter(type= FilterType.CUSTOM,classes={CustomTypeFilter.class})
        }, useDefaultFilters=false)
})
public class AnnotationConfig2 {

    @Bean
    public Person person(){
        return new Person("bwone", 18);
    }
}
