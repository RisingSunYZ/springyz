package annotation;

import com.anotation.config.MainAutowireConfig;
import com.anotation.controller.StudentController;
import com.anotation.model.MyDataSource;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestAutoWired {

    AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext();

    @Test
    public void test(){

        app.getEnvironment().setActiveProfiles("test");
        app.register(MainAutowireConfig.class);
        app.refresh();

        StudentController bean = app.getBean(StudentController.class);
//        System.out.println(MyDataSource.getName());
        bean.save();

        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String s:
                beanDefinitionNames) {
            System.out.println(s);
        }

    }

}
