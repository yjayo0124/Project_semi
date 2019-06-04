package web.controller.board.festival;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.board.festival.FestivalFileDao;
import web.dao.board.festival.FestivalFileDaoImpl;
import web.dto.festival.FestivalBoard;
import web.dto.festival.FestivalFile;
import web.service.board.festival.FestivalService;
import web.service.board.festival.FestivalServiceImpl;


@WebServlet("/board/festival/delete")
public class FestivalDeletecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FestivalService festivalService = new FestivalServiceImpl();
	private FestivalFileDao festivalFileDao = new FestivalFileDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		FestivalBoard board = festivalService.getBoardno(req);
		
		FestivalFile file = new FestivalFile();
		file.setFestival_board_no(board.getFestival_board_no());
		festivalFileDao.selectByBoardno(file);
		
		festivalFileDao.delete(file);
		
		File uploadfile = new File("D:/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Project_semi/upload/"+file.getFestival_storedname());
		uploadfile.delete();
		
		
		festivalService.delete(board);
				
		resp.sendRedirect("/board/festival");
	}

}
