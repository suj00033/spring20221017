package org.zerock.controller.lecture.p05redirect;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex19")
public class Controller19 {
	// 1. 요청받고
	// 2. request parameter 수집
	// 3. request parameter 가공
	// 4. business logic
	// 5. add attribute
	// *6. forward / redirect
	@RequestMapping("sub01") // 01로 요청을 보내고
	public void met01(HttpServletResponse res) throws Exception {
		// redirect response
		String location = "sub02"; // 02로 요청을 받음
		res.sendRedirect(location);
	}
	
	// spring에서
	@RequestMapping("sub03")
	public String met02() {
		return "redirect:sub04"; // redirect views로 해석함
	}
	
	// sub05 -> sub06으로 redirect
	@RequestMapping("sub05")
	public String met03() {
		return "redirect:sub06"; // 클라이언트가 사용하는 경로(상대경로), spring
	}
	// sub05 -> sub06으로 redirect
	@RequestMapping("sub07")
	public void met04(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String path = req.getContextPath() + "/ex19/sib08"; // 절대경로
		res.sendRedirect(path);
	}
	
	@RequestMapping("sub09")
	public String met05() {
		return "redirect:/ex19/sub10"; // 절대경로
	}

	@RequestMapping("sub11")
	public String met06() {
		return "redirect:/ex19/sub12"; // 절대경로, spring location에서 /controller/가 붙어있음
	}
}
