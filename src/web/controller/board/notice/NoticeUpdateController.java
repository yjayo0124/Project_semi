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

@WebServlet("/board/notice/update")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private NoticeService noticeService = new NoticeServiceImpl();
	private NoticeDao noticeDao = new NoticeDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Notice notice = new Notice();
		//----------------------------------------------		
		String param = req.getParameter("notice_no");
		
		int notice_no = 0;
		if( param!=null && !"".equals(param) ) {
			notice_no = Integer.parseInt(param);
		}
		//---------------------------------------------		
		
		
		notice.setNotice_no(notice_no);

		Notice res = new Notice();
		
		res = noticeDao.selectNoticeByNoticeno(notice);
		//-------
		
		req.setAttribute("notice", res);
					
		req.getRequestDispatcher("/WEB-INF/views/board/notice/update.jsp").forward(req, resp);
	
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Notice notice = new Notice();

		
	//	String param = req.getParameter("notice_no");
		
		int notice_no = Integer.parseInt(req.getParameter("notice_no"));
		

		//파라미터에서 게시글 객체 가져와서 notice변수에 담음.
		notice.setNotice_no(notice_no);
		notice.setNotice_title(req.getParameter("notice_title"));
		notice.setNotice_content(req.getParameter("notice_content"));
		
		
	//	System.out.println(notice);
		
		//위에 변수를 이제 update메소드에 파라미터로 넣는다.
		noticeService.updateNotice(notice);
		
		resp.sendRedirect("/board/notice/list");
		
		
	}
	
}
