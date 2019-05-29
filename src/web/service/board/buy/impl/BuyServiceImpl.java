package web.service.board.buy.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.board.buy.face.BuyDao;
import web.dao.board.buy.impl.BuyDaoImpl;

import web.dto.BuyBoard;
import web.service.board.buy.face.BuyService;
import web.util.Paging;

public class BuyServiceImpl implements BuyService{
	
	private BuyDao buyDao = new BuyDaoImpl();
	
	@Override
	public List getList(Paging paging) {

		return buyDao.selectAll(paging);
	}
	
	@Override
	public Paging getCurPage(HttpServletRequest req) {
		
		// 전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		// 전체 게시글 수
		int totalCount = buyDao.selectCntAll();
		
		// 페이징 객체 생성
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging); //TEST
		
		return paging;
	}

	@Override
	public BuyBoard getBoardno(HttpServletRequest req) {
		
		// 전달파라미터 boardno 파싱
				String param = req.getParameter("boardno");
				int boardno = 0;
				if( param!=null && !"".equals(param) ) {
					boardno = Integer.parseInt(param);
				}
				
				//Board 객체 생성
				BuyBoard board = new BuyBoard();
				board.setBoardno(boardno);
				
				return board;
	}

	@Override
	public BuyBoard view(BuyBoard viewBoard) {
		
		return buyDao.selectBoardByBoardno(viewBoard);
	}
	
}
