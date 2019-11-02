package com.anotation.condition;

import com.anotation.model.BlueSon;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanImportRegistor implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean b = beanDefinitionRegistry.containsBeanDefinition("com.anotation.model.Blue");
        if(b){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(BlueSon.class);
            beanDefinitionRegistry.registerBeanDefinition("son",rootBeanDefinition);
        }
    }
}
