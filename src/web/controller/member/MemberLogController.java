package web.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.LoginLog;
import web.service.memberlog.MemberLogService;
import web.service.memberlog.MemberLogServiceImpl;
import web.util.Paging;



@WebServlet("/member/log")
public class MemberLogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberLogService memberLogService = new MemberLogServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청파라미터에서 curPage 얻어오기
		Paging paging = memberLogService.getCurPage(req);
		
		LoginLog log = new LoginLog();
	
		//MODEL로 Paging 객체 넣기
		req.setAttribute("paging", paging);
		
		//jsp 에서  member_id 받아오기
		String member_id = (String)req.getParameter("member_id");
		
		log.setMember_id(member_id);
		
		
		//게시판 목록 조회
		List list = memberLogService.getList(paging,log);
	
		System.out.println(list);
		
		//MODEL로 조회 결과 넣기
		req.setAttribute("list", list);
		
		
		
		//VIEW지정
		req.getRequestDispatcher("/WEB-INF/views/member/loglist.jsp").forward(req, resp);
	
	}
	

}
