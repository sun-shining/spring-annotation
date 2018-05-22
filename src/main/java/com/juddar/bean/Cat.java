package com.juddar.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean{
    public Cat() {
        System.err.println("Cat Constructor...");
    }

    @Override
    public void destroy() throws Exception {
        System.err.println("cat destory...");
    }

    /**
     * 其他属性都赋值完毕后，调用该方法完成指定操作
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("cat ... afterPropertiesSet");
    }
}
