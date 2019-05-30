package web.service.board.buy.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.BuyBoard;
import web.dto.BuyFile;
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
	

	/**
	 * 게시글 작성
	 * 	입력한 게시글 내용을 DB에 저장
	 * 
	 *  [ 예정 ] 첨부파일을 함께 업로드 할 수 있도록 처리
	 * 
	 * @param req - 요청정보 객체(게시글내용 + 첨부파일)
	 * 
	 */
	public void write(HttpServletRequest req);
	
	
	public BuyFile viewFile(BuyBoard buyboard);
	
	
	public boolean checkWriter(HttpServletRequest req);
	
	public void update(HttpServletRequest req);
	
	public void delete(BuyBoard board);
	
}