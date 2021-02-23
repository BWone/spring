package com.spring.annotation.topic13.annotation;

import java.lang.annotation.*;

/**
 * @Author: BWone
 * @Date: 2021/2/19 10:08
 * @Description: 自定义Qualifier注解
 */
@Target({ElementType.FIELD}) //字段上使用
@Retention(RetentionPolicy.RUNTIME) //运行时得到
@Documented
public @interface CustomQualifier {
    String value() default "";
}
