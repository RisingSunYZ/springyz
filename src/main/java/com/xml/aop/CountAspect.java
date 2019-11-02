package com.xml.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Aspect
@Component
public class CountAspect {

    @Pointcut("execution(* com.xml.model.ICount.*(..))")
    private void pointCut(){};

    @Before("execution(* com.xml.model.Count.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("方法"+joinPoint.getSignature().getName()+"开始,参数是"+ Arrays.asList(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("方法"+joinPoint.getSignature().getName()+"结束,参数是"+ Arrays.asList(joinPoint.getArgs()));
    }


    @AfterReturning(returning="result",value = "pointCut()")
    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println("方法"+joinPoint.getSignature().getName()+"结束,结果是"+ result);
    }

    @AfterThrowing(throwing="e",value = "pointCut()")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        System.out.println("方法"+joinPoint.getSignature().getName()+"结束,异常是"+ e);
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Around方法"+proceedingJoinPoint.getSignature().getName()+"开始,参数是"+ proceedingJoinPoint.getArgs());
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
            System.out.println("Around方法"+proceedingJoinPoint.getSignature().getName()+"结果是"+ proceed);
        } catch (Throwable throwable) {
            System.out.println("Around方法"+proceedingJoinPoint.getSignature().getName()+"异常,异常是"+ throwable);
            throw new RuntimeException(throwable);
        }
        System.out.println("Around方法"+proceedingJoinPoint.getSignature().getName()+"结束");
        return proceed;
    }


}
