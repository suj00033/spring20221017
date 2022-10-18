package org.zerock.controller.lecture.p02param;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex12")
public class Controller12 {

	// /ex12/sub01?city=seoul&city=ny&city=tokyo
	@RequestMapping("sub01")
	public void met01(@RequestParam("city") String city) {
		// (,)로 구분된
		System.out.println(city);
	}

	@RequestMapping("sub02")
	public void met02(@RequestParam("city") String[] city) {
		// 배열로 구분
		System.out.println(city.length);
		System.out.println(Arrays.toString(city));
	}

	@RequestMapping("sub03")
	public void met03(@RequestParam("city") List<String> city) {
		// 리스트로 구분
		System.out.println(city.size());
		System.out.println(city);
	}
	
	// 위 3개의 @RequestParam value attribute 생략 가능
	
	
	// /ex12/sub04
	@RequestMapping("sub04")
	public void met04(String name, String address, int age, String email, int password) {
		System.out.println("44444 일함");
		System.out.println(name);
		System.out.println(address);
		System.out.println(email);
		System.out.println(age);
		System.out.println(password);
	}
}
