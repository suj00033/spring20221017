package org.zerock.controller.lecture.p05redirect;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.lecture.JavaBean03;
import org.zerock.domain.lecture.Student;

@Controller
@RequestMapping("ex22")
public class Controller22 {

	@RequestMapping("sub01")
	public String met01(Model model) {
		model.addAttribute("name", "park");
		
		return "redirect:/ex22/sub02";
	}
	
	@RequestMapping("sub02")
	public void met02(Model model) {
		boolean hasName = model.containsAttribute("name"); // false -> sub01에 넣은 attribute와 달라서 false
		System.out.println(hasName);
	}
	
	
	@RequestMapping("sub03")
	public String met03(HttpSession session) {
		session.setAttribute("name", "park");
		
		return "redirect:/ex22/sub04";
	}
	
	@RequestMapping("sub04")
	public void met04(HttpSession session) {
		String name = (String) session.getAttribute("name");
		System.out.println(name);
	}
	
	// sub05 요청
	// /ex22/sub06 redirect
	// session에 attribute 넣는 코드 추가(Student)
	@RequestMapping("sub05")
	public String met05(HttpSession session) {
		Student student = new Student();
		student.setName("son");
		student.setClassName("soccer");
		student.setStudentNumber("13");
		
		session.setAttribute("student", student);
		
		
		return "redirect:/ex22/sub06";
	}
	
	@RequestMapping("sub06")
	public void met06(HttpSession session) {
		Student student = (Student) session.getAttribute("student");
		System.out.println(student.getName());
		System.out.println(student.getStudentNumber());
		System.out.println(student.getClassName());
	}
	
	// RedirectAttributes로 객체 넘기기
	@RequestMapping("sub07")
	public String met07(RedirectAttributes rt) {
		Student student = new Student();
		student.setName("lee");
		student.setClassName("spring");
		student.setStudentNumber("562");
		
		rt.addFlashAttribute("student", student); // student 객체를 섹션에서 뺏다가 @ModelAttribute에 사용하고 삭제(객체 넘기기)
		
		return "redirect:/ex22/sub08";
	}
	
	@RequestMapping("sub08")
	public void met08(Student student) { // (@ModelAttribute("student") Student student)
		System.out.println(student);
		
	}
	
	@RequestMapping("sub09")
	public String method9(RedirectAttributes rttr) {
		JavaBean03 j = new JavaBean03();
		j.setAvg(99.9);
		j.setClassName("math");
		j.setLocation("korea");
		j.setScore(100);
		j.setStudentNumber("11");
		
		rttr.addFlashAttribute("javaBean03", j);
		
		return "redirect:/ex22/sub10";
	}
	
	@RequestMapping("sub10")
	public void method10(JavaBean03 javaBean03) {
		System.out.println(javaBean03);
	}
	
//	@RequestMapping("sub09")
//	public String method9(RedirectAttributes rttr) {
//		JavaBean03 j = new JavaBean03();
//		j.setAvg(99.9);
//		j.setClassName("math");
//		j.setLocation("korea");
//		j.setScore(100);
//		j.setStudentNumber("11");
//		
//		rttr.addFlashAttribute("myBean", j);
//		
//		return "redirect:/ex22/sub10";
//	}
//	
//	// sub10 요청 
//	// 모델에 있는 org.zerock.domain.lecture.JavaBean03 타입의 객체 내용 출력
//	@RequestMapping("sub10")
//	public void method10(@ModelAttribute("myBean") JavaBean03 bean) {
//		System.out.println(bean);
//	}
}
