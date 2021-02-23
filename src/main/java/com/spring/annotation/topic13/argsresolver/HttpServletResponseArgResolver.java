package com.spring.annotation.topic13.argsresolver;

import com.spring.annotation.topic13.annotation.CustomService;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@CustomService(value = "httpServletResponseArgResolver")
public class HttpServletResponseArgResolver implements ArgumentResolver {

    @Override
    public boolean support(Method method, Class<?> type, int index) {
        return ServletResponse.class.isAssignableFrom(type);
    }

    @Override
    public Object argumentResolver(Method method, Class<?> type, int index, HttpServletRequest req, HttpServletResponse resp) {
        return resp;
    }
}
