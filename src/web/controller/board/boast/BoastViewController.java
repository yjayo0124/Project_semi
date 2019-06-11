package web.controller.board.boast;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.boast.BoastBoard;
import web.dto.boast.BoastComment;
import web.dto.boast.BoastFile;
import web.dto.boast.Recommend;
import web.service.board.boast.BoastService;
import web.service.board.boast.BoastServiceImpl;

@WebServlet("/board/boast/view")
public class BoastViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoastService boardService = new BoastServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//게시글 번호 파싱
		BoastBoard viewBoard = boardService.getBoardno(req);
		
		//게시글 조회
		viewBoard = boardService.view(viewBoard);
		//MODEL로 게시글 전달
		req.setAttribute("viewBoard", viewBoard);
		
		//첨부파일 전달
		BoastFile boardFile = boardService.viewFile(viewBoard);
		req.setAttribute("boardFile", boardFile);
		
		BoastComment comment = new BoastComment() ;
		List<BoastComment> commentList = boardService.getCommentList(viewBoard) ;
		req.setAttribute( "commentList" , commentList ) ; 
		
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/board/boast/view.jsp").forward(req, resp);
		
	}
	
}
