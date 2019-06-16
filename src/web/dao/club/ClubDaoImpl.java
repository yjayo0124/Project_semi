package web.dao.club;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.club.Club;
import web.dto.club.ClubBoard;
import web.dto.club.ClubComment;
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
				sql+="	SELECT club_no, club_originname, club_storedname, club_title, club_include, club_tag, member_id, club_createdate, membercnt FROM club";
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
						club.setMembercnt(rs.getInt("membercnt"));
						
						list.add(club);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}

				return list;
			}

	@Override
	public List selectPop() {
		
		String sql = "";
		sql+="SELECT * FROM ( SELECT rownum rnum, B.* FROM (";
		sql+="	SELECT club_no, club_originname, club_storedname, club_title, club_include, club_tag, member_id, club_createdate, membercnt FROM club";
		sql+="	ORDER BY membercnt DESC) B ORDER BY rnum";
		sql+="	) club";
		sql+=" WHERE rnum BETWEEN 1 AND 4";

		List pop = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);

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
				club.setMembercnt(rs.getInt("membercnt"));
				
				pop.add(club);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pop;
	}

	
	
	@Override
	public void insert(Club club) {
		String sql ="";
		sql+="INSERT INTO club (club_no, club_originname, club_storedname, club_title, club_include, club_tag, member_id)";
		sql+=" VALUES (club_seq.nextval, ?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, club.getClub_originname());
			ps.setString(2, club.getClub_storedname());
			ps.setString(3, club.getClub_title());
			ps.setString(4, club.getClub_include());
			ps.setInt(5, club.getClub_tag());
			ps.setString(6, club.getMember_id());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Club selectClubByClubno(Club club) {
		String sql= "";
		sql+="SELECT club_storedname, club_title, club_include, club_tag, member_id, membercnt";
		sql+=" FROM club";
		sql+=" WHERE club_no = ?";
		
		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1,club.getClub_no());
			rs= ps.executeQuery();

			while(rs.next()) {
				club.setClub_storedname(rs.getString("club_storedname"));
				club.setClub_title(rs.getString("club_title"));
				club.setClub_include(rs.getString("club_include"));
				club.setClub_tag(rs.getInt("club_tag"));
				club.setMember_id(rs.getString("member_id"));
				club.setMembercnt(rs.getInt("membercnt"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return club;
	}
	
	
	@Override
	public int selectBoardCntAll(int club_no) {
		String sql ="";
		sql += "SELECT count(*)";
		sql += " FROM club_board";
		sql += " WHERE club_no = ?";
		int totalCount = 0;

		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1,club_no);
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
	public List selectBoardAll(ClubPaging paging) {
		String sql = "";
		sql+="SELECT * FROM ( SELECT rownum rnum, B.* FROM (";
		sql+="	SELECT club_board_no, club_board_title, club_board_content, club_board_writer,club_board_writedate FROM club_board";
		sql+="	WHERE club_no = ? ORDER BY club_board_writedate DESC) B ORDER BY rnum";
		sql+="	) club_board";
		sql+=" WHERE rnum BETWEEN ? AND ?";

		List list = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getClub_no());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());

			rs = ps.executeQuery();

			while( rs.next() ) {
				ClubBoard clubBoard = new ClubBoard();
				
//				clubBoard.setClub_no(paging.getClub_no());
				clubBoard.setClub_board_no(rs.getInt("club_board_no"));
				clubBoard.setClub_board_title(rs.getString("club_board_title"));
				clubBoard.setClub_board_content(rs.getString("club_board_content"));
				clubBoard.setClub_board_writer(rs.getString("club_board_writer"));
				clubBoard.setClub_board_writedate(rs.getDate("club_board_writedate"));
				
				list.add(clubBoard);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void insert(ClubBoard clubBoard) {
		
		String sql ="";
		sql+="INSERT INTO club_board(club_board_no, club_no, club_board_title, club_board_content, club_board_writer, member_id)";
		sql+=" VALUES(club_board_seq.nextval, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, clubBoard.getClub_no());
			ps.setString(2, clubBoard.getClub_board_title());
			ps.setString(3, clubBoard.getClub_board_content());
			ps.setString(4, clubBoard.getClub_board_writer());
			ps.setString(5, clubBoard.getMember_id());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkClub(String member_id) {
		boolean check = false;

		String sql ="";
		sql += "SELECT club_no";
		sql += " FROM member_detail";
		sql += " WHERE  member_id = ? ";
		

		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, member_id);
			rs= ps.executeQuery();

			while(rs.next()) {
				if(rs.getInt("club_no") == 0) {
					check = true;
				} else {
					check = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public boolean checkIdByClub(String member_id, int club_no) {
		int count = 0;
		boolean check = false;

		String sql ="";
		sql += "SELECT count(*)";
		sql += " FROM club_member";
		sql += " WHERE  club_no = ? AND member_id = ? ";
		

		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, club_no);
			ps.setString(2, member_id);
			rs= ps.executeQuery();

			while(rs.next()) {
				count = rs.getInt(1);
				if(count != 0) {
					check = true;
				} else {
					check = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public void join(String member_id, int club_no) {
		
		String sql ="";
		sql+="INSERT INTO club_member(club_member_no, club_no, member_id)";
		sql+=" VALUES (club_member_seq.nextval, ?, ?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, club_no);
			ps.setString(2, member_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateMember(String member_id, int club_no) {
		
		String sql ="";
		sql+="update member_detail set club_no = ?";
		sql+=" WHERE member_id = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, club_no);
			ps.setString(2, member_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateNullMember(String member_id) {
		
		String sql ="";
		sql+="update member_detail set club_no = ?";
		sql+=" WHERE member_id = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setString(2, member_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void delete(String member_id) {
		
		String sql ="";
		sql+="DELETE club_member WHERE member_id = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean checkjoin(String member_id) {
		int count = 0;
		boolean check = false;

		String sql ="";
		sql += "SELECT club_no";
		sql += " FROM member_detail";
		sql += " WHERE member_id = ? ";
		

		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, member_id);
			rs= ps.executeQuery();

			while(rs.next()) {
				count = rs.getInt(1);
				if(count == 0) {
					check = true;
				} else {
					check = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public boolean checkleave(String member_id, int club_no) {
		int count = 0;
		boolean check = false;

		String sql ="";
		sql += "SELECT club_no";
		sql += " FROM club_member";
		sql += " WHERE member_id = ? ";
		

		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, member_id);
			rs= ps.executeQuery();

			while(rs.next()) {
				count = rs.getInt(1);
				if(count == club_no) {
					check = true;
				} else {
					check = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public void delete(ClubBoard clubBoard) {
		
		String sql ="";
		sql += "DELETE FROM club_board";
		sql += " WHERE club_board_no = ?";
		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, clubBoard.getClub_board_no());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void membercntIncrese(int club_no) {
		String sql ="";
		sql+="update club set membercnt = membercnt + 1";
		sql+=" WHERE club_no = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, club_no);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void membercntReduced(int club_no) {
		
		String sql ="";
		sql+="update club set membercnt = membercnt - 1";
		sql+=" WHERE club_no = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, club_no);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int SelectmembercntByclubno(int club_no) {
		int membercnt = 0;
		
		String sql ="";
		sql += "SELECT membercnt";
		sql += " FROM club";
		sql += " WHERE club_no = ?";
		
		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1,club_no);
			rs= ps.executeQuery();

			while(rs.next()) {
				membercnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return membercnt;
	}

	@Override
	public int selectClubnoByMemberId(String member_id) {
		
		String sql ="";
		sql += "SELECT club_no";
		sql += " FROM club";
		sql += " WHERE member_id = ?";
		int club_no = 0;
		

		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1,member_id);
			rs= ps.executeQuery();

			while(rs.next()) {
				club_no = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return club_no;
	}
	
}
