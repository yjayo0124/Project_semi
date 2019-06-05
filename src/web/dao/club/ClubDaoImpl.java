package web.dao.club;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.club.Club;
import web.util.club.ClubPaging;

public class ClubDaoImpl implements ClubDao {
	
	private Connection conn = DBConn.getConnection();

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int selectCntAll(int club_tag) {
		
		String sql ="";
		sql += "SELECT count(*)";
		sql += " FROM club";
		sql += " WHERE club_tag = ?";
		int totalCount = 0;

		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1,club_tag);
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

	@Override
	public List selectAll(ClubPaging paging) {
		
				String sql = "";
				sql+="SELECT * FROM ( SELECT rownum rnum, B.* FROM (";
				sql+="	SELECT club_no, club_originname, club_storedname, club_title, club_include, club_tag, member_id, club_createdate FROM club";
				sql+="	WHERE club_tag = ? ORDER BY club_no DESC) B ORDER BY rnum";
				sql+="	) club";
				sql+=" WHERE rnum BETWEEN ? AND ?";

				List list = new ArrayList();
				try {
					ps = conn.prepareStatement(sql);
					
					ps.setInt(1, paging.getClub_tag());
					ps.setInt(2, paging.getStartNo());
					ps.setInt(3, paging.getEndNo());

					rs = ps.executeQuery();

					while( rs.next() ) {
						Club club = new Club();
						
						club.setClub_no(rs.getInt("club_no"));
						club.setClub_originname(rs.getString("club_originname"));
						club.setClub_storedname(rs.getString("club_storedname"));
						club.setClub_title(rs.getString("club_title"));
						club.setClub_include(rs.getString("club_include"));
						club.setClub_tag(rs.getInt("club_tag"));
						club.setMember_id(rs.getString("member_id"));
						
						list.add(club);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}

				return list;
			}

}
