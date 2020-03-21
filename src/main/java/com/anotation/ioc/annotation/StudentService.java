package com.anotation.ioc.annotation;

@YzService(value = "studentSer",scope = "prototype")
public class StudentService {


    @YzValue("${name}")
    private String name;

    public StudentService() {
        System.out.println("StudentService init ....................");
    }

    @YzResource(name="StudentDao")
    private StudentDao studentDao;

    public void syaHellow(String name){
        studentDao.syaHellow(name);
    }


    @Override
    public String toString() {
        return "StudentService{" +
                "name='" + name + '\'' +
                ", studentDao=" + studentDao +
                '}';
    }
}
