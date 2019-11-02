import com.xml.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2019/10/22 15:02
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    @org.junit.Test
    public void test(){

        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:application.xml");
//        Person p = (Person)app.getBean("person");
//        Car c = (Car)app.getBean("car");
//        Person p1 = (Person)app.getBean("person");
//        System.out.println(p == p1);
//        System.out.println(p);
//        System.out.println(c);

        Person p3 = app.getBean(Person.class);
        System.out.println(p3);
    }
}
