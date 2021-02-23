package com.spring.annotation.topic13.argsresolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public interface ArgumentResolver {

    /**
     * 判断是否是需要解析的类,访问对应的判断实现类
     * @param method 方法
     * @param type 参数类型
     * @param index 参数下标
     */
    boolean support(Method method, Class<?> type, int index);

    /**
     * 参数解析
     */
    Object argumentResolver(Method method, Class<?> type, int index, HttpServletRequest req, HttpServletResponse resp);
}
