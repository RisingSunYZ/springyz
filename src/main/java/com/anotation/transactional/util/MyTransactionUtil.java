package com.anotation.transactional.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/12 16:28
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
@Component
public class MyTransactionUtil {


    private static TransactionStatus transaction;

    @Autowired
    private  PlatformTransactionManager dataSourceTransactionManager;

    public  void begin(){
        System.out.println("开启事物===================");
        transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionDefinition());
    }

    public  void commit(){
        System.out.println("提交事物===================");
        dataSourceTransactionManager.commit(transaction);
    }

    public  void rollback(){
        System.out.println("回滚事物===================");
        dataSourceTransactionManager.rollback(transaction);
    }

}
