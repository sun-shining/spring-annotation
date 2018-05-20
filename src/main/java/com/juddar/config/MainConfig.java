package com.juddar.config;

import com.juddar.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 配置类相当与以前的配置文件
 */
@Configuration//告诉spring这是一个配置类
@ComponentScan(value ="com.juddar", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Service.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
},useDefaultFilters = false)
// @ComponentScan 相当与以前配置文件里的包扫描,可以指定要扫描的包
// excludeFilters 排除指定包或者类
// excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
// 以注解的形式排出，排除带Controller和Service的注解
// includeFilters
// @Repeatable 标识这个注解是一个可以写好几个指定注解的注解
//FilterType ASSIGNABLE_TYPE 按指定类型加载
//FilterType CUSTOM 按指定类型加载,自定义的规则需要实现TypeFilter接口
public class MainConfig {

    //给容器注册一个bean；类型为返回值类型，id默认是将方法名作为id，
    // 如果getbean时传入参数与方法名不一致，会报NoSuchBeanDefinitionException异常
    //value属性也可以为bean起id的名字
    @Bean(value = "person")
    public Person person1(){
        return new Person("lisi",20);
    }

}
