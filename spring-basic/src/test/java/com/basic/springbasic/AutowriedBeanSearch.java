package com.basic.springbasic;

import org.apache.catalina.core.ApplicationContext;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

public class AutowriedBeanSearch {

    @Test
    void searchBean(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        String[] beanNames = ac.getBeanDefinitionNames();
        for(String bean : beanNames){
            System.out.println(bean);
        }

    }
}
