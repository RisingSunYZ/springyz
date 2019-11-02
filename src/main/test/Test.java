import com.xml.model.Count;
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

        Person p = (Person)app.getBean("person");
        System.out.println(p);
    }


    @org.junit.Test
    public void testAop(){

        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:application-aop.xml");
        Count p3 = app.getBean(Count.class);
        System.out.println(p3.getClass().getName());
        System.out.println(p3.add(1,3));
        System.out.println(p3.div(1,0));
        System.out.println(p3.mul(1,3));
        System.out.println(p3.sub(1,3));
    }

}
