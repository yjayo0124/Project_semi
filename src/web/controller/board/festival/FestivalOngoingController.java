package web.controller.board.festival;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.board.festival.FestivalService;
import web.service.board.festival.FestivalServiceImpl;
import web.util.festival.FestivalPaging;

@WebServlet("/board/festival/ongoing")
public class FestivalOngoingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FestivalService festivalService = new FestivalServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		FestivalPaging paging = festivalService.getOngoingCurpage(req);

		req.setAttribute("ongoingpaging", paging);

		//게시판 목록 조회
		List list = festivalService.getOngoingList(paging);

		//MODEL로 조회 결과 넣기
		req.setAttribute("ongoinglist", list);

		req.getRequestDispatcher("/WEB-INF/views/board/festival/festival_ongoing.jsp").forward(req, resp);
	}


}
