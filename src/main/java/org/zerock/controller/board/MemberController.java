package org.zerock.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 회원가입 컨트롤러
@Controller
@RequestMapping("member")
public class MemberController {

	@GetMapping("signup")
	public void signup() {
		
	}
	
}
