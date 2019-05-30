package web.controller.board.buy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.board.buy.face.BuyService;
import web.service.board.buy.impl.BuyServiceImpl;
import web.util.Paging;


@WebServlet("/buy/list")
public class BuyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		
	private BuyService buyservice = new BuyServiceImpl();
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	Paging paging = buyservice.getCurPage(req);
    	
    	// MODEL로 Paging 객체 넣기
    	req.setAttribute("paging", paging);
    	
    	// 게시판 목록 조회
    	List list = buyservice.getList(paging);
    	
    	req.setAttribute("list", list);
    	
    	
    	// VIEW 지정
    	req.getRequestDispatcher("/WEB-INF/views/board/buy/buylist.jsp").forward(req, resp);
    }

}
