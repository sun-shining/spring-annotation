package com.juddar.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MySelector implements ImportSelector{

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        //该方法不能返回null否则会空指针
        return new String[]{"com.juddar.bean.Red"};
    }
}
