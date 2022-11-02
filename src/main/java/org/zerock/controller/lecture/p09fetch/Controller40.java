package org.zerock.controller.lecture.p09fetch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ex40")
public class Controller40 {

	@RequestMapping("sub0")
	public void met00() {
		// jsp로 포워드
	}
	
	@GetMapping("sub01")
	public void met01() {
		System.out.println("/ex40/sub01 get 방식 요청 잘받음");
	}
	
	@GetMapping("sub02")
	public void met02() {
		System.out.println("/ex40/sub02 get 방식 요청 잘받음");
	}
	
	@PostMapping("sub03")
	public void met03() {
		System.out.println("/ex40/sub03 post 방식 요청 잘받음");
	}
	
	@GetMapping("sub04")
	public void met04() {
		System.out.println("/ex40/sub04 get 방식@#@##@#@#@#@");
	}

	@PostMapping("sub04")
	public void met05() {
		System.out.println("/ex40/sub04 post 방식 요청 잘받음@@@@@@@@@@");
	}
	
//	@RequestMapping(path = "sub04", method = RequestMethod.PUT)이랑 같은 역할
	@PutMapping("sub04")
	public void met06() {
		System.out.println("/ex40/sub04 put방식 요청 잘받음@@@@@@@@@@");
	}
	
//	@RequestMapping(path="sub04", method=Request.DELETE)
	@DeleteMapping("sub04")
	public void met07() {
		System.out.println("delte 방식 요청받음@!!2@@@@@@");
	}
	
	@GetMapping("sub05")
	public void met08() {
		System.out.println("sub05 get@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	@PostMapping("sub05")
	public void met09() {
		System.out.println("sub05 post@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	@PutMapping("sub05")
	public void met010() {
		System.out.println("sub05 put@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	@DeleteMapping("sub05")
	public void met11() {
		System.out.println("sub05 delete@@@@@@@@@@@@@@@@@@@@@@@@");
	}
}
