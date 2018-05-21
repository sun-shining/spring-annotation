package com.juddar.config;

import com.juddar.bean.Blue;
import com.juddar.bean.Person;
import com.juddar.condition.LinuxCondition;
import com.juddar.condition.MacCondition;
import com.juddar.condition.MySelector;
import com.juddar.condition.MySelector2;
import org.springframework.context.annotation.*;

@Configuration
@Import({Blue.class, MySelector.class, MySelector2.class})
//@Conditional(value = {LinuxCondition.class})  该注解也可以仍在类上，对整个类进行条件加载
public class MainConfig2 {

    /**
     * Scope的取值范围：
     * singleton 单例的 容器启动时即创建该对象，以后用就从IOC容器里拿
     * prototype 多实例的 容器启动时不会创建该对象，使用到该对象时，才会创建该对象，多次使用就多次调用方法，
     * request 同一次请求创建一个对象
     * session 同一个session创建一个对象
     * @return
     *
     * 懒加载：
     *      单例bean默认在容器启动时加载,使用Lazy注解后,只有在第一次使用时才加载　　
     */
//    @Scope("prototype")
    @Lazy
    @Bean(value = "person")
    public Person person1(){
        System.err.println(".sdf...");
        return new Person("zhaosi",28);
    }

    /**
     *  @Conditional: 按照一定的条件进行判断 满足条件给容器中注册bean
     *  如果系统是Windows注册bill，如果是linux则注册linux
     */
    @Conditional(value = {MacCondition.class})
    @Bean("qiaobs")
    public Person person01(){
        return new Person("qiaobs", 62);
    }

    @Conditional(value = {LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linux", 45);
    }

    /**
     * 给容器中注册组件的方式：
     * 1.包扫描+组件标注注解{包扫描/@Service/@Controller/@Repository/@Component}--自己写的类的时候用
     * 2.@Bean ---导入第三方包里的组件
     * 3.@Import--- 快速给容器导入一个组件，
     *      1.id默认是组件的全类名，可以加在类上。
     *      2.ImportSelector ：返回导入组件的全类名 继承该接口，将需要注入的bean的全类名返回即可
     *      3.ImportBeanDefinitionRegistrar : 实现该接口，手动注册bean到容器中
     */
}
