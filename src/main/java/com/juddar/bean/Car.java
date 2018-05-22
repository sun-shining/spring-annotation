package com.juddar.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 实现ApplicationContextAware 接口可以注入ctx对象，都和beanPostProcessor有关
 */
@Component
public class Car implements ApplicationContextAware{

    private ApplicationContext ctx;

    public Car() {
        System.err.println("car constructor...");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.err.println("init method...");
    }

    //容器调用销毁方法之前调用销毁方法
    @PreDestroy
    public void destory(){
        System.err.println("destory method...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
