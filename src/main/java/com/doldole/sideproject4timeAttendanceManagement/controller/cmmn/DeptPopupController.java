package com.doldole.sideproject4timeAttendanceManagement.controller.cmmn;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
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
public class DeptPopupController {

    private final DeptRepository deptRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/cmmn/deptPopupList")
    public String deptPopupList(Model model) {
        List<Dept> deptList = deptRepository.findAll();
        model.addAttribute("deptList", deptList);
        return "/cmmn/deptPopupList";
    }
}
