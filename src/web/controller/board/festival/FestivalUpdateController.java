package web.controller.board.festival;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import web.dao.board.festival.FestivalFileDao;
import web.dao.board.festival.FestivalFileDaoImpl;
import web.dto.festival.FestivalBoard;
import web.dto.festival.FestivalFile;
import web.service.board.festival.FestivalService;
import web.service.board.festival.FestivalServiceImpl;

@WebServlet("/board/festival/update")
public class FestivalUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FestivalService festivalService = new FestivalServiceImpl();
	private FestivalFileDao festivalFileDao = new FestivalFileDaoImpl(); 
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		FestivalBoard board = festivalService.getBoardno(req);
		festivalService.view(board);
		
		req.setAttribute("update", board);
				
		
		req.getRequestDispatcher("/WEB-INF/views/board/festival/festival_update.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// - - - MultipartRequest �깮�꽦�옄�쓽 留ㅺ컻蹂��닔 以�鍮� - - -

		//1. �슂泥� 媛앹껜 - �뵲濡� 留뚮뱾 �븘�슂 �뾾�쓬

		//2. �뙆�씪 ���옣 �쐞移� - �꽌踰꾩쓽 real path
		ServletContext context = getServletContext();
		String saveDirectory = context.getRealPath("upload");

		System.out.println(saveDirectory);

		//3. �뾽濡쒕뱶 �젣�븳 �궗�씠利� - 10MB
		int maxPostSize = 10 * 1024* 1024;

		//4. �씤肄붾뵫 - utf-8
		String encoding = "UTF-8";

		//5. 以묐났 �뙆�씪 �씠由� �젙梨� - 湲곕낯 �젙梨�
		FileRenamePolicy policy = new DefaultFileRenamePolicy();

		// ----------------------------------------------

		//�뙆�씪 �뾽濡쒕뱶 媛앹껜 �깮�꽦
		MultipartRequest mul = new MultipartRequest (
				req,
				saveDirectory,
				maxPostSize,
				encoding,
				policy );
		
		
		FestivalBoard updateboard = festivalService.getBoardno(req);
		String title = mul.getParameter("title");
		String host = mul.getParameter("host");
		String content = mul.getParameter("content");
		String phone = mul.getParameter("phone");
		String web = mul.getParameter("web");
		String start = mul.getParameter("start");
		String end =mul.getParameter("end");
		String fee = mul.getParameter("fee");
		
		updateboard.setFestival_title(title);
		updateboard.setFestival_host(host);
		updateboard.setFestival_content(content);
		updateboard.setFestival_phone(phone);
		updateboard.setFestival_web(web);
		updateboard.setFestival_start(start);
		updateboard.setFestival_end(end);
		updateboard.setFestival_fee(fee);
		
		req.setAttribute("updateboard", updateboard);
		
		
		festivalService.update(updateboard);
		
		FestivalFile file = new FestivalFile();
		file.setFestival_board_no(updateboard.getFestival_board_no());
		file.setFestival_originname(mul.getOriginalFileName("upfile"));
		file.setFestival_storedname(mul.getFilesystemName("upfile"));
		
		festivalFileDao.updateFile(file);
		
		
		resp.sendRedirect("/board/festival");
	}
}
