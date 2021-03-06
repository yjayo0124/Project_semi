package web.dao.board.buy.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import web.dao.board.buy.face.BuyDao;
import web.dbutil.DBConn;

import web.dto.BuyBoard;
import web.dto.BuyFile;
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
				// System.out.println(paging.getSelect());
				
				if ("".equals(paging.getSelect()) || paging.getSelect() == null || paging.getSelect().equals("buy_board_title")) {
					sql += "SELECT * FROM (";
					sql += " 	SELECT rownum rnum, B.* FROM (";
					sql += " 		SELECT buy_board_no, buy_board_title, buy_board_writer, buy_board_hit, buy_board_written_date FROM Buy_Board";
					sql += " WHERE buy_board_title LIKE '%'||?||'%'";
					sql += " 		ORDER BY buy_board_no DESC";
					sql += " 	) B";
					sql += " 	ORDER BY rnum";
					sql += " ) ";
					sql += " WHERE rnum BETWEEN ? AND ?";
					
					
				} else if (paging.getSelect().equals("buy_board_content")) {
					sql += "SELECT * FROM (";
					sql += " 	SELECT rownum rnum, B.* FROM (";
					sql += " 		SELECT buy_board_no, buy_board_title, buy_board_writer, buy_board_hit, buy_board_written_date FROM Buy_Board";
					sql += " WHERE buy_board_content LIKE '%'||?||'%'";
					sql += " 		ORDER BY buy_board_no DESC";
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
	public int selectCntAll(String select, String search) {
		//전체 게시글 수 조회 쿼리
				String sql = "";
				
				
				
				// System.out.println(select);
				if ("".equals(select) || select == null || select.equals("buy_board_title")) {
					sql+="SELECT count(*)";
					sql+=" FROM Buy_Board";
					sql+=" WHERE buy_board_title LIKE '%'||?||'%'";
				
				} else if(select.equals("buy_board_content")) {
					
					sql+="SELECT count(*)";
					sql+=" FROM Buy_Board";
					sql+=" WHERE buy_board_content LIKE '%'||?||'%'";
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
	public void updateHit(BuyBoard viewBoard) {
		//파일업로드 기록 조회쿼리
				String sql = "";
				sql+="UPDATE Buy_Board";
				sql+=" SET buy_board_hit = buy_board_hit + 1";
				sql+=" WHERE buy_board_no = ?";
			
				try {
					ps = conn.prepareStatement(sql);
					
					ps.setInt(1, viewBoard.getBoardno());
					
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
	public BuyBoard selectBoardByBoardno(BuyBoard viewBoard) {
		//게시글 조회쿼리
				String sql = "";
				sql += "SELECT";
				sql += " 	buy_board_no,";
				sql += " 	buy_board_title,";
				sql += " 	buy_board_writer,";
				sql += " 	buy_board_content,";
				sql += " 	buy_board_hit,";
				sql += " 	buy_board_written_date,";
				sql += "    buy_board_direct,";
				sql += "    buy_board_delivery,";
				sql += "    buy_board_price,";
				sql += "    buy_board_phoneAgree";
				sql += " FROM Buy_Board";
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
						viewBoard.setDirect(rs.getString("buy_board_direct"));
						viewBoard.setDelivery(rs.getString("buy_board_delivery"));
						viewBoard.setPrice(rs.getInt("buy_board_price"));
						viewBoard.setPhoneAgree(rs.getString("buy_board_phoneAgree"));
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
				sql += "SELECT Buy_Board_seq.nextval";
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
	public void insert(BuyBoard board) {
		//다음 게시글 번호 조회 쿼리
				String sql = "";
				sql += "INSERT INTO Buy_Board(Buy_board_no,buy_board_title,buy_board_writer,buy_board_content,buy_board_hit, buy_board_direct, buy_board_delivery, buy_board_price, buy_board_phoneAgree) ";
				sql += " VALUES (?, ?, ?, ?, 0, ?, ?, ?, ?)";
				
				try {
					//DB작업
					ps = conn.prepareStatement(sql);
					ps.setInt(1, board.getBoardno());
					ps.setString(2, board.getTitle());
					ps.setString(3, board.getWriter());
					ps.setString(4, board.getContent());
					
					ps.setString(5, board.getDirect());
					ps.setString(6, board.getDelivery());
					ps.setInt(7, board.getPrice());
					ps.setString(8, board.getPhoneAgree());
					
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
	public void insertFile(BuyFile boardFile) {
		//다음 게시글 번호 조회 쿼리
				String sql = "";
				sql += "INSERT INTO BuyFile(fileno,buy_board_no,originname,storedname,filesize) ";
				sql += " VALUES (BuyFile_seq.nextval, ?, ?, ?, ?)";
				
				try {
					//DB작업
					ps = conn.prepareStatement(sql);
					ps.setInt(1, boardFile.getBoardno());
					ps.setString(2, boardFile.getOriginName());
					ps.setString(3, boardFile.getStoredName());
					ps.setLong(4, boardFile.getFilesize());

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
	public BuyFile selectFile(BuyBoard buyboard) {
		//다음 게시글 번호 조회 쿼리
				String sql = "";
				sql += "SELECT * FROM BuyFile";
				sql += " WHERE buy_board_no = ?";
				
				BuyFile boardFile = new BuyFile();
				
				try {
					//DB작업
					ps = conn.prepareStatement(sql);
					ps.setInt(1, buyboard.getBoardno());

					rs = ps.executeQuery();
					
					while(rs.next()) {
					
						boardFile.setFileno( rs.getInt("fileno") );
						boardFile.setBoardno( rs.getInt("buy_board_no") );
						boardFile.setOriginName( rs.getString("originname") );
						boardFile.setStoredName( rs.getString("storedname") );
						boardFile.setFilesize( rs.getLong("filesize") );
						boardFile.setWriteDate( rs.getDate("writedate") );
						
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
	public BuyFile selectByFileno(int fileno) {
		//다음 게시글 번호 조회 쿼리
				String sql = "";
				sql += "SELECT * FROM BuyFile";
				sql += " WHERE fileno = ?";
				
				//DB 객체
				PreparedStatement ps = null; 
				ResultSet rs = null;
				
				BuyFile buyFile = new BuyFile();
				
				try {
					//DB작업
					ps = conn.prepareStatement(sql);
					ps.setInt(1, fileno);

					rs = ps.executeQuery();
					
					while(rs.next()) {
					
						buyFile.setFileno( rs.getInt("fileno") );
						buyFile.setBoardno( rs.getInt("buy_board_no") );
						buyFile.setOriginName( rs.getString("originname") );
						buyFile.setStoredName( rs.getString("storedname") );
						buyFile.setFilesize( rs.getLong("filesize") );
						buyFile.setWriteDate( rs.getDate("writedate") );
						
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
				
				return buyFile;
		
		
	}

	@Override
	public void update(BuyBoard board) {
		String sql = "";
		sql += "UPDATE Buy_Board";
		sql += " SET buy_board_title = ?,";
		sql += " 	buy_board_content = ?,";
		sql += "    buy_board_price = ?,";
		sql += "    buy_board_direct = ?,";
		sql += "    buy_board_delivery = ?,";
		sql += "    buy_board_phoneAgree = ?";
		sql += " WHERE buy_board_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setInt(3, board.getPrice());
			ps.setString(4, board.getDirect());
			ps.setString(5, board.getDelivery());
			ps.setString(6, board.getPhoneAgree());
			ps.setInt(7, board.getBoardno());

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
	public void delete(BuyBoard board) {
		String sql = "";
		sql += "DELETE Buy_Board";
		sql += " WHERE buy_board_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());

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
	public void deleteFile(BuyBoard board) {
		String sql = "";
		sql += "DELETE BuyFile";
		sql += " WHERE buy_board_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());

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
	public void updateFile(BuyFile buyfile) {
		String sql = "";
		
		if( buyfile.getFileno() != 0 ) {
		sql += "UPDATE BuyFile";
		sql += " SET ";
		sql += " 	buy_board_no = ?,";
		sql += "    originname = ?,   "; 
		sql += "    storedname = ?, ";
		sql += "    filesize = ?";
		
		sql += " WHERE buy_board_no = ?";
		
		} else {
			sql += "INSERT INTO BuyFile(fileno,buy_board_no,originname,storedname,filesize) ";
			sql += " VALUES (BuyFile_seq.nextval, ?, ?, ?, ?)";
		}
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			
			if (buyfile.getFileno() != 0) {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, buyfile.getBoardno());
			ps.setString(2, buyfile.getOriginName());
			ps.setString(3, buyfile.getStoredName());
			ps.setLong(4, buyfile.getFilesize());
			ps.setInt(5, buyfile.getBoardno());
			ps.executeUpdate();
			
			} else {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, buyfile.getBoardno());
				ps.setString(2, buyfile.getOriginName());
				ps.setString(3, buyfile.getStoredName());
				ps.setLong(4, buyfile.getFilesize());

				ps.executeUpdate();
			}
			
			
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
	public HashMap getPrevNext(BuyBoard board) {
		String sql = "";
		sql += "SELECT * FROM (";
		sql += " SELECT";
		sql += " 	LEAD( buy_board_no, 1 ) OVER (ORDER BY buy_board_no DESC) prev,";
		sql += "	buy_board_no,";
		sql += " 	LAG( buy_board_no, 1 ) OVER (ORDER BY buy_board_no DESC) next";
		sql += " FROM Buy_Board";
		sql += " )";
		sql += " WHERE buy_board_no = ?";
		  
		HashMap<String, Integer> map = new HashMap();
		try {  
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno() ) ;
			rs = ps.executeQuery();

			while(rs.next()) {
				map.put("prev", rs.getInt("prev"));
				map.put("next", rs.getInt("next"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return map ;
	}

	@Override
	public HashMap getPrevNextName(BuyBoard board) {
		String sql = "";
		sql += "SELECT * FROM (";
		sql += " SELECT";
		sql += " 	LEAD( buy_board_title, 1 ) OVER (ORDER BY buy_board_no DESC) prev,";
		sql += "	buy_board_no , buy_board_title,";
		sql += " 	LAG( buy_board_title, 1 ) OVER (ORDER BY buy_board_no DESC) next";
		sql += " FROM buy_board";
		sql += " )";
		sql += " WHERE buy_board_no = ?";
		  
		HashMap<String, String> map = new HashMap();
		try {  
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno() ) ;
			rs = ps.executeQuery();

			while(rs.next()) {
				map.put("prev", rs.getString("prev"));
				map.put("next", rs.getString("next"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return map ;
	}

	
	
	
}
