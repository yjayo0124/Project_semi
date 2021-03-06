package web.dao.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.MemberDetail;
import web.util.Paging;

public class MemberDaoImpl implements MemberDao{

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private Connection conn = DBConn.getConnection();
	
	@Override
	public int selectCntMemberByMemberidAndMemberpw(MemberDetail member) {

		if( member.getMember_id() == null || member.getMember_pw() == null ) {
			
			return -1;
		} 

		//荑쇰━ �옉�꽦
		String sql = "";
		sql += "SELECT COUNT(*) FROM Member_Detail";
		sql += " WHERE 1=1";
		sql += " AND member_id = ?";
		sql += " AND member_pw = ?";
		
		int cnt = -1;
		try {
			//DB�옉�뾽
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMember_id());
			ps.setString(2, member.getMember_pw());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				cnt = rs.getInt(1);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB媛앹껜 �떕湲�
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
		
	}
	
	@Override
	public MemberDetail selectMemberByMemberid(MemberDetail member) {
		
		if( member.getMember_id() == null ) {
			return null;
		}

		//荑쇰━ �옉�꽦
		String sql = "";
		sql += "SELECT * FROM Member_Detail";
		sql += " WHERE 1=1";
		sql += " AND member_id = ?";
		
		try {
			//DB�옉�뾽
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMember_id());
		
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				member.setMember_code(rs.getInt("member_code"));
				member.setMember_id( rs.getString("member_id") );
				member.setMember_pw( rs.getString("member_pw") );
				member.setMember_nick( rs.getString("member_nick") );
				member.setMember_phone(rs.getString("member_phone"));
				member.setMember_email(rs.getString("member_email"));
				member.setMember_name( rs.getString("member_name") );
				member.setMember_gender( rs.getString("member_gender") );
				member.setMember_birthday( rs.getDate("member_birthday") );
				member.setMember_group(rs.getInt("member_group"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB媛앹껜 �떕湲�
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return member;
		
	}
	
	@Override
	public void insert(MemberDetail member) {
		
		//荑쇰━�옉�꽦
		String sql = "";
		sql += "INSERT INTO Member_Detail ( member_id, member_pw, member_nick, member_code, member_name,";
		sql += " member_gender, member_birthday, member_email, member_phone )";
		sql += " VALUES( ?, ?, ?, Member_Detail_seq.nextval, ?, ?, ?, ?, ? )";
		
		try {
			//DB�옉�뾽
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMember_id());
			ps.setString(2, member.getMember_pw());
			ps.setString(3, member.getMember_nick());
			ps.setString(4, member.getMember_name());
			ps.setString(5, member.getMember_gender());
			ps.setDate(6, new java.sql.Date(member.getMember_birthday().getTime()));
			ps.setString(7, member.getMember_email());
			ps.setString(8, member.getMember_phone());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB媛앹껜 �떕湲�
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int checkMemberCode(int member_code) {
		
		
		String sql = " ";
		sql = " SELECT member_group FROM member_detail WHERE member_code = ? ";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, member_code);
			
			rs = ps.executeQuery();
		
			while( rs.next() ) {
				res = rs.getInt(1);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
		
	}
	public boolean idCheck(MemberDetail member) {
		boolean check = false; 
		String sql = "";
		int count=0;
		sql += " SELECT COUNT(*) FROM member_Detail";
		sql += " WHERE member_id =?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMember_id());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			} 
			if(count==0) {
				check = true; 
			}
			else {
				check = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps !=null) ps.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return check; // 데이터베이스 오류
	}

	@Override
	public MemberDetail selectMemberByMemberpw(MemberDetail member) {
	
		if( member.getMember_pw() == null ) {
			return null;
		}

		
		String sql = "";
		sql += "SELECT * FROM Member_Detail";
		sql += " WHERE 1=1";
		sql += " AND member_pw = ?";
		
		try {
			//DB�옉�뾽
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMember_pw());
		
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				member.setMember_code(rs.getInt("member_code"));
				member.setMember_id( rs.getString("member_id") );
				member.setMember_pw( rs.getString("member_pw") );
				member.setMember_nick( rs.getString("member_nick") );
				member.setMember_name( rs.getString("member_name") );
				member.setMember_gender( rs.getString("member_gender") );
				member.setMember_birthday( rs.getDate("member_birthday") );
				member.setMember_group(rs.getInt("member_group"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB媛앹껜 �떕湲�
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return member;

	}

	@Override
	public void deleteMember(MemberDetail member) {
		String sql = "";
		sql += "UPDATE Member_Detail";
		sql += " SET member_pw = null, ";
		sql += "     member_name = null, ";
		sql += "     member_gender = null, ";
		sql += "     member_birthday = null, ";
		sql += "     member_email = null, ";
		sql += "     member_phone = null, ";
		sql += "     member_group = 2 ";
		sql += "  WHERE member_id = ?";
		
		
		try {
			//DB�옉�뾽
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMember_id());
		
			ps.executeUpdate();
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB媛앹껜 �떕湲�
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void updateMember(MemberDetail member) {
		String sql = "";
		sql += "UPDATE Member_Detail";
		sql += " SET member_pw = ?, ";
		sql += "     member_email = ?, ";
		sql += "     member_phone = ? ";
		sql += "  WHERE member_id = ?";
		
		
		try {
			//DB�옉�뾽
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMember_pw());
			ps.setString(2, member.getMember_email());
			ps.setString(3, member.getMember_phone());
			ps.setString(4, member.getMember_id());
		
			ps.executeUpdate();
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB媛앹껜 �떕湲�
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List selectAll(Paging paging) {
		
		String sql ="";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "	 SELECT member_code, member_id, member_name, member_gender, ";
		sql += "	 member_email, member_phone";
		sql += "	 FROM member_detail";
		sql += "	 WHERE member_group = 0";
		sql	+= "     AND member_id LIKE '%'||?||'%' ";	
		sql += "	 ORDER BY member_code DESC";
		sql += "	) B";
		sql += " ) ";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List list = new ArrayList();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDetail member = new MemberDetail();
				
				member.setMember_code(rs.getInt("member_code"));
				member.setMember_id(rs.getString("member_id"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_gender(rs.getString("member_gender"));
				member.setMember_email(rs.getString("member_email"));
				member.setMember_phone(rs.getString("member_phone"));
				
				list.add(member);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				// 자원 해제
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	@Override
	public int selectCntAll(String search) {

		
		String sql = "";
		sql += "SELECT count(*) FROM member_detail";
		sql += " WHERE member_id LIKE '%'||?||'%'";
		sql += " AND member_group=0";
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, search);
			rs = ps.executeQuery();
			
			rs.next();
			
			totalCount = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return totalCount;
		
	}
	
	public void memberforceout(MemberDetail member) {
		
		String sql ="";
		sql += "	UPDATE member_detail";
		sql += "	SET member_pw = null,";
		sql += "	member_name = null,";
		sql += "	member_gender = null,";
		sql += "	member_birthday = null,";
		sql += "	member_email = null,";
		sql += "	member_phone = null,";
		sql += "	member_group = 2";
		sql += "	WHERE member_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMember_id());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
