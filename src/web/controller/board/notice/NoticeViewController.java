package web.controller.board.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.board.notice.NoticeDao;
import web.dao.board.notice.NoticeDaoImpl;
import web.dto.Notice;
import web.service.board.notice.NoticeService;
import web.service.board.notice.NoticeServiceImpl;


@WebServlet("/board/notice/view")
public class NoticeViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private NoticeService noticeService = new NoticeServiceImpl();
	private NoticeDao noticeDao = new NoticeDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Notice notice = noticeService.getNoticeno(req);
		notice = noticeService.viewNotice(notice);
		//    <--게시글번호로 가져온 글 객체를 좌변에 담음
//		System.out.println(notice);
//		System.out.println(req.getSession().getAttribute("member_id"));

		boolean writer_check;
		//작성자==로그인객체 비교하는 메소드
		writer_check = noticeService.CheckWriter(notice.getMember_id(), req);
		//작성자 == 로그인객체라면 true 반환 아니라면 false반환
		
		// writer체크하는 model 전송 
		req.setAttribute("writer_check", writer_check);
		
		//--ㅡmodel전송
		req.setAttribute("notice", notice);
			
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/board/notice/view.jsp").forward(req, resp);
	
	
	}
	

}
