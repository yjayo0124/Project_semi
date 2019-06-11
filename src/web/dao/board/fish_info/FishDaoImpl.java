package web.dao.board.fish_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
			sql += " 	 SELECT i.fish_no , i.fish_name , i.fish_type , i.fish_sesson , i.fish_min_length , ";
			sql += "     i.fish_care , i.fish_content , i.fish_written_date , i.member_id , f.fish_storedname ";
			sql += " 	 FROM Fish_Info i , fish_file f " ;
			sql += " 	 where i.fish_no = f.fish_no(+) " ;
			sql += "	 ORDER BY fish_no DESC";
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
					fish.setFish_storedname( rs.getString( "fish_storedname" ) ) ;

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

	@Override
	public FishInfo selectBoardByBoardno(FishInfo fishInfo) {
		//게시글 조회쿼리
			String sql = "";
			sql += "select i.fish_no , i.fish_name , i.fish_type , i.fish_sesson ," ;
			sql += " i.fish_min_length , i.fish_care , i.fish_content , i.fish_written_date , i.member_id , f.fish_storedname " ;
			sql += " from Fish_Info i , fish_file f " ;
			sql += " WHERE i.fish_no = f.fish_no and i.fish_no = ?";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setInt( 1 , fishInfo.getFish_no() ) ;
					
				rs = ps.executeQuery();
					
				while( rs.next() ) {
						
				fishInfo.setFish_no( rs.getInt( "fish_no" ) ) ;
				fishInfo.setFish_name( rs.getString( "fish_name" ) ) ;
				fishInfo.setFish_type( rs.getString( "fish_type" ) ) ;
				fishInfo.setFish_sesson( rs.getString( "fish_sesson" ) ) ;
				fishInfo.setFish_min_length( rs.getString( "fish_min_length" ) ) ;
				fishInfo.setFish_care( rs.getString( "fish_care" ) ) ;
				fishInfo.setFish_content( rs.getString( "fish_content" ) );
				fishInfo.setFish_written_date( rs.getDate( "fish_written_date" ) ) ;
				fishInfo.setMember_id( rs.getString( "member_id" ) ) ;
				fishInfo.setFish_storedname( rs.getString( "fish_storedname" ) ) ;
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
						
			return fishInfo;
		}

	@Override
	public int selectBoardno() {
		String sql = "";
		sql += "SELECT Fish_Info_seq.nextval";
		sql += " FROM dual";
		
		//게시글번호
		int fish_no = 0;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//결과 담기
			while(rs.next()) {
				fish_no = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//게시글 번호 반환
		return fish_no;
	}

	@Override
	public void insert(FishInfo fishInfo) {
		
		String sql = "";
		sql += "insert into Fish_Info ( fish_no , fish_name , fish_type , fish_sesson ," ;
		sql += " fish_min_length , fish_care , fish_content , fish_written_date , member_id ) ";
		sql += " values ( Fish_Info_seq.nextval , ? , ? , ? , ? , ? , ? , sysdate , ? )" ;
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString( 1 , fishInfo.getFish_name() ) ;
			ps.setString( 2 , fishInfo.getFish_type() ) ;
			ps.setString( 3 , fishInfo.getFish_sesson() ) ;
			ps.setString( 4 , fishInfo.getFish_min_length() ) ;
			ps.setString( 5 , fishInfo.getFish_care() ) ;
			ps.setString( 6 , fishInfo.getFish_content() ) ;
			ps.setString( 7 , fishInfo.getMember_id() ) ;
			
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
	public void update(FishInfo fishInfo) {

		String sql = "";
		sql += "UPDATE Fish_Info";
		sql += " SET fish_name = ? , ";
		sql += " 	fish_type = ? , " ;
		sql += " 	fish_sesson = ? , " ;
		sql += " 	fish_min_length = ? ," ;
		sql += " 	fish_care = ? , " ;
		sql += " 	fish_content = ?";
		sql += " WHERE fish_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);

			ps.setString( 1 , fishInfo.getFish_name() ) ;
			ps.setString( 2 , fishInfo.getFish_type() ) ;
			ps.setString( 3 , fishInfo.getFish_sesson() ) ;
			ps.setString( 4 , fishInfo.getFish_min_length() ) ;
			ps.setString( 5 , fishInfo.getFish_care() ) ;
			ps.setString( 6 , fishInfo.getFish_content() ) ;
			ps.setInt( 7 , fishInfo.getFish_no() ) ;
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(FishInfo fishInfo) {
		String sql = "";
		sql += "DELETE Fish_Info";
		sql += " WHERE fish_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fishInfo.getFish_no() ) ;

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public HashMap getPrevNext(FishInfo fishInfo) {
		String sql = "";
		sql += "SELECT * FROM (";
		sql += " SELECT";
		sql += " 	LEAD( fish_no, 1 ) OVER (ORDER BY fish_no DESC) prev,";
		sql += "	fish_no,";
		sql += " 	LAG( fish_no, 1 ) OVER (ORDER BY fish_no DESC) next";
		sql += " FROM fish_info";
		sql += " )";
		sql += " WHERE fish_no = ?";
		  
		HashMap<String, Integer> map = new HashMap();
		try {  
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fishInfo.getFish_no() ) ;
			rs = ps.executeQuery();

			while(rs.next()) {
				map.put("prev", rs.getInt("prev"));
				map.put("next", rs.getInt("next"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return map ;
	}

	@Override
	public HashMap getPrevNextName(FishInfo fishInfo) {
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += " SELECT";
		sql += " 	LEAD( fish_name, 1 ) OVER (ORDER BY fish_no DESC) prev,";
		sql += "	fish_no , fish_name,";
		sql += " 	LAG( fish_name, 1 ) OVER (ORDER BY fish_no DESC) next";
		sql += " FROM fish_info";
		sql += " )";
		sql += " WHERE fish_no = ?";
		  
		HashMap<String, String> map = new HashMap();
		try {  
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fishInfo.getFish_no() ) ;
			rs = ps.executeQuery();

			while(rs.next()) {
				map.put("prev", rs.getString("prev"));
				map.put("next", rs.getString("next"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return map ;
	}

	@Override
	public FishInfo selectImgByBoardno(FishInfo fishInfo) {
		
		String sql = "";
		sql += "SELECT fish_storedname FROM fish_file";
		sql += " WHERE fish_no = ?";


		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, fishInfo.getFish_no());
			rs = ps.executeQuery();

			while( rs.next() ) {	
				fishInfo.setFish_storedname( rs.getString("fish_storedname") );

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fishInfo;
	}


		
}

