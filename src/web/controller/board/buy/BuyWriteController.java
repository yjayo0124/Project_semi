package web.controller.board.buy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.board.buy.face.BuyService;
import web.service.board.buy.impl.BuyServiceImpl;


@WebServlet("/buy/write")
public class BuyWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BuyService buyservice = new BuyServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인 되어있지 않으면 리다이렉트 
				if( req.getSession().getAttribute("login") == null ) {
					resp.sendRedirect("/main");
					return;
				}
				
				//VIEW 지정
				req.getRequestDispatcher("/WEB-INF/views/board/buy/buywrite.jsp")
					.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		buyservice.write(req);
		
		
		//목록으로 리다이렉션
		resp.sendRedirect("/buy/list");
		
	}


}
