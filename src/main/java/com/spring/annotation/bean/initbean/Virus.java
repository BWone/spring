package com.spring.annotation.bean.initbean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: BWone
 * @Date: 2021/2/2 15:34
 * @Description: 通过注解的方式对bean进行初始化和销毁
 */
@Component
public class Virus {

    public Virus() {
        System.out.println("------> Virus constructor <------");
    }

    @PostConstruct
    public void init(){
        System.out.println("------>  Virus init <------");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("------>  Virus destroy <------");
    }
}
