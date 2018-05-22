package com.juddar.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 将后置处理器加入容器中，在初始化前后做一些工作
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("postProcessBeforeInitialization..." + beanName + " =>" +bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("postProcessAfterInitialization..." + beanName + " =>" +bean);
        return bean;
    }
}
