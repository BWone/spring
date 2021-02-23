package com.spring.annotation.topic9.config;

import com.spring.annotation.topic9.dao.Topic9Dao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author: BWone
 * @Date: 2021/2/2 11:17
 * @Description: 获取bean的操作
 */
@Configuration
@ComponentScan(value = {"com.spring.annotation.bean.gainbean"})
public class AnnotationConfig902 {

}
