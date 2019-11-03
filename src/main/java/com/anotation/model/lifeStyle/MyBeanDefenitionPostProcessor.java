package com.anotation.model.lifeStyle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanDefenitionPostProcessor implements BeanDefinitionRegistryPostProcessor {

    //BeanDefinitionRegistry Bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean实例；
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("MyBeanDefenitionPostProcessor====postProcessBeanDefinitionRegistry   "+beanDefinitionRegistry.getBeanDefinitionCount());
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(CarBeanDefinetion.class);
        beanDefinitionRegistry.registerBeanDefinition("MyBeanDefenitionPostProcessorCar",rootBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        System.out.println("MyBeanDefenitionPostProcessor.....................................begin");
        System.out.println(Arrays.asList(beanDefinitionNames));
        System.out.println(configurableListableBeanFactory.getBeanDefinitionCount());
        System.out.println("MyBeanDefenitionPostProcessor.....................................end");
    }
}
