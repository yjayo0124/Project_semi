package web.controller.board.boast;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.boast.Recommend;
import web.service.board.boast.BoastService;
import web.service.board.boast.BoastServiceImpl;

/**
 * Servlet implementation class BoastRecommendController
 */
@WebServlet("/board/boast/recommend")
public class BoastRecommendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoastService boardService = new BoastServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//추천 정보 얻기
		Recommend recommendParam = boardService.getRecommend(req);

		//추천 정보 토글
		boolean result = boardService.recommend(recommendParam);

		//추천 수 조회
		int cnt = boardService.getTotalCntRecommend(recommendParam);

		//결과 JSON응답
		resp.getWriter().println("{\"result\": "+result+", \"cnt\": "+cnt+"}");
				
			}
}
