package com.anotation.ioc.xml;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class YzClassPathXmlApplicationContext {


    private String path;

    private static final String PREX_METHOD = "set";


    private ConcurrentHashMap<String,Object> app = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,String> modifyMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,ConcurrentHashMap<String,String>> porpularMap = new ConcurrentHashMap<>();

    public YzClassPathXmlApplicationContext(String path) throws Exception{
        this.path = path;
        parseXml(path);
    }


    public Object getBean(String beanName) throws Exception{
        if(StringUtils.isBlank(beanName)){
            throw new Exception("beanName 不能为null");
        }
        Object o = app.get(beanName);
        if(null == o){
            String s = modifyMap.get(beanName);
            Object object = getObject(s);
            popularBean(beanName, object);
            return object;
        }
        return o;
    }

    void initBean(String beanId,String className) throws Exception{
        Object o = getObject(className);
        app.put(beanId,o);
    }

    private Object getObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName(className);
        return aClass.newInstance();
    }

    void popularBean(String beanId,Object o) throws Exception{
        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = porpularMap.get(beanId);
        for(Map.Entry<String,String> entry:stringStringConcurrentHashMap.entrySet()){
            String key = entry.getKey();
            String val = entry.getValue();
            String s1 = key2method(key);
            Method method = o.getClass().getDeclaredMethod(s1,String.class);
            method.setAccessible(true);
            method.invoke(o,val);
        }
    }

    private String key2method(String key){
        String c = key.substring(0,1);
        return  PREX_METHOD+c.toUpperCase()+key.substring(1);
    }


    void parseXml(String path) throws Exception {
        SAXReader saxReader = new SAXReader();
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(path);
        Document read = saxReader.read(resourceAsStream);
        Element rootElement = read.getRootElement();
        Iterator iterator = rootElement.elementIterator("bean");
        while (iterator.hasNext()){
            Element next = (Element)iterator.next();
            String className = next.attributeValue("class");
            String beanId = next.attributeValue("id");
            String singleton = next.attributeValue("scope");

            modifyMap.put(beanId,className);

            Iterator property = next.elementIterator("property");
            ConcurrentHashMap<String,String> popularMapTemp = new ConcurrentHashMap<>();
            while(property.hasNext()){
                Element next1 = (Element)property.next();
                String name = next1.attributeValue("name");
                String value = next1.attributeValue("value");
                popularMapTemp.put(name,value);
            }
            porpularMap.put(beanId,popularMapTemp);

            if(StringUtils.isBlank(className)){
                throw new Exception("class 不能为null");
            }

            if(StringUtils.isBlank(beanId)){
                throw new Exception("id 不能为null");
            }

            if(StringUtils.equals("singleton",singleton)){
                initBean(beanId,className);
                popularBean(beanId,app.get(beanId));
            }

        }

    }

}
