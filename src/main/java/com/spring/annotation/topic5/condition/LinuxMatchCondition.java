package com.spring.annotation.topic5.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxMatchCondition implements Condition {

    /**
     * 判断是否是linux系统
     * @param context 判断条件可以使用的上下文(环境)
     * @param metadata 注解的信息
     * @return 是否匹配成功
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取IOC容器正在使用的BeanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 获取当前环境变量(包括操作系统是WIN还是LINUX)
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");

        if (osName.contains("Linux")){
            return true;
        }
        return false;
    }
}
