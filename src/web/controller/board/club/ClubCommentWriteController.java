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

import web.dao.club.ClubCommentDao;
import web.dao.club.ClubCommentDaoImpl;
import web.dto.club.ClubComment;

/**
 * Servlet implementation class ClubCommentWriteController
 */
@WebServlet("/board/club/comment/write")
public class ClubCommentWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClubCommentDao clubCommentDao = new ClubCommentDaoImpl();

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw= resp.getWriter();
		//세션 얻어 오기
		HttpSession session = req.getSession();
		
		String param = req.getParameter("club_board_no");
		int club_board_no = 0;
		if(param!= null && !"".equals(param)) {
			club_board_no = Integer.parseInt(param);
		}
		
		String param2 = req.getParameter("club_no");
		int club_no = 0;
		if(param2!= null && !"".equals(param2)) {
			club_no = Integer.parseInt(param2);
		}

		String club_comment_content = req.getParameter("club_comment_content");
		String member_id = (String)session.getAttribute("member_id");
		String club_comment_writer = (String)session.getAttribute("member_nick");
		
		ClubComment clubComment = new ClubComment();
		clubComment.setClub_board_no(club_board_no);
		clubComment.setClub_comment_content(club_comment_content);
		clubComment.setMember_id(member_id);
		clubComment.setClub_comment_writer(club_comment_writer);
		
		clubCommentDao.insert(clubComment);
		
		
		JSONObject obj = new JSONObject();
		obj.put("club_comment_writer", clubComment.getClub_comment_writer());
		obj.put("club_comment_content", clubComment.getClub_comment_content());
		
		pw.println(obj);

	}

}
