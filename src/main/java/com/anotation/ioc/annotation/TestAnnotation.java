package com.anotation.ioc.annotation;

/**
 * 注解简单实现ioc
 * 1. 支持 原型注入原型，原型注入单例，单例注入单例，不支持，单例注入原型
 */
public class TestAnnotation {

    public static void main(String[] args) throws Exception{

        YzAnnotationConfigApplicationContext app = new YzAnnotationConfigApplicationContext(MainClass.class);
        StudentService StudentService = (StudentService)app.getBean("studentSer");
        StudentDao StudentDao = (StudentDao)app.getBean("StudentDao");
        System.out.println(StudentDao);
        StudentService StudentService2 = (StudentService)app.getBean("studentSer");
        StudentService StudentService3 = (StudentService)app.getBean("studentSer");
        StudentService StudentService4 = (StudentService)app.getBean("studentSer");
        System.out.println(StudentService);
        StudentService.syaHellow("yangzhao");



    }
}
