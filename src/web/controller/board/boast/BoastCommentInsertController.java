package web.controller.board.boast;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.boast.BoastComment;
import web.service.board.boast.BoastService;
import web.service.board.boast.BoastServiceImpl;

/**
 * Servlet implementation class BoastCommentInsertController
 */
@WebServlet("/boast/comment/insert")
public class BoastCommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoastService boastService = new BoastServiceImpl() ;
	
    @Override
    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		doPost( req , resp ) ;
    	}

    @Override
    	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	BoastComment comment = boastService.getComment(req) ;
    	System.out.println(comment);
    	boastService.insertComment(comment);
    	
    	System.out.println(comment.getBoast_content());
    	
    	resp.sendRedirect( "/board/boast/view?boast_board_no="+comment.getBoast_board_no() );
    	}
}
