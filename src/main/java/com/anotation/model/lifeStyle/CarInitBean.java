package com.anotation.model.lifeStyle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


@Component
public class CarInitBean implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("CarInitBean destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("CarInitBean int");
    }
}
