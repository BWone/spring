package com.spring.annotation.bean.initbean;

/**
 * @Author: BWone
 * @Date: 2021/2/2 15:14
 * @Description: 自定义初始化和销毁方法,通过@Bean的initMethod和destroyMethod属性进行引用
 */
public class Protozoa {

    public Protozoa() {
        System.out.println("------> Protozoa constructor <------");
    }

    public void init(){
        System.out.println("------>  Protozoa init <------");
    }

    public void destroy(){
        System.out.println("------>  Protozoa destroy <------");
    }
}
