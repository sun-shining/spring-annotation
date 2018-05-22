package com.juddar.test;

import com.juddar.bean.Person;
import com.juddar.config.MainConfig;
import com.juddar.config.MainConfig2;
import com.juddar.config.MainConfigOfAutowired;
import com.juddar.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class IOCTest4Autowired {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
//        BookService bookService = (BookService) ctx.getBean("bookService");
//        bookService.print();
//        Object bookDao = ctx.getBean("bookDao2");
//        System.err.println(bookDao);

        printBeans(ctx);
    }



    public void printBeans(ApplicationContext ctx) {
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names){
            System.err.println(name);
        }
    }
}
