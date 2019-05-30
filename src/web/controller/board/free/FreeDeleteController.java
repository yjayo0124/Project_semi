package web.controller.board.free;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.FreeBoard;
import web.service.board.free.FreeService;
import web.service.board.free.FreeServiceImpl;

/**
 * Servlet implementation class FreeDeleteController
 */
@WebServlet("/board/free/delete")
public class FreeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//BoardService 객체
	private FreeService boardService = new FreeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FreeBoard board = boardService.getBoardno(req);
		
		
		boardService.delete(board);
		
		//목록으로 리다이렉트
		resp.sendRedirect("/board/free/list");
		
	}
}
