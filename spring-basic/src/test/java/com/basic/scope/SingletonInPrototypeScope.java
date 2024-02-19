package com.basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.Annotation;

public class SingletonInPrototypeScope {

    @Test
    void countTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Singleton.class,Prototype.class);
        Singleton singleton1 = ac.getBean(Singleton.class);
        Singleton singleton2 = ac.getBean(Singleton.class);

        Assertions.assertThat(singleton1.prototypeCount()).isEqualTo(singleton2.prototypeCount());
    }

    @Scope("singleton")
    static class Singleton{
        @Autowired
        private ObjectProvider<Prototype> prototypeProvider;

        public int prototypeCount(){
            Prototype provider = prototypeProvider.getObject();
            provider.count();
            return provider.getCnt();
        }
        @PostConstruct
        void init(){
            System.out.println("singleton init");
        }
        @PreDestroy
        void close(){
            System.out.println("singleton close");
        }
    }

    @Scope("prototype")
    static class Prototype{
        int cnt = 0;

        @PostConstruct
        void init(){
            System.out.println("prototype init");
        }
        @PreDestroy
        void close(){
            System.out.println("prototype close");
        }

        public int count(){
            return ++cnt;
        }

        public int getCnt() {
            return cnt;
        }
    }
}
