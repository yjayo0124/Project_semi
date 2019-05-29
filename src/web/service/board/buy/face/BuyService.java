package web.service.board.buy.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import web.dto.BuyBoard;
import web.util.Paging;

public interface BuyService {

	// 게시글 리스트 조회
	public List getList(Paging paging);
	
	/**
	 * 요청파라미터에서 boardno를 파싱한다
	 * 
	 * @param req - 요청정보객체
	 * @return Board - boardno를 입력한 객체
	 */
	public Paging getCurPage(HttpServletRequest req);
	
	/**
	 * 요청파라미터에서 boardno를 파싱한다
	 * 
	 * @param req - 요청정보객체
	 * @return Board - boardno를 입력한 객체
	 */
	public BuyBoard getBoardno(HttpServletRequest req);
	
	/**
	 * 상세보기 게시글 조회
	 * 
	 * @param viewBoard - 상세보기할 boardno를 가진 객체
	 * @return Board - 상세보기할 게시글 조회 결과
	 */
	public BuyBoard view(BuyBoard viewBoard);
	
	
}
