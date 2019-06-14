package web.dao.memberlog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.LoginLog;
import web.util.Paging;

public class MemberLogDaoImpl implements MemberLogDao{

	//DB관련 객체
	private Connection conn = DBConn.getConnection(); 

	private PreparedStatement ps = null;
	private ResultSet rs = null;


	
	
	@Override
	public List selectAll(Paging paging, LoginLog log) {
		
		
		String sql = "";
		sql += "SELECT * FROM( "; 
		sql += " SELECT rownum rnum, B.*FROM (";
		sql += " SELECT logno, logintime, loginip, member_id FROM loginlog";
		sql += " ORDER BY logno DESC";
		sql += " ) B";
		sql += " ORDER BY rnum";
		sql += " ) logno";
		sql += " WHERE rnum BETWEEN ? AND ?";		
		sql += "  AND member_id= ?";		
		
		
		List list = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			ps.setString(3, log.getMember_id());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				LoginLog loginLog = new LoginLog();
				
			loginLog.setLogno( rs.getInt("logno") );
			loginLog.setLogintime( rs.getString("logintime") );
			loginLog.setLoginip( rs.getString("loginip") );
			loginLog.setMember_id( rs.getString("member_id") );

				
				list.add(loginLog);
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
				
		return list;
		
	}

	
	
	@Override
	public int selectCntAll(String search, LoginLog log) {
	      // 수행할 SQL 쿼리
	      String sql = "";
	      sql+= "SELECT count(*)";
	      sql+= " FROM loginlog";
	      sql+= " WHERE member_id = ?";
	      
	      int totalCount =0;
	      
	      try {
	         ps = conn.prepareStatement(sql); // 수행객체 얻기
	         ps.setString(1, log.getMember_id());

	         rs = ps.executeQuery(); // SQL 수행결과 얻기

	         
	         
	         while(rs.next()) {
	            totalCount = rs.getInt(1);
	            
	            
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	         
	      } finally {
	         
	         try {
	            if(rs!=null);
	            rs.close();
	            if(ps!=null);
	            ps.close();            
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }
	      
	      
	      return totalCount;

	}



	@Override
	public void insertLog(LoginLog log) {
		String sql = "";
		sql += "INSERT INTO loginlog ( logno, loginip, member_id)";
		sql += " VALUES( loginlog_seq.nextval, ?, ? )";
		
		try {
			//DB�옉�뾽
			ps = conn.prepareStatement(sql);
			ps.setString(1, log.getLoginip());
			ps.setString(2, log.getMember_id());
	
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


}
