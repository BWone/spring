package com.spring.annotation.topic13.hander;

import com.spring.annotation.topic13.hander.impl.HanderToolsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

public interface HanderToolsService {

    Object[] hander(Method method, Map<String, Object> beans, HttpServletRequest req, HttpServletResponse resp);
}
