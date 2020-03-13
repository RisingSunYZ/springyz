package com.anotation.transactional.aspect;

import com.anotation.transactional.util.MyTransactionUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            myTransactionUtil.begin();
            proceed = joinPoint.proceed();
            myTransactionUtil.commit();
        }catch (Throwable e){
            myTransactionUtil.rollback();
            e.printStackTrace();
        }
        return proceed;
    }
}
