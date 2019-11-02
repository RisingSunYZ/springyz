package com.anotation.config;


import com.anotation.filter.MyFilter;
import com.anotation.model.Student;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScans({
        @ComponentScan(value = "com.anotation",includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Repository.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyFilter.class})
        },excludeFilters = {
                @ComponentScan.Filter(classes = Controller.class)
        },useDefaultFilters = false)
})

//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则

public class MainConfig {


    @Bean("student2")
    public Student student(){
        return new Student();
    }
}
