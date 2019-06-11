package web.controller.board.club;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import web.dao.club.ClubCommentDao;
import web.dao.club.ClubCommentDaoImpl;
import web.dto.club.ClubComment;

/**
 * Servlet implementation class ClubCommentViewController
 */
@WebServlet("/board/club/comment/view")
public class ClubCommentViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClubCommentDao clubCommentDao = new ClubCommentDaoImpl();

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw= resp.getWriter();
		
		String param = req.getParameter("club_board_no");
		int club_board_no = 0;
		if(param!= null && !"".equals(param)) {
			club_board_no = Integer.parseInt(param);
		}

		ArrayList<ClubComment> comment = clubCommentDao.selectAll(club_board_no);


		JSONObject obj = new JSONObject();
			JSONArray jArray = new JSONArray();//배열이 필요할때
			for (int i = 0; i < comment.size(); i++)//배열
			{
				JSONObject sObject = new JSONObject();//배열 내에 들어갈 json
				sObject.put("club_board_no", comment.get(i).getClub_board_no());
				sObject.put("club_comment_no", comment.get(i).getClub_comment_no());
				sObject.put("club_comment_content", comment.get(i).getClub_comment_content());
				sObject.put("member_id", comment.get(i).getMember_id());
				sObject.put("club_comment_writer", comment.get(i).getClub_comment_writer());
//				sObject.put("club_comment_writedate", comment.get(i).getClub_comment_writedate());
				jArray.add(sObject);
			}
			
			obj.put("comment", jArray);//배열을 넣음

			pw.println(obj);



	}

}
