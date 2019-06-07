package web.controller.board.fish_info;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.board.fish_info.FishFileDao;
import web.dao.board.fish_info.FishFileDaoImpl;
import web.dto.FishInfo;
import web.dto.FishInfoFile;
import web.service.board.fish_info.FishService;
import web.service.board.fish_info.FishServiceImpl;

/**
 * Servlet implementation class FishDeleteController
 */
@WebServlet("/board/fish/info/delete")
public class FishDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FishService fishService = new FishServiceImpl() ;
	private FishFileDao fishFileDao = new FishFileDaoImpl() ;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		FishInfo fishInfo = fishService.getBoardno(req) ;
		
		FishInfoFile file = new FishInfoFile() ;
		file.setFish_no( fishInfo.getFish_no() ) ;
		fishFileDao.selectByBoardno(file) ;
		
		fishFileDao.delete(file);
		
		File upfile = new File( "D:/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Project_semi/fishupload/"+ file.getFish_storedname()) ;
		
		fishService.delete(fishInfo);
		
		resp.sendRedirect( "/board/fish/info" ) ;
		}

}
