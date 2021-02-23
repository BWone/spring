package com.spring.annotation.topic14.controller;

import com.spring.annotation.topic14.service.Topic14Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Topic14Controller {

    @Autowired
    private Topic14Service topic14Service;

    @RequestMapping(value = "/web")
    @ResponseBody
    public String web(){
        return topic14Service.web();
    }
}
