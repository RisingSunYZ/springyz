package com.anotation.ioc.annotation;

@YzService()
public class StudentDao {


    @YzValue("test")
    private String name;


    public StudentDao() {
        System.out.println("StudentDao init....................");
    }

    public void syaHellow(String name){
        System.out.println(name + "hello World!!!");
    }


    @Override
    public String toString() {
        return "StudentDao{" +
                "name='" + name + '\'' +
                '}';
    }
}
