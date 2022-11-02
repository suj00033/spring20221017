package org.zerock.controller.lecture.p09fetch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.sample.JavaBean20;

@Controller
@RequestMapping("ex44")
public class Controller44 {

	@RequestMapping("sub")
	public void met() {
		
	}
	
	// console에서 null로 나옴 (Content-Type: text/plain;)
	@PostMapping("sub01")
	public void met01(String name, String address) {
		System.out.println("1 메소드 일");
		System.out.println(name);
		System.out.println(address);
	}
	
	@PostMapping("sub02")
	public void met02(@RequestBody String data) {
		System.out.println("2번 메소드 일함");
		System.out.println(data);
	}
	
	@PostMapping("sub03")
	public void met03(@RequestBody JavaBean20 data) {
		System.out.println("3번 메소드 일함");
		System.out.println(data);
	}
	
	
}
