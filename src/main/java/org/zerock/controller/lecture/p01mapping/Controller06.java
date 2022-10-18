package org.zerock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex06")
public class Controller06 {
	
	// 좀더 구체적으로 requestmapping을 작성한 메소드가 우선권 갖음
	// @@RequestMapping(value="sub01", method=RequestMethod.GET)
	@GetMapping("sub01") 
	public void met1() {
		System.out.println("111111111111");
	}
	
	@RequestMapping("sub01")
	public void met2() {
		System.out.println("2222222222222");
	}

	@PostMapping("sub01") // 얘가 우선권있음
	public void met3() {
		System.out.println("3333333");
	}
	
	
}
