package com.basic.springbasic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    MemberRepository memberRepository;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void saveMember(Member member) {
        memberRepository.saveMember(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.getMemberInfo(memberId);
    }
}
