package org.zerock.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.PageInfo;
import org.zerock.service.board.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	private BoardService service;

	// 게시물 등록
	@GetMapping("register")
	public void register() {
		// 게시물 작성 view로 포워드
		// /WER-INF/views/board/register.jsp
	}
	
	// 등록한글 보여줌
	@PostMapping("register")
	public String register(BoardDto board, RedirectAttributes rttr) {  // title 프로퍼티를 받아야함
		// request param 수집/가공 (자바빈)
//		System.out.println(board); // 콘솔에 내용이 잘담겼는지 확인
		
		// business logic (Controller가 Service에게 일을 시키고 Service가 처리)
		int cnt = service.register(board);
		
		if (cnt == 1) {
			rttr.addFlashAttribute("message", "새 게시물이 등록되었습니다.");
		} else {
			rttr.addFlashAttribute("message", "새 게시물이 등록되지 않았습니다.");
		}
		
		// /board/list로 redirect
		return "redirect:/board/list";
		
	}
	
	// 게시물 목록으로 redirect
	@GetMapping("list")            // 페이지가 없으면 1로
	public void list(
			@RequestParam(name="page", defaultValue = "1") int page,
			@RequestParam(name="q", defaultValue = "") String keyword, // 검색 String q(keyword)
			PageInfo pageInfo, // Model이 생략되어있음
			Model model) {
		// request param 수집/가공
		
		// 비지니스 로직(서비스)
		List<BoardDto> list = service.listBoard(page, keyword, pageInfo);
		
		// add attribute
		model.addAttribute("boardList", list);
		// forward
	}
	
	// 게시글 글 보기
	@GetMapping("get")
	public void get(
			//@RequestParam 생략가능 (request 수집가공)
			@RequestParam(name="id") int id,
						Model model) {
		// 비지니스 로직 (게시물 db에서 가져오기)
		BoardDto board = service.get(id);
//		System.out.println(board);
		// add attribute
		model.addAttribute("board", board);
		// forward / redirect
		
	}
	
	@GetMapping("modify")
	public void modify(int id, Model model) {
		BoardDto board = service.get(id);
		model.addAttribute("board", board);
		
	}
	
	@PostMapping("modify")
	public String modify(BoardDto board, RedirectAttributes rttr) {
		int cnt = service.update(board);
		
		if (cnt == 1) {
			rttr.addFlashAttribute("message", board.getId() + "번 게시물이 수정되었습니다.");
		} else {
			rttr.addFlashAttribute("message", board.getId() + "번 게시물이 수정되지 않았습니다.");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("remove")
	public String remove(int id, RedirectAttributes rttr) {
		int cnt = service.remove(id);
		
		if(cnt == 1) {
			rttr.addFlashAttribute("message", id + "번 게시물이 삭제되었습니다.");
		} else {
			rttr.addFlashAttribute("message", id + "번 게시물이 삭제되지 않았습니다.");
		}
		
		return "redirect:/board/list";
	}
}
