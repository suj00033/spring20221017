package org.zerock.controller.lecture.p09fetch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.lecture.JavaBean20;
import org.zerock.domain.lecture.JavaBean24;
import org.zerock.domain.lecture.JavaBean25;
import org.zerock.domain.lecture.JavaBean26;
import org.zerock.domain.lecture.JavaBean27;

@Controller
@RequestMapping("ex45")
public class Controller45 {

	@RequestMapping("sub")
	public void met() {
		
	}
	
	@GetMapping("sub01")
	public ResponseEntity met01() {
//		return ResponseEntity.ok().build(); 					status code 200
//		return ResponseEntity.badRequest().build();			    status code 400
//		return ResponseEntity.notFound().build();               status code 404
		return ResponseEntity.status(500).build();       // 직접 상태코드 입력가능
	}
	
	@GetMapping("sub02")
	public ResponseEntity met02() {
		return ResponseEntity.status(202).build();
	//  return ResponseEntity.accepted().build();
	}

	// header 변경하는 메소드
	@GetMapping("sub03")
	public ResponseEntity met03() {
		return ResponseEntity.ok()
				.header("My-Header", "My-Value")
				.build();
	}

	@GetMapping("sub04")
	public ResponseEntity met04() {
		return ResponseEntity.ok()
				.header("Your-Header", "Your-Value")
				.build();
	}

	// 본문 String, 한글로 인코딩
	@GetMapping("sub05")
	public ResponseEntity<String> met05() {
		return ResponseEntity
				.ok()
				.header("Content-Type", "text/plain;charset=UTF-8") 
				.body("헬로 월드");

	}

	@GetMapping("sub06")
	public ResponseEntity<JavaBean24> met06() {
		JavaBean24 data = new JavaBean24();
		data.setLocation("서울");
		data.setSince("2000년");
		
		return ResponseEntity
				.ok()
				.body(data);
	}

	@GetMapping("sub07")
	public ResponseEntity<JavaBean20> met07() {
		JavaBean20 data = new JavaBean20();
		data.setAddress("서울");
		data.setName("손흥민");
		
		return ResponseEntity
				.ok()
				.body(data);
	}

	// 배열로 받음 -> 다른 형태로 받고싶을때는 자바빈에서 필요한 코드사용
	@GetMapping("sub08")
	public ResponseEntity<JavaBean27> met08() {
		JavaBean27 data = new JavaBean27();
		data.setName("띤띤");
		data.setDate(LocalDate.now());
		data.setDateTime(LocalDateTime.now());
		
		return ResponseEntity
				.ok(data);
	}
	
	// 자바빈 2개, list complex
	@GetMapping("sub09")
	public ResponseEntity<JavaBean25> met09() {
		JavaBean25 data = new JavaBean25();
		JavaBean26 sub = new JavaBean26();
		
		sub.setAddress(List.of("서울", "부산", "제주"));
		sub.setMarried(true);

		data.setInfo(sub);
		data.setAge(23);
		
		return ResponseEntity
				.ok(data);
	}

	@GetMapping("sub10")
	@ResponseBody  			// 이를 붙여주면 바로 자바빈 부름
	public JavaBean25 met10() {
		JavaBean25 data = new JavaBean25();
		JavaBean26 sub = new JavaBean26();
		
		sub.setAddress(List.of("서울", "부산", "제주"));
		sub.setMarried(true);

		data.setInfo(sub);
		data.setAge(23);
		
		return data;
	}
	
	@GetMapping("sub11")
	@ResponseBody
	public JavaBean27 met11() {
		JavaBean27 data = new JavaBean27();
		data.setName("두루룽");
		data.setDate(LocalDate.now());
		data.setDateTime(LocalDateTime.now());
		
		return data;
	}
	
}
