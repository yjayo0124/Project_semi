package web.controller.board.free;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.member.MemberDao;
import web.dao.member.MemberDaoImpl;
import web.service.board.free.FreeService;
import web.service.board.free.FreeServiceImpl;
import web.util.Paging;

@WebServlet("/board/free/list")
public class FreeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//BoardService 객체
	private FreeService FreeService = new FreeServiceImpl();
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청파라미터에서 curPage 얻어오기
		Paging paging = FreeService.getCurPage(req);
		
		//MODEL로 Paging 객체 넣기
		req.setAttribute("paging", paging);
		
		
		
		//게시판 목록 조회
		List list = FreeService.getList(paging);
		
		//MODEL로 조회 결과 넣기
		req.setAttribute("list", list);
		
		
		int res = 0;
		
		if( req.getSession().getAttribute("member_id") != null) {
			
			res = 1 ; 
			
		}
		
		req.setAttribute("res", res);
		
		
		
		//VIEW지정
		req.getRequestDispatcher("/WEB-INF/views/board/free/list.jsp").forward(req, resp);
		
	}

	
	
	
}
