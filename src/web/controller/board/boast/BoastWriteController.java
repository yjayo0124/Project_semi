package web.controller.board.boast;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.service.board.boast.BoastService;
import web.service.board.boast.BoastServiceImpl;

@WebServlet("/board/boast/write")
public class BoastWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoastService boastService = new BoastServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/main");
			return;
		}
	
		req.getRequestDispatcher("/WEB-INF/views/board/boast/write.jsp")
		.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//작성글 삽입
				boastService.write(req);
				
				//목록으로 리다이렉션
				resp.sendRedirect("/board/boast/list");
		
	}
}
