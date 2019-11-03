package annotation;

import com.anotation.config.MainConfigLifeStyle;
import com.anotation.model.lifeStyle.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class TestLifeStyle {

    AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainConfigLifeStyle.class);

    @Test
    public void test(){
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String s:
                beanDefinitionNames) {
            System.out.println(s);
        }

        app.close();
    }

    @Test
    public void testVal(){
        app.publishEvent(new ApplicationEvent(new String("杨钊发布的事件")) {


        });
        Car car = app.getBean(Car.class);
        System.out.println(car);
        app.close();
    }



}
