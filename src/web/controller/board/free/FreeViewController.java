package web.controller.board.free;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Comment;
import web.dto.FreeBoard;
import web.dto.FreeComment;
import web.dto.FreeFile;
import web.service.board.free.FreeService;
import web.service.board.free.FreeServiceImpl;

@WebServlet("/board/free/view")
public class FreeViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private FreeService boardService = new FreeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//게시글 번호 파싱
		FreeBoard viewBoard = boardService.getBoardno(req);
		
		//게시글 조회
		viewBoard = boardService.view(viewBoard);

		//MODEL로 게시글 전달
		req.setAttribute("viewBoard", viewBoard);
		
		// 이전글 / 다음글 
		HashMap map = boardService.getPrevNext(viewBoard);
//		System.out.println(map);
		req.setAttribute("prev_next", map);
		
		// 이전글 / 다음글 
		HashMap name = boardService.getPrevNextName(viewBoard) ;
		req.setAttribute( "prev_next_name", name);
		
		//첨부파일 전달
		FreeFile boardFile = boardService.viewFile(viewBoard);
		req.setAttribute("boardFile", boardFile);
	
    	//댓글 리스트 전달
    	FreeComment comment = new FreeComment();
    	List<Comment> commentList =boardService.getCommentList(viewBoard);
    	req.setAttribute("commentList", commentList);
    			

		
		
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/board/free/view.jsp").forward(req, resp);
		
	}

	
	
}
