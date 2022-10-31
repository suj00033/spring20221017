package org.zerock.mapper.board;

import java.util.List;

import org.zerock.domain.board.BoardDto;

public interface BoardMapper {
	
	int insert(BoardDto board);

	List<BoardDto> list();

	BoardDto select(int id);

	int update(BoardDto board);

	int delete(int id);
}
