package web.dao.club;

import java.util.ArrayList;

import web.dto.club.ClubComment;


public interface ClubCommentDao {
	
	public ArrayList<ClubComment> selectAll(int club_board_no);
	
	public void insert (ClubComment clubComment);
	
	public void delete (ClubComment clubComment);
	
	public void deleteBoard(int club_board_no);
	
}
