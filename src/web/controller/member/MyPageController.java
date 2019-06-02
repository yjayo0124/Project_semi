package web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.MemberDetail;
import web.service.member.MemberService;
import web.service.member.MemberServiceImpl;

@WebServlet("/member/mypage")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		MemberDetail member = new MemberDetail();
		
		member.setMember_id(req.getParameter("member_id"));
		
   		member = memberService.getMemberByMemberid(member);
	
   		req.setAttribute("member", member);
		
		
		req.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp")
		.forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String passwordCheck = req.getParameter("password_check");
		
		MemberDetail member = new MemberDetail();
		
		member.setMember_id(req.getParameter("member_id"));

   		member = memberService.getMemberByMemberid(member);
   		
   		
   		if(passwordCheck==member.getMember_pw()) {
   		
		req.getRequestDispatcher("/WEB-INF/views/member/mypagedelete.jsp")
		.forward(req, resp);
   		
   		}
	
	}
	
}
