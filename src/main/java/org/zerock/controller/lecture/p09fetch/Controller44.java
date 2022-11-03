package org.zerock.controller.lecture.p09fetch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean20;
import org.zerock.domain.lecture.JavaBean21;
import org.zerock.domain.lecture.JavaBean22;
import org.zerock.domain.lecture.JavaBean23;
import org.zerock.domain.lecture.JavaBean25;
import org.zerock.domain.lecture.JavaBean27;

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

	@PostMapping("sub04")
	public void met04(@RequestBody JavaBean21 data) {
		System.out.println("4번 메소드 일함");
		System.out.println(data);
	}

	@PostMapping("sub05")
	public void met05(@RequestBody JavaBean22 data) {
		System.out.println("5번 메소드 일함");
		System.out.println(data);
	}

	@PostMapping("sub06")
	public void met06(@RequestBody JavaBean23 data) {
		System.out.println("6번 메소드 일함");
		System.out.println(data);
	}

	@PostMapping("sub07")
	public void met07(@RequestBody JavaBean25 data) {
		System.out.println("7번 메소드 일함");
		System.out.println(data);
	}

	@PostMapping("sub14")
	public void met14(@RequestBody JavaBean27 data) {
		System.out.println("14번 메소드 일함");
		System.out.println(data);
	}
	
	// get경로에 붙여서 보내는 방식(@PathVariable)
	@GetMapping("sub15/{id}")
	public void met15(@PathVariable String id) {
		System.out.println(id);
	}

	// path variable 자동 형변환
	// 파라미터명과 path variable 이름 같으면 value 속성 생략 가능
	@GetMapping("sub16/{d}")
	public void met16(@PathVariable("d") String d) {
		System.out.println(d);
	}
	
	
}
