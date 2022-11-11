package org.zerock.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
	public String signup(MemberDto member, 
						RedirectAttributes rttr) {
		
		System.out.println(member);
		
		// 비지니스 로직 처리
		int cnt = service.insert(member);
		
		
		// 가입 실행되면
		rttr.addFlashAttribute("message", "회원가입이 되었습니다.");
			
		return "redirect:/board/list";
		
	}
	
	// 회원목록
	@GetMapping("list")
	public void list(Model model) {
		model.addAttribute("memberList", service.list());
	}
}
