package com.spring.annotation.topic12.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.spring.annotation.bean.Animal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author: BWone
 * @Date: 2021/2/4 09:30
 * @Description: 事务
 */
@Configuration
@ComponentScan(value = "com.spring.annotation.bean.initbean.processor")
public class AnnotationConfig12 {

    @Bean
    public Animal animal(){
        return new Animal();
    }

}
