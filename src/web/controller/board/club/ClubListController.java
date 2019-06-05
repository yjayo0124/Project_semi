package web.controller.board.club;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.board.club.ClubService;
import web.service.board.club.ClubServiceImpl;
import web.util.club.ClubPaging;

@WebServlet("/board/club")
public class ClubListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClubService clubService = new ClubServiceImpl();
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClubPaging paging = clubService.getCurpage(req);
		req.setAttribute("paging", paging);
		
		List list = clubService.getList(paging);
		
		req.setAttribute("list", list);
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/board/club/club.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
