package web.dao.board.sell.face;

import java.util.HashMap;
import java.util.List;

import web.dto.SellBoard;
import web.dto.SellFile;
import web.util.Paging;

public interface SellDao {
	/*
	 * 테이블 전체조회
	 * 
	 */
	public List selectAll(Paging paging);
	
	public int selectCntAll(String select, String search);
	
	public void updateHit(SellBoard viewBoard);
	
	public SellBoard selectBoardByBoardno(SellBoard viewBoard);
	
	public int selectBoardno();
	
	/**
	 * 게시글 입력
	 * 
	 * @param board - 삽입될 게시글 내용
	 */
	public void insert(SellBoard board);
	
	
	public void insertFile(SellFile boardFile);
	
	public SellFile selectFile(SellBoard SellBoard);
	
	public SellFile selectByFileno(int fileno);
	
	public void update(SellBoard board);
	
	public void updateFile(SellFile sellfile);
	
	public void delete(SellBoard board);
	
	public void deleteFile(SellBoard board);
	
	public HashMap getPrevNext(SellBoard board);
	
	public HashMap getPrevNextName(SellBoard board);
	
	
}
