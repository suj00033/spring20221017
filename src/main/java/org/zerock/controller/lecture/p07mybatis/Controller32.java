package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean07;
import org.zerock.domain.lecture.JavaBean08;
import org.zerock.domain.lecture.JavaBean09;
import org.zerock.mapper.lecture.Mapper05;

@Controller
@RequestMapping("ex32")
public class Controller32 {

	@Autowired
	private Mapper05 mapper;
	
	@RequestMapping("sub01")
	public void met01() {
		JavaBean07 order = mapper.getOrder();
		System.out.println(order);
	}

	// 자바빈 안에 또 자바빈을 처리하는 방법
	@RequestMapping("sub02")
	public void met02() {
		JavaBean08 order = mapper.getOrder2();
		System.out.println(order);
	}
	
	@RequestMapping("sub03")
	public void met03() {
		JavaBean09 product = mapper.getProduct();
		System.out.println(product.getId()); // 10
		System.out.println(product.getName()); // Ikura
		System.out.println(product.getPrice()); // 31.00
		System.out.println(product.getSupplier().getId()); // 4
		System.out.println(product.getSupplier().getName()); // Tokyo Traders
		System.out.println(product.getSupplier().getPhone()); // (03) 3555-5011
	}
	
}
