package com.anotation.transactional.aspect;

import com.anotation.transactional.annotation.MyTransaction;
import com.anotation.transactional.util.MyTransactionUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/13 10:31
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
@Component
@Aspect
public class TransactionAspect {

    @Autowired
    private MyTransactionUtil myTransactionUtil;

    @Pointcut("execution(* com.anotation.transactional.sd.TestSdTransactional.addAspect(..))")
    public void transactionPoint(){};

    @Around("transactionPoint()")
    public Object arround(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        try{

            String name = joinPoint.getSignature().getName();
            Method method = joinPoint.getTarget().getClass().getMethod(name);
            MyTransaction annotation = method.getAnnotation(MyTransaction.class);
            String value = annotation.value();
            if(null == annotation){
                System.out.println("============灭有注解");
            }else{
                System.out.println("============有注解");
            }

            myTransactionUtil.begin();
            proceed = joinPoint.proceed();
            myTransactionUtil.commit();
        }catch (Throwable e){
            myTransactionUtil.rollback();
            e.printStackTrace();
        }
        return proceed;
    }

    @Pointcut("@annotation(com.anotation.transactional.annotation.MyTransaction)")
    public void myAnnotation(){};

    @Around("myAnnotation()")
    public Object myAnnotationArround(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        try{
            myTransactionUtil.begin();
            joinPoint.proceed();
            myTransactionUtil.commit();
        }catch (Throwable e){
            myTransactionUtil.rollback();
            e.printStackTrace();
        }
        return proceed;
    }
}
