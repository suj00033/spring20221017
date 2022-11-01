package org.zerock.controller.practica;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.prado.BoardVO;
import org.zerock.mapper.pramap.BoardSer;

@Controller
@RequestMapping("pra")
public class Boardpra {

	private BoardSer service;
	
	@GetMapping("register")
	public void insert() {
		
	}
	
	@PostMapping("register")
	public String insertPost(BoardVO board, RedirectAttributes rttr) {
		int cnt = service.register(board);
		
		if (cnt == 1) {
			rttr.addFlashAttribute("message", "새 게시물이 등록되었습니다.");
		} else {
			rttr.addFlashAttribute("message", "새 게시물이 등록되지 않았습니다.");
		}
		
		return "redirect:/prajsp/list";
	}
}
