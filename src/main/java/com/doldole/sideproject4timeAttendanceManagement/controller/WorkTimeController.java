package com.doldole.sideproject4timeAttendanceManagement.controller;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import com.doldole.sideproject4timeAttendanceManagement.domain.WorkTime;
import com.doldole.sideproject4timeAttendanceManagement.form.WorkTimeForm;
import com.doldole.sideproject4timeAttendanceManagement.repository.MemberRepository;
import com.doldole.sideproject4timeAttendanceManagement.service.WorkTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class WorkTimeController {

    private final WorkTimeService workTimeService;
    private final MemberRepository memberRepository;

    @GetMapping("/workTime/new")
    public String workTimeForm(Model model) {
        model.addAttribute("workTimeForm", new WorkTimeForm());
        return "/workTime/workTimeForm";
    }

    @PostMapping("/workTime/new")
    public String createWorkTime(@Valid WorkTimeForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/workTime/workTimeForm";
        }

        Optional<Member> findMember = memberRepository.findById(form.getEmpId());

        if(!findMember.isEmpty()) {
            Member member = findMember.get();
            WorkTime workTime = new WorkTime(form.getWorkDate(), form.getBeginTime(), form.getEndTime(), member);
            workTimeService.insertWorkTime(workTime);
        }

        return "redirect:/";
    }
}
