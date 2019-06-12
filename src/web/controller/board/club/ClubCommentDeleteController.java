package web.controller.board.club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import web.dao.club.ClubCommentDao;
import web.dao.club.ClubCommentDaoImpl;
import web.dto.club.ClubComment;


@WebServlet("/board/club/comment/delete")
public class ClubCommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClubCommentDao clubCommentDao = new ClubCommentDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw= resp.getWriter();
		
		String param = req.getParameter("club_comment_no");
		int club_comment_no = 0;
		if(param!= null && !"".equals(param)) {
			club_comment_no = Integer.parseInt(param);
		}
		
		ClubComment clubComment = new ClubComment();
		clubComment.setClub_comment_no(club_comment_no);
		
		clubCommentDao.delete(clubComment);
		
		JSONObject obj = new JSONObject();		
		
		pw.println(obj);
		
		
	}

}
