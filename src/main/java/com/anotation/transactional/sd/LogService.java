package com.anotation.transactional.sd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/13 13:42
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
@Service
public class LogService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void logAdd(){
        jdbcTemplate.execute("INSERT INTO `test_ysportal`.`tbl_log`(`name`, `classname`) VALUES ('1', '122');");
    }
}
