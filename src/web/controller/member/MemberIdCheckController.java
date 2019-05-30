package web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import web.dao.member.MemberDao;
import web.dao.member.MemberDaoImpl;
import web.dto.MemberDetail;
import web.service.member.MemberService;
import web.service.member.MemberServiceImpl;

@WebServlet("/member/idcheck")
public class MemberIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDetail member = new MemberDetail();
		
		req.setCharacterEncoding("UTF-8");

		String member_id = req.getParameter("member_id");
		
		member.setMember_id(member_id);
		
		boolean check = memberDao.idCheck(member); 
//		String n = null;
//		if(check) {
//			n="true";
//		}else if(!check) {
//			n="false";
//		}
		JsonObject obj = new JsonObject();
		obj.addProperty("check", check);
		resp.getWriter().print(obj);
		
	}
}
