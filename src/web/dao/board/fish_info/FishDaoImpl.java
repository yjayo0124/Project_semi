package web.dao.board.fish_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.FishInfo;
import web.dto.FreeBoard;
import web.util.Fish_Paging;
import web.util.Paging;

public class FishDaoImpl implements FishDao {

	//DB관련 객체
	private Connection conn = DBConn.getConnection(); 

	private PreparedStatement ps = null;
	private ResultSet rs = null;
		
	@Override
	public List selectAll(Fish_Paging paging) {
			
			//게시글 목록 조회쿼리
			String sql = "";
			sql += "SELECT * FROM (";
			sql += " 	SELECT rownum rnum, B.* FROM (";
			sql += " 	 SELECT fish_no , fish_name , fish_type , fish_sesson , fish_min_length , ";
			sql += "     fish_care , fish_content , fish_written_date , member_id";
			sql += " 	FROM Fish_Info ORDER BY fish_no DESC";
			sql += " 	) B";
			sql += " 	ORDER BY rnum";
			sql += " ) Fish_Info";
			sql += " WHERE rnum BETWEEN ? AND ?";

		
			List fishlist = new ArrayList();
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
				
				rs = ps.executeQuery();
				
				while( rs.next() ) {
					FishInfo fish = new FishInfo() ;
					
					fish.setFish_no( rs.getInt( "fish_no" ) ) ;
					fish.setFish_name( rs.getString( "fish_name" ) ) ;
					fish.setFish_type( rs.getString( "fish_type" ) ) ;
					fish.setFish_sesson( rs.getString( "fish_sesson" ) ) ;
					fish.setFish_min_length( rs.getString( "fish_min_length" ) ) ;
					fish.setFish_care( rs.getString( "fish_care" ) ) ;
					fish.setFish_content( rs.getString( "fish_content" ) ) ;
					fish.setFish_written_date( rs.getDate( "fish_written_date" ) ) ;
					fish.setMember_id( rs.getString( "member_id" ) ) ;

					fishlist.add( fish ) ;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					// 자원 해제
					if(rs!=null)	rs.close();
					if(ps!=null)	ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
					
			return fishlist;
			
		}

	@Override
	public int selectCntAll() {
		//전체 게시글 수 조회 쿼리
		String sql = "";
		sql+="SELECT count(*)";
		sql+=" FROM Fish_Info";
	
		int totalCount = 0;
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				totalCount = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return totalCount;
	}

}
