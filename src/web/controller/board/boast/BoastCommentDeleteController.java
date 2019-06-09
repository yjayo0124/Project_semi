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
 * Servlet implementation class BoastCommentDeleteController
 */
@WebServlet("/boast/comment/delete")
public class BoastCommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoastService boardService = new BoastServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost( req , resp ) ;
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoastComment comment = new BoastComment() ;
		
		String boast_board_comment_no = (String)req.getParameter( "boast_board_comment_no" ) ;
		
		comment.setBoast_board_comment_no( Integer.parseInt( boast_board_comment_no ) ) ;
		
		boolean success = boardService.deleteComment(comment) ;
		
		resp.getWriter().append("{\"success\":"+success+"}");
		
	}
	
}
