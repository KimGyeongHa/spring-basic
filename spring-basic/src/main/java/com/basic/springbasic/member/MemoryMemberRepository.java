package com.basic.springbasic.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository{

    Map<Long,Member> store = new HashMap<>();
    @Override
    public void saveMember(Member member) {
        store.put(member.getMemberId(),member);
    }

    @Override
    public Member getMemberInfo(Long id) {
        return store.get(id);
    }
}
