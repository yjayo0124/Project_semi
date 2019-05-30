package web.controller.board.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.board.notice.NoticeDao;
import web.dao.board.notice.NoticeDaoImpl;
import web.service.board.notice.NoticeService;
import web.service.board.notice.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeWriteController
 */
@WebServlet("/board/notice/write")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeService noticeService = new NoticeServiceImpl();
	private NoticeDao noticeDao = new NoticeDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		
		//만약 세션에 로그인 객체가 없다면,글쓰기 버튼 눌렀을 시 공지사항게시판으로 리다이렉트해줌 
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/board/notice/list");
			return;
		}
		
		//위에서 세션확인됐으면-->글쓰기폼으로 이동시킴
		req.getRequestDispatcher("/WEB-INF/views/board/notice/write.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		

		
		//db에 insert메소드 실행
		noticeService.writeNotice(req);
		
		//post버튼 누르고 목록으로 이동시킴
		resp.sendRedirect("/board/notice/list");
		
	}
	
	
	
}
