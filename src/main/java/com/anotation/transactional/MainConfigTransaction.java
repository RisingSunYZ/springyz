package com.anotation.transactional;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/12 16:30
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
@Configuration
@ComponentScan(value="com.anotation.transactional")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class MainConfigTransaction {


    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("system");
        dataSource.setPassword("!@#$56789");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://10.10.20.49:3306/test_ysportal");
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        JdbcTemplate JdbcTemplate = new JdbcTemplate();
        JdbcTemplate.setDataSource(dataSource());
        return JdbcTemplate;
    }


    @Bean
    public PlatformTransactionManager dataSourceTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
