package org.zerock.controller.lecture.p09fetch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex43")
public class Controller43 {

	@RequestMapping("sub")
	public void met() {
		
	}
	
	// 데이터 전달
	@GetMapping("sub01")
	public void met01(String name, String address) {
		System.out.println("첫번째 메소드 일함");
		System.out.println(name);
		System.out.println(address);
	}
	
	@GetMapping("sub02")
	public void met02(String email, Integer age) {
		System.out.println("두번째 메소드 일함");
		System.out.println(email);
		System.out.println(age);
	}
	
	@GetMapping("sub03")
	public void met03(String name, String email) {
		System.out.println("세번째 메소드 일함");
		System.out.println(name);
		System.out.println(email);
	}
	
	@GetMapping("sub04")
	public void met04(String address, Integer age) {
		System.out.println("네번째 메소드 일함");
		System.out.println(address);
		System.out.println(age);
	}
	
	@PostMapping("sub05")
	public void met05(String address, Integer age) {
		System.out.println("다섯번째 메소드 일함");
		System.out.println(address);
		System.out.println(age);
	}

	@PostMapping("sub06")
	public void met06(String name, String email) {
		System.out.println("여섯번째 메소드 일함");
		System.out.println(name);
		System.out.println(email);
	}
	
	@PostMapping("sub07")
	public void met07(String name, String email) {
		System.out.println("7번 메소드 일함");
		System.out.println(name);
		System.out.println(email);
	}
	
	@PostMapping("sub08")
	public void met08(String address, Integer age) {
		System.out.println("여덟번째 메소드 일함");
		System.out.println(address);
		System.out.println(age);
	}
}
