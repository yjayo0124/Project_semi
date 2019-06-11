package web.service.board.boast;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.BuyBoard;
import web.dto.Comment;
import web.dto.boast.BoastBoard;
import web.dto.boast.BoastComment;
import web.dto.boast.BoastFile;
import web.dto.boast.Recommend;
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
	
	// --- 댓글
		/**
		 * 댓글 전달파라미터 꺼내기
		 */
		public BoastComment getComment(HttpServletRequest req);
		
		/**
		 * 댓글 입력
		 * 
		 * @param comment - 삽입될 댓글
		 */
		public void insertComment(BoastComment comment);
		
		/**
		 * 댓글 리스트
		 * 
		 * @param board - 댓글이 조회될 게시글
		 * @return List - 댓글 리스트
		 */
		public List getCommentList(BoastBoard board);
		
		/**
		 * 댓글 삭제
		 *  
		 * @param comment - 삭제할 댓글
		 * @return boolean - 삭제 성공 여부
		 */
		public boolean deleteComment(BoastComment comment);
		
		/**
		 * 게시글 추천 상태 조회
		 * 
		 * @param recommend - 추천 상태 체크 객체
		 * @return boolean - true:추천했음, false:추천하지않았음
		 */
		public boolean isRecommend(Recommend recommend);
		
		/**
		 * 추천 정보 파라미터 얻기
		 * 
		 * @param req - 요청 정보 객체
		 * @return Recommend - 추천 정보 객체
		 */
		public Recommend getRecommend(HttpServletRequest req);
		
		/**
		 * 추천 토글
		 * 
		 * @param recommend - 추천 정보 객체
		 * @return boolean - true:추천 성공, false:추천취소 성공
		 */
		public boolean recommend(Recommend recommend);
		
		/**
		 * 게시글의 총 추천 수 구하기
		 * 
		 * @param board - 해당 게시글
		 * @return int - 총 추천 수
		 */
		public int getTotalCntRecommend(Recommend recommend);

		public HashMap getPrevNext(BoastBoard viewBoard);

		public HashMap getPrevNextName(BoastBoard viewBoard);
}
