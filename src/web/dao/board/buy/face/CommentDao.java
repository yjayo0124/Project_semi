package web.dao.board.buy.face;

import java.util.List;

import web.dto.BuyBoard;
import web.dto.Comment;

public interface CommentDao {
public List selectComment(BuyBoard board);
	
	/**
	 * 코멘트 INSERT
	 * 
	 * @param comment - 삽입될 댓글
	 */
	public void insertComment(Comment comment);

	/**
	 * 댓글 삭제하기
	 * 
	 * @param comment - 삭제할 댓글
	 */
	public void deleteComment(Comment comment);

	/**
	 * 댓글 카운트 - 댓글 존재 여부 확인
	 * 
	 * @param comment - 존재 여부 체크 대상 댓글
	 * @return int - 댓글 갯수
	 */
	public int countComment(Comment comment);
}
