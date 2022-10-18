package org.zerock.controller.lecture.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex11")
public class Controller11 {

	// /ex11/sub01?address=seoul
	@GetMapping("sub01")
	public void met1(@RequestParam("address") String abc) {
		System.out.println(abc);
	}

	
	@GetMapping("sub02")
	public void met2(@RequestParam String address) {
		
		// request param 의 이름과 메소드 아규먼트의 이름이 같으면
		// @RequestParam의 value속성 생략 가능
		System.out.println(address);
	}

	// /ex11/sub03?address=korea
	@GetMapping("sub03")
	public void met3(String address) {
		
		// 메소드 파라미터가 기본타입(8개, 또는 wrapper), String이면
		// @RequestParam이 붙은 것으로 간주
		System.out.println(address);
	}
	
	// /ex11/sub04?city=ny&age=90&name=donald
	@GetMapping("sub04")
	public void met04(String city, int age, String name) {
		System.out.println(city);
		System.out.println(age);
		System.out.println(name);
	}
}
