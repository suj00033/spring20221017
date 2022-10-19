package org.zerock.controller.lecture.p03forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex15")
public class Controller15 {
	
	// ex15/sub01
	@RequestMapping("sub01")
	public void met01() {
		System.out.println("메소1");
	}
	
	// sub02 요청
	// /WEB-INF/views/ex15/sub02.jsp
	@RequestMapping("sub02")
	public void met02() {
		System.out.println("메소22222");
	}
	
	@RequestMapping("sub03")
	public String met03() {
		
		// void처럼 default view name(/WEB-INF/views/)을 사용해서 view로 포워드함
		return null; 
	}
	
	// sub04 요청
	// /WEB-INF/views/ex15/sub04.jsp 포워드하도록
	@RequestMapping("sub04")
	public String met04() {
		return null;
	}
	
	// sub05 요청
	// name request param이 있으면
	// /WEB-INF/views/ex15/sub051.jsp로 포워드

	// 없으면 /WEB-INF/views/sub05.jsp로 포워드
	@RequestMapping("sub05")
	public String met05(String name) {
		if (name == null) {
			return null;
		}
		
		return "ex15/sub051";
	}
	
	@RequestMapping("sub06") // address 없으면 얘가 실행됨
	public void met08() {
		
	}
	
	@GetMapping(path="sub06", params="address") // 쿼리스트링에 address가 있을때 먼저 실행
	public String met07() {
		return "ex15/sub061";
	}
}
