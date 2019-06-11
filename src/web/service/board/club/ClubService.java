package web.service.board.club;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.util.club.ClubPaging;

public interface ClubService {
	
	public List getList(ClubPaging paging);
	
	public ClubPaging getCurpage(HttpServletRequest req);
	
	public ClubPaging getBoardCurpage(HttpServletRequest req, int club_no);

}
