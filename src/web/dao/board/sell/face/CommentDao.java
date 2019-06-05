package web.dao.board.sell.face;

import java.util.List;

import web.dto.Comment;
import web.dto.SellBoard;

public interface CommentDao {
	
	
	
	public List selectComment(SellBoard board);
	

	public void insertComment(Comment comment);
	
	public void deleteComment(Comment comment);

	
	public int countComment(Comment comment);




}
