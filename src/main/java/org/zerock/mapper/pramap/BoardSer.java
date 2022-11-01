package org.zerock.mapper.pramap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.prado.BoardVO;

@Service
public class BoardSer {

	@Autowired
	private BoardMap mapper;

	public int register(BoardVO board) {
		return mapper.insert(board);
		
	}
}
