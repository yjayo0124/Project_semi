package web.dao.board.boast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dbutil.DBConn;
import web.dto.boast.Recommend;


public class RecommendDaoImpl implements RecommendDao {
	
	//DB관련 객체
	private Connection conn = DBConn.getConnection(); 

	private PreparedStatement ps = null;
	private ResultSet rs = null;



	@Override
	public int selectCntRecommend(Recommend recommend) {
		String sql = "";
		sql += "SELECT count(*) FROM recommend";
		sql += " WHERE boast_board_no = ?";
		sql += " 	AND member_id = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		int cnt = -1;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, recommend.getBoast_board_no());
			ps.setString(2, recommend.getMember_id());

			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				if(rs!=null)	rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	@Override
	public void insertRecommend(Recommend recommend) {
		String sql = "";
		sql += "INSERT INTO recommend";
		sql += " VALUES ( ?, ? )";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, recommend.getMember_id());
			ps.setInt(2, recommend.getBoast_board_no());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				if(rs!=null)	rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteRecommend(Recommend recommend) {
		String sql = "";
		sql += "DELETE recommend";
		sql += " WHERE member_id = ?";
		sql += " 	AND boast_board_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, recommend.getMember_id());
			ps.setInt(2, recommend.getBoast_board_no());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				if(rs!=null)	rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int selectTotalCntRecommend(Recommend recommend) {

		String sql = "SELECT COUNT(*) FROM recommend"
				+ " WHERE boast_board_no =?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, recommend.getBoast_board_no());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
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









