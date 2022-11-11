package org.zerock.mapper.member;

import java.util.List;

import org.zerock.domain.member.MemberDto;

public interface MemberMapper {
	// 회원가입
	int insert(MemberDto member);

	// 회원목록 보기
	List<MemberDto> selectAll();

	// 회원 정보 보기
	MemberDto selectById(String id);
}
