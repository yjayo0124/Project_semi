package web.dao.board.fish_info;

import java.util.HashMap;
import java.util.List;

import web.dto.FishInfo;
import web.dto.FreeBoard;
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
	
	/**
	 * 상세보기 게시글 조회
	 * 
	 * @param viewBoard - 조회 대상
	 * @return Board - 게시글 조회 결과
	 */
	public FishInfo selectBoardByBoardno(FishInfo fishInfo);
	
	public int selectBoardno();

	public void insert(FishInfo fishInfo);
	
	public void update(FishInfo fishInfo);

	public void delete(FishInfo fishInfo);

	/**
	 * 
	 * @param fishInfo
	 * @return 다음글 이전글 번호불러오기
	 */
	public HashMap getPrevNext(FishInfo fishInfo);
	
	/**
	 * 
	 * @param fishInfo
	 * @return 다음글 이전글 제목불러오기
	 */
	public HashMap getPrevNextName( FishInfo fishInfo ) ;
}
