package com.juddar.config;

import com.juddar.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 使用PropertySource读取外部配置文件中的属性到运行环境中.允许填写多个地址，但多个地址需要分别写清楚，而且不能使用通配符
 * 之前需要在配置文件中添加 <context:property-placeholder location="classpath:xxx"/>
 */
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }
}
