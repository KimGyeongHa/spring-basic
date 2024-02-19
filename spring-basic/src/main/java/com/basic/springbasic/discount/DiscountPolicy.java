package com.basic.springbasic.discount;

import com.basic.springbasic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
