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


@WebServlet("/member/mypagedelete")
public class MyPageDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();



	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDetail member = new MemberDetail();
	
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String passwordCheck = req.getParameter("password_check");
		
		MemberDetail member = new MemberDetail();
		
		member.setMember_pw(req.getParameter("password_check"));

   		member = memberService.getMemberByMemberpw(member);
   		
   		req.setAttribute("member", member);
   	
   		
   		if(passwordCheck.equals(member.getMember_pw())&&member.getMember_id()!=null)
   			//문자열비교할때는 참조값으로 비교되기때문에 equal을 써야한다
   		{
   			req.getRequestDispatcher("/WEB-INF/views/member/mypagedelete.jsp")
   			.forward(req, resp);
   	
   		}
   		
   		else {
   			resp.sendRedirect("/main");
   		}
	

	}
}
