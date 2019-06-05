package web.controller.board.sell;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Comment;
import web.service.board.sell.face.SellService;
import web.service.board.sell.impl.SellServiceImpl;


@WebServlet("/sell/comment/insert")
public class CommInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private SellService sellservice = new SellServiceImpl();
    
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    	Comment comment = sellservice.getComment(req);
    	
    	sellservice.insertComment(comment);
    	
    	resp.sendRedirect("/sell/view?boardno="+comment.getBoardNo());
    	
    	
    }
	

}
