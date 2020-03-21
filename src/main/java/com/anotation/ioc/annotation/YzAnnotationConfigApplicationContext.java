package com.anotation.ioc.annotation;

import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class YzAnnotationConfigApplicationContext {

    private Class clazz;

    private ConcurrentHashMap<String,Object> app;
    private ConcurrentHashMap<String,String> modifyMap;
    private InputStream resourceAsStream = null;
    private Properties properties = null;


    {
        app = new ConcurrentHashMap<>();
        modifyMap = new ConcurrentHashMap<>();
    }

    private void initProperties() throws Exception{
        YzPropertySource annotation = (YzPropertySource)clazz.getAnnotation(YzPropertySource.class);
        if(null != annotation){
            String value = annotation.value();
            resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(value);
            properties = new Properties();
            properties.load(resourceAsStream);
        }
    }


    public Object getBean(String beanName) throws Exception{
        if(StringUtils.isBlank(beanName)){
            throw new Exception("beanName 不能为null");
        }
        Object o = app.get(beanName);
        if(null == o){
            return getPrototypeObj(beanName);
        }
        return o;
    }

    private Object getPrototypeObj(String beanName) throws Exception{
        String classzz = "";
        for(Map.Entry<String,String> entry:modifyMap.entrySet()){
            if(StringUtils.equals(beanName,entry.getValue())){
                classzz = entry.getKey();
            }
        }
        if(StringUtils.isBlank(classzz)){
            throw new Exception("class not found");
        }

        Class<?> aClass = Class.forName(classzz);
        return getObject(aClass);
    }

    private Object getObject(Class<?> aClass) throws ClassNotFoundException, InstantiationException, Exception {
        String beanId = class2BeanId(aClass);
        initBean(beanId,aClass.getName());
        Object object = app.get(beanId);
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field field:declaredFields){
            YzResource YzResource = (YzResource)field.getAnnotation(YzResource.class);
            if(null != YzResource){
                String name1 = YzResource.name();
                Object o = app.get(name1);
                if(null == o){
                    String name = field.getName();
                    o = app.get(name);
                    if(null == o){
                        //说明这个bean也是原型的
                        Class<?> type = field.getType();
                        Object object1 = getObject(type);
                        field.setAccessible(true);
                        field.set(object,object1);
                    }else{
                        field.setAccessible(true);
                        field.set(object,o);
                    }
                }else{
                    field.setAccessible(true);
                    field.set(object,o);
                }
            }


            YzValue YzValue = (YzValue)field.getAnnotation(YzValue.class);
            if(null != YzValue){
                String value = YzValue.value();

                if(value.contains("$")){
                    String key = value.replace("$", "")
                            .replace("{", "")
                            .replace("}", "");
                    value = (String)properties.get(key);
                }
                field.setAccessible(true);
                field.set(object,value);
            }
        }
        return object;
    }

    private String class2BeanId(Class aClass){
        YzService annotation1 = (YzService)aClass.getAnnotation(YzService.class);
        String beanId = annotation1.value();
        if(StringUtils.isBlank(beanId)){
            String[] split = aClass.getName().split("\\.");
            beanId = split[split.length - 1];
        }
        return beanId;
    }


    public YzAnnotationConfigApplicationContext(Class clazz) throws Exception{
        this.clazz = clazz;
        initProperties();
        init();


    }

    void init() throws Exception{
        YzComponentScan annotation = (YzComponentScan)clazz.getAnnotation(YzComponentScan.class);
        if(null == annotation){
            throw new Exception("启动类上没有扫包注解");
        }
        String basepackage = annotation.value();

        Set<Class<?>> classes = ClassUtils.getClasses(basepackage);
        Set<Class<?>> myClass = new HashSet<>();
        for(Class zz:classes){
            YzService annotation1 = (YzService)zz.getAnnotation(YzService.class);
            if(null != annotation1){
                myClass.add(zz);
            }
        }
        firstInit(myClass);
        lastInit(myClass);

    }


    void lastInit(Set<Class<?>> myClass) throws Exception{
        for(Class zz:myClass){
            YzService annotation1 = (YzService)zz.getAnnotation(YzService.class);
            if(StringUtils.equals("single",annotation1.scope())){
                Field[] declaredFields = zz.getDeclaredFields();
                String s = modifyMap.get(zz.getName());
                Object o1 = app.get(s);
                for(Field field:declaredFields){
                    YzResource YzResource = (YzResource)field.getAnnotation(YzResource.class);
                    if(null != YzResource){
                        String name1 = YzResource.name();
                        Object o = app.get(name1);
                        if(null == o){
                            String name = field.getName();
                            o = app.get(name);
                            if(null == o){
                                throw new Exception(zz.getName()+"   "+field.getName()+"  not found");
                            }
                        }
                        field.setAccessible(true);
                        field.set(o1,o);
                    }

                    YzValue YzValue = (YzValue)field.getAnnotation(YzValue.class);
                    if(null != YzValue){
                        String value = YzValue.value();
                        field.setAccessible(true);

                        if(value.contains("$")){
                            String key = value.replace("$", "")
                                    .replace("{", "")
                                    .replace("}", "");
                            value = (String)properties.get(key);
                        }

                        field.set(o1,value);
                    }

                }
            }

        }
    }

    void firstInit(Set<Class<?>> myClass) throws Exception{
        for(Class zz:myClass){
            YzService annotation1 = (YzService)zz.getAnnotation(YzService.class);
            String beanId = class2BeanId(zz);
            modifyMap.put(zz.getName(),beanId);
            if(StringUtils.equals("single",annotation1.scope())){
                initBean(beanId,zz.getName());
            }

        }
    }

    void initBean(String beanId,String className) throws Exception{
        Object o = getObject(className);
        app.put(beanId,o);
    }

    private Object getObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName(className);
        return aClass.newInstance();
    }

}
