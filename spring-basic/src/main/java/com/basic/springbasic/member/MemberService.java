package com.basic.springbasic.member;

public interface MemberService {
    void saveMember(Member member);
    Member findMember(Long memberId);
}
