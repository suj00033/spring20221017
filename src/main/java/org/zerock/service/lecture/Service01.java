package org.zerock.service.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.mapper.lecture.Mapper11;

@Service // 안에 component메소드 있음
public class Service01 {

	@Autowired
	private Mapper11 mapper;
	
	public JavaBean18 getCustomer(int id) {
		// 비지니스 로직
		return mapper.getCustomerById(id);
	}

	@Transactional 
	public void transferMoney() {
		// 1번 고객의 돈을 (500원)
		// 2번 고객에게 전달
		int cnt = mapper.updateBank(1, -500); // 오류나는 코드를 돌리면 1번만 성공하고 오류가 나서 @Transactional이 작동되어 컷당함
											  // 컷당해서 둘다 돈이 그대로 멈춰있음, 별일없으면 Service에서는 이 어노테이션에 붙이자
		System.out.println(cnt + "건 성공");  // 이 어노테이션을 사용안하면 1번 계좌만 돈이 빠져나가고 2번 계좌에는 돈안들어옴
		
		// 오류나는 코드
//		int a = 3/0;
		
		mapper.updateBank(2, 500);
	}
}
