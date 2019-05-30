package web.controller.board.buy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.BuyBoard;
import web.dto.BuyFile;
import web.service.board.buy.face.BuyService;
import web.service.board.buy.impl.BuyServiceImpl;


@WebServlet("/buy/view")
public class BuyViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BuyService buyservice = new BuyServiceImpl();
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	// 게시글 번호 파싱
    	BuyBoard viewBoard = buyservice.getBoardno(req);
    	
    	// 게시글 조회 및 MODEL로 게시글 전달
    	viewBoard = buyservice.view(viewBoard);
    	req.setAttribute("viewBoard", viewBoard);
    	
    	BuyFile buyFile = buyservice.viewFile(viewBoard);
    	req.setAttribute("buyFile", buyFile);
    	
    	
    	
    	req.getRequestDispatcher("/WEB-INF/views/board/buy/buyview.jsp").forward(req, resp);
    	
    	
    	
    }
    
    
    
    

}
