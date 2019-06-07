package web.dao.board.free;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.Comment;
import web.dto.FreeBoard;
import web.dto.FreeComment;

public class FreeCommentDaoImpl implements FreeCommentDao {

	// DB 연결 객체
	private Connection conn = DBConn.getConnection();

	// JDBC 객체
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List selectComment(FreeBoard board) {
		String sql
		= "SELECT * FROM ("
				+ "SELECT rownum rnum, B.* FROM ("
				+ "	SELECT"
				+ "		free_board_comment_no,"
				+ "		free_board_content,"
				+ "		free_board_comment_date,"
				+ "		member_id,"
				+ "		free_board_no"
				+ "	FROM Free_Comment"
				+ "	WHERE free_board_no = ?"
				+ "	ORDER BY free_board_comment_date DESC"
				+ "	) B"
				+ ") ORDER BY rnum";

		List commentList = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, board.getFree_board_no() );

			// ResultSet 반환
			rs = ps.executeQuery();

			while( rs.next() ) {
				FreeComment comment = new FreeComment();

				comment.setFree_board_comment_no(rs.getInt("free_board_comment_no"));
				comment.setFree_board_content(rs.getString("free_board_content"));
				comment.setFree_board_comment_date(rs.getString("free_board_comment_date"));
				comment.setMember_id(rs.getString("member_id"));
				comment.setFree_board_no(rs.getInt("free_board_no"));
			

				commentList.add(comment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return commentList;
	}

	@Override
	public void insertComment(FreeComment comment) {
		String sql
		= "INSERT INTO Free_Comment ("
				+ "		free_board_comment_no,"
				+ "		free_board_content,"
				+ "		member_id,"
				+ "		free_board_no )"
				+ "	VALUES ("
				+ "		Free_Comment_seq.nextval,"
				+ "		?,"
				+ "		?, "
				+ "		? )";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, comment.getFree_board_content());
			ps.setString(2, comment.getMember_id());
			ps.setInt(3, comment.getFree_board_no());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
	}

	@Override
	public void deleteComment(FreeComment comment) {
		String sql
		= "DELETE Free_Comment"
				+ "	WHERE Free_board_comment_no = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getFree_board_comment_no());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int countComment(FreeComment comment) {
	String sql = "SELECT COUNT(*) FROM Free_Comment WHERE free_board_comment_no=?";
		
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getFree_board_comment_no());
			rs = ps.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

}


