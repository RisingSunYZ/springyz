package com.anotation.model.lifeStyle;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class CarAnotation implements ApplicationContextAware {

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("CarAnotation destory");
    }


    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("CarAnotation int");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }
}
