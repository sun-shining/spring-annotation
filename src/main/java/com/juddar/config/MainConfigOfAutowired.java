package com.juddar.config;

import com.juddar.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配：
 *      Spring利用DI，完成对IOC容器中各个组件的依赖关系赋值。
 *      @Autowired : 1,默认安装类型去容器中找对应的组件 2,如果找到多个相同类型的组件，再将属性的名称作为id去找
 *      @Qualifier("bookDao") 可以明确指定装配某个类；自动装配，默认一定要将属性赋值好，否则就会报错.如果想在没有的情况不报错，可以使用
 *      @Autowired(required = false) 设置成非必须的
 *      2。@Primary 让Spring在进行自动装配时，默认使用首选的bean，也可以结合 @Qualifier 指定要装配哪个，@Qulifier优先级比@Primary高
 *
 *      @Resource 是java规范的注解,既然是java规范的注解，自然和@Qualifer 不能同时使用，且@Primary不好使
 *      @Inject 是java规范的注解，使用前需要导入包，等价于@Autowired，没有required=false的属性
 *
 *      3。@Autowired 可以标注构造器，方法，类或者参数位置
 *
 *      4.自定义组件想使用SPring内部的类，可以实现xxxAware 接口，注入,参见Red类
 */
@Configuration
@ComponentScan({"com.juddar.service","com.juddar.dao","com.juddar.controller", "com.juddar.bean"})
public class MainConfigOfAutowired {

    @Primary //指定首选的bean
    @Bean(value = "bookDao2")
    public BookDao bookDao2(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
}
