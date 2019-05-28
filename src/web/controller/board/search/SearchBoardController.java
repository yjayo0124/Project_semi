package web.controller.board.search;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchBoardController
 */
@WebServlet("/board/search")
public class SearchBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String FIRST_URL = "http://api.data.go.kr/openapi/fshlc-info-std?";	
	private static String KEY = "serviceKey=xkoM0fFVJiv9hmvG8chBcmLjxoUgAY%2FayOgAS3tZL%2F%2BCqJ7XBPCVVS%2BZcz3L%2FK9BJo4Hg87FRHlEBZYMR9DDIg%3D%3D";
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/board/search.jsp").forward(req, resp);
	
	}

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	

		String strURL = null;
		String insttNm = null;
		
		insttNm = "&insttNm=" +URLEncoder.encode(req.getParameter("insttNm"), "UTF-8");
			
		strURL = FIRST_URL;
		strURL += KEY;
		strURL += "&pageNo=1";
		strURL += "&numOfRows=100";
		strURL += "&type=xml";
		strURL += insttNm;		
		
		System.out.println(strURL);
		
		
		
		resp.sendRedirect(strURL);
	
	
	
	}

	
	
}
