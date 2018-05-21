package com.juddar;

import com.juddar.bean.Person;
import com.juddar.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//        Object person = ctx.getBean("person");
//        System.out.println( person );

        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        Object person = ctx.getBean("person");
        System.err.println(person);

        //查看bean在IOC容器中的名字
        String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
        for (String str : beanNamesForType){
            System.err.println(str);
        }

    }
}
