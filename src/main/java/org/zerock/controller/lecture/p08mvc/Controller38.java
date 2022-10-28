package org.zerock.controller.lecture.p08mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.service.lecture.Service01;

@Controller
@RequestMapping("ex38")
public class Controller38 {

	@Autowired
	private Service01 service;
	
	@RequestMapping("sub01")
	public void met01() {
		// request 파라미터 수집/가공
		int id = 5;
		// 비지니스 로직
		JavaBean18 customer = service.getCustomer(id);
		
		System.out.println(customer);
		// 모델에 어트리뷰트 추가
		
		// 포워드/리다이렉트
	}
	
	@RequestMapping("sub02")
	public void met02() {
		// 리퀘스트
		
		// 비지니스 로직
		service.transferMoney();
		
		
	}
}
