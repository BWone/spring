package com.spring.annotation.topic10.aop;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Author: BWone
 * @Date: 2021/2/4 9:48
 * @Description: 切面类
 */
@Aspect
public class Aspects {

    @Pointcut(value = "execution(* com.spring.annotation.topic10.aop.Calculator.*(..))")
    public void pointCut(){

    }

    /**
     * 切入表达式：指定方法返回值 / 在哪个包下的哪个方法 / 传入参数
     */
    @Before(value = "pointCut()")
    public void aspectStart(JoinPoint joinPoint){
        System.out.println("运行开始 <------ 方法名是：" + joinPoint.getSignature().getName() + "    参数列表是：" + Arrays.toString(joinPoint.getArgs()));
    }

    @After(value = "pointCut()")
    public void aspectEnd(){
        System.out.println("运行结束 <------");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void aspectReturn(Object result){
        System.out.println("运行正常返回 <------ 返回结果是：" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void aspectException(Exception exception){
        System.out.println("运行异常 <------ 异常信息是：" + exception);
    }

    @SneakyThrows
    @Around(value = "pointCut()")
    public Object  aspectRound(ProceedingJoinPoint joinPoint){
        System.out.println("环绕运行之前 <------");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕运行之后 <------");
        return proceed;
    }



}
