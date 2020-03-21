package com.anotation.ioc.xml;


import com.xml.model.Person;

/**
 * 简单实现spring xml 解析ioc
 * 实现了 单例 原型 属性赋值 ，但是没有实现除string 类型之外的赋值 以及 ref 引用
 */
public class TestXml {

    public static void main(String[] args) throws Exception{


        YzClassPathXmlApplicationContext app = new YzClassPathXmlApplicationContext("application_xml.xml");

        Person person2 = (Person)app.getBean("person2");
        Person person3 = (Person)app.getBean("person2");
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person2 == person3);


        Person person4 = (Person)app.getBean("person3");
        Person person5 = (Person)app.getBean("person3");
        System.out.println(person4);
        System.out.println(person5);
        System.out.println(person4 == person5);

    }
}
