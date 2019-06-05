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


@WebServlet("/member/update")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDetail member = new MemberDetail();
		
		
		member.setMember_id(req.getParameter("member_id"));
		
		member = memberService.getMemberByMemberid(member);
		
		req.setAttribute("member", member);

	 req.getRequestDispatcher("/WEB-INF/views/member/mypageupdate.jsp")
	 .forward(req, resp);
	}

	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		MemberDetail member = new MemberDetail();


		member.setMember_id(req.getParameter("member_id"));
		member.setMember_pw(req.getParameter("member_pw2"));
		member.setMember_email(req.getParameter("member_email"));
		member.setMember_phone(req.getParameter("member_phone"));
			
		System.out.println(member.getMember_id());
		System.out.println(member.getMember_pw());
		System.out.println(member.getMember_email());
		System.out.println(member.getMember_phone());

		
		memberService.updateMemberByMemberid(member);
		resp.sendRedirect("/main");
		
			
		}

}
