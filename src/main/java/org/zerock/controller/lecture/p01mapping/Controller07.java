package org.zerock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex07")
public class Controller07 {

	@GetMapping("sub01") // sub1로 요청왔을때
	public void met1() {
		System.out.println("1111");
	}
	
	@GetMapping(value="sub01", params="name") // 쿼리?name이라는 단어가 들어갔을때만 실행하고싶다(?name, ?name=a)
	public void met2() {
		System.out.println("22222");
	}
	
	@GetMapping("sub02")
	public void met3() {
		System.out.println("333333333333");
	}
	
	@GetMapping(value="sub02", params="address")
	public void met4() {
		System.out.println("4444444");
	}

	@GetMapping(path="sub03", params="address=seoul")
	public void met5() {
		System.out.println("555");
	}
	
	@GetMapping(path="sub03")
	public void met6() {
		System.out.println("6번");
	}
	
	@GetMapping("sub04")
	public void met7() {
		System.out.println("777");
	}
	
	@GetMapping(path="sub04", params= {"name", "age"})
	public void met8() {
		System.out.println("8번쓰");
	}
}
