package org.zerock.controller.lecture.p03forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex14")
public class Controller14 {
	// 1. 요청받고
	// 2. request parameter 수집
	// 3. request parameter 가공
	// 4. business logic
	// 5. add attribute
	// *6. forward / redirect
	
	@RequestMapping("sub01")
	public void method1(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("메소드1번 일함!!!!!");
		String path = "/WEB-INF/views/ex14/sub01.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}
	
	
	@RequestMapping("sub02")
	public String method2() {
		System.out.println("method 2 !!!!!!!!!!!!");
		
		return "abc";
	}
	
	
	// sub03 경로
	// /WEB-INF/views/xyz.jsp 로 포워드하는 메소드 작성, .jsp앞에 있는 문자를 String으로 받음
	// /controller/ex14/sub03 URL 작성
	@RequestMapping("sub03")
	public String met03() {
		System.out.println("333333");
		
		return "xyz";
	}

	@RequestMapping("sub04")
	public String met04() {
		System.out.println("4444");
		
		// /WEB-INF/views/ex14/sub04.jsp로 받음
		return "ex14/sub04";
	}
	
	@RequestMapping("sub05")
	public String met05() {
		System.out.println("5working");
		
		// /WEB-INF/views/ex14/sub05.jsp
		return "ex14/sub05";
	}
	
}
