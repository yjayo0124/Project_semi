package web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import web.dto.LoginLog;
import web.dto.MemberDetail;
import web.service.member.MemberService;
import web.service.member.MemberServiceImpl;
import web.service.memberlog.MemberLogService;
import web.service.memberlog.MemberLogServiceImpl;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   private MemberService memberService = new MemberServiceImpl();
   private MemberLogService memberLogService = new MemberLogServiceImpl();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
      //VIEW 지정
      req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
   
   }
   
   @SuppressWarnings("unchecked")
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      PrintWriter pw =resp.getWriter();
      
      //세션 얻어 오기
      HttpSession session = req.getSession();
      
      //로그인 정보 얻기
      MemberDetail member = memberService.getLoginMember(req);
      LoginLog log = new LoginLog();

      
      //로그인 인증
      boolean login = memberService.login(member);
      
      if(login) {
         
         // 로그인 사용자 정보 얻어오기
         member = memberService.getMemberByMemberid(member);
         
       //ip 주소 불러오기
			InetAddress local;
			local = InetAddress.getLocalHost();
			String ip = local.getHostAddress();
         
         //세션정보저장
         session.setAttribute("login", login);
         session.setAttribute("member_id", member.getMember_id());
         session.setAttribute("member_nick", member.getMember_nick());
         session.setAttribute("member_phone", member.getMember_phone());
         session.setAttribute("member_code", member.getMember_code());
         session.setAttribute("member_email", member.getMember_email());
         session.setAttribute("member_group", member.getMember_group());
 
			log.setMember_id(member.getMember_id());
			log.setLoginip(ip);
			memberLogService.insertLoginLog(log);

         JSONObject obj = new JSONObject();
         obj.put("login", login);
         
         pw.println(obj);
      }else {
      
      JSONObject obj = new JSONObject();
      obj.put("login", login);
      pw.println(obj);
   }
}
}