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

@WebServlet("/member/delete")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		MemberDetail member = new MemberDetail();
		
	
		member.setMember_id(req.getParameter("member_id"));
		
		System.out.println(member.getMember_id());
		memberService.deleteMemberByMemberid(member);


		
   		resp.sendRedirect("/main");
   		
		
	}

}
