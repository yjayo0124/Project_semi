package web.controller.board.sell;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.SellBoard;
import web.service.board.sell.face.SellService;
import web.service.board.sell.impl.SellServiceImpl;


@WebServlet("/sell/delete")
public class SellDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SellService sellservice = new SellServiceImpl();
	
    @Override
    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	SellBoard sellboard = sellservice.getBoardno(req);
    	
    	sellservice.delete(sellboard);
    	
    	
    	resp.sendRedirect("/sell/list");
    	
    	}

}
