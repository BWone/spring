package com.spring.annotation.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Person {
    /**
     * 不通过getter/setter或构造器方式赋值时使用@Value的默认值
     */

    @Value(value = "bwone")
    private String name;

    /**
     * 通过表达式的方式赋值
     */
    /*@Value(value = "#{20-2}")
    private Integer age;*/

    /**
     * 通过配置文件方式赋值
     */
    @Value(value = "${person.age}")
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
