package web.dao.board.notice;

import java.util.List;

import web.dto.Notice;
import web.util.Paging;

public interface NoticeDao {

	//조회대상 페이징 객체
	public List selectAll(Paging paging);
	
	//테이블 전체 행 수 조회 결과
	public int selectCntAll(String search);
	
	//공지사항 조회수 +1해주는 메소드
	public void updateHit(Notice notice);
	
	//공지사항 보여줄 메소드를 notice번호를 통해
	public Notice selectNoticeByNoticeno(Notice notice);
	
	//공지사항 번호 가져오는 메소드
	public int selectNoticeno();
	
	public void insert(Notice notice);
	
	public void update(Notice notice);
	
	public void delete(Notice notice);
	
	
	
}
