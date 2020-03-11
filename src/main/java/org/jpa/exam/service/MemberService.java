package org.jpa.exam.service;

import lombok.RequiredArgsConstructor;
import org.jpa.exam.domain.Member;
import org.jpa.exam.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    public Long join(Member member) {
        return memberRepository.save(member).getId();
    }
}
