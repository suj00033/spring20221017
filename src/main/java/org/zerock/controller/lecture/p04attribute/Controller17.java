package org.zerock.controller.lecture.p04attribute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean03;
import org.zerock.domain.lecture.Student;

import lombok.Data;

@Controller
@RequestMapping("ex17")
public class Controller17 {
	
	@RequestMapping("sub01")
	public void met01(Model model) { // Model 인터페이스 안에는 addAttribute(attribute name, attribute value)
		model.addAttribute("myName", "cha"); // request 역할
	}
	
	// sub02 요청
	// /WEB-INF/views/ex17/sub02/jsp 포워드
	// add attribute : email : abc@daum.net
	@RequestMapping("sub02")
	public void met02(Model model) {
		model.addAttribute("email", "abc@daum.net");
	}
	
	// sub03 요청
	@RequestMapping("sub03")
	public void met03(Model model) {
		model.addAttribute("name", "Son");
		model.addAttribute("age", 32);
		model.addAttribute("address", "london");
		model.addAttribute("email", "ghj@gmail.com");
	}
	
	// attribute value값에 자바빈 넣기
	@RequestMapping("sub04")
	public void met04(Model model) {
		JavaBean03 obj = new JavaBean03();
		obj.setAvg(9.99);
		obj.setClassName("spring");
		obj.setLocation("seoul");
		obj.setScore(100);
		obj.setStudentNumber("s80");
		
		model.addAttribute("student", obj);
	}
	
	@RequestMapping("sub05")
	public void met05(Model model) {
		Student s = new Student();
		s.setName("Son");
		s.setClassName("soccer");
		s.setStudentNumber("13");
		
//		model.addAttribute("student", s); 생략가능
		model.addAttribute(s);
		model.addAttribute("hell"); // attribute name이 생략되면 클래스명을 따라감
									// string형으로 출력되기때문에 jsp에서 string으로 호출
	}
}


