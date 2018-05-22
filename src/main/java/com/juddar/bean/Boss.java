package com.juddar.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//默认加在IOC容器中的组件，容器启动会调用无参构造器创建对象，在进行初始化赋值等操作
@Component
public class Boss {

    private Car car;

//    @Autowired //car也是在容器中获取的
    public Boss(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    @Autowired //标注在方法上，Spring会调用当前方法，完成赋值，方法使用的参数，自定义类型的值从IOC容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
