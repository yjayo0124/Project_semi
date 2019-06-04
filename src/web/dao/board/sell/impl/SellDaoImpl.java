package web.dao.board.sell.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dao.board.sell.face.SellDao;
import web.dbutil.DBConn;
import web.dto.SellBoard;
import web.dto.SellFile;
import web.util.Paging;

public class SellDaoImpl implements SellDao{
	
	//DB관련 객체
			private Connection conn = DBConn.getConnection(); 

			private PreparedStatement ps = null;
			private ResultSet rs = null;
	
			
			@Override
			public List selectAll(Paging paging) {
				//게시글 목록 조회쿼리
						
				
						String sql = "";
						// System.out.println(paging.getSelect());
						
						if ("".equals(paging.getSelect()) || paging.getSelect() == null || paging.getSelect().equals("sell_board_title")) {
							sql += "SELECT * FROM (";
							sql += " 	SELECT rownum rnum, B.* FROM (";
							sql += " 		SELECT sell_board_no, sell_board_title, sell_board_writer, sell_board_hit, sell_board_written_date FROM Sell_Board";
							sql += " WHERE sell_board_title LIKE '%'||?||'%'";
							sql += " 		ORDER BY sell_board_no DESC";
							sql += " 	) B";
							sql += " 	ORDER BY rnum";
							sql += " ) ";
							sql += " WHERE rnum BETWEEN ? AND ?";
							
							
						} else if (paging.getSelect().equals("sell_board_content")) {
							sql += "SELECT * FROM (";
							sql += " 	SELECT rownum rnum, B.* FROM (";
							sql += " 		SELECT sell_board_no, sell_board_title, sell_board_writer, sell_board_hit, sell_board_written_date FROM Sell_Board";
							sql += " WHERE sell_board_content LIKE '%'||?||'%'";
							sql += " 		ORDER BY sell_board_no DESC";
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
								SellBoard board = new SellBoard();
								
								board.setBoardno( rs.getInt("sell_board_no") );
								board.setTitle( rs.getString("sell_board_title") );
								board.setWriter( rs.getString("sell_board_writer") );
								board.setHit( rs.getInt("sell_board_hit") );
								board.setWrittendate( rs.getDate("sell_board_written_date") );
								
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
						if ("".equals(select) || select == null || select.equals("sell_board_title")) {
							sql+="SELECT count(*)";
							sql+=" FROM Sell_Board";
							sql+=" WHERE sell_board_title LIKE '%'||?||'%'";
						
						} else if(select.equals("sell_board_content")) {
							
							sql+="SELECT count(*)";
							sql+=" FROM Sell_Board";
							sql+=" WHERE sell_board_content LIKE '%'||?||'%'";
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
			public void updateHit(SellBoard viewBoard) {
				//파일업로드 기록 조회쿼리
						String sql = "";
						sql+="UPDATE sell_board";
						sql+=" SET sell_board_hit = sell_board_hit + 1";
						sql+=" WHERE sell_board_no = ?";
					
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
			public SellBoard selectBoardByBoardno(SellBoard viewBoard) {
				//게시글 조회쿼리
						String sql = "";
						sql += "SELECT";
						sql += " 	sell_board_no,";
						sql += " 	sell_board_title,";
						sql += " 	sell_board_writer,";
						sql += " 	sell_board_content,";
						sql += " 	sell_board_hit,";
						sql += " 	sell_board_written_date,";
						sql += "    sell_board_direct,";
						sql += "    sell_board_delivery,";
						sql += "    sell_board_price,";
						sql += "    sell_board_phoneAgree";
						sql += " FROM Sell_Board";
						sql += " WHERE sell_board_no = ?";
					
						try {
							ps = conn.prepareStatement(sql);
							
							ps.setInt(1, viewBoard.getBoardno());
							
							rs = ps.executeQuery();
							
							while( rs.next() ) {
								
								viewBoard.setBoardno( rs.getInt("sell_board_no") );
								viewBoard.setTitle( rs.getString("sell_board_title") );
								viewBoard.setWriter( rs.getString("sell_board_writer") );
								viewBoard.setContent( rs.getString("sell_board_content") );
								viewBoard.setHit( rs.getInt("sell_board_hit") );
								viewBoard.setWrittendate( rs.getDate("sell_board_written_date") );
								viewBoard.setDirect(rs.getString("sell_board_direct"));
								viewBoard.setDelivery(rs.getString("sell_board_delivery"));
								viewBoard.setPrice(rs.getInt("sell_board_price"));
								viewBoard.setPhoneAgree(rs.getString("sell_board_phoneAgree"));
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
						sql += "SELECT Sell_Board_seq.nextval";
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
			public void insert(SellBoard board) {
				//다음 게시글 번호 조회 쿼리
						String sql = "";
						sql += "INSERT INTO sell_board(sell_board_no,sell_board_title,sell_board_writer,sell_board_content,sell_board_hit, sell_board_direct, sell_board_delivery, sell_board_price, sell_board_phoneAgree) ";
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
			public void insertFile(SellFile boardFile) {
				//다음 게시글 번호 조회 쿼리
						String sql = "";
						sql += "INSERT INTO SellFile(fileno,sell_board_no,originname,storedname,filesize) ";
						sql += " VALUES (SellFile_seq.nextval, ?, ?, ?, ?)";
						
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
			public SellFile selectFile(SellBoard SellBoard) {
				//다음 게시글 번호 조회 쿼리
						String sql = "";
						sql += "SELECT * FROM SellFile";
						sql += " WHERE sell_board_no = ?";
						
						SellFile boardFile = new SellFile();
						
						try {
							//DB작업
							ps = conn.prepareStatement(sql);
							ps.setInt(1, SellBoard.getBoardno());

							rs = ps.executeQuery();
							
							while(rs.next()) {
							
								boardFile.setFileno( rs.getInt("fileno") );
								boardFile.setBoardno( rs.getInt("sell_board_no") );
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
			public SellFile selectByFileno(int fileno) {
				//다음 게시글 번호 조회 쿼리
						String sql = "";
						sql += "SELECT * FROM SellFile";
						sql += " WHERE fileno = ?";
						
						//DB 객체
						PreparedStatement ps = null; 
						ResultSet rs = null;
						
						SellFile SellFile = new SellFile();
						
						try {
							//DB작업
							ps = conn.prepareStatement(sql);
							ps.setInt(1, fileno);

							rs = ps.executeQuery();
							
							while(rs.next()) {
							
								SellFile.setFileno( rs.getInt("fileno") );
								SellFile.setBoardno( rs.getInt("sell_board_no") );
								SellFile.setOriginName( rs.getString("originname") );
								SellFile.setStoredName( rs.getString("storedname") );
								SellFile.setFilesize( rs.getLong("filesize") );
								SellFile.setWriteDate( rs.getDate("writedate") );
								
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
						
						return SellFile;
				
				
			}

			@Override
			public void update(SellBoard board) {
				String sql = "";
				sql += "UPDATE sell_board";
				sql += " SET sell_board_title = ?,";
				sql += " 	sell_board_content = ?";
				sql += " WHERE sell_board_no = ?";
				
				//DB 객체
				PreparedStatement ps = null; 
				
				try {
					//DB작업
					ps = conn.prepareStatement(sql);
					ps.setString(1, board.getTitle());
					ps.setString(2, board.getContent());
					ps.setInt(3, board.getBoardno());

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
			public void delete(SellBoard board) {
				String sql = "";
				sql += "DELETE sell_board";
				sql += " WHERE sell_board_no = ?";
				
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
			public void deleteFile(SellBoard board) {
				String sql = "";
				sql += "DELETE SellFile";
				sql += " WHERE sell_board_no = ?";
				
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
			
			
			
}
