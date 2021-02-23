package com.spring.annotation.topic13.annotation;

import java.lang.annotation.*;

/**
 * @Author: BWone
 * @Date: 2021/2/19 10:12
 * @Description: 自定义RequestMapping注解
 */
@Target({ElementType.METHOD, ElementType.TYPE}) //方法和类上使用
@Retention(RetentionPolicy.RUNTIME) //运行时得到
@Documented
public @interface CustomRequestMapping {
    String value() default "";
}
