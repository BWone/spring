package com.spring.annotation.topic13.controller;

import com.spring.annotation.topic13.annotation.CustomController;
import com.spring.annotation.topic13.annotation.CustomQualifier;
import com.spring.annotation.topic13.annotation.CustomRequestMapping;
import com.spring.annotation.topic13.annotation.CustomRequestParam;
import com.spring.annotation.topic13.service.Topic13Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@CustomController
@CustomRequestMapping(value = "/topic13")
public class Topic13Controller {

    @CustomQualifier(value = "topic13ServiceImpl")
    private Topic13Service topic13Service;

    @CustomRequestMapping(value = "/customAnno")
    public void customAnnotation(@CustomRequestParam(value = "name") String name, HttpServletRequest rep, HttpServletResponse reps){
        System.out.println("name：" + name);
        try {
            PrintWriter writer = reps.getWriter();
            writer.write(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
