package com.doldole.sideproject4timeAttendanceManagement.service;

import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import com.doldole.sideproject4timeAttendanceManagement.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long insertMember(Member member) {
        memberRepository.save(member);
        return member.getId();
    }
}
