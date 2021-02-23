package com.spring.annotation.topic5.config;

import com.spring.annotation.bean.Person;
import com.spring.annotation.topic5.condition.WindowsMatchCondition;
import com.spring.annotation.topic5.condition.LinuxMatchCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: BWone
 * @Date: 2021/2/1 11:45
 * @Description: 包扫描的配置类
 **/
@Configuration
public class AnnotationConfig5 {

    /**
     * 按给定条件注入
     */
    @Conditional(value = WindowsMatchCondition.class)
    @Bean
    public Person youngPerson(){
        System.out.println("给容器中添加youngPerson");
        return new Person("bwone", 18);
    }

    @Conditional(value = LinuxMatchCondition.class)
    @Bean
    public Person ordPerson(){
        System.out.println("给容器中添加ordPerson");
        return new Person("test", 60);
    }

}
