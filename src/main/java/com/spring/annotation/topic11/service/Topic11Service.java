package com.spring.annotation.topic11.service;

import com.spring.annotation.topic11.dao.Topic11Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Topic11Service {
    @Autowired
    private Topic11Dao orderDao;

    @Transactional(rollbackFor = Exception.class)
    public void addOrder(){
        orderDao.insert();
        System.out.println("操作完成 <------");
        int a = 1/0;
    }
}
