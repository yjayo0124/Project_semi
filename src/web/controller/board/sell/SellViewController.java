package web.controller.board.sell;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Comment;
import web.dto.SellBoard;
import web.dto.SellFile;
import web.service.board.sell.face.SellService;
import web.service.board.sell.impl.SellServiceImpl;


@WebServlet("/sell/view")
public class SellViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SellService sellservice = new SellServiceImpl();
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	// 게시글 번호 파싱
    	SellBoard viewBoard = sellservice.getBoardno(req);
    	
    	// 게시글 조회 및 MODEL로 게시글 전달
    	viewBoard = sellservice.view(viewBoard);
    	req.setAttribute("viewBoard", viewBoard);
    	
    	
    	// 첨부 파일 전달
    	SellFile sellFile = sellservice.viewFile(viewBoard);
    	req.setAttribute("buyFile", sellFile);
    	
    	
    	//댓글 리스트 전달
    	Comment comment = new Comment();
    	List<Comment> commentList = sellservice.getCommentList(viewBoard);
    	req.setAttribute("commentList", commentList);
    			
    	
    	
    	
    	req.getRequestDispatcher("/WEB-INF/views/board/sell/sellview.jsp").forward(req, resp);
    	
    	
    	
    }
    
    
    
    

}
