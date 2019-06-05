package web.dto.club;

import java.util.Date;

public class ClubBoard {
	
	private int club_board_no;
	private int club_no;
	private String club_board_title;
	private String club_board_content;
	private String club_board_writer;
	private String member_id;
	private Date club_board_writedate;
	
	public int getClub_board_no() {
		return club_board_no;
	}
	public void setClub_board_no(int club_board_no) {
		this.club_board_no = club_board_no;
	}
	public int getClub_no() {
		return club_no;
	}
	public void setClub_no(int club_no) {
		this.club_no = club_no;
	}
	public String getClub_board_title() {
		return club_board_title;
	}
	public void setClub_board_title(String club_board_title) {
		this.club_board_title = club_board_title;
	}
	public String getClub_board_content() {
		return club_board_content;
	}
	public void setClub_board_content(String club_board_content) {
		this.club_board_content = club_board_content;
	}
	public String getClub_board_writer() {
		return club_board_writer;
	}
	public void setClub_board_writer(String club_board_writer) {
		this.club_board_writer = club_board_writer;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Date getClub_board_writedate() {
		return club_board_writedate;
	}
	public void setClub_board_writedate(Date club_board_writedate) {
		this.club_board_writedate = club_board_writedate;
	}
}
