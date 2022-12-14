package org.zerock.controller.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.member.MemberDto;
import org.zerock.service.member.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	// 이메일 중복 확인
	@PostMapping("existEmail")
	@ResponseBody
	public Map<String, Object> existEmail(@RequestBody Map<String, String> req) {

		Map<String, Object> map = new HashMap<>();

		MemberDto member = service.getByEmail(req.get("email"));

		if (member == null) {
			map.put("status", "not exist");
			map.put("message", "사용가능한 이메일입니다.");
		} else {
			map.put("status", "exist");
			map.put("message", "이미 존재하는 이메일입니다.");
		}

		return map;
	}

	@GetMapping("existId/{id}")
	@ResponseBody
	public Map<String, Object> existId(@PathVariable String id) {
		Map<String, Object> map = new HashMap<>();

		MemberDto member = service.getById(id);

		if (member == null) {
			map.put("status", "not exist");
			map.put("message", "사용가능한 아이디입니다.");
		} else {
			map.put("status", "exist");
			map.put("message", "이미 존재하는 아이디입니다.");
		}

		return map;
	}
	
	@GetMapping("signup")
	public void signup() {
		
	}
	
	@PostMapping("signup")
	public String signup(MemberDto member, RedirectAttributes rttr) {
		System.out.println(member);
		
		int cnt = service.insert(member);
		
		// 가입 잘되면
		rttr.addFlashAttribute("message", "회원가입 되었습니다.");
		return "redirect:/board/list";
	}
	
	@GetMapping("list")
	public void list(Model model) {
		model.addAttribute("memberList", service.list());
	}
	
	@GetMapping({"info", "modify"})
	public void info(String id, Model model) {
		
		model.addAttribute("member", service.getById(id));
	}
	
	@PostMapping("modify")
	public String modify(MemberDto member, String oldPassword, RedirectAttributes rttr) {
		// 회원 정보 수정 시 전 암호를 입력하여 수정하기
		MemberDto oldMember = service.getById(member.getId());
		
		// 기존 암호가 일치할시에 회원 정보 수정하고
		if (oldMember.getPassword().equals(oldPassword)) {
			int cnt = service.modify(member);
			
			rttr.addAttribute("id", member.getId());
			if (cnt == 1) {
				rttr.addFlashAttribute("message", "회원 정보가 수정되었습니다.");
				return "redirect:/member/info";
			} else {
				rttr.addFlashAttribute("message", "회원 정보가 수정되지 않았습니다.");
				return "redirect:/member/modify";
			}
			// 일치하지않으면 변경되지않고 다시 modify로 되돌아옴
		} else {
			rttr.addFlashAttribute("message", "암호가 일치하지 않습니다.");
		}
		
		return "redirect:/member/modify";
	}
	
	@PostMapping("remove")
	public String remove(String id, String oldPassword, RedirectAttributes rttr) {
		// 예전 정보를 가지고 와서
		MemberDto oldMember =  service.getById(id);
		
		// 예전 암호와 일치하면 탈퇴 진행
		if (oldMember.getPassword().equals(oldPassword)) {
			int cnt = service.remove(id);
		
		rttr.addFlashAttribute("message", "회원 탈퇴하였습니다.");
		
		return "redirect:/board/list";
	
		// 아니면 modify창으로 되돌아옴
		} else {
			rttr.addAttribute("id", id);
			rttr.addFlashAttribute("message", "암호가 일치하지 않습니다.");
		
			return "redirect:/member/modify";
		}
	}
}











