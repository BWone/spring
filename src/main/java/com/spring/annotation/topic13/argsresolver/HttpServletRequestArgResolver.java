package com.spring.annotation.topic13.argsresolver;

import com.spring.annotation.topic13.annotation.CustomService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@CustomService(value = "httpServletRequestArgResolver")
public class HttpServletRequestArgResolver implements ArgumentResolver {

    @Override
    public boolean support(Method method, Class<?> type, int index) {
        return ServletRequest.class.isAssignableFrom(type);
    }

    @Override
    public Object argumentResolver(Method method, Class<?> type, int index, HttpServletRequest req, HttpServletResponse resp) {
        return req;
    }
}
