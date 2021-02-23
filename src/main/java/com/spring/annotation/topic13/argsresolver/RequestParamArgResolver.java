package com.spring.annotation.topic13.argsresolver;

import com.spring.annotation.topic13.annotation.CustomRequestParam;
import com.spring.annotation.topic13.annotation.CustomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@CustomService(value = "requestParamArgResolver")
public class RequestParamArgResolver implements ArgumentResolver {

    @Override
    public boolean support(Method method, Class<?> type, int index) {
        // 拿到的是二维数组,参数类型--参数名
        Annotation[][] paramAnnotations = method.getParameterAnnotations();

        // 根据参数下标获取参数
        Annotation[] paramAnnotation = paramAnnotations[index];

        for (Annotation anno:paramAnnotation) {
            // 判断此Class对象是否与传入的Class参数相同
            if (CustomRequestParam.class.isAssignableFrom(anno.getClass())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object argumentResolver(Method method, Class<?> type, int index, HttpServletRequest req, HttpServletResponse resp) {
        // 拿到的是二维数组,参数类型--参数名
        Annotation[][] paramAnnotations = method.getParameterAnnotations();

        // 根据参数下标获取参数
        Annotation[] paramAnnotation = paramAnnotations[index];

        for (Annotation anno:paramAnnotation) {
            // 判断此Class对象是否与传入的Class参数相同
            if (CustomRequestParam.class.isAssignableFrom(anno.getClass())) {

                // 通过获取到的value去请求里获取对应的值
                CustomRequestParam requestParam = (CustomRequestParam) anno;
                String value = requestParam.value();
                return req.getParameter(value);
            }
        }
        return null;
    }
}
