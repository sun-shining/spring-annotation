package com.juddar.test;

import com.juddar.config.MainConfigLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCLifeCycleTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
        System.err.println("容器创建完成。。。");
        //关闭容器，调用销毁方法
        ctx.close();
    }
}
