package com.spring.annotation.topic13.service.impl;

import com.spring.annotation.topic13.annotation.CustomService;
import com.spring.annotation.topic13.service.Topic13Service;

@CustomService(value = "topic13ServiceImpl")
public class Topic13ServiceImpl implements Topic13Service {

    @Override
    public void customAnnotation() {

    }
}
