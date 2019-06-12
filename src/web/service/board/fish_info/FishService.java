package web.service.board.fish_info;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.FishInfo;
import web.dto.FreeBoard;
import web.util.Fish_Paging;
import web.util.Paging;

public interface FishService {
	/**
	 * 게시글 리스트 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 게시글을 조회한 결과
	 */
	public List getList(Fish_Paging paging);
	
	/**
	 * 요청파라미터에서 curPage를 파싱한다
	 * 
	 * @param req - 요청정보객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Fish_Paging getCurPage(HttpServletRequest req);
	
	public FishInfo getBoardno(HttpServletRequest req);
	
	/**
	 * 상세보기 게시글 조회
	 * 
	 * @param viewBoard - 상세보기할 boardno를 가진 객체
	 * @return Board - 상세보기할 게시글 조회 결과
	 */
	public FishInfo view(FishInfo fishInfo);
	
	/**
	 * 게시글 작성
	 * 	입력한 게시글 내용을 DB에 저장
	 * 
	 *  [ 예정 ] 첨부파일을 함께 업로드 할 수 있도록 처리
	 * 
	 * @param req - 요청정보 객체(게시글내용 + 첨부파일)
	 * 
	 */
	public void write(FishInfo fishInfo);
	
	public boolean checkWriter(HttpServletRequest req);
	
	public void update(FishInfo fishInfo);

	public void delete(FishInfo fishInfo);
	
	public HashMap getPrevNext(FishInfo fishInfo);
	
	public HashMap getPrevNextName(FishInfo fishInfo);
	
	public int getBoardNo();
}
