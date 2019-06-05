package web.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.member.MemberService;
import web.service.member.MemberServiceImpl;
import web.util.Paging;

@WebServlet("/member/management")
public class MemberManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Paging paging = memberService.getCurPage(req);
		
		req.setAttribute("paging", paging);
		
		List list = memberService.getList(paging);
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/member/memberManagement.jsp").forward(req, resp);
		
	}
	
	
}
