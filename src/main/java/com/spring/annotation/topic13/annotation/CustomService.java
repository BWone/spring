package com.spring.annotation.topic13.annotation;

import java.lang.annotation.*;

/**
 * @Author: BWone
 * @Date: 2021/2/19 10:16
 * @Description: 自定义Service注解
 */
@Target({ElementType.TYPE}) //类上使用
@Retention(RetentionPolicy.RUNTIME) //运行时得到
@Documented
public @interface CustomService {
    String value() default "";
}
