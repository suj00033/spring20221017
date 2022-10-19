package org.zerock.controller.lecture.p05redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("ex21")
public class Controller21 {

	// redirect때 데이터 넘겨주기
	
	// RedirectAttributes 사용
	@RequestMapping("sub01")	
	public String method1(RedirectAttributes rttr) {
		rttr.addAttribute("name", "captain");
		rttr.addAttribute("address", "seoul");
		
		return "redirect:/ex21/sub02";
	}
	
	@RequestMapping("sub02")
	public void method2(String name, String address) {
		System.out.println(name);
		System.out.println(address);
	}
	
	@RequestMapping("sub03")
	public String method3(RedirectAttributes rt) {
		rt.addAttribute("age", 23);
		rt.addAttribute("email", "q2ed@google.com");
		
		return "redirect:/ex21/sub04";
	}
	
	@RequestMapping("sub04")
	public void method4(String email, int age) {
		System.out.println(email);
		System.out.println(age);
	}
}
