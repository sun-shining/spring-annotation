package com.juddar.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color>{
    //返回一个color对象，这个对象会被添加到容器里
    @Override
    public Color getObject() throws Exception {
        System.err.println("Color Object created...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //true 表示这个bean是单实例，每次获取都创建一个新的
    @Override
    public boolean isSingleton() {
        return false;
    }
}
