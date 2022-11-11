package org.zerock.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.member.MemberDto;
import org.zerock.service.member.MemberService;

// 회원가입 컨트롤러
@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("signup")
	public void signup() {
	}
	
	@PostMapping("signup")
	public String signup(MemberDto member) {
		System.out.println(member);
		
		int cnt = service.insert(member);
		// 비지니스 로직 처리
		
		
		if (cnt == 1) {
			// 가입 실행되면
			return "redirect:/board/list";
		} else {
			// 가입 실행안되면
			return "redirect:/member/signup";
		}
	}
	
}
