package web.dao.board.free;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.FreeBoard;
import web.util.Paging;

public class FreeDaoImpl implements FreeDao {
	
	//DB관련 객체
	private Connection conn = DBConn.getConnection(); 

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List selectAll(Paging paging) {
		
		//게시글 목록 조회쿼리
		String sql = "";
		sql += "SELECT * FROM (";
		sql += " 	SELECT rownum rnum, B.* FROM (";
		sql += " 	 SELECT free_board_no, free_board_title, free_board_content, free_board_writer, ";
		sql += "    free_board_hit, free_board_written_date, free_board_comment_no, free_board_file_idx, member_id ";
		sql += " 	FROM Free_Board	ORDER BY free_board_no DESC";
		sql += " 	) B";
		sql += " 	ORDER BY rnum";
		sql += " ) Free_Board";
		sql += " WHERE rnum BETWEEN ? AND ?";

	
		List list = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				FreeBoard board = new FreeBoard();
				
				board.setFree_board_no( rs.getInt("free_board_no") );
				board.setFree_board_title( rs.getString("free_board_title") );
				board.setFree_board_content( rs.getString("free_board_content") );
				board.setFree_board_writer( rs.getString("free_board_writer") );
				board.setFree_board_hit( rs.getInt("free_board_hit") );
				board.setFree_board_written_date( rs.getDate("free_board_written_date") );
				board.setFree_board_comment_no( rs.getInt("free_board_comment_no") );
				board.setFree_board_file_idx( rs.getInt("free_board_file_idx") );
				board.setMember_id( rs.getInt("member_id") );
				
				list.add(board);
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
	public int selectCntAll() {
		//전체 게시글 수 조회 쿼리
		String sql = "";
		sql+="SELECT count(*)";
		sql+=" FROM board";
	
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
	public void updateHit(FreeBoard viewBoard) {
		//파일업로드 기록 조회쿼리
		String sql = "";
		sql+="UPDATE Free_Board";
		sql+=" SET hit = hit + 1";
		sql+=" WHERE free_board_no = ?";
	
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, viewBoard.getFree_board_no());
			
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
	public FreeBoard selectBoardByBoardno(FreeBoard viewBoard) {
		//게시글 조회쿼리
		String sql = "";
		sql += "SELECT free_board_no, free_board_title, free_board_content, free_board_writer, free_board_ hit, free_board_ writtendate, free_board_comment_no, free_board_file_idx, member_id FROM Free_Board";
		sql += " WHERE free_board_no = ?";
	
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, viewBoard.getBoardno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				viewBoard.setBoardno( rs.getInt("boardno") );
				viewBoard.setTitle( rs.getString("title") );
				viewBoard.setWriter( rs.getString("writer") );
				viewBoard.setContent( rs.getString("content") );
				viewBoard.setHit( rs.getInt("hit") );
				viewBoard.setWrittendate( rs.getDate("writtendate") );
				
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

}
