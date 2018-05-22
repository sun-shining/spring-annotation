package com.juddar.test;

import com.juddar.bean.Person;
import com.juddar.config.MainConfigLifeCycle;
import com.juddar.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCPropertySetTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        printBeans(ctx);
        System.err.println("===========");

        Person person = (Person) ctx.getBean("person");
        System.err.println(person);
    }


    public void printBeans(ApplicationContext ctx) {
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names){
            System.err.println(name);
        }
    }
}
