package web.dao.board.boast;

import java.util.HashMap;
import java.util.List;

import web.dto.boast.BoastBoard;
import web.dto.boast.BoastFile;
import web.util.boast.BoastPaging;

public interface BoastDao {
	/**
	 * 테이블 전체 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 테이블 전체 조회 결과
	 */
	public List selectAll(BoastPaging paging);
	
	/**
	 * 테이블 전체 COUNT 조회
	 * @param search2 
	 * 
	 * @return 테이블 전체 행 수 조회 결과
	 */
	public int selectCntAll(String search, String search2);
	

	
	/**
	 * 조회되는 게시글의 조회수 +1
	 * 
	 * @param viewBoard - 조회 대상
	 */
	public void updateHit(BoastBoard viewBoard);
	
	/**
	 * 상세보기 게시글 조회
	 * 
	 * @param viewBoard - 조회 대상
	 * @return Board - 게시글 조회 결과
	 */
	public BoastBoard selectBoardByBoardno(BoastBoard viewBoard);

	
	// 파일 업로드 쪽
	public int selectBoardno();

	//삽입될 게시글 내용
	public void insert(BoastBoard board);

	//첨부파일 입력
	public void insertFile(BoastFile boardFile);


	/**
	 * 첨부파일 조회
	 * 
	 * @param board - 첨부파일을 조회할 게시글 객체
	 * @return BoardFile - 조회된 첨부파일
	 */
	
	public BoastFile selectFile(BoastBoard board);

	public BoastFile selectByFileno(int fileno);

	public void update(BoastBoard board);

	public void delete(BoastBoard board);

	public void deleteFile(BoastBoard board);
	
	public BoastBoard selectrecommend( BoastBoard board ) ;

	public HashMap getPrevNext(BoastBoard viewBoard);

	public HashMap getPrevNextName(BoastBoard viewBoard);

}
