package com.basic.springbasic;

import com.basic.springbasic.member.Member;
import com.basic.springbasic.member.MemberService;
import com.basic.springbasic.member.MemberServiceImpl;
import com.basic.springbasic.member.MemoryMemberRepository;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
public class BeanSerach {

    @Test
    public void searchBean(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for(String bean : beanNames){
            System.out.println(bean);
        }
    }

    @Test
    void getBean(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(setCustomBean.class);
        MemberService memberService = ac.getBean("Bean1",MemberService.class);

        Member member = memberService.findMember(1L);
        System.out.println(member);
    }
    @Configuration
    static class setCustomBean{
        @Bean
        public MemberService Bean1(){
            return new MemberServiceImpl(new MemoryMemberRepository());
        }
        @Bean
        public MemberService Bean2(){
            return new MemberServiceImpl(new MemoryMemberRepository());
        }
    }



}
