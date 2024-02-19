package com.basic.springbasic;

import com.basic.springbasic.discount.DiscountPolicy;
import com.basic.springbasic.discount.FixDiscountPolicy;
import com.basic.springbasic.discount.SubDiscountPolicy;
import com.basic.springbasic.member.Grade;
import com.basic.springbasic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AsociateBeanTest {

    @Test
    void AsociateAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);

        int subDiscountVal = discountService.findMatchDiscount(
                new Member(1L,"김경하",Grade.VIP),50000,"subDiscountPolicy");

        int fixDiscountVal = discountService.findMatchDiscount(
                new Member(1L,"하경김",Grade.Basic),50000,"fixDiscountPolicy");

        assertThat(ac.getBean("subDiscountPolicy")).isInstanceOf(DiscountPolicy.class);
        assertThat(ac.getBean("fixDiscountPolicy")).isInstanceOf(DiscountPolicy.class);
    }

    static class DiscountService{

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;
        }

        public int findMatchDiscount(Member member, int price, String policyCode){
            return policyMap.get(policyCode).discount(member,price);
        }

    }



}
