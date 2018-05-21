package com.juddar.test;

import com.juddar.bean.Person;
import com.juddar.config.MainConfig;
import com.juddar.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

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
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
        //@Scope("prototype") 时，下方两个值不相当
        Object person = ctx.getBean("person");
//        Object person2 = ctx.getBean("person");
//        System.err.println(person == person2);
    }

    ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test03(){
        String[] forType = ctx.getBeanNamesForType(Person.class);
        for (String str : forType){
            System.err.println(str);
        }
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        Map<String, Person> beansOfType = ctx.getBeansOfType(Person.class);
        System.err.println(beansOfType);
//        Environment environment = ctx.getEnvironment();
//        String property = environment.getProperty("os.name");
//        System.err.println(property);
    }

    @Test
    public void test04(){
        printBeans(ctx);
    }

    public void printBeans(ApplicationContext ctx) {
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names){
            System.err.println(name);
        }
    }
}
