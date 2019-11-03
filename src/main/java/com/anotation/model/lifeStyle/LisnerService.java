package com.anotation.model.lifeStyle;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class LisnerService {

    @EventListener(classes = ApplicationEvent.class)
    public void receive(ApplicationEvent event){
        System.out.println("LisnerService 。。。。"+event);
    }
}
