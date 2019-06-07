package web.controller.board.boast;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.boast.BoastBoard;
import web.service.board.boast.BoastService;
import web.service.board.boast.BoastServiceImpl;

@WebServlet("/board/boast/delete")
public class BoastDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoastService boardService = new BoastServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoastBoard board = boardService.getBoardno(req);
		
		
		boardService.delete(board);
		
		//목록으로 리다이렉트
		resp.sendRedirect("/board/boast/list");
	
	}
}
