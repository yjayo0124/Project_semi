package web.service.board.fish_info;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
}
