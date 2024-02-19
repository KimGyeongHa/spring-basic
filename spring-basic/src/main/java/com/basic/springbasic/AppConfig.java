package com.basic.springbasic;

import com.basic.springbasic.discount.DiscountPolicy;
import com.basic.springbasic.discount.FixDiscountPolicy;
import com.basic.springbasic.member.MemberRepository;
import com.basic.springbasic.member.MemberService;
import com.basic.springbasic.member.MemberServiceImpl;
import com.basic.springbasic.member.MemoryMemberRepository;
import com.basic.springbasic.store.AppRepository;
import com.basic.springbasic.store.AppService;
import com.basic.springbasic.store.AppServiceImpl;
import com.basic.springbasic.store.MemoryAppRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memoryMemberRepository());
    }
    @Bean
    public MemberRepository memoryMemberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
    @Bean
    public AppService appService(){
        return new AppServiceImpl(appRepository(),discountPolicy());
    }
    @Bean
    public AppRepository appRepository(){
        return new MemoryAppRepository();
    }

}*/
