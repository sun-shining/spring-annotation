package com.juddar.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MacCondition implements Condition{

    /**
     *
     * @param context  判断条件能使用的上下文环境
     * @param metadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        BeanDefinitionRegistry registry = context.getRegistry();
        ClassLoader classLoader = context.getClassLoader();
        Environment environment = context.getEnvironment();

        if ("Mac OS X".equals(environment.getProperty("os.name")) ) {
            return true;
        }
        return false;
    }
}
