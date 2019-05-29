package web.dao.board.free;

import java.util.List;

import web.dto.FreeBoard;
import web.util.Paging;

public interface FreeDao {

	/**
	 * 테이블 전체 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 테이블 전체 조회 결과
	 */
	public List selectAll(Paging paging);
	
	/**
	 * 테이블 전체 COUNT 조회
	 * 
	 * @return 테이블 전체 행 수 조회 결과
	 */
	public int selectCntAll();
	

	
	/**
	 * 조회되는 게시글의 조회수 +1
	 * 
	 * @param viewBoard - 조회 대상
	 */
	public void updateHit(FreeBoard viewBoard);
	
	/**
	 * 상세보기 게시글 조회
	 * 
	 * @param viewBoard - 조회 대상
	 * @return Board - 게시글 조회 결과
	 */
	public FreeBoard selectBoardByBoardno(FreeBoard viewBoard);

}
