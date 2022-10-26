package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.mapper.lecture.Mapper01;

@Controller
@RequestMapping("ex28")
public class Controller28 {

	@Autowired
	private Mapper01 mapper;

	@RequestMapping("sub01")
	public void met01() {
		String time = mapper.getCurrentTime();
		System.out.println(time);
	}
	
	@RequestMapping("sub02")
	public void met02() {
		System.out.println(mapper.getCustomerName());
	}
	
	@RequestMapping("sub03")
	public void met03() {
		System.out.println(mapper.getEmployeeName());
	}
	
	@RequestMapping("sub04")
	public void met04() {
		System.out.println(mapper.getProductName());
	}
	
	@RequestMapping("sub05")
	public void met05()	{
		System.out.println(mapper.getPrice());
	}
	
	@RequestMapping("sub06")
	public void met06() {
		System.out.println(mapper.getQuantity());
	}

	@RequestMapping("sub07")
	public void met07() {
		System.out.println(mapper.getBirthDate());
	}
}
