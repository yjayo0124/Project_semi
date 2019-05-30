package web.dao.board.festival;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.festival.FestivalBoard;
import web.util.festival.FestivalPaging;

public class FestivalDaoImpl implements FestivalDao{
	
	private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List selectAll(FestivalPaging paging) {
		
		//파일업로드 기록 조회쿼리
				String sql = "";
				sql+="SELECT * FROM (	SELECT rownum rnum, B.* FROM (";
				sql+="	SELECT festival_board_no, festival_title, festival_content, festival_start, festival_end, festival_writtendate FROM Festival_Board";
				sql+="	ORDER BY festival_board_no DESC) B ORDER BY rnum";
				sql+="	) Festival_Board";
				sql+=" WHERE rnum BETWEEN ? AND ?";
			
				List list = new ArrayList();
				try {
					ps = conn.prepareStatement(sql);
					
					ps.setInt(1, paging.getStartNo());
					ps.setInt(2, paging.getEndNo());
					
					rs = ps.executeQuery();
					
					while( rs.next() ) {
						FestivalBoard board = new FestivalBoard();
						
						board.setFestival_board_no( rs.getInt("festival_board_no") );
						board.setFestival_title(rs.getString("festival_title"));
						board.setFestival_content(rs.getString("festival_content"));
						board.setFestival_start(rs.getDate("festival_start"));
						board.setFestival_end(rs.getDate("festival_end"));
						board.setFestival_writtendate(rs.getDate("festival_writtendate"));
						
						list.add(board);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
						
				return list;
	}

	@Override
	public int selectCntAll() {
		String sql ="";
		sql += "SELECT count(*)";
		sql += " FROM Festival_Board";
		int totalCount = 0;
		
		 try {
				ps= conn.prepareStatement(sql);
				rs= ps.executeQuery();
				
				while(rs.next()) {
					totalCount = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
					
			return totalCount;
	}

	

}
