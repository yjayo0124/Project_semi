package web.service.board.boast;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.boast.BoastBoard;
import web.dto.boast.BoastFile;
import web.util.Paging;
import web.util.boast.BoastPaging;

public interface BoastService {

	/**
	 * 게시글 리스트 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 게시글을 조회한 결과
	 */
	public List getList(BoastPaging paging);

	/**
	 * 요청파라미터에서 curPage를 파싱한다
	 * 
	 * @param req - 요청정보객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public BoastPaging getCurPage(HttpServletRequest req);

	/**
	 * 요청파라미터에서 boardno를 파싱한다
	 * 
	 * @param req - 요청정보객체
	 * @return Board - boardno를 입력한 객체
	 */
	public BoastBoard getBoardno(HttpServletRequest req);
	
	/**
	 * 상세보기 게시글 조회
	 * 
	 * @param viewBoard - 상세보기할 boardno를 가진 객체
	 * @return Board - 상세보기할 게시글 조회 결과
	 */
	public BoastBoard view(BoastBoard viewBoard);
	
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
	
	/**
	 * 첨부파일 얻기
	 * 
	 * @param board - 첨부파일을 조회할 게시글 번호 객체
	 * @return BoardFile - 게시글에 첨부된 파일 정보
	 */
	public BoastFile viewFile(BoastBoard board);
	
	/**
	 * 글 작성자인지 판단하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return boolean - true : 로그인한 사람이 글 작성자
	 */
	public boolean checkWriter(HttpServletRequest req);

	/**
	 * 게시글 수정
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void update(HttpServletRequest req);
	
	/**
	 * 게시글 삭제
	 * 
	 * @param board - 삭제할 게시글 번호를 가진 객체
	 */
	public void delete(BoastBoard board);
}
