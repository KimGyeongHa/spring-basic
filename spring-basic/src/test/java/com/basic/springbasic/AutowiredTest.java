package com.basic.springbasic;

import com.basic.springbasic.member.Member;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowriedOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(config.class);

    }

    static class config{
@Qualifier
        @Autowired(required = false)
        public void getBean1(Member member){
            System.out.println("1번 빈 출력 : " + member);
        }

        @Autowired
        public void getBean2(@Nullable Member member){
            System.out.println("2번 빈 출력 : " + member);
        }

        @Autowired
        public void getBean3(Optional<Member> member){
            System.out.println("3번 빈 출력 : " + member);
        }

    }

}
