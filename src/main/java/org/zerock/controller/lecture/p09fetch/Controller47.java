package org.zerock.controller.lecture.p09fetch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;
import org.zerock.mapper.lecture.Mapper11;

@Controller
@RequestMapping("ex47")
public class Controller47 {
	
	@Autowired
	private Mapper11 mapper;

	@RequestMapping("sub")
	public void met() {
		
	}
	
	@GetMapping("sub01")
	@ResponseBody
	public Map<String, String> met01() {
		return Map.of("address", "seoul", "name", "son", "job", "soccer player");
	}

	@GetMapping("sub03")
	@ResponseBody
	public Map<String, Object> met03() {
		return Map.of("color", List.of("blue", "red"), "model", 5, "location", "USA");
	}
	
	@GetMapping("sub04")
	@ResponseBody
	public JavaBean18 method4() {
		return mapper.getCustomerById(30);
	}
	
	@GetMapping("sub05")
	@ResponseBody
	public JavaBean19 method5() {
		return mapper.getSupplierById(4);
	}
	
	// id로 불러오기
	@GetMapping("sub06/{id}")
	@ResponseBody
	public JavaBean18 method6(@PathVariable int id) {
		return mapper.getCustomerById(id);
	}
	
	@GetMapping("sub07/{id}")
	@ResponseBody
	public JavaBean19 met07(@PathVariable int id) {
		return mapper.getSupplierById(id);
	}
	
	// id로 불러오기
	@GetMapping("sub08/{id}")
	@ResponseBody
	public Map<String, Object> method8(@PathVariable int id) {
		Map<String, Object> map = new HashMap<>();
		
		JavaBean18 customer = mapper.getCustomerById(id);
		
		if (customer != null) {
			map.put("customer", customer);
			map.put("message", "조회 완료되었습니다.");
		} else {
			map.put("message", "조회되지 않았습니다.");
		}
		
		return map;
	}

	// id로 불러오기
	@GetMapping("sub09/{id}")
	@ResponseBody
	public Map<String, Object> method9(@PathVariable int id) {
		Map<String, Object> map = new HashMap<>();
		
		JavaBean19 supplier = mapper.getSupplierById(id);
		
		if (supplier != null) {
			map.put("supplier", supplier);
			map.put("message", "조회 완료되었습니다.");
		} else {
			map.put("message", "조회되지 않았습니다.");
		}
		
		return map;
	}
	
	@PutMapping("sub10")
	@ResponseBody
	public Map<String, String> method10(@RequestBody JavaBean18 customer) {
		Map<String, String> map = new HashMap<>();
		int cnt = mapper.updateCustomer(customer);
		if (cnt == 1) {
			map.put("message", customer.getId() + "번 고객정보가 변경되었습니다.");
		} else {
			map.put("message", customer.getId() + "번 고객정보가 변경되지 않았습니다.");
		}
		
		return map;
	}
	
	@PutMapping("sub11")
	@ResponseBody
	public Map<String, String> met11(@RequestBody JavaBean19 suppplier) {
		Map<String, String> map = new HashMap<>();
		int cnt = mapper.updateSupplier(suppplier);
		
		if(cnt == 1) {
			map.put("message", suppplier.getId() + "번 공급자정보가 변경되었습니다.");
		} else {
			map.put("message", suppplier.getId() + "번 공급자정보가 변경되지 않았습니다.");
		}
		return map;
	}
	
	@PostMapping("sub12")
	@ResponseBody
	public Map<String, String> met12(@RequestBody JavaBean18 customer) {
		Map<String, String> map = new HashMap<>();
		int cnt = mapper.insertCustomer(customer);
		if (cnt == 1) {
			map.put("message", customer.getId() + "번 고객정보가 입력되었습니다.");
		} else {
			map.put("message", "고객정보가 입력되지 않았습니다.");
		}
		
		return map;
	}
	
	@PostMapping("sub13")
	@ResponseBody
	public Map<String, String> met13(@RequestBody JavaBean19 supplier) {
		Map<String, String> map = new HashMap<>();
		int cnt = mapper.insertSupplier(supplier);
		if (cnt == 1) {
			map.put("message", supplier.getId() + "번 공급자정보가 입력되었습니다.");
		} else {
			map.put("message", "공급자 정보가 입력되지않았습니다.");
		}
		return map;
	}
	
	@DeleteMapping("sub14/{id}")
	@ResponseBody
	public Map<String, Object> method14(@PathVariable int id) {
		Map<String, Object> map = new HashMap<>();
		
		int cnt = mapper.deleteCustomer(id);
		
		if (cnt == 1) {
			map.put("message", id + "번 고객이 삭제되었습니다.");
		} else {
			map.put("message", id + "번 고객이 삭제되지 않았습니다.");
		}
		
		return map;
	}

	@DeleteMapping("sub15/{id}")
	@ResponseBody
	public Map<String, Object> method15(@PathVariable int id) {
		Map<String, Object> map = new HashMap<>();
		
		int cnt = mapper.deleteSupplier(id);
		
		if (cnt == 1) {
			map.put("message", id + "번 공급자가 삭제되었습니다.");
		} else {
			map.put("message", id + "번 공급자가 삭제되지 않았습니다.");
		}
		
		return map;
	}
}
