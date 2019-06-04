package web.controller.board.sell;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.BuyFile;
import web.dto.BuyBoard;
import web.service.board.buy.face.BuyService;
import web.service.board.buy.impl.BuyServiceImpl;


@WebServlet("/sell/update")
public class SellUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private BuyService buyservice = new BuyServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인한 사람의 글이 아니면 중단하고 목록으로 리다이렉트
				if( !buyservice.checkWriter(req) ) {
					resp.sendRedirect("/buy/list");
					return;
				}
				
				//게시글 번호 파싱
				BuyBoard viewBoard = buyservice.getBoardno(req);
				
				//게시글 조회
				viewBoard = buyservice.view(viewBoard);

				//MODEL로 게시글 전달
				req.setAttribute("viewBoard", viewBoard);
				
				//첨부파일 전달
				BuyFile boardFile = buyservice.viewFile(viewBoard);
				req.setAttribute("boardFile", boardFile);
				
				//VIEW 지정
				req.getRequestDispatcher("/WEB-INF/views/board/buy/buyupdate.jsp").forward(req, resp);	
				
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		
		buyservice.update(req);
		
		resp.sendRedirect("/buy/list");
		
	}
	

}
