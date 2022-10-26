package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean04;
import org.zerock.domain.lecture.JavaBean05;
import org.zerock.domain.lecture.JavaBean06;
import org.zerock.mapper.lecture.Mapper03;

@Controller
@RequestMapping("ex30")
public class Controller30 {

	@Autowired // 주입
	private Mapper03 mapper;
	
	@RequestMapping("sub01")
	public void met01() {
		JavaBean04 customer = mapper.getCustomer();
		System.out.println(customer);
	}
	
	@RequestMapping("sub02")
	public void met02() {
		JavaBean05 employee = mapper.getEmployee();
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
	}
	
	@RequestMapping("sub03")
	public void met03() {
		JavaBean05 emp = mapper.getEmployee2();
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
	}
	
	@RequestMapping("sub04")
	public void met04() {
		JavaBean04 cus = mapper.getCustomer2();
		System.out.println(cus.getName());
		System.out.println(cus.getCountry());
	}
	
	@RequestMapping("sub05")
	public void met05() {
		JavaBean06 pro = mapper.getProduct();
		System.out.println(pro.getName());
		System.out.println(pro.getPrice());
	}
}
