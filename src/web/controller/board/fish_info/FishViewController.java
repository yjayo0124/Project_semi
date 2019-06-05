package web.controller.board.fish_info;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.member.MemberDao;
import web.dao.member.MemberDaoImpl;
import web.dto.FishInfo;
import web.service.board.fish_info.FishService;
import web.service.board.fish_info.FishServiceImpl;
import web.util.Fish_Paging;

/**
 * Servlet implementation class FishViewController
 */
@WebServlet("/board/fish/info")
public class FishViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FishService fishService = new FishServiceImpl() ;
	private MemberDao memberDao = new MemberDaoImpl();
       
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Fish_Paging paging = fishService.getCurPage(req) ;
		
		req.setAttribute( "paging", paging);
		
		List fishlist = fishService.getList( paging ) ;
		
		req.setAttribute( "fishlist", fishlist);
		
		int res = 0 ;
		
//		System.out.println(req.getSession().getAttribute("member_id"));
//		System.out.println(req.getSession().getAttribute("member_group"));
		
		if( req.getSession().getAttribute("member_id") != null) {
			
			int memCode = (int) req.getSession().getAttribute("member_code");
	
			res = memberDao.checkMemberCode(memCode);
		
		}
		req.setAttribute("res", res);
		
		req.getRequestDispatcher( "/WEB-INF/views/board/fish_info/fish_info.jsp" ).forward(req, resp);
		}
}
