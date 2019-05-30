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
	public FestivalPaging getCurpage(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
			System.out.println(curPage);
		}
		int totalCount = festivalDao.selectCntAll();
		
		FestivalPaging paging = new FestivalPaging(totalCount, curPage);
		
		return paging;
	}
	

	@Override
	public FestivalBoard getBoardno(HttpServletRequest req) {
		
		return null;
	}

	@Override
	public FestivalBoard view(FestivalBoard board) {
		
		return null;
	}

}
