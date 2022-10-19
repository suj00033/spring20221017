package org.zerock.controller.lecture.p04attribute;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean01;
import org.zerock.domain.lecture.JavaBean02;
import org.zerock.domain.lecture.Student;

@Controller
@RequestMapping("ex18")
public class Controller18 {

	// /ex18/sub01?name=park&address=seoul&email=hj@dgh.djd
	@RequestMapping("sub01")
	public void met01(@ModelAttribute("bean") JavaBean01 b) {
		
	}
	
	// @ModelAttribute 어노테이션을 사용해서
	// bean2 라는 이름의 attribute를 model에 추가
	// bean2의 type은 org.zerock.domain.lecture.JavaBean02
	
	@RequestMapping("sub02")
	public void met02(@ModelAttribute("JavaBean02") JavaBean02 c) {
		c.setAge(30);
		c.setEmail("dh@bg.bet");
		c.setName("hju");
		c.setPassword("q1`w2e32");
	}
	
	@RequestMapping("sub03")
	public void met03(@ModelAttribute Student s) {
		// attribute name이 생략되면 클래스명을 따라감
		// string형으로 출력되기때문에 jsp에서 string으로 호출
		s.setClassName("soccer");
		s.setName("Son");
		s.setStudentNumber("23");
	}

	@RequestMapping("sub04")
	public String met04(Student s) {
		s.setClassName("futbol");
		s.setName("juan");
		s.setStudentNumber("12");
		
		return "ex18/sub03"; // 같은 jsp 재활용
	}
}
