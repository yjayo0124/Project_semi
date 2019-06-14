package web.controller.board.boast;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.board.boast.CommentDao;
import web.dao.board.boast.CommentDaoImpl;
import web.dto.boast.BoastBoard;
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
	private CommentDao boastDao = new CommentDaoImpl() ;
    @Override
    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		doPost( req , resp ) ;
    	}

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
System.out.println(33);
	req.setCharacterEncoding("UTF-8");
	resp.setCharacterEncoding("UTF-8");
	
	HttpSession session = req.getSession();
	BoastComment comment = boastService.getComment(req) ;
	
	String param = req.getParameter("boast_board_no");
	int boast_board_no = 0;
	if(param!= null && !"".equals(param)) {
		boast_board_no = Integer.parseInt(param);
	}  	
	String member_id = (String)session.getAttribute("member_id");
	String boast_content = (String)req.getParameter("boast_content");
	
	comment.setBoast_board_no(boast_board_no);
	comment.setMember_id(member_id);
	comment.setBoast_content(boast_content);
	
	System.out.println( comment);
	
	
	boastService.insertComment(comment);
	
	BoastBoard board = new BoastBoard();
	board.setBoast_board_no(boast_board_no);
	
	List<BoastComment> commentList = boastDao.selectComment(board) ;
	req.setAttribute("commentList", commentList);
	System.out.println(989);
	req.getRequestDispatcher( "/WEB-INF/views/board/boast/comment.jsp").forward(req, resp);
	
	
	}
}
