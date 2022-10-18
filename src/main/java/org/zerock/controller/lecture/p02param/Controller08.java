package org.zerock.controller.lecture.p02param;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex08")
public class Controller08 { // 같은 이름의 bean을 만들수없으므로 08로 만듦
	// 1. 요청 받고 *2. request parameter 수집 3. 가공 4. business logic 5. add attribute 6. forward / redirect
	// 2, 3 작업
	
	// 참고사이트
	// https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments
	@GetMapping("sub01")
	public void met01() {
		System.out.println("메11111");
	}
	
	@GetMapping("sub02")
	public void met02(HttpServletRequest request) { // 쿼리스트링에 name이나 age를 넣어도 실행
		System.out.println("22222222");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name);
		System.out.println(age);
	}
	
	@GetMapping("sub03")
	public void met03(HttpServletRequest re) {
		System.out.println("3실행");
		
		String address = re.getParameter("address");
		System.out.println("주소는 " + address + " 입니다.");
	}
}
