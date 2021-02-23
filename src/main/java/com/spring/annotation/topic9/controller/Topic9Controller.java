package com.spring.annotation.topic9.controller;

import com.spring.annotation.topic9.service.Topic9Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Topic9Controller {

    @Autowired
    private Topic9Service topic9Service;
}
