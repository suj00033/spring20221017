package org.zerock.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.PageInfo;
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
	public List<BoardDto> listBoard(int page, PageInfo pageInfo) { 
		// 몇개 (두번째 ?, 0부터 10개를 보여주겠다)
		int records = 10;
		int offset = (page - 1) * records; // 어디서부터 (첫번째 ?)
		
		// 마지막 페이지 SELECT Count(*) FROM Board;
		int countAll = mapper.countAll();
		int lastPage = (countAll - 1) / records + 1;
		
		int leftPageNumber = (page - 1) / 10 * 10 + 1;
		int rightPageNumber = leftPageNumber + 9;
		rightPageNumber = Math.min(rightPageNumber, lastPage);
		
		pageInfo.setCurrentPageNumber(page);
		pageInfo.setLeftPageNumber(leftPageNumber);
		pageInfo.setRightPageNumber(rightPageNumber);
		pageInfo.setLastPageNumber(lastPage); //pageInfo domain
		
		return mapper.list(offset, records);
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
