package org.zerock.controller.lecture.p09fetch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex42")
public class Controller42 {

	@RequestMapping("sub")
	public void met0() {
		
	}
	
	@RequestMapping(path = "sub01", produces = "text/plain") // produces가 jsp에서 "Accept"가 선언한 미디어타입과 다르면
														     // 작동하지 않는다. (EX)text/html
	public void met01() {
		System.out.println("Accept ex42 sub01 요청받음@@@@@@");
	}
	
	@GetMapping(path = "sub01", produces = "text/html")
	public void met02() {
		System.out.println("ex42 sub01 text/html 작동중");
	}
}
