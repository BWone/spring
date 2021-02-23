package com.spring.annotation.topic13.annotation;

import java.lang.annotation.*;

/**
 * @Author: BWone
 * @Date: 2021/2/19 10:14
 * @Description: 自定义RequestParam注解
 */
@Target({ElementType.PARAMETER}) //入参中使用
@Retention(RetentionPolicy.RUNTIME) //运行时得到
@Documented
public @interface CustomRequestParam {
    String value() default "";
}
