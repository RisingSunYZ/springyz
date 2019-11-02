package com.anotation.model.lifeStyle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class CarBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {

        System.out.println(s+"postProcessBeforeInitialization..........");
//        System.out.println(o.toString());
//        System.out.println(s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println(s+"postProcessAfterInitialization..........");
//        System.out.println(o.toString());
//        System.out.println(s);
        return o;
    }
}
