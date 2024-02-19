package com.basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

public class scopeTest {


    @Test
    void singletonScope(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Singleton.class);

        Singleton singleton = ac.getBean(Singleton.class);
        Singleton singleton2 = ac.getBean(Singleton.class);


        System.out.println(singleton.getClass());
        System.out.println(singleton2.getClass());

        ac.close();
    }

    @Scope("singleton")
    static class Singleton{

        @PostConstruct
        public void init(){
            System.out.println("singleton init");
        }

        @PreDestroy
        public void close(){
            System.out.println("singleton close");
        }


    }


}
