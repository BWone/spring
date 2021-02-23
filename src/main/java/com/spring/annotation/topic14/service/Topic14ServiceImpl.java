package com.spring.annotation.topic14.service;

import org.springframework.stereotype.Service;

@Service
public class Topic14ServiceImpl implements Topic14Service {

    @Override
    public String web() {
        return "web............";
    }
}
