package org.zerock.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.member.MemberDto;
import org.zerock.mapper.member.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	// 회원가입
	public int insert(MemberDto member) {
		
		return mapper.insert(member);
	}

	// 회원목록
	public List<MemberDto> list() {
		return mapper.selectAll();
	}

	// 회원 정보 보기
	public MemberDto getById(String id) {
		return mapper.selectById(id);
	}

	
}
