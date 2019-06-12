package web.dao.board.boast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.boast.BoastBoard;
import web.dto.boast.BoastFile;
import web.util.boast.BoastPaging;

public class BoastDaoImpl implements BoastDao{

	//DB관련 객체
	private Connection conn = DBConn.getConnection(); 

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List selectAll(BoastPaging paging) {
		
		String sql = "";
		
		if ("".equals(paging.getSelect()) || paging.getSelect() == null || paging.getSelect().equals("boast_board_title")) {

		
		sql += "SELECT * FROM (";
		sql += " 	SELECT rownum rnum, B.* FROM (";
		sql += " 	 SELECT boast_board_no, boast_board_title, boast_board_content, boast_board_writer, ";
		sql += "     boast_board_hit, boast_board_written_date, boast_board_comment_no, boast_board_file_idx, member_id ";
		sql += " 	 FROM Boast_Board	";
		sql	+= "     WHERE boast_board_title LIKE '%'||?||'%' ";
		sql	+= "     ORDER BY boast_board_no DESC";
		sql += " 	) B";
		sql += " 	ORDER BY rnum";
		sql += " ) ";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		} else if (paging.getSelect().equals("boast_board_content")) {
			
			sql += "SELECT * FROM (";
			sql += " 	SELECT rownum rnum, B.* FROM (";
			sql += " 	 SELECT boast_board_no, boast_board_title, boast_board_content, boast_board_writer, ";
			sql += "     boast_board_hit, boast_board_written_date, boast_board_comment_no, boast_board_file_idx, member_id ";
			sql += " 	 FROM Boast_Board	";
			sql	+= "     WHERE boast_board_content LIKE '%'||?||'%' ";
			sql	+= "     ORDER BY boast_board_no DESC";
			sql += " 	) B";
			sql += " 	ORDER BY rnum";
			sql += " ) ";
			sql += " WHERE rnum BETWEEN ? AND ?";

		}
		List list = new ArrayList();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs =  ps.executeQuery();
			
			while(rs.next()) {
				BoastBoard board = new BoastBoard();
				
				board.setBoast_board_no(rs.getInt("boast_board_no"));
				board.setBoast_board_title( rs.getString("boast_board_title") );
				board.setBoast_board_content( rs.getString("boast_board_content") );
				board.setBoast_board_writer( rs.getString("boast_board_writer") );
				board.setBoast_board_hit( rs.getInt("boast_board_hit") );
				board.setBoast_board_written_date( rs.getDate("boast_board_written_date") );
				board.setBoast_board_comment_no( rs.getInt("boast_board_comment_no") );
				board.setBoast_board_file_idx( rs.getInt("boast_board_file_idx"));
				board.setMember_id( rs.getString("member_id") );
				
				list.add(board);
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
	public int selectCntAll(String select, String search) {
		String sql = "";
		if("".equals(select) || select == null || select.equals("boast_board_title")) {

		sql += "SELECT count(*) FROM Boast_Board";
		sql += " WHERE boast_board_title LIKE '%'||?||'%'";
		
		}else if(select.equals("boast_board_content")) {
			
			sql += "SELECT count(*) FROM Boast_Board";
			sql += " WHERE boast_board_content LIKE '%'||?||'%'";
			
		}
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
	public void updateHit(BoastBoard viewBoard) {
		String sql = "";
		sql+="UPDATE Boast_Board";
		sql+=" SET boast_board_hit = boast_board_hit + 1";
		sql+=" WHERE boast_board_no = ?";
	
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, viewBoard.getBoast_board_no());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public BoastBoard selectBoardByBoardno(BoastBoard viewBoard) {
		String sql = "";
		sql += "SELECT boast_board_no, boast_board_title, boast_board_content, boast_board_writer,";
		sql += " boast_board_hit, boast_board_written_date, boast_board_comment_no, boast_board_file_idx, member_id";
		sql += " FROM Boast_Board B";
		sql += " WHERE boast_board_no = ?";
	
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, viewBoard.getBoast_board_no());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				viewBoard.setBoast_board_no( rs.getInt("boast_board_no") );
				viewBoard.setBoast_board_title( rs.getString("boast_board_title") );
				viewBoard.setBoast_board_content( rs.getString("boast_board_content") );
				viewBoard.setBoast_board_writer( rs.getString("boast_board_writer") );
				viewBoard.setBoast_board_hit( rs.getInt("boast_board_hit") );
				viewBoard.setBoast_board_written_date( rs.getDate("boast_board_written_date") );
				viewBoard.setBoast_board_comment_no( rs.getInt("boast_board_comment_no") );
				viewBoard.setBoast_board_file_idx( rs.getInt("boast_board_file_idx") );
				viewBoard.setMember_id( rs.getString("member_id") );
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
				
		return viewBoard;
	}

	@Override
	public int selectBoardno() {
			//다음 게시글 번호 조회 쿼리
			String sql = "";
			sql += "SELECT Boast_Board_seq.nextval";
			sql += " FROM dual";
			
			//게시글번호
			int boardno = 0;
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				//결과 담기
				while(rs.next()) {
					boardno = rs.getInt(1);
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
			return boardno;
	}

	@Override
	public void insert(BoastBoard board) {
		String sql = "";
		sql += "INSERT INTO Boast_board ( boast_board_no, boast_board_title, boast_board_content, boast_board_writer, ";
		sql	+= " boast_board_hit, boast_board_written_date, boast_board_comment_no, boast_board_file_idx, member_id) ";
		sql += " VALUES (?, ?, ?, ?, 0, sysdate, ?, ?, ?)";
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoast_board_no());
			ps.setString(2, board.getBoast_board_title());
			ps.setString(3, board.getBoast_board_content());
			ps.setString(4, board.getBoast_board_writer());
			ps.setInt(5, board.getBoast_board_comment_no());
			ps.setInt(6, board.getBoast_board_file_idx());
			ps.setString(7, board.getMember_id());


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
	public void insertFile(BoastFile boardFile) {
		String sql = "";
		sql += "INSERT INTO Boast_File ( boast_board_file_idx, boast_board_file_no, boast_board_origin_name, ";
		sql	+= " boast_board_stored_name, boast_board_upload_date, boast_board_no)";  
		sql += " VALUES (Boast_File_seq.nextval, ?, ?, ?, sysdate, ?)";
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);//파일인덱스  다시 생성
			ps.setInt(1, boardFile.getBoast_board_file_no());
			ps.setString(2, boardFile.getBoast_board_origin_name());
			ps.setString(3, boardFile.getBoast_board_stored_name());
			ps.setInt(4, boardFile.getBoast_board_no());

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
	public BoastFile selectFile(BoastBoard board) {
		String sql = "";
		sql += "SELECT * FROM Boast_File";
		sql += " WHERE boast_board_no = ?";
		
		BoastFile boardFile = new BoastFile();
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoast_board_no());

			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				boardFile.setBoast_board_file_idx( rs.getInt("boast_board_file_idx") );
				boardFile.setBoast_board_file_no( rs.getInt("boast_board_file_no") );
				boardFile.setBoast_board_origin_name( rs.getString("boast_board_origin_name") );
				boardFile.setBoast_board_stored_name( rs.getString("boast_board_stored_name") );
				boardFile.setBoast_board_upload_date( rs.getDate("boast_board_upload_date") );
				boardFile.setBoast_board_no( rs.getInt("boast_board_no") );
				
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
		
		return boardFile;
	}

	@Override
	public BoastFile selectByFileno(int fileno) {
		String sql = "";
		sql += "SELECT * FROM Boast_File";
		sql += " WHERE boast_board_file_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		BoastFile boardFile = new BoastFile();
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fileno);

			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				boardFile.setBoast_board_file_no( rs.getInt("boast_board_file_no") );
				boardFile.setBoast_board_no( rs.getInt("boast_board_no") );
				boardFile.setBoast_board_origin_name( rs.getString("boast_board_origin_name") );
				boardFile.setBoast_board_stored_name( rs.getString("boast_board_stored_name") );
				boardFile.setBoast_board_upload_date( rs.getDate("boast_board_upload_date") );
				
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
		
		return boardFile;
	}

	@Override
	public void update(BoastBoard board) {
		String sql = "";
		sql += "UPDATE Boast_Board";
		sql += " SET boast_board_title = ?,";
		sql += " 	boast_board_content = ?";
		sql += " WHERE boast_board_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getBoast_board_title());
			ps.setString(2, board.getBoast_board_content());
			ps.setInt(3, board.getBoast_board_no());

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
	public void delete(BoastBoard board) {
		String sql = "";
		sql += "DELETE Boast_Board";
		sql += " WHERE boast_board_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoast_board_no());

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
	public void deleteFile(BoastBoard board) {
		String sql = "";
		sql += "DELETE Boast_File";
		sql += " WHERE boast_board_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoast_board_no());

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
	public BoastBoard selectrecommend(BoastBoard board) {
		String sql = "";
		sql += "SELECT" ;
		sql += " boast_board_no, " ;
		sql += " boast_board_title, " ;
		sql += " (SELECT COUNT(*) FROM recommend WHERE boardno = board.boardno) AS recommend, " ;
		sql += " FROM board" ;
		sql += " WHERE boast_board_no = ? ";
		return null;
	}
	
		}


