package com.juddar.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    /**
     * @Value 注解
     *  1。可以直接写值
     *  2。可以写SPEL:#{}
     *  3。可以写${}:取出配置文件中的值（在运行的环境变量里的值）
     */
    @Value("lisi")
    private String name;
    @Value("#{20-2}")
    private int age;
    @Value("${person.nickName}")
    private String nickName;

    public Person() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
