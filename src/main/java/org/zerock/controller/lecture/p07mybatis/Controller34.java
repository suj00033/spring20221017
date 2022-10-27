package org.zerock.controller.lecture.p07mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean13;
import org.zerock.domain.lecture.JavaBean14;
import org.zerock.domain.lecture.JavaBean15;
import org.zerock.mapper.lecture.Mapper07;
import org.zerock.mapper.lecture.Mapper08;


@Controller
@RequestMapping("ex34")
public class Controller34 {
	
	@Autowired
	private Mapper07 mapper;
	
	@Autowired
	private Mapper08 mapper8;

	@RequestMapping("sub01")
	public void met01() {
		JavaBean13 category = mapper.getCategory();
		System.out.println(category.getId());
		System.out.println(category.getName());
		category.getProduct().forEach(p -> {
			System.out.println(p.getId());     // id값이 있어야 성능향상
			System.out.println(p.getName());
			System.out.println(p.getPrice());
		});
	}
		
		@RequestMapping("sub02")
		public void method2() {
			JavaBean15 supplier = mapper.getSupplier();
			System.out.println(supplier.getId());
			System.out.println(supplier.getName());
			
			List<JavaBean14> product = supplier.getProduct(); // getProduct를 만들지 않았지만 실행된 이유는 mapper 인터페이스에 롬복@Data적용
			product.forEach(p -> {
				System.out.println(p.getId());
				System.out.println(p.getName());
				System.out.println(p.getPrice());
			});
		}
		
		// 부등호 <, > 쿼리 처리
		@RequestMapping("sub03")
		public void method3() {
			System.out.println("####### entity 로 해결 #########");
			mapper8.getProductName().forEach(System.out::println);
			
			System.out.println("####### CDATA 요소로 해결 #########");
			mapper8.getProductName2().forEach(System.out::println);
		}
		
		@RequestMapping("sub04")
		public void method4() {
			System.out.println("=====================================");
			mapper8.getEmployeeFirstName().forEach(System.out::println);
		}
}
