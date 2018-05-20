package com.juddar.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("os.name");
        boolean person = context.getRegistry().containsBeanDefinition("person");
        if (property.contains("Linux") || person){
            return true;
        }
        return false;
    }
}
