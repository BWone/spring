package com.spring.annotation.topic13.hander.impl;

import com.spring.annotation.topic13.annotation.CustomService;
import com.spring.annotation.topic13.argsresolver.ArgumentResolver;
import com.spring.annotation.topic13.hander.HanderToolsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@CustomService("handerTools")
public class HanderToolsServiceImpl implements HanderToolsService {

    /**
     * 通过反射返回方法中的参数
     * @param method 反射方法
     * @param beans bean实例容器
     * @return Object[] 用于invoke的入参参数
     */
    @Override
    public Object[] hander(Method method, Map<String, Object> beans, HttpServletRequest req, HttpServletResponse resp) {
        Class<?>[] parameterTypes = method.getParameterTypes();

        // 用于返回参数的对象数组
        Object[] args = new Object[parameterTypes.length];

        // 策略模式 参数解析
        // 1.拿到所有实现了ArgumentResolver接口的实例
        Map<String, Object> argsResolvers = getArgumentResolverBean(beans, ArgumentResolver.class);

        // 2.比较参数类型
        int index = 0, i = 0;
        for (Class<?> paramClazz:parameterTypes) {
            for (Map.Entry<String, Object> resolver:argsResolvers.entrySet()) {
                ArgumentResolver argResolver = (ArgumentResolver) resolver.getValue();

                // 如果比对成功则执行解析方法
                if (argResolver.support(method, paramClazz, index)) {
                    args[i++] = argResolver.argumentResolver(method, paramClazz, index, req, resp);
                }
            }
            index++;
        }
        return args;
    }

    private Map<String, Object> getArgumentResolverBean(Map<String, Object> beans, Class<?> type) {
        Map<String, Object> resultBeans = new HashMap<>();

        // 循环获取每个bean的抽象类接口,如果是指定类型就放入map中
        for (Map.Entry<String, Object> bean:beans.entrySet()) {
            Class<?>[] interfaces = bean.getValue().getClass().getInterfaces();

            if (interfaces != null && interfaces.length > 0) {

                for (Class<?> inter:interfaces) {

                    if (inter.isAssignableFrom(type)) {
                        resultBeans.put(bean.getKey(), bean.getValue());
                    }
                }
            }
        }
        return resultBeans;
    }
}
