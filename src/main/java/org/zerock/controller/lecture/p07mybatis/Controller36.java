package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;
import org.zerock.mapper.lecture.Mapper10;

// DELETE 쿼리
@Controller
@RequestMapping("ex36")
public class Controller36 {

	@Autowired
	private Mapper10 mapper;
	
	@RequestMapping("sub01")
	public void met01()	{
		int cnt = mapper.removeCustomer();
		System.out.println(cnt + "개 레코드 삭제됨");
	}

	@RequestMapping("sub02")
	public void met02()	{
		int cnt = mapper.removeEmployee();
		System.out.println(cnt + "개 레코드 삭제됨");
	}
	
	@RequestMapping("sub03")
	public void met03(@RequestParam(name = "id", defaultValue = "0") int id) {
		int cnt = mapper.removeCustomerById(id);
		System.out.println(cnt + "개 고객 레코드 삭제됨");
	}
	
	@RequestMapping("sub04")
	public void method04(@RequestParam(name="id", defaultValue = "0") int id) {
		int cnt = mapper.removeEmployeeById(id);
		System.out.println(cnt + "개 직원 레코드 삭제됨");
	}
	
	// 추가입력 쿼리
	@RequestMapping("sub05")
	public void met05() {
		int cnt = mapper.addCutomer();
		System.out.println(cnt + "개 고객 정보 입력됨");
	}
	
	@RequestMapping("sub06")
	public void met06() {
		int cnt = mapper.addSuppiler();
		System.out.println(cnt + "개 공급자 정보 입력됨");
	}
	
	// jsp파일에서 입력하여 sql로 전송
	@GetMapping("sub07")
	public void customerForm() {
		
	}
	
	@PostMapping("sub07")
	public void met07(JavaBean18 customer) {
		int cnt = mapper.insetCustomer(customer);
		System.out.println(cnt + "개 고객 정보 입력됨");
	}
	
	@GetMapping("sub08")
	public void supplierFrom() {
		// forward to /WEB-INF/views/ex36/sub08
	}
	
	@PostMapping("sub08")
	public void met08(JavaBean19 supplier) {
		// 1. request 수집가공
		// 2. business logic
		int cnt = mapper.insertSupplier(supplier);
		System.out.println(cnt + "개 공급자 정보 입력됨");
		
		// 3. add attribute
		// 4. forward / redirect
	}
	
	@GetMapping("sub09")
	public String getMet09() {
		
		return "/ex36/sub07";
	}
	
	@PostMapping("sub09") 
		public String postMet09(JavaBean18 customer, RedirectAttributes rttr) {
			System.out.println("key: " + customer.getId()); // 0 
			
			int cnt = mapper.insetCustomerAndGetKey(customer);
			System.out.println(cnt + "개 고객 정보 입력"); 
			System.out.println("key:" + customer.getId()); // 생성된 키값
			
			// rttr은 string, msp, list 등 object 형태를 그대로 넘겨줄수 있음, url에 파라미터가 노출됨
			// addFlashAttribute는 데이터를 post형식으로 전달, redirect 직전 플래시(섹션에 넣었다뺌)에 저장하는 메소드
			// redirect 이후에는 날아감(휘발성), url 파라미터에 보이지않음
			rttr.addFlashAttribute("message", customer.getId() + "번 고객 등록 완료");
			return "redirect:/ex36/sub09";
	}
	
	@GetMapping("sub10")
	public String met10() {
		
		return "/ex36/sub08";
	}
	
	@PostMapping("sub10")
	public String postMet10(JavaBean19 supplier, RedirectAttributes rttr) {
		// 1. request parameter 수집 : JavaBean19
		// 2. business logic : Supplier 테이블에 레코드 입력 And generated key 얻기
		System.out.println("key : " + supplier.getId());
		
		int cnt = mapper.insertSupplierAndGetKey(supplier);
		System.out.println(cnt + "개 공급자 정보 입력");
		System.out.println("key : " + supplier.getId());
		
		// 3. add attribute : (message : id번 공급자 입력되었습니다.)
		// 4. redirect : /ex36/sub10
		rttr.addFlashAttribute("message", supplier.getId() + "번 공급자 등록 완료");
		return "redirect:/ex36/sub10";
		
		
	}

}

