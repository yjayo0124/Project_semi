package web.dao.board.festival;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dbutil.DBConn;
import web.dto.festival.FestivalFile;

public class FestivalFileDaoImpl implements FestivalFileDao{

	//DB愿��젴 媛앹껜
		private Connection conn = DBConn.getConnection(); 

		private PreparedStatement ps = null;
		private ResultSet rs = null;
		
		@Override
		public void insert(FestivalFile board) {
			
			//�뙆�씪�뾽濡쒕뱶 湲곕줉 �궫�엯荑쇰━
			String boardno = "SELECT Festival_board_seq.currval FROM dual";
			String sql = "";
			sql+="INSERT INTO Festivalfile ( Festival_file_no, Festival_board_no, Festival_originname, Festival_storedname)";
			sql+=" VALUES ( Festivalfile_seq.nextval, ?, ?, ? )";
			
			try {
				ps = conn.prepareStatement(boardno);
				rs = ps.executeQuery();
				
				while( rs.next() ) {
					int num = (rs.getInt(1));
					board.setFestival_board_no(num);
				}
				
				ps = conn.prepareStatement(sql);
				//�궫�엯�븷 �궡�슜 吏��젙
				ps.setInt(1, board.getFestival_board_no());
				ps.setString(2, board.getFestival_originname());
				ps.setString(3, board.getFestival_storedname());

				// INSERT 荑쇰━ �닔�뻾
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public FestivalFile selectByBoardno(FestivalFile file) {
			
			//SQL荑쇰━
			String sql = "";
			sql += "SELECT";
			sql += "	festival_file_no";
			sql += "	, festival_board_no";
			sql += "	, festival_originname";
			sql += "	, festival_storedname";
			sql += "	, festival_writtendate";
			sql += " FROM festivalfile";
			sql += " WHERE festival_board_no = ?";
			
			try {
				ps = conn.prepareStatement(sql); //SQL �닔�뻾 媛앹껜
				
				ps.setInt(1, file.getFestival_board_no());
				
				rs = ps.executeQuery(); //SQL �닔�뻾 寃곌낵
				
				//寃곌낵 泥섎━
				while( rs.next() ) {
					file.setFestival_file_no(rs.getInt("festival_file_no"));
					file.setFestival_board_no(rs.getInt("festival_board_no"));
					file.setFestival_originname(rs.getString("festival_originname"));
					file.setFestival_storedname(rs.getString("festival_storedname"));
					file.setFestival_writtendate(rs.getDate("festival_writtendate"));
				}
				
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
			
			
			return file;
		}

		@Override
		public void delete(FestivalFile board) {
			String sql ="";
			sql += "DELETE FROM festivalfile";
			sql += " WHERE festival_file_no = "+board.getFestival_file_no();
			try {
				ps= conn.prepareStatement(sql);
				ps.executeUpdate(sql);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}
