package com.doldole.sideproject4timeAttendanceManagement.service;

import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import com.doldole.sideproject4timeAttendanceManagement.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

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

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).get();
    }
}
