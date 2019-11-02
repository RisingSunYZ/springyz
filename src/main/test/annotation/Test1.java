package annotation;

import com.anotation.config.MainConfig;
import com.anotation.config.MainConfig2;
import com.anotation.model.Black;
import com.anotation.model.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.prefs.BackingStoreException;

public class Test1 {

    ApplicationContext app = new AnnotationConfigApplicationContext(MainConfig.class);
    ApplicationContext app2 = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test(){
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for(String s:beanDefinitionNames){
            System.out.println(s);
        }
    }


    @Test
    public void test2(){
        String[] beanDefinitionNames = app2.getBeanDefinitionNames();
        for(String s:beanDefinitionNames){
            System.out.println(s);
        }

        Object black = app2.getBean("myBeanFactory");
        Object black2 = app2.getBean("myBeanFactory");
        System.out.println(black.getClass());
        System.out.println(black == black2);

        Object black3 = app2.getBean("&myBeanFactory");
        System.out.println(black3);
    }

    @Test
    public void test3(){


//        Object black = app2.getBean("red");
//        Object black2 = app2.getBean("red");
//        System.out.println(black.getClass());
//        System.out.println(black == black2);

        String[] beanDefinitionNames = app2.getBeanDefinitionNames();
        for(String s:beanDefinitionNames){
            System.out.println(s);
        }



    }

}
