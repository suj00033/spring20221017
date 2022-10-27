package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
	}
	
	@PostMapping("sub08")
	public void met08(JavaBean19 supplier) {
		int cnt = mapper.insertSupplier(supplier);
		System.out.println(cnt + "개 공급자 정보 입력됨");
	}
}
