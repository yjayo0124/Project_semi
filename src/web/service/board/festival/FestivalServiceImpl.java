package web.service.board.festival;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.board.festival.FestivalDao;
import web.dao.board.festival.FestivalDaoImpl;
import web.dto.festival.FestivalBoard;
import web.util.festival.FestivalPaging;

public class FestivalServiceImpl implements FestivalService{
	
	private FestivalDao festivalDao = new FestivalDaoImpl();
	
	@Override
	public List getList(FestivalPaging paging) {
		
		return festivalDao.selectAll(paging);
	}
	
	@Override
	public List getOngoingList(FestivalPaging paging) {
		
		return festivalDao.selectOngoing(paging);
	}
	
	@Override
	public List getClosedList(FestivalPaging paging) {
		
		return festivalDao.selectClosed(paging);
	}

	@Override
	public FestivalPaging getCurpage(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		int totalCount = festivalDao.selectCntAll();
		
		FestivalPaging paging = new FestivalPaging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public FestivalPaging getOngoingCurpage(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		int totalCount = festivalDao.selectCntOngoing();
		
		FestivalPaging paging = new FestivalPaging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public FestivalPaging getClosedCurpage(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		int totalCount = festivalDao.selectCntClosed();
		
		FestivalPaging paging = new FestivalPaging(totalCount, curPage);
		
		return paging;
	}
	

	@Override
	public FestivalBoard getBoardno(HttpServletRequest req) {
		
		String param = req.getParameter("festival_board_no");
		int boardno = 0;
		if(param!=null && !"".contentEquals(param)) {
			boardno = Integer.parseInt(param);
		}
		FestivalBoard board = new FestivalBoard();
		board.setFestival_board_no(boardno);
		return board;
	}

	@Override
	public FestivalBoard view(FestivalBoard board) {
		
		return festivalDao.selectBoardByBoardno(board);
	}

	@Override
	public void write(FestivalBoard board) {


		festivalDao.insert(board);
		
	}

	@Override
	public void update(FestivalBoard board) {
		festivalDao.update(board);
		
	}

	@Override
	public void delete(FestivalBoard board) {
		festivalDao.delete(board);
		
	}


}
