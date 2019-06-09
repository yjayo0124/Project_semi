package web.dao.board.boast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.Comment;
import web.dto.boast.BoastBoard;
import web.dto.boast.BoastComment;

public class CommentDaoImpl implements CommentDao {

	// DB 연결 객체
	private Connection conn = DBConn.getConnection();

	// JDBC 객체
	private PreparedStatement ps;
	private ResultSet rs;
			
	@Override
	public List selectComment(BoastBoard board) {
		String sql
		= "SELECT * FROM ("
				+ "SELECT rownum rnum, B.* FROM ("
				+ "	SELECT"
				+ "		boast_board_comment_no,"
				+ "		boast_board_no,"
				+ "		member_id,"
				+ "		boast_content,"
				+ "		boast_comment_written_date"
				+ "	FROM Boast_Comment"
				+ "	WHERE boast_board_no = ?"
				+ "	ORDER BY boast_comment_written_date DESC"
				+ "	) B"
				+ ") ORDER BY rnum";

		List commentList = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, board.getBoast_board_no() );

			// ResultSet 반환
			rs = ps.executeQuery();

			while( rs.next() ) {
				BoastComment comment = new BoastComment();

				comment.setRnum( rs.getInt( "rnum" ) ) ;
				comment.setBoast_board_comment_no( rs.getInt( "boast_board_comment_no" ) ) ;
				comment.setBoast_board_no( rs.getInt( "boast_board_no" ) ) ;
				comment.setBoast_content( rs.getString( "boast_content" ) ) ;
				comment.setBoast_comment_written_date( rs.getDate( "boast_comment_written_date" ) ) ;
				comment.setMember_id( rs.getString( "member_id" ) ) ;
 								
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
	public void insertComment(BoastComment comment) {
		
		String sql
		= "INSERT INTO Boast_Comment ("
				+ "		boast_board_comment_no,"
				+ "		boast_board_no,"
				+ "		boast_content,"
				+ "		member_id)"
				
				+ "	VALUES ("
				+ "		Boast_Comment_seq.nextval,"
				+ "		?,"
				+ "		?,"
				+ "		?)";		

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, comment.getBoast_board_no());
			ps.setString(2, comment.getBoast_content());
			ps.setString(3, comment.getMember_id());
	
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
	public void deleteComment(BoastComment comment) {
		
		String sql
		= "DELETE Boast_Comment"
				+ "	WHERE boast_board_comment_no = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getBoast_board_comment_no());
			
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
	public int countComment(BoastComment comment) {

		String sql = "SELECT COUNT(*) FROM Boast_Comment WHERE boast_board_comment_no=?";
		
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getBoast_board_comment_no() );
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
