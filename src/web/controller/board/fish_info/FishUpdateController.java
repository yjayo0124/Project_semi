package web.controller.board.fish_info;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.FishInfo;
import web.service.board.fish_info.FishService;
import web.service.board.fish_info.FishServiceImpl;

/**
 * Servlet implementation class FishUpdateController
 */
@WebServlet("/board/fish/info/update")
public class FishUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FishService fishService = new FishServiceImpl() ;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		FishInfo fishInfo = fishService.getBoardno(req) ;
		
		fishInfo = fishService.view(fishInfo) ;
		
		req.setAttribute( "fishInfo" , fishInfo ) ; 
		
		req.getRequestDispatcher( "/WEB-INF/views/board/fish_info/fish_info_update.jsp" ).forward(req, resp) ;
		}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		fishService.update(req);
		
		resp.sendRedirect( "/board/fish/info" ) ;
		}
}
