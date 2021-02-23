package com.spring.annotation.topic14.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Author: BWone
 * @Date: 2021/2/22 15:38
 * @Description: 子容器注入Controller层的bean
 */
@ComponentScan(value = "com.spring.annotation.topic14", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
public class CustomServletConfig {
}
