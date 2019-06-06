package web.controller.board.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.board.search.SearchService;
import web.service.board.search.SearchServiceImpl;



@WebServlet("/board/search")
public class SearchBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SearchService searchService = new SearchServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/board/search/search.jsp").forward(req, resp);
	
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8"); 
	    
		PrintWriter out = resp.getWriter();
		
		List list = new ArrayList();
		
		list = searchService.result(req,resp);
	
//		System.out.println("list로 받아온 값 : "+list);

		String res = "0";
		res =searchService.count(req, resp);
		
		req.setAttribute("res", res);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/board/search/result.jsp").forward(req, resp);
		
	
	}

	
	
}
