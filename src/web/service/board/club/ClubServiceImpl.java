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
		int club_tag = 0;
		if(param!=null && !"".equals(param)) {
			club_tag = Integer.parseInt(param);
		}
		
		String param2 = req.getParameter("curPage");
		int curPage = 0;
		if(param2!=null && !"".equals(param2)) {
			curPage = Integer.parseInt(param2);
		}
		System.out.println(club_tag);
		System.out.println(curPage);
		int totalCount = clubDao.selectCntAll(club_tag);
		ClubPaging paging = new ClubPaging(totalCount,curPage);
		paging.setClub_tag(club_tag);
		
		return paging;
	}

}
