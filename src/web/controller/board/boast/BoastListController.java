package web.controller.board.boast;

import java.io.IOException;
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
import web.util.boast.BoastPaging;

@WebServlet("/board/boast/list")
public class BoastListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoastService boardService = new BoastServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoastPaging paging = boardService.getCurPage(req);
		
		//MODEL로 Paging 객체 넣기
		req.setAttribute("paging", paging);
		
		
		
		//게시판 목록 조회
		List list = boardService.getList(paging);
		
		//MODEL로 조회 결과 넣기
		req.setAttribute("list", list);
		
		
		// test
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
				
				
		//회원에게만 버튼 보이도록 하는 값 res 
		int res = 0;
		    	
		if( req.getSession().getAttribute("member_id") != null) {
		    		
		    res = 1;
		}
		    	
		req.setAttribute("res", res);
		
		req.getRequestDispatcher("/WEB-INF/views/board/boast/list.jsp").forward(req, resp);
	
	
	}
	
}
