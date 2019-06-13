package web.controller.board.club;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.club.ClubCommentDao;
import web.dao.club.ClubCommentDaoImpl;
import web.dao.club.ClubDao;
import web.dao.club.ClubDaoImpl;
import web.dto.club.ClubBoard;

/**
 * Servlet implementation class ClubBoardDelete
 */
@WebServlet("/board/club/boardDelete")
public class ClubBoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClubDao clubDao = new ClubDaoImpl();
	private ClubCommentDao clubCommentDao = new ClubCommentDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClubBoard clubBoard = new ClubBoard();
		
		String clubboardno = req.getParameter("club_board_no");
		int club_board_no = 0;
		if(clubboardno!= null && !"".equals(clubboardno)) {
			club_board_no = Integer.parseInt(clubboardno);
		}
		clubBoard.setClub_board_no(club_board_no);
		
		
		String clubno = req.getParameter("club_no");
		int club_no = 0;
		if(clubno!= null && !"".equals(clubno)) {
			club_no = Integer.parseInt(clubno);
		}
		clubBoard.setClub_no(club_no);
		
		clubCommentDao.deleteBoard(club_board_no);
		
		clubDao.delete(clubBoard);
		
		resp.sendRedirect("/board/club/detail?club_no="+club_no);
		
	}

}
