package com.xml.BeanProcesser;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PersonBeanProcesser implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {

        System.out.println("postProcessBeforeInitialization....");
        System.out.println(o.toString());
        System.out.println(s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization....");
        System.out.println(o.toString());
        System.out.println(s);
        return o;
    }
}
