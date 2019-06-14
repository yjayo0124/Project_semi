package web.controller.board.club;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.club.ClubDao;
import web.dao.club.ClubDaoImpl;
import web.dto.club.Club;
import web.dto.club.ClubBoard;
import web.service.board.club.ClubService;
import web.service.board.club.ClubServiceImpl;
import web.util.club.ClubPaging;

@WebServlet("/board/club/detail")
public class ClubDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClubService clubService = new ClubServiceImpl();
	private ClubDao clubDao = new ClubDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String member_id = (String)session.getAttribute("member_id");
		
		Club club = new Club();

		String clubno = req.getParameter("club_no");
		int club_no = 0;
		if(clubno!= null && !"".equals(clubno)) {
			club_no = Integer.parseInt(clubno);
		}
		club.setClub_no(club_no);
		
		boolean check = clubDao.checkIdByClub(member_id, club_no);
		req.setAttribute("check", check);
		
		boolean checkjoin = clubDao.checkjoin(member_id);
		req.setAttribute("checkjoin", checkjoin);
		
		boolean checkleave = clubDao.checkleave(member_id, club_no);
		req.setAttribute("checkleave", checkleave);
		
		
		

		clubDao.selectClubByClubno(club);

		req.setAttribute("club", club);

		ClubPaging paging = clubService.getBoardCurpage(req, club_no);
		req.setAttribute("paging", paging);

		List list = clubDao.selectBoardAll(paging);
		req.setAttribute("list", list);


		req.getRequestDispatcher("/WEB-INF/views/board/club/club_detail.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		int club_no = clubService.write(req);


		resp.sendRedirect("/board/club/detail?club_no="+club_no);
	}

}
