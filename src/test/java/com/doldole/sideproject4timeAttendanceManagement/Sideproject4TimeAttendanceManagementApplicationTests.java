package com.doldole.sideproject4timeAttendanceManagement;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.doldole.sideproject4timeAttendanceManagement.repository.DeptRepository;
import com.doldole.sideproject4timeAttendanceManagement.repository.MemberRepository;

import javax.persistence.EntityManager;

@SpringBootTest
class Sideproject4TimeAttendanceManagementApplicationTests {

	@Autowired
	EntityManager em;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private DeptRepository deptRepository;

	@Test
	public void test() {
		Dept dept = new Dept("test");
		deptRepository.save(dept);

		Member member = new Member("member1", "AA", dept);
		memberRepository.save(member);
	}

}
