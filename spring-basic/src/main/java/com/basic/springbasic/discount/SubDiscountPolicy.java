package com.basic.springbasic.discount;

import com.basic.springbasic.annotation.MainDiscountPolicy;
import com.basic.springbasic.member.Grade;
import com.basic.springbasic.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class SubDiscountPolicy implements DiscountPolicy {

    private static int discount = 1000;
    @Override
    public int discount(Member member, int price) {
        int discountPrice = price;
        if(Grade.VIP == member.getGrade()) discountPrice = discountPrice - discount;

        return discountPrice;
    }
}
