package web.controller.board.fish_info;

import java.io.IOException;

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
import web.dto.festival.FestivalBoard;
import web.dto.festival.FestivalFile;
import web.service.board.fish_info.FishService;
import web.service.board.fish_info.FishServiceImpl;

/**
 * Servlet implementation class FishWriteController
 */
@WebServlet("/board/fish/info/write")
public class FishWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FishService fishService = new FishServiceImpl() ;
	private FishFileDao fishFileDao = new FishFileDaoImpl() ;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if( req.getSession().getAttribute("login") == null ) {
		resp.sendRedirect("/main");
			return;
		}
		
		req.getRequestDispatcher( "/WEB-INF/views/board/fish_info/fish_info_write.jsp" ).forward(req, resp);
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String saveDirectory = context.getRealPath("fishupload");

		System.out.println(saveDirectory);

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
		
		HttpSession session = req.getSession();
		FishInfo fishInfo = new FishInfo() ;
		
		String fish_name = mul.getParameter("fish_name");
		String fish_type = mul.getParameter("fish_type");
		String fish_sesson = mul.getParameter("fish_sesson");
		String fish_min_length = mul.getParameter("fish_min_length");
		String fish_care = mul.getParameter("fish_care");
		String fish_content = mul.getParameter("fish_content");
		String fish_member = (String) session.getAttribute("member_id");
		
		fishInfo.setFish_name( fish_name ) ;
		fishInfo.setFish_type( fish_type ) ;
		fishInfo.setFish_sesson( fish_sesson ) ;
		fishInfo.setFish_min_length( fish_min_length ) ;
		fishInfo.setFish_care( fish_care ) ;
		fishInfo.setFish_content( fish_content ) ;
		fishInfo.setMember_id( fish_member ) ;
		
		
		int fish_no = fishService.getBoardNo();
		fishInfo.setFish_no(fish_no);
		
		req.setAttribute("fishInfo", fishInfo);
		fishService.write( fishInfo ) ;
		
		
		FishInfoFile file = new FishInfoFile() ;
		file.setFish_originname(mul.getOriginalFileName("upfile"));
		file.setFish_storedname(mul.getFilesystemName("upfile"));
		file.setFish_no(fish_no);
		
		fishFileDao.insert(file) ;
		req.setAttribute("file", file);
		
		resp.sendRedirect( "/board/fish/info" ) ;
		
		}
}
