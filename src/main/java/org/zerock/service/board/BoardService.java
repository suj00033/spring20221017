package org.zerock.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.board.BoardDto;
import org.zerock.mapper.board.BoardMapper;

// Mapper에게 일 시키기
@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	// 게시글 등록
	public int register(BoardDto board) {
		return mapper.insert(board);
		
	}

	// 게시글 목록 보기
	public List<BoardDto> listBoard() {
		return mapper.list();
	}

	// 게시글 선택해서 내용보기
	public BoardDto get(int id) {
		return mapper.select(id);
	}

	public int update(BoardDto board) {
		
		return mapper.update(board);	
	}

	public int remove(int id) {
		return mapper.delete(id);
	}

}
