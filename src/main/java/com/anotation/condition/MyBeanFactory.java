package com.anotation.condition;

import com.anotation.model.Black;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

public class MyBeanFactory implements FactoryBean<Black> {
    @Override
    public Black getObject() throws Exception {
        return new Black();
    }

    @Override
    public Class<?> getObjectType() {
        return Black.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
