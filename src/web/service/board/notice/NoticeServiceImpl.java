package web.service.board.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.board.notice.NoticeDao;
import web.dao.board.notice.NoticeDaoImpl;
import web.dto.Notice;
import web.util.Paging;

public class NoticeServiceImpl implements NoticeService{

	private NoticeDao noticeDao = new NoticeDaoImpl();
	
	
	
	@Override
	public List getList(Paging paging) {
	
		return noticeDao.selectAll(paging);
	}

	@Override
	public Paging getCurPage(HttpServletRequest req) {
		// 전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
						
		//검색어
		String search = (String)req.getParameter("search");
				
		// 전체 게시글 수
		int totalCount = noticeDao.selectCntAll(search);
						
		// 페이징 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearch(search);
//		System.out.println(paging); //TEST
				
		return paging;
	}

	@Override
	public Notice getNoticeno(HttpServletRequest req) {
		
		// 전달파라미터로 공지사항번호 가져오기
		String param = req.getParameter("notice_no");
		int notice_no = 0;
		if( param!=null && !"".equals(param) ) {
			notice_no = Integer.parseInt(param);
		}
		
		//공지사항 객체 생성
		Notice notice = new Notice();
		notice.setNotice_no(notice_no);
		
		//파라미터로 얻은 번호 가져와서 객체에 담고 그걸 return
		return notice;
		
	}

	@Override
	public Notice viewNotice(Notice notice) {
		
		//공지사항 조회수 +1
		noticeDao.updateHit(notice);
		
		//게시글 조회 반환 ㄱ메소드
		return noticeDao.selectNoticeByNoticeno(notice);
		
		
		
	}

	@Override
	public void writeNotice(HttpServletRequest req) {
		
		//공지사항 객체 선언
		Notice notice = new Notice();
		
		String notice_writer = (String) req.getSession().getAttribute("member_nick");  //세션객체에서 닉네임가져와서 공지사항 글쓴이에 넣고
		String notice_writer_id = (String) req.getSession().getAttribute("member_id"); //세션객체에서 id가져와서 공지사항을 쓴 사람 id에 넣는다.
		//parameter를 통해 값을 위 객체에 넣는다
		notice.setNotice_no(noticeDao.selectNoticeno());
		notice.setNotice_title(req.getParameter("notice_title"));
		notice.setNotice_writer(notice_writer); //글쓴 닉네임
		notice.setNotice_content(req.getParameter("notice_content"));
		notice.setMember_id(notice_writer_id); //글쓴사람 id
		
		
		//값을 넣은 객체를 insert메소드로 보낸다.
		noticeDao.insert(notice);
		
		
		
	}

	@Override
	public void deleteNotice(Notice notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean CheckWriter(HttpServletRequest req) {
		
		//로그인한 세션 ID 얻기
		String loginId = (String) req.getSession().getAttribute("member");

		//작성한 게시글 번호 얻기
		Notice notice = getNoticeno(req);
		
		//게시글 얻어오기
		notice = noticeDao.selectNoticeByNoticeno(notice);
		
		//게시글의 작성자와 로그인 아이디 비교
		if( !loginId.equals(notice.getNotice_writer()) ) {
			return false;
		}
		
		return true;
		
	}

}
