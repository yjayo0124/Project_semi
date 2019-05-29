package web.dao.board.buy.face;

import java.util.List;

import web.dto.BuyBoard;
import web.util.Paging;

public interface BuyDao {
	
	/*
	 * 테이블 전체조회
	 * 
	 */
	public List selectAll(Paging paging);
	
	public int selectCntAll();
	
	public BuyBoard selectBoardByBoardno(BuyBoard viewBoard);
}
