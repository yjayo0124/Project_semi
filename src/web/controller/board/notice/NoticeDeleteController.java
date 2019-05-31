package web.controller.board.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Notice;
import web.service.board.notice.NoticeService;
import web.service.board.notice.NoticeServiceImpl;


@WebServlet("/board/notice/delete")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeService noticeService = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		req.getRequestDispatcher("/WEB-INF/views/board/notice/delete.jsp").forward(req, resp);
		//게시글 객체선언
		Notice notice = new Notice();
	
		int notice_no = Integer.parseInt(req.getParameter("notice_no"));
		//파라미터로 게시글 번호 가져와서 int형으로 형변환		
		notice.setNotice_no(notice_no);
		//선언한 객체에 notice_no 변수 넣어줌.
		
		
		//메소드실행
		noticeService.deleteNotice(notice);
		
		//실행이후 delete페이지로 리다이렉트
//		resp.sendRedirect("/board/notice/delete");
	
		
		
	}
	
	
}
