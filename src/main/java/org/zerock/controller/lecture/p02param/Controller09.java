package org.zerock.controller.lecture.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex09")
public class Controller09 {

	// /ex09/sub01?address=seoul
	@GetMapping("sub01")
	public void met01(@RequestParam(name = "address")String a) { // @RequestParam 여기에만 사용가능, 일일이 쓰지않도 알아서 꺼내씀
		System.out.println(a);
	}
	
	@GetMapping("sub02")
	public void met02(@RequestParam(name = "name") String s) 	{
		System.out.println(s);
	}
	
	@GetMapping("sub05")
	public void met03(@RequestParam("name") String a,
						@RequestParam("address") String b) {
		System.out.println("name: " + a);
		System.out.println("address: " + b);
	}
	
	@GetMapping("sub06")
	public void met04(@RequestParam("q") String a,
			@RequestParam("age") String b) {
		System.out.println("주소는 " + a);
		System.out.println("나이는 " + b + "입니다.");
	}
	
	@GetMapping("sub07")
	public void met05(@RequestParam("age") int a) {
		System.out.println(a);
	}
	
	@GetMapping("sub08")
	public void met06(@RequestParam("num1") int num1,
			@RequestParam("num2") int num2) {
		System.out.println(num1 + num2);
	}
	
	// request param -> method param 바인딩 될때
	// 자동형변환되는 type:
	// String, 기본타입(primitive), wrapper
	
	// /ex09/sub09?a=seoul&b=3.14&c=9.99&d=100&e=300
	@GetMapping("sub09")
	public void met09(@RequestParam("a") String a,
					@RequestParam("b") double b,
					@RequestParam("c") Double c,
					@RequestParam("d") int d,
					@RequestParam("e") Integer e) {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
	}
}
