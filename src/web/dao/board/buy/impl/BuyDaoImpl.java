package web.dao.board.buy.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dao.board.buy.face.BuyDao;
import web.dbutil.DBConn;
import web.dto.BuyBoard;
import web.util.Paging;

public class BuyDaoImpl implements BuyDao{
	
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
				sql += " 		SELECT buy_board_no, buy_board_title, buy_board_writer, buy_board_hit, buy_board_written_date FROM Buy_Board";
				sql += " 		ORDER BY buy_board_no DESC";
				sql += " 	) B";
				sql += " 	ORDER BY rnum";
				sql += " ) Buy_BOARD";
				sql += " WHERE rnum BETWEEN ? AND ?";
			
				List list = new ArrayList();
				try {
					ps = conn.prepareStatement(sql);
					
					ps.setInt(1, paging.getStartNo());
					ps.setInt(2, paging.getEndNo());
					
					rs = ps.executeQuery();
					
					while( rs.next() ) {
						BuyBoard board = new BuyBoard();
						
						board.setBoardno( rs.getInt("buy_board_no") );
						board.setTitle( rs.getString("buy_board_title") );
						board.setWriter( rs.getString("buy_board_writer") );
						board.setHit( rs.getInt("buy_board_hit") );
						board.setWrittendate( rs.getDate("buy_board_written_date") );
						
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
				sql+=" FROM Buy_Board";
			
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
	public BuyBoard selectBoardByBoardno(BuyBoard viewBoard) {
		//게시글 조회쿼리
				String sql = "";
				sql += "SELECT";
				sql += " 	buy_board_no,";
				sql += " 	buy_board_title,";
				sql += " 	buy_board_writer,";
				sql += " 	buy_board_content,";
				sql += " 	buy_board_hit,";
				sql += " 	buy_board_written_date";
				sql += " FROM buy_board B";
				sql += " WHERE buy_board_no = ?";
			
				try {
					ps = conn.prepareStatement(sql);
					
					ps.setInt(1, viewBoard.getBoardno());
					
					rs = ps.executeQuery();
					
					while( rs.next() ) {
						
						viewBoard.setBoardno( rs.getInt("buy_board_no") );
						viewBoard.setTitle( rs.getString("buy_board_title") );
						viewBoard.setWriter( rs.getString("buy_board_writer") );
						viewBoard.setContent( rs.getString("buy_board_content") );
						viewBoard.setHit( rs.getInt("buy_board_hit") );
						viewBoard.setWrittendate( rs.getDate("buy_board_written_date") );
						
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
