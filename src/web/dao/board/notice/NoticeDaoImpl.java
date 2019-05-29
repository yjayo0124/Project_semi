package web.dao.board.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.Notice;
import web.util.Paging;

public class NoticeDaoImpl implements NoticeDao {

	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List selectAll(Paging paging) {
		
		String sql = " ";
		sql += "SELECT * FROM ("; 
		sql += "	SELECT rownum rnum, B.* FROM ("; 
		sql += "		SELECT"; 
		sql += "		notice_no,"; 
		sql += "		notice_title,";
		sql += "		notice_writer,";
		sql += "		notice_hit,";
		sql += "		notice_written_date"; 
		sql += "		FROM notice"; 
		sql += "		WHERE notice_title LIKE '%'||?||'%'"; 
		sql += "		ORDER BY notice_no DESC"; 
		sql += "	) B"; 
		sql += "	ORDER BY rnum"; 
		sql += " )"; 
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List list = new ArrayList();
		
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while( rs.next()) {
				
				Notice notice = new Notice();
				notice.setNotice_no(rs.getInt("notice_no"));
				notice.setNotice_title(rs.getString("notice_title"));
				notice.setNotice_writer(rs.getString("notice_writer"));
				notice.setNotice_hit(rs.getInt("notice_hit"));
				notice.setNotice_written_date(rs.getDate("notice_written_date"));
			
				list.add(notice); //db로부터 가져온 리스트들을 위에 ㅇ선언한 list에 담음
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rs !=null) rs.close();
				if(ps !=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
		
	}

	@Override
	public int selectCntAll(String search) {

		
		String sql = " ";
		sql += " SELECT count(*) FROM notice";
		sql += " WHERE notice_title LIKE '%'||?||'%'";
		
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

	@Override
	public void updateHit(Notice notice) {
		String sql ="";
	    sql += "UPDATE notice SET notice_hit = notice_hit+1";
	    sql += " WHERE notice_no = "+notice.getNotice_no();
	    try {
	    	
	         ps= conn.prepareStatement(sql);
	         ps.executeUpdate(sql);

	      } catch (SQLException e) {
	          e.printStackTrace();
		
	      }		
	}

	@Override
	public Notice selectNoticeByNoticeno(Notice notice) {
		
		String sql = " ";
		sql += " SELECT * FROM notice WHERE notice_no = ";
		sql += notice.getNotice_no();
		Notice res = new Notice(); //결과값 반환할 객체 선언
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				res.setNotice_no(rs.getInt("notice_no"));
				res.setNotice_title(rs.getString("notice_title"));
				res.setNotice_writer(rs.getString("notice_writer"));
				res.setNotice_content(rs.getString("notice_content"));
				res.setNotice_hit(rs.getInt("notice_hit"));
				res.setNotice_written_date(rs.getDate("notice_written_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if( rs!=null) rs.close();
				if( ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return res;
		
	}

	@Override
	public int selectNoticeno() {
		String sql = " ";
		sql += " SELECT notice_seq.nextval FROM dual";
		
		int notice_no = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				notice_no = rs.getInt(1);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return notice_no;
		
	}

	@Override
	public void insert(Notice notice) {
	
		String sql = " ";
		sql += " INSERT INTO notice( notice_no, notice_title, notice_writer, notice_content, notice_hit, member_id) ";
		sql += " VALUES ( ?, ?, ?, ?, 0, ? ) ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, notice.getNotice_no());
			ps.setString(2, notice.getNotice_title());
			ps.setString(3, notice.getNotice_writer());
			ps.setString(4, notice.getNotice_content());
			ps.setString(5, notice.getMember_id());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps !=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}

	@Override
	public void update(Notice notice) {
		
		String sql = " ";
		sql += " UPDATE notice ";
		sql += " SET title= ?, content= ? ";
		sql += " WHERE notice_no = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, notice.getNotice_title());
			ps.setString(2, notice.getNotice_content());
			ps.setInt(3, notice.getNotice_no());
			
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
	public void delete(Notice notice) {
		
		String sql = " ";
		sql += " DELETE notice";
		sql += " WHERE notice_no = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, notice.getNotice_no());
			
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

}
