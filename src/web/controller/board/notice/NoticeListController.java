package web.controller.board.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.member.MemberDao;
import web.dao.member.MemberDaoImpl;
import web.dto.MemberDetail;
import web.service.board.notice.NoticeService;
import web.service.board.notice.NoticeServiceImpl;
import web.util.Paging;

/**
 * Servlet implementation class NoticeListController
 */
@WebServlet("/board/notice/list")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NoticeService noticeService = new NoticeServiceImpl();
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//요청파라미터에서 curPage 얻어오기
		Paging paging = noticeService.getCurPage(req);
				
		//MODEL로 Paging 객체 넣기
		req.setAttribute("paging", paging);
							
		//게시판 목록 조회
		List list = noticeService.getList(paging);
				
		//MODEL로 조회 결과 넣기
		req.setAttribute("list", list);
		//---------------------------------------
		
		
		//관리자인이 일반사용자인지 확인한뒤 parameter로 값 보내기
		int res = 0;
			
//		System.out.println(req.getSession().getAttribute("member_id"));
		
		if( req.getSession().getAttribute("member_id") != null) {
		
			int memCode = (int) req.getSession().getAttribute("member_code");
	
			res = memberDao.checkMemberCode(memCode);
		
		}
		req.setAttribute("res", res);
		
		//---------------------------------멤버코드 체크한뒤 관리자이면 1/ 일반사용자이면 0인 값을 req로 보냄!!
		
		
		//view지정
		req.getRequestDispatcher("/WEB-INF/views/board/notice/list.jsp").forward(req, resp);
	
	}
	
    
}
