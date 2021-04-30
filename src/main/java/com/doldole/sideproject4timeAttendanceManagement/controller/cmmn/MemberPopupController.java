package com.doldole.sideproject4timeAttendanceManagement.controller.cmmn;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import com.doldole.sideproject4timeAttendanceManagement.repository.DeptRepository;
import com.doldole.sideproject4timeAttendanceManagement.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberPopupController {

    private final DeptRepository deptRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/cmmn/empPopupList")
    public String memberPopupList(Model model) {
        List<Dept> deptList = deptRepository.findAll();
        model.addAttribute("deptList", deptList);
        return "/cmmn/empPopupList";
    }

    @ResponseBody
    @GetMapping("/cmmn/selectDeptEmpList")
    public List<Member> selectDeptEmpList(@RequestParam("deptId") Long deptId) {
        List<Member> result = memberRepository.findByDeptId(deptId);
        return result;
    }
}
