package org.zerock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex02") // '/' 생략가능
public class Controller02 {
	
	// 요청경로가 같을 경우에는 하나로 묶을 수 있다
	@RequestMapping("/sub01")
	public void method1() {
		System.out.println("ex2 메소드1");
	}
	@RequestMapping("sub02")
	public void method2() {
		System.out.println("ex2 메소드2");
	}
	@RequestMapping("sub03")
	public void function() {
		System.out.println("ex2 메소드3");
	}
	
}
