package web.controller.board.club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import web.dao.club.ClubDao;
import web.dao.club.ClubDaoImpl;


@WebServlet("/board/club/leave")
public class ClubLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ClubDao clubDao = new ClubDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		PrintWriter pw= resp.getWriter();
		
		HttpSession session = req.getSession();
		String member_id = (String)session.getAttribute("member_id");
		
		String clubno = req.getParameter("club_no");
		int club_no = 0;
		if(clubno!= null && !"".equals(clubno)) {
			club_no = Integer.parseInt(clubno);
		}
		
		clubDao.updateNullMember(member_id);
		clubDao.delete(member_id);
		
		JSONObject obj = new JSONObject();
		pw.println(obj);
		
	}
    
}
