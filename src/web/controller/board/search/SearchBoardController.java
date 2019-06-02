package web.controller.board.search;

import java.io.IOException;
import java.io.PrintWriter;
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
	
	    
	
		PrintWriter out = resp.getWriter();
	
		String strURL = null;
		String insttNm = null; //시군구명 합친문자열 들어갈 변수  
		String insttNm1 = null; //시 명 
		String insttNm2 = null; //군 구 명 
		String fshlcNm = null;
		String kdfsh = null;
		
//		주소에 변수 추가 
		strURL = FIRST_URL;
		strURL += KEY;
		strURL += "&pageNo=1";
		strURL += "&numOfRows=100";
		strURL += "&type=json";
		
		//낚시터
		fshlcNm = URLEncoder.encode(req.getParameter("fshlcNm"), "UTF-8");
		
		//주요어종 
		kdfsh = URLEncoder.encode(req.getParameter("kdfsh"), "UTF-8");

		//시도명 
		insttNm1 = URLEncoder.encode(req.getParameter("insttNm1"), "UTF-8");

		//구/군
		insttNm2 = URLEncoder.encode(req.getParameter("insttNm2"), "UTF-8");
		
		
		if( fshlcNm != null &&!"".equals(fshlcNm)) {
			strURL += "&fshlcNm="+fshlcNm;
		}
		
		if( kdfsh != null &&!"".equals(kdfsh)) {
			strURL += "&kdfsh="+kdfsh;
		}
	
		if( insttNm1 != null &&!"".equals(insttNm1)) {
			strURL += "&insttNm="+insttNm1+"%20"+insttNm2;
		}
		
		System.out.println(strURL);
	
		
	//	out.println(strURL);
		
		resp.sendRedirect(strURL);
	
	
		
	
	}

	
	
}
