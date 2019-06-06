package web.controller.board.search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Search;
import web.service.board.search.SearchService;
import web.service.board.search.SearchServiceImpl;

/**
 * Servlet implementation class SearchViewController
 */
@WebServlet("/board/search/view")
public class SearchViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SearchService searchService = new SearchServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	Search res = searchService.getSearch(req, resp);
    	
    	
    	req.setAttribute("res", res);

    	req.getRequestDispatcher("/WEB-INF/views/board/search/view.jsp").forward(req, resp);
    
   
	
	}
	


}
