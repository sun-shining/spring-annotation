package com.juddar.config;

import com.juddar.bean.Car;
import com.juddar.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bena的生命周期：
 *      指bean创建---初始化---销毁的过程
 *   我们可以自定义初始化和销毁方法，容器在创建该对象的时候会调用我们自己定义的方法
 *
 *   BeanPostProcessor.postProcessBeforeInitialization： 在初始化之前工作
 *   初始化：
 *      对象创建完成，并赋值好，调用初始化方法
 *   BeanPostProcessor.postProcessAfterInitialization;  在初始化之后工作
 *   销毁：
 *      单实例，容器关闭时销毁
 *      多实例，容器不管
 *
 *   1。指定初始化和销毁方法
 *          ---其实就是指定@Bean注解的 init-method和destory-method
 *          初始化，单例是容器创建时已经初始化好了，但是多例的是在第一次使用时才创建
 *          单实例bean是在容器关闭的时候销毁，而多实例的bean容器不会管你的销毁操作
 *   2。让bean实现InitializingBean 完成初始化，实现 DisposableBean 的destory方法实现销毁对象
 *   3。也可以使用 JSR250 定义的两个注解 @PostConstruct  在bean创建完成，属性赋值完成，执行初始化，放在方法上
 *                              和 @PreDestory bean被移除之前，来执行该注解标注的方法
 *   4。 BeanPostProcessor： bean后置处理器
 *          在bean初始化前后做一些处理工作
 *          postProcessBeforeInitialization： 在初始化之前工作
 *          postProcessAfterInitialization：在初始化之后工作
 * 原理：
 * populateBean(beanName, mbd, instanceWrapper); //给对象的属性赋值
 * initializeBean(beanName, exposedObject, mbd); //初始化bean，分三步
 * {
 *    applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName); //调用所有BeanPostProcessor的 before方法
 *    invokeInitMethods(beanName, wrappedBean, mbd); //调用自定义的init方法
 *    applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName); //调用所有BeanPostProcessor的 after方法
 * }
 *
 * Spring底层对 @Link BeanPostProcessor 的使用很广泛，如bean的赋值，注入其他组件：@Autowired @Async
 *
 * 创建对象->postProcessBeforeInitialization->afterPropertiesSet->postProcessAfterInitialization
 */
@ComponentScan("com.juddar.bean")
@Configuration
public class MainConfigLifeCycle {

    //@Scope("prototype")
//    @Bean(initMethod = "init", destroyMethod = "destory")
    @Bean
    public Car car(){
        return new Car();
    }

//    @Bean
//    public Cat cat(){
//        return new Cat();
//    }
}
