package com.anotation.transactional.sd;

import com.anotation.transactional.annotation.MyTransaction;
import com.anotation.transactional.util.MyTransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/12 16:27
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
@Service
public class TestSdTransactional {

    @Autowired
    private  JdbcTemplate jdbcTemplate;

    @Autowired
    private  MyTransactionUtil myTransactionUtil;

    @Autowired
    private LogService logService;

    @Transactional(propagation = Propagation.REQUIRED)
    public  void addSpring(){
        logService.logAdd();
        jdbcTemplate.execute("INSERT INTO `test_ysportal`.`tbl_test`(`id`, `name`) VALUES ('1', '1');\n");
        int a = 1/0;
    }


//    @Transactional
    public  void add(){
        myTransactionUtil.begin();
        try{
            jdbcTemplate.execute("INSERT INTO `test_ysportal`.`tbl_test`(`id`, `name`) VALUES ('1', '1');\n");
//            int a =  1/0;
            myTransactionUtil.commit();
        }catch (Exception e){
            myTransactionUtil.rollback();
            e.printStackTrace();
        }

    }

    @MyTransaction("llalala")
    public  void addAspect(){
            jdbcTemplate.execute("INSERT INTO `test_ysportal`.`tbl_test`(`id`, `name`) VALUES ('1', '1');\n");
//            int a =  1/0;
    }

    @MyTransaction
    public  void addAnnotation(){
        jdbcTemplate.execute("INSERT INTO `test_ysportal`.`tbl_test`(`id`, `name`) VALUES ('1', '1');\n");
//            int a =  1/0;
    }
}
