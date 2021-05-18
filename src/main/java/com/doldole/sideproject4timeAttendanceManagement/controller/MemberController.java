package com.doldole.sideproject4timeAttendanceManagement.controller;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import com.doldole.sideproject4timeAttendanceManagement.form.MemberForm;
import com.doldole.sideproject4timeAttendanceManagement.service.DeptService;
import com.doldole.sideproject4timeAttendanceManagement.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final DeptService deptService;
    private final MemberService memberService;

    @GetMapping("/member/new")
    public String createMemberForm(Model model) {

        List<Dept> depts = deptService.findAll();

        model.addAttribute("depts", depts);
        model.addAttribute("memberForm", new MemberForm());
        return "/member/memberForm";
    }

    @PostMapping("/member/new")
    public String createMember(@Valid MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/member/new";
        }

        Optional<Dept> resultDept = deptService.findById(form.getDeptId());

        if(!resultDept.isEmpty()) {
            Dept dept = resultDept.get();
            Member member = new Member(form.getName(), form.getRank(), dept);
            memberService.insertMember(member);
        }

        return "redirect:/";
    }

    @GetMapping("/member/memberList")
    public String memberList(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);

        return "/member/memberList";
    }
}
