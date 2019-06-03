package web.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dbutil.DBConn;
import web.dto.MemberDetail;

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
				member.setMember_birthday( rs.getString("member_birthday") );
				member.setMember_group(rs.getInt("member_group"));
				member.setMember_email(rs.getString("member_email"));
				member.setMember_phone(rs.getString("member_phone"));
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
			ps.setString(6,member.getMember_birthday());
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
				member.setMember_birthday( rs.getString("member_birthday") );
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
		sql += "DELETE FROM Member_Detail";
		sql += " WHERE 1=1";
		sql += " AND member_id = ?";
		
		
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
	
}
