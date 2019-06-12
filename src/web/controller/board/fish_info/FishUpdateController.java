package web.controller.board.fish_info;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import web.dao.board.fish_info.FishFileDao;
import web.dao.board.fish_info.FishFileDaoImpl;
import web.dto.FishInfo;
import web.dto.FishInfoFile;
import web.service.board.fish_info.FishService;
import web.service.board.fish_info.FishServiceImpl;

/**
 * Servlet implementation class FishUpdateController
 */
@WebServlet("/board/fish/info/update")
public class FishUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FishService fishService = new FishServiceImpl() ;
	private FishFileDao fishFileDao = new FishFileDaoImpl() ;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding( "UTF-8" ) ;
		
		FishInfo fishInfo = fishService.getBoardno(req) ;
		
		fishInfo = fishService.view(fishInfo) ;
		
		req.setAttribute( "fishInfo" , fishInfo ) ; 
		
		req.getRequestDispatcher( "/WEB-INF/views/board/fish_info/fish_info_update.jsp" ).forward(req, resp) ;
		}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String saveDirectory = context.getRealPath("fishupload");

//System.out.println(saveDirectory);

		int maxPostSize = 10 * 1024* 1024;

		String encoding = "UTF-8";

		FileRenamePolicy policy = new DefaultFileRenamePolicy();

		// ----------------------------------------------

		MultipartRequest mul = new MultipartRequest (
				req,
				saveDirectory,
				maxPostSize,
				encoding,
				policy );
		
		FishInfo fishInfo = fishService.getBoardno(req) ;
		
		int no = Integer.parseInt( mul.getParameter( "fish_no" ) ) ;
		String name = mul.getParameter("fish_name");
		String type = mul.getParameter("fish_type");
		String seasson = mul.getParameter("fish_sesson");
		String length = mul.getParameter("fish_min_length");
		String care = mul.getParameter("fish_care");
		String content = mul.getParameter("fish_content");
		String member = mul.getParameter( "member_id" ) ;
		String stored = mul.getParameter( "fish_storedname" ) ;
		
		fishInfo.setFish_no( no ) ;
		fishInfo.setFish_name( name ) ;
		fishInfo.setFish_type( type ) ;
		fishInfo.setFish_sesson( seasson ) ;
		fishInfo.setFish_min_length( length ) ;
		fishInfo.setFish_care( care ) ;
		fishInfo.setFish_content( content ) ;
		fishInfo.setMember_id( member ) ;
		fishInfo.setFish_storedname( stored ) ;
		
		req.setAttribute("fishInfo", fishInfo);
		fishService.update(fishInfo);
		
		
		FishInfoFile file = new FishInfoFile() ;
		file.setFish_no( fishInfo.getFish_no() ) ;
		file.setFish_originname(mul.getOriginalFileName("upfile"));
		file.setFish_storedname(mul.getFilesystemName("upfile"));

		System.out.println("ooooooLLLL:::::::::::"+ file );
		fishFileDao.insert(file);
		fishFileDao.deleteWithoutInsert(file);
		req.setAttribute("file", file);
		
		resp.sendRedirect( "/board/fish/info" ) ;
		
		}

}
