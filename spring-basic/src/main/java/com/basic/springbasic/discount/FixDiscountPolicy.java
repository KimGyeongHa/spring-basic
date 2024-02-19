package com.basic.springbasic.discount;

import com.basic.springbasic.member.Grade;
import com.basic.springbasic.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FixDiscountPolicy implements DiscountPolicy {
    private static int discount = 2000;
    @Override
    public int discount(Member member, int price) {
        int discountPrice = price;
        if(Grade.VIP == member.getGrade()) discountPrice = discountPrice - discount;

        return discountPrice;
    }
}
