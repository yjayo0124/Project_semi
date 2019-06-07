package web.dao.board.fish_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dbutil.DBConn;
import web.dto.FishInfoFile;

public class FishFileDaoImpl implements FishFileDao {

	private Connection conn = DBConn.getConnection(); 

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public void insert(FishInfoFile fishInfoFile) {
		
		String fishno = "SELECT Fish_Info_seq.currval FROM dual";
		String sql = "";
		sql+="INSERT INTO fish_file ( fish_file_no, fish_no, fish_originname, fish_storedname)";
		sql+=" VALUES ( fishfile_seq.nextval, ?, ?, ? )";
		
		try {
			ps = conn.prepareStatement(fishno);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				int num = (rs.getInt(1));
				fishInfoFile.setFish_no(num);
			}
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, fishInfoFile.getFish_no());
			ps.setString(2, fishInfoFile.getFish_originname());
			ps.setString(3, fishInfoFile.getFish_storedname());

			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public FishInfoFile selectByBoardno(FishInfoFile fishInfoFile) {

		String sql = "";
		sql += "SELECT";
		sql += "	fish_file_no";
		sql += "	, fish_no";
		sql += "	, fish_originname";
		sql += "	, fish_storedname";
		sql += "	, fish_writtendate";
		sql += " FROM fish_file";
		sql += " WHERE fish_no = ?";
		
		try {
			ps = conn.prepareStatement(sql); 
			
			ps.setInt(1, fishInfoFile.getFish_no());
			
			rs = ps.executeQuery(); 
			
			
			while( rs.next() ) {
				fishInfoFile.setFish_file_no(rs.getInt("fish_file_no"));
				fishInfoFile.setFish_no(rs.getInt("fish_no"));
				fishInfoFile.setFish_originname(rs.getString("fish_originname"));
				fishInfoFile.setFish_storedname(rs.getString("fish_storedname"));
				fishInfoFile.setFish_writtendate(rs.getDate("fish_writtendate"));
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
		
		
		return fishInfoFile;
	}
	
	@Override
	public void updateFile(FishInfoFile fishInfoFile) {

		String sql ="";
		sql += "UPDATE fish_file";
		sql += " SET fish_originname = ?,";
		sql += "	 fish_storedname = ?";
		sql += " WHERE fish_no = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fishInfoFile.getFish_originname());
			ps.setString(2, fishInfoFile.getFish_storedname());
			ps.setInt(3, fishInfoFile.getFish_no());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Override
	public void delete(FishInfoFile fishInfoFile) {

		String sql ="";
		sql += "DELETE FROM fish_file";
		sql += " WHERE fish_file_no = ? " ;
		
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setInt( 1 , fishInfoFile.getFish_file_no()) ;
			
			ps.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
