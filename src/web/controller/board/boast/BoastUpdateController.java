package web.controller.board.boast;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.boast.BoastBoard;
import web.dto.boast.BoastFile;
import web.service.board.boast.BoastService;
import web.service.board.boast.BoastServiceImpl;

@WebServlet("/board/boast/update")
public class BoastUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoastService boardService = new BoastServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		BoastBoard viewBoard = boardService.getBoardno(req);
		
		viewBoard = boardService.view(viewBoard);

		//MODEL로 게시글 전달
		req.setAttribute("viewBoard", viewBoard);
		
		//첨부파일 전달
		BoastFile boardFile = boardService.viewFile(viewBoard);
		req.setAttribute("boardFile", boardFile);
		
		
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/board/boast/update.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");

		boardService.update(req);
		
		resp.sendRedirect("/board/boast/list");	
	
	}
}
