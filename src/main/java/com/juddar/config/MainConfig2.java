package com.juddar.config;

import com.juddar.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig2 {

    /**
     * Scope的取值范围：
     * singleton 单例的 容器启动时即创建该对象，以后用就从IOC容器里拿
     * prototype 多实例的 容器启动时不会创建该对象，使用到该对象时，才会创建该对象，多次使用就多次调用方法，
     * request 同一次请求创建一个对象
     * session 同一个session创建一个对象
     * @return
     *
     * 懒加载：
     *      单例bean默认在容器启动时加载,使用Lazy注解后,只有在第一次使用时才加载　　
     */
//    @Scope("prototype")
    @Lazy
    @Bean(value = "person")
    public Person person1(){
        System.err.println(".sdf...");
        return new Person("zhaosi",28);
    }
}
