package org.zerock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex03")
public class Controller03 {
	
	// ex03/sub01        ex03/sub02
	@RequestMapping({"sub01", "sub02", "sub03"})
	public void method1() {
		System.out.println("ex03 메소드1");
	}

	@RequestMapping({"sub04", "sub05"})
	public void method2() {
		System.out.println("4와 5가 일하고 있음");
	}
	
	@RequestMapping(value = "sub06")
	public void function1() {
		System.out.println("6일한다");
	}

	@RequestMapping(path = "sub07")
	public void function2() {
		System.out.println("7일한다");
	}
}
