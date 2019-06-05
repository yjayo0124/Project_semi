package web.dao.club;

import java.util.List;

import web.util.club.ClubPaging;

public interface ClubDao {

	public int selectCntAll(int club_tag);
	
	public List selectAll(ClubPaging paging);
	
}
