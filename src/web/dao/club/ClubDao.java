package web.dao.club;

import java.util.List;

import web.dto.club.Club;
import web.dto.club.ClubBoard;
import web.dto.club.ClubComment;
import web.util.club.ClubPaging;

public interface ClubDao {

	public int selectCntAll(int club_tag);
	
	public List selectAll(ClubPaging paging);
	
	public List selectPop();
	
	public void insert (Club club);
	
	public Club selectClubByClubno(Club club);
	
	public int selectBoardCntAll(int club_no);
	
	public List selectBoardAll(ClubPaging paging);
	
	public void insert(ClubBoard clubBoard);
	
	public boolean checkClub(String member_id);
	
	public boolean checkIdByClub(String member_id, int club_no);
	
	public void join(String member_id, int club_no);
	
	public void updateMember(String member_id, int club_no);
	
	public void updateNullMember(String member_id);
	
	public void delete(String member_id);
	
	public boolean checkjoin(String member_id);
	
	public boolean checkleave(String member_id, int club_no);
}
