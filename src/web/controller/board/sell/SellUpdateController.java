package web.controller.board.sell;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.BuyFile;
import web.dto.SellBoard;
import web.dto.SellFile;
import web.dto.BuyBoard;
import web.service.board.buy.face.BuyService;
import web.service.board.buy.impl.BuyServiceImpl;
import web.service.board.sell.face.SellService;
import web.service.board.sell.impl.SellServiceImpl;


@WebServlet("/sell/update")
public class SellUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private SellService sellservice = new SellServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인한 사람의 글이 아니면 중단하고 목록으로 리다이렉트
				if( !sellservice.checkWriter(req) ) {
					resp.sendRedirect("/sell/list");
					return;
				}
				
				//게시글 번호 파싱
				SellBoard viewBoard = sellservice.getBoardno(req);
				
				//게시글 조회
				viewBoard = sellservice.view(viewBoard);

				//MODEL로 게시글 전달
				req.setAttribute("viewBoard", viewBoard);
				
				//첨부파일 전달
				SellFile boardFile = sellservice.viewFile(viewBoard);
				req.setAttribute("boardFile", boardFile);
				
				//VIEW 지정
				req.getRequestDispatcher("/WEB-INF/views/board/sell/sellupdate.jsp").forward(req, resp);	
				
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		
		sellservice.update(req);
		
		resp.sendRedirect("/sell/list");
		
	}
	

}
