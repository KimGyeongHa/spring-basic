package com.basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class PrototypeBean {

    @Test
    void beanSearch(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Prototype.class);

        String[] aa = ac.getBeanDefinitionNames();
        for(String a : aa){
            System.out.println(a);
        }

        Prototype prototype1 = ac.getBean(Prototype.class);
        Prototype prototype2 = ac.getBean(Prototype.class);

        System.out.println(prototype1);
        System.out.println(prototype2);


        assertThat(prototype1).isNotSameAs(prototype2);

    }


    @Scope("prototype")
    static class Prototype{

        @PostConstruct
        public void init(){
            System.out.println("init");
        }

        @PreDestroy
        public void close(){
            System.out.println("close");
        }


    }
}
