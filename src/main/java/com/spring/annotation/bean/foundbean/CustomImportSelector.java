package com.spring.annotation.bean.foundbean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: BWone
 * @Date: 2021/2/1 17:21
 * @Description: 实现ImportSelector接口注入组件
 */
public class CustomImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.spring.annotation.bean.Plant"};
    }
}
