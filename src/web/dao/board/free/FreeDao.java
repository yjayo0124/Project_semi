package web.dao.board.free;

import java.util.List;

import web.dto.FreeBoard;
import web.dto.FreeFile;
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
	 * @param search2 
	 * 
	 * @return 테이블 전체 행 수 조회 결과
	 */
	public int selectCntAll(String select, String search);
	

	
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

	
	// 파일 업로드 쪽
	public int selectBoardno();

	//삽입될 게시글 내용
	public void insert(FreeBoard board);

	//첨부파일 입력
	public void insertFile(FreeFile boardFile);


	/**
	 * 첨부파일 조회
	 * 
	 * @param board - 첨부파일을 조회할 게시글 객체
	 * @return BoardFile - 조회된 첨부파일
	 */
	
	public FreeFile selectFile(FreeBoard board);

	public FreeFile selectByFileno(int fileno);

	public void update(FreeBoard board);

	public void delete(FreeBoard board);

	public void deleteFile(FreeBoard board);

}
