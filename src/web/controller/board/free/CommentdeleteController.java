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



@WebServlet("/board/free/comment/delete")
public class CommentdeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private FreeService freeService = new FreeServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	doPost(req, resp);

	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FreeComment comment = new FreeComment();
    	
    	String commentNo = (String)req.getParameter("free_board_comment_no");
    	   	
    	comment.setFree_board_comment_no(Integer.parseInt(commentNo));
 
    	boolean success = freeService.deleteComment(comment);
    	
    	resp.getWriter().append("{\"success\":"+success+"}");
    	
	
	}
	
	
	
}
