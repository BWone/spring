package com.spring.annotation.bean.foundbean;

import com.spring.annotation.bean.initbean.Prokaryote;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: BWone
 * @Date: 2021/2/1 14:21
 * @Description: 实现FactoryBean接口创建bean
 */
public class CustomFactoryBean implements FactoryBean<Prokaryote> {
    /**
     * 获取bean
     */
    @Override
    public Prokaryote getObject() throws Exception {
        return new Prokaryote();
    }

    /**
     * 返回bean类型
     */
    @Override
    public Class<?> getObjectType() {
        return Prokaryote.class;
    }

    /**
     * 设置单例或多例
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}