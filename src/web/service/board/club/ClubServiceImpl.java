package web.service.board.club;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.club.ClubDao;
import web.dao.club.ClubDaoImpl;
import web.util.club.ClubPaging;

public class ClubServiceImpl implements ClubService {
	
	private ClubDao clubDao = new ClubDaoImpl(); 

	@Override
	public List getList(ClubPaging paging) {
		
		return clubDao.selectAll(paging);
	}

	@Override
	public ClubPaging getCurpage(HttpServletRequest req) {
		
		String param = req.getParameter("club_tag");
		int club_tag = 1;
		if(param!=null && !"".equals(param)) {
			club_tag = Integer.parseInt(param);
		}
		
		String param2 = req.getParameter("curPage");
		int curPage = 0;
		if(param2!=null && !"".equals(param2)) {
			curPage = Integer.parseInt(param2);
		}
		
		
		int totalCount = clubDao.selectCntAll(club_tag);
		ClubPaging paging = new ClubPaging(totalCount,curPage);
		paging.setClub_tag(club_tag);
		
		return paging;
	}

	@Override
	public ClubPaging getBoardCurpage(HttpServletRequest req, int club_no) {
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = clubDao.selectBoardCntAll(club_no);
		ClubPaging paging = new ClubPaging(totalCount,curPage);
		paging.setClub_no(club_no);
		
		return paging;
	}

	

}
