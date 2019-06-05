package web.controller.board.club;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet("/board/club/create")
public class ClubCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/board/club/club_create.jsp").forward(req, resp);
		
	};
}
