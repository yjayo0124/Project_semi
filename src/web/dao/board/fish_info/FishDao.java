package web.dao.board.fish_info;

import java.util.List;

import web.util.Fish_Paging;
import web.util.Paging;

public interface FishDao {
	
	/**
	 * 테이블 전체 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 테이블 전체 조회 결과
	 */
	public List selectAll(Fish_Paging paging) ;
	
	/**
	 * 테이블 전체 COUNT 조회
	 * 
	 * @return 테이블 전체 행 수 조회 결과
	 */
	public int selectCntAll();
	
}
