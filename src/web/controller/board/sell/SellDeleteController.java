package web.controller.board.sell;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.BuyBoard;
import web.service.board.buy.face.BuyService;
import web.service.board.buy.impl.BuyServiceImpl;


@WebServlet("/sell/delete")
public class SellDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BuyService buyservice = new BuyServiceImpl();
	
    @Override
    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	BuyBoard buyboard = buyservice.getBoardno(req);
    	
    	buyservice.delete(buyboard);
    	
    	
    	resp.sendRedirect("/buy/list");
    	
    	}

}
