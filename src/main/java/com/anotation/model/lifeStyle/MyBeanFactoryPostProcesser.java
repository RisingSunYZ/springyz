package com.anotation.model.lifeStyle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanFactoryPostProcesser implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        System.out.println("MyBeanFactoryPostProcesser.....................................begin");
        System.out.println(Arrays.asList(beanDefinitionNames));
        System.out.println(configurableListableBeanFactory.getBeanDefinitionCount());
        System.out.println("MyBeanFactoryPostProcesser.....................................end");
    }
}
