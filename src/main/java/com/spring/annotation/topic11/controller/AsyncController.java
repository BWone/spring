package com.spring.annotation.topic11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

@Controller
public class AsyncController {

    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedQueue<>();

    @RequestMapping(value = "/async01")
    @ResponseBody
    public Callable<String> async01(){
        System.out.println("主线程开始" + Thread.currentThread() + "----" + System.currentTimeMillis());
        Callable<String> callable = () -> {
            System.out.println("副线程开始" + Thread.currentThread() + "----" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("副线程结束" + Thread.currentThread() + "----" + System.currentTimeMillis());
            return "successful";
        };
        System.out.println("主线程结束" + Thread.currentThread() + "----" + System.currentTimeMillis());
        return callable;
    }

    /**
     * 模仿消息中间件异步返回数据
     * 访问addAsync02接口后,如果在5秒内没有去访问getAsync02接口,并调用setResult返回数据,就返回fail
     * 写两个接口的目的是模仿两个线程,其实也可以在一个接口中启动多线程进行操作
     * @return UUID
     */
    @RequestMapping(value = "/addAsync02")
    @ResponseBody
    public DeferredResult<Object> addAsync02(){
        DeferredResult<Object> result = new DeferredResult<>((long) 5000, "fail");
        add(result);
        return result;
    }

    @RequestMapping(value = "/getAsync02")
    @ResponseBody
    public String getAsync02(){
        String uuid = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = get();
        deferredResult.setResult(uuid);
        return "获取队列" + uuid;
    }

    /**
     * 往队列中添加
     */
    public static void add(DeferredResult<Object> deferredResult){
        queue.add(deferredResult);
    }

    /**
     * 获取队列
     */
    public static DeferredResult<Object> get(){
        return queue.poll();
    }
}
