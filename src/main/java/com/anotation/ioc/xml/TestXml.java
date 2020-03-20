package com.anotation.ioc.xml;


import com.xml.model.Person;

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
