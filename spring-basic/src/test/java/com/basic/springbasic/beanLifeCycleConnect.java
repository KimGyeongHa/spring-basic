package com.basic.springbasic;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class beanLifeCycleConnect {

    @Test
    void connectTest(){
       AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(beanConfig.class);

       ac.close();

       try(beanConfig beanConfig = new beanConfig()) {

       }catch (Exception e){

       }
    }

    @Configuration
    static class beanConfig implements AutoCloseable {
        @Bean(initMethod = "connect")
        public BeanLifeCycle beanLifeCycle(){
            BeanLifeCycle beanLifeCycle = new BeanLifeCycle();
            beanLifeCycle.setUrl("www.naver.com");
            return beanLifeCycle;
        }

        @Override
        public void close() throws Exception {

        }
    }



}
