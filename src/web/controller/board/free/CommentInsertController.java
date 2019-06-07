package web.controller.board.free;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.FreeComment;
import web.service.board.free.FreeService;
import web.service.board.free.FreeServiceImpl;

@WebServlet("/board/free/comment/insert")
public class CommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private FreeService freeService = new FreeServiceImpl();

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 doPost(req, resp);
	 
	 }

	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 	FreeComment comment = freeService.getComment(req);
	    	
	    	freeService.insertComment(comment);
	    	
	    	resp.sendRedirect("/board/free/view?free_board_no="+comment.getFree_board_no());
	    	
	 
	 
	 
	 }
	 
}


