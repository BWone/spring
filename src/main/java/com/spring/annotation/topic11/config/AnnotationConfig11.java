package com.spring.annotation.topic11.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.spring.annotation.topic10.aop.Aspects;
import com.spring.annotation.topic10.aop.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
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
@ComponentScan(value = "com.spring.annotation.topic11")
@EnableTransactionManagement  // 开启事务管理功能,对事务注解起作用
public class AnnotationConfig11 {

    /**
     * 创建数据源
     */
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_anno?useSSL=false&serverTimezone=GMT&allowMultiQueries=true");
        return dataSource;
    }

    /**
     * JdbcTemplate简化增删改查操作
     */
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    /**
     * 注册事务管理器
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager(){
        // 只针对当前数据源起作用
        return new DataSourceTransactionManager(dataSource());
    }
}
