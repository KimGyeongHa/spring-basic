package com.basic.springbasic.member;

import java.util.Map;

public interface MemberRepository {
    void saveMember(Member member);
    Member getMemberInfo(Long id);
}
