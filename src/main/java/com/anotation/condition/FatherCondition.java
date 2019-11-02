package com.anotation.condition;


import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

public class FatherCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        boolean myBeanFactory = registry.containsBeanDefinition("co22m.anotation.model.Blue");
        if(myBeanFactory){
            return true;
        }
        return false;
    }
}
