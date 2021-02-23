package com.spring.annotation.topic14.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: BWone
 * @Date: 2021/2/22 15:38
 * @Description: 根容器注入非Controller层的bean
 */
@ComponentScan(value = "com.spring.annotation.topic14", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})
public class CustomRootConfig {
}
