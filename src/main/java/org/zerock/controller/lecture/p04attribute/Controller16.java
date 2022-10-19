package org.zerock.controller.lecture.p04attribute;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex16")
public class Controller16 {
	// 1. 요청받고
	// 2. request parameter 수집
	// 3. request parameter 가공
	// 4. business logic
	// *5. add attribute
	// 6. forward / redirect
	
	// /es16/sub01
	// /WEB-INF/views/ex15/sub01.jsp로 포워드
	@RequestMapping("sub01")
	public void met01(HttpServletRequest req) { // 같은 request이므로 읽으면 myName이 나옴
		req.setAttribute("myName", "Prak");		// attribute 추가
	}

	@RequestMapping("sub02")
	public void met02(HttpServletRequest req) { 
		req.setAttribute("address", "Seoul");
	}
}
