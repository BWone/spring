package com.spring.annotation.topic9.service;

import com.spring.annotation.topic9.dao.Topic9Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Topic9Service {

    @Autowired
    @Qualifier(value = "topic9Dao2")
    private Topic9Dao topic9Dao;

    public void topic9(){
        System.out.println(topic9Dao);
    }
}
