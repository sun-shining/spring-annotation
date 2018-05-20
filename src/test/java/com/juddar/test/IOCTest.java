package com.juddar.test;

import com.juddar.config.MainConfig;
import com.juddar.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
//        String[] names = ctx.getBeanDefinitionNames();
//        for(String str: names) {
//            System.err.println(str);
//        }
        Object person = ctx.getBean("person");
        Object person2 = ctx.getBean("person");
        System.err.println(person == person2);//两次调用返回同一个对象，说明一个对象在IOC容器里是单例的
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
        //@Scope("prototype") 时，下方两个值不相当
        Object person = ctx.getBean("person");
//        Object person2 = ctx.getBean("person");
//        System.err.println(person == person2);
    }
}
