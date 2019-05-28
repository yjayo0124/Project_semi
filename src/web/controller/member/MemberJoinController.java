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

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//MemberService 객체
	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);		

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");

		// 요청파라미터 처리
		MemberDetail param = memberService.getJoinMember(req);
		
		// 회원가입
		memberService.join(param);
		
		// 메인으로 리다이렉션
		resp.sendRedirect("/main");
		
	}
	
}
