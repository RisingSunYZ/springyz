package com.xml.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Order(1)
@Aspect
@Component
public class ValidateAspect {

    @Before("execution(public int com.xml.model.ICount.*(..))")
    public void validateParam(JoinPoint joinPoint){
        System.out.println("校验参数...............");
        List<Object> objects = Arrays.asList(joinPoint.getArgs());
        if(null !=objects){
            if(objects.get(1).equals(0)){
                throw new RuntimeException("除数不能为0");
            }
        }
    }

}
