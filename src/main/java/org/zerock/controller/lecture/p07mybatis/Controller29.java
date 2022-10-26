package org.zerock.controller.lecture.p07mybatis;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.mapper.lecture.Mapper02;

// 여러 데이터를 가지고 올때 리스트로
@Controller
@RequestMapping("ex29")
public class Controller29 {

	@Autowired
	private Mapper02 mapper;
	
	@RequestMapping("sub01")
	public void met01() {
		List<String> names = mapper.getCustomerNames();
		System.out.println(names.size());
		System.out.println(names.get(0));
		System.out.println(names.get(1));
	}
	
	@RequestMapping("sub02")
	public void met02() {
		List<Integer> ids = mapper.getCustomerIDs();
		System.out.println(ids.size());
		System.out.println(ids.get(0));
		System.out.println(ids.get(1)); // 2개만 출력
	}
	
	@RequestMapping("sub03")
	public void met03() {
		List<Double> priceList = mapper.getProductPrices();
		System.out.println(priceList.size());
		System.out.println(priceList.get(0));
		System.out.println(priceList.get(1));
	}
	
	@RequestMapping("sub04")
	public void met04() {
		List<LocalDate> birthDateList = mapper.getEmployeeBirthDate();
		System.out.println(birthDateList.size());
		birthDateList.forEach(System.out::println);
	}
	
	// 여러 컬럼이 있을때는 자바빈을 만들어야함
}
