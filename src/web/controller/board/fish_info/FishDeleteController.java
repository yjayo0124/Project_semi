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
 * Servlet implementation class FishDeleteController
 */
@WebServlet("/board/fish/info/delete")
public class FishDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FishService fishService = new FishServiceImpl() ;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		FishInfo fishInfo = fishService.getBoardno(req) ;
		
		fishService.delete(fishInfo);
		
		resp.sendRedirect( "/board/fish/info" ) ;
		}

}
