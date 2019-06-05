package web.controller.board.sell;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Comment;
import web.service.board.buy.face.BuyService;
import web.service.board.buy.impl.BuyServiceImpl;


@WebServlet("/sell/comment/delete")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private BuyService buyservice = new BuyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    	doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    	Comment comment = new Comment();
    	
    	String commentNo = (String)req.getParameter("commentNo");
    	
    	
    	comment.setCommentNo( Integer.parseInt(commentNo));
    	
    	boolean success = buyservice.deleteComment(comment);
    	
    	resp.getWriter().append("{\"success\":"+success+"}");
    			
    	
    	
    }
    
}
