package web.dao.board.buy.face;

import java.util.List;

import web.dto.BuyFile;
import web.dto.BuyBoard;
import web.util.Paging;

public interface BuyDao {
	
	/*
	 * 테이블 전체조회
	 * 
	 */
	public List selectAll(Paging paging);
	
	public int selectCntAll(String select, String search);
	
	public void updateHit(BuyBoard viewBoard);
	
	public BuyBoard selectBoardByBoardno(BuyBoard viewBoard);
	
	public int selectBoardno();
	
	/**
	 * 게시글 입력
	 * 
	 * @param board - 삽입될 게시글 내용
	 */
	public void insert(BuyBoard board);
	
	
	public void insertFile(BuyFile boardFile);
	
	public BuyFile selectFile(BuyBoard buyboard);
	
	public BuyFile selectByFileno(int fileno);
	
	public void update(BuyBoard board);
	
	public void updateFile(BuyFile buyfile);
	
	public void delete(BuyBoard board);
	
	public void deleteFile(BuyBoard board);
	
	
	
	
}
