package org.zerock.service.board;

import java.io.File;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.PageInfo;
import org.zerock.mapper.board.BoardMapper;
import org.zerock.mapper.board.ReplyMapper;

// Mapper에게 일 시키기
@Service
// @Transactional에 붙여도 상관무
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	// 게시글 등록
	@Transactional
	public int register(BoardDto board, MultipartFile[] files) {
		// db에 게시물 정보 저장
		int cnt = boardMapper.insert(board);
		
		for(MultipartFile file : files)
			if (file != null && file.getSize() > 0) {
				
			// db에 파일 저장
			// 파일명, 게시물id 정보가 있어야함
			boardMapper.insertFile(board.getId(), file.getOriginalFilename());
			
			// 파일 저장
			// 파일이 업로드 될때마다 board id를 가져와 새폴더 만드는 작업
			File folder = 
					new File("C:\\Users\\user\\Desktop\\study\\upload\\prj1\\board\\" + board.getId());
			folder.mkdirs();
			
			File dest = new File(folder, file.getOriginalFilename());
			
			try {
				// 받은 파일을 목적지로 전송 transferTo
				file.transferTo(dest);
		 	} catch (Exception e) {
		 		// @Transactional은 RuntiemExecption에서만 rollback됨 
		 		e.printStackTrace();
		 		throw new RuntimeException(e);
		 		}
			
			}
			return cnt;
	}

	// 게시글 목록 보기
	public List<BoardDto> listBoard(int page, String type, String keyword, PageInfo pageInfo) { 
		// 몇개 (두번째 ?, 0부터 10개를 보여주겠다)
		int records = 10;
		int offset = (page - 1) * records;
		
		int countAll = boardMapper.countAll(type, "%" + keyword + "%"); // SELECT Count(*) FROM Board
		int lastPage = (countAll - 1) / records + 1;
		
		int leftPageNumber = (page - 1) / 10 * 10 + 1;
		int rightPageNumber = leftPageNumber + 9;
		rightPageNumber = Math.min(rightPageNumber, lastPage);
		
		// 이전버튼 유무
		boolean hasPreButton = page > 10;
		// 다음버튼 유무
		boolean hasNextButton = page <= ((lastPage - 1) / 10 * 10);
		
		// 이전버튼 눌렀을 때 가는 페이지 번호
		int jumpPrePageNumber = (page - 1) / 10 * 10 - 9;
		int jumpNextPageNumber = (page - 1) / 10 * 10 + 11; 
		
		pageInfo.setHasPreButton(hasPreButton);
		pageInfo.setHasNextButton(hasNextButton);
		pageInfo.setJumpPrePageNumber(jumpPrePageNumber);
		pageInfo.setJumpNextPageNumber(jumpNextPageNumber);
		pageInfo.setCurrentPageNumber(page);
		pageInfo.setLeftPageNumber(leftPageNumber);
		pageInfo.setRightPageNumber(rightPageNumber);
		pageInfo.setLastPageNumber(lastPage);
		
		return boardMapper.list(offset, records, type, "%" + keyword + "%");
	}
	

	// 게시글 선택해서 내용보기
	public BoardDto get(int id) {
		return boardMapper.select(id);
	}

	public int update(BoardDto board) {
		
		return boardMapper.update(board);	
	}

	// 한꺼번에 일어나는 작업에서 오류가 나지않도록 예외처리
	// 댓글 추가, 삭제 메소드 변경
	@Transactional
	public int remove(int id) {
		// 게시물의 댓글들 지우기
		replyMapper.deleteByBoardId(id);
		
// int a = 3 / 0; // run time => 오류가 나면 댓글과 게시글이 삭제되지않도록
		
		// 게시물 지우기
		return boardMapper.delete(id);
	}
	

}
