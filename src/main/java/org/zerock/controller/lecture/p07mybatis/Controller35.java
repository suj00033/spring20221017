package org.zerock.controller.lecture.p07mybatis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean04;
import org.zerock.domain.lecture.JavaBean16;
import org.zerock.domain.lecture.JavaBean17;
import org.zerock.mapper.lecture.Mapper09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("ex35")
public class Controller35 {

	@Autowired
	private Mapper09 mapper;
	
	// ?으로 입력받은 id값 출력하기
	@RequestMapping("sub01")
	public void met01() {
		String name1 = mapper.getCustomerNameById(1);
		String name2 = mapper.getCustomerNameById(2);
		
		System.out.println(name1);
		System.out.println(name2);
	}
	
	@RequestMapping("sub02")
	public void method2() {
		/*
		 * SELECT FirstName FROM Employees WHERE EmployeeID = ?
		 * 
		 */
		String name1 = mapper.getEmployeeFirstNameById(1);
		String name2 = mapper.getEmployeeFirstNameById(2);
		
		System.out.println(name1);
		System.out.println(name2);
	}
	
	@RequestMapping("sub03")
	public void method3() {
		List<String> berlin = mapper.getCustomerNameByCityAndCountry("Germany", "Berlin");
		List<String> london = mapper.getCustomerNameByCityAndCountry("UK", "London");
		
		System.out.println(berlin);
		System.out.println(london);
	}
	
	@RequestMapping("sub04")
	public void met04() {
		String londona = mapper.getSupplierNameByCityAndCountry("UK", "Londona");
		String newOl = mapper.getSupplierNameByCityAndCountry("USA", "New Orleans");
		
		System.out.println(londona);
		System.out.println(newOl);
	}
	
	// /ex35/sub05?name=Alfreds Futterkiste&country=Germany
	// /ex35/sub05?name=Antonio Moreno Taquería&country=Mexico
	@RequestMapping("sub05")
	public void met05(JavaBean04 p) {
		String c1 = mapper.getContactName(p);
		System.out.println(c1);
	}
	// /ex35/sub06?name=Grandma Kelly's Homestead&country=USA
	@RequestMapping("sub06")
	public void mer06(JavaBean04 b) {
		String c = mapper.getSupplierContactName(b);
		System.out.println(c);
	}
	
	// /ex35/sub07?categoryId=1&price=10.00
	// /ex35/sub07?categoryId=2&price=20.00
		
		@RequestMapping("sub07")
		public void method7(JavaBean16 p1, JavaBean17 p2) {
			
			List<String> list = mapper.getProductName(p1, p2);
			list.forEach(System.out::println);
		}
	}

