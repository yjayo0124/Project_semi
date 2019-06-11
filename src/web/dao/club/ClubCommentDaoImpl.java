package web.dao.club;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.club.ClubComment;



public class ClubCommentDaoImpl implements ClubCommentDao{
	
	private Connection conn = DBConn.getConnection();

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public ArrayList<ClubComment> selectAll(int club_board_no) {
		
		String sql = "";
		sql+="SELECT * FROM ( SELECT rownum rnum, B.* FROM (";
		sql+="	SELECT club_comment_no, club_board_no, club_comment_content, member_id, club_comment_writer, club_comment_writedate FROM club_comment";
		sql+="	WHERE club_board_no=?  ORDER BY club_comment_writedate) B ORDER BY rnum ) club_comment";

		ArrayList<ClubComment> comment = new ArrayList<ClubComment>();
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, club_board_no);

			rs = ps.executeQuery();

			while( rs.next() ) {
				ClubComment clubComment = new ClubComment();
				
				clubComment.setClub_comment_no(rs.getInt("club_comment_no"));
				clubComment.setClub_board_no(rs.getInt("club_board_no"));
				clubComment.setClub_comment_content(rs.getString("club_comment_content"));
				clubComment.setMember_id(rs.getString("member_id"));
				clubComment.setClub_comment_writer(rs.getString("club_comment_writer"));
				clubComment.setClub_comment_writedate(rs.getDate("club_comment_writedate"));
				
				comment.add(clubComment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comment;
	}

	@Override
	public void insert(ClubComment clubComment) {
		
		String sql ="";
		sql+="INSERT INTO club_comment( club_comment_no, club_board_no, club_comment_content, member_id, club_comment_writer )";
		sql+=" VALUES(club_comment_seq.nextval, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, clubComment.getClub_board_no());
			ps.setString(2, clubComment.getClub_comment_content());
			ps.setString(3, clubComment.getMember_id());
			ps.setString(4, clubComment.getClub_comment_writer());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
