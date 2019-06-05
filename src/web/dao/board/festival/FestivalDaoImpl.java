package web.dao.board.festival;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.festival.FestivalBoard;
import web.util.festival.FestivalPaging;

public class FestivalDaoImpl implements FestivalDao{

	private Connection conn = DBConn.getConnection();

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List selectAll(FestivalPaging paging) {

		//�뙆�씪�뾽濡쒕뱶 湲곕줉 議고쉶荑쇰━
		String sql = "";
		sql+="SELECT * FROM (	SELECT rownum rnum, B.* FROM (";
		sql+="	SELECT C.festival_board_no, C.festival_title, C.festival_content, C.festival_start, C.festival_end, C.festival_writtendate, d.festival_storedname FROM Festival_Board C, festivalfile D";
		sql+="	WHERE C.festival_board_no = d.festival_board_no ORDER BY festival_board_no DESC) B ORDER BY rnum";
		sql+="	) Festival_Board";
		sql+=" WHERE rnum BETWEEN ? AND ?";

		List list = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());

			rs = ps.executeQuery();

			while( rs.next() ) {
				FestivalBoard board = new FestivalBoard();

				board.setFestival_board_no( rs.getInt("festival_board_no") );
				board.setFestival_title(rs.getString("festival_title"));
				board.setFestival_content(rs.getString("festival_content"));
				String start = rs.getString("festival_start");
				start = start.substring(0,10);
				board.setFestival_start(start);
				String end = rs.getString("festival_end");
				end = end.substring(0,10);
				board.setFestival_end(end);
				board.setFestival_writtendate(rs.getDate("festival_writtendate"));
				board.setFestival_storedname(rs.getString("festival_storedname"));

				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}




	@Override
	public List selectOngoing(FestivalPaging paging) {
		//�뙆�씪�뾽濡쒕뱶 湲곕줉 議고쉶荑쇰━
		String sql = "";
		sql+="SELECT * FROM (	SELECT rownum rnum, B.* FROM (";
		sql+="	SELECT C.festival_board_no, C.festival_title, C.festival_content, C.festival_start, C.festival_end, C.festival_writtendate, d.festival_storedname FROM Festival_Board C, festivalfile D";
		sql+="	WHERE C.festival_board_no = d.festival_board_no AND sysdate <= festival_end ORDER BY festival_board_no DESC) B ORDER BY rnum";
		sql+="	) Festival_Board";
		sql+=" WHERE rnum BETWEEN ? AND ?";

		List list = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());

			rs = ps.executeQuery();

			while( rs.next() ) {
				FestivalBoard board = new FestivalBoard();

				board.setFestival_board_no( rs.getInt("festival_board_no") );
				board.setFestival_title(rs.getString("festival_title"));
				board.setFestival_content(rs.getString("festival_content"));
				String start = rs.getString("festival_start");
				start = start.substring(0,10);
				board.setFestival_start(start);
				String end = rs.getString("festival_end");
				end = end.substring(0,10);
				board.setFestival_end(end);
				board.setFestival_writtendate(rs.getDate("festival_writtendate"));
				board.setFestival_storedname(rs.getString("festival_storedname"));

				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}




	@Override
	public List selectClosed(FestivalPaging paging) {
		//�뙆�씪�뾽濡쒕뱶 湲곕줉 議고쉶荑쇰━
		String sql = "";
		sql+="SELECT * FROM (	SELECT rownum rnum, B.* FROM (";
		sql+="	SELECT C.festival_board_no, C.festival_title, C.festival_content, C.festival_start, C.festival_end, C.festival_writtendate, d.festival_storedname FROM Festival_Board C, festivalfile D";
		sql+="	WHERE C.festival_board_no = d.festival_board_no AND sysdate > C.festival_end ORDER BY festival_board_no DESC) B ORDER BY rnum";
		sql+="	) Festival_Board";
		sql+=" WHERE rnum BETWEEN ? AND ?";

		List list = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());

			rs = ps.executeQuery();

			while( rs.next() ) {
				FestivalBoard board = new FestivalBoard();

				board.setFestival_board_no( rs.getInt("festival_board_no") );
				board.setFestival_title(rs.getString("festival_title"));
				board.setFestival_content(rs.getString("festival_content"));
				String start = rs.getString("festival_start");
				start = start.substring(0,10);
				board.setFestival_start(start);
				String end = rs.getString("festival_end");
				end = end.substring(0,10);
				board.setFestival_end(end);
				board.setFestival_writtendate(rs.getDate("festival_writtendate"));
				board.setFestival_storedname(rs.getString("festival_storedname"));

				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}




	@Override
	public int selectCntAll() {
		String sql ="";
		sql += "SELECT count(*)";
		sql += " FROM Festival_Board";
		int totalCount = 0;

		try {
			ps= conn.prepareStatement(sql);
			rs= ps.executeQuery();

			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return totalCount;
	}
	
	@Override
	public int selectCntOngoing() {
		String sql ="";
		sql += "SELECT count(*)";
		sql += " FROM Festival_Board";
		sql += " WHERE sysdate <= festival_end";
		int totalCount = 0;

		try {
			ps= conn.prepareStatement(sql);
			rs= ps.executeQuery();

			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totalCount;
	}




	@Override
	public int selectCntClosed() {
		String sql ="";
		sql += "SELECT count(*)";
		sql += " FROM Festival_Board";
		sql += " WHERE sysdate > festival_end";
		int totalCount = 0;

		try {
			ps= conn.prepareStatement(sql);
			rs= ps.executeQuery();

			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totalCount;
	}
	
	

	@Override
	public FestivalBoard selectBoardByBoardno(FestivalBoard board) {

		String sql ="";
		sql += "SELECT festival_board_no, festival_title, festival_content, festival_start, festival_end, festival_phone, festival_web, festival_host, festival_fee, festival_writtendate";
		sql += " FROM festival_board";
		sql += " WHERE festival_board_no = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, board.getFestival_board_no());
			rs = ps.executeQuery();

			while( rs.next() ) {

				board.setFestival_board_no( rs.getInt("festival_board_no") );
				board.setFestival_title(rs.getString("festival_title"));
				board.setFestival_content(rs.getString("festival_content"));
				String start = rs.getString("festival_start");
				start = start.substring(0,10);
				board.setFestival_start(start);
				String end = rs.getString("festival_end");
				end = end.substring(0,10);
				board.setFestival_end(end);
				board.setFestival_phone(rs.getString("festival_phone"));
				board.setFestival_web(rs.getString("festival_web"));
				board.setFestival_host(rs.getString("festival_host"));
				board.setFestival_fee(rs.getString("festival_fee"));
				board.setFestival_writtendate(rs.getDate("festival_writtendate"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return board;
	}


	@Override
	public void insert(FestivalBoard board) {

		String sql ="";
		sql += "INSERT INTO festival_board( festival_board_no, festival_title, festival_content, festival_start, festival_end, festival_phone, festival_web, festival_host, festival_fee, member_code)";
		sql += " VALUES (Festival_Board_seq.nextval, '"+board.getFestival_title()+"', '"+board.getFestival_content()+"', TO_DATE('"+board.getFestival_start()+"', 'YYYY-MM-DD'), TO_DATE('"+board.getFestival_end()+"', 'YYYY-MM-DD'), '"+board.getFestival_phone()+"', '"+board.getFestival_web()+"', '"+board.getFestival_host()+"', '"+board.getFestival_fee()+"', '"+board.getMember_code()+"' )";
		try {
			ps= conn.prepareStatement(sql);
			ps.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(FestivalBoard board) {
		String sql ="";
		sql += "UPDATE festival_board";
		sql += " SET festival_title = ?,";
		sql += "	festival_content = ?,";
		sql += "	festival_start = "+"TO_DATE('"+board.getFestival_start()+"', 'YYYY-MM-DD')"+",";
		sql += "	festival_end = "+"TO_DATE('"+board.getFestival_end()+"', 'YYYY-MM-DD')"+",";
		sql += "	festival_phone = ?,";
		sql += "	festival_web = ?,";
		sql += "	festival_host = ?,";
		sql += " 	festival_fee = ?";
		sql += " WHERE festival_board_no = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getFestival_title());
			ps.setString(2, board.getFestival_content());
			ps.setString(3, board.getFestival_phone());
			ps.setString(4, board.getFestival_web());
			ps.setString(5, board.getFestival_host());
			ps.setString(6, board.getFestival_fee());
			ps.setInt(7, board.getFestival_board_no());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(FestivalBoard board) {

		String sql ="";
		sql += "DELETE FROM festival_board";
		sql += " WHERE festival_board_no = "+board.getFestival_board_no();
		try {
			ps= conn.prepareStatement(sql);
			ps.executeUpdate(sql);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public FestivalBoard selectImgByBoardno(FestivalBoard board) {

		String sql = "";
		sql += "SELECT festival_storedname FROM festivalfile";
		sql += " WHERE festival_board_no = ?";


		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, board.getFestival_board_no());
			rs = ps.executeQuery();

			while( rs.next() ) {	
				board.setFestival_storedname( rs.getString("festival_storedname") );

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return board;
	}



}
