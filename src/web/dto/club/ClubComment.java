package web.dto.club;

import java.util.Date;

public class ClubComment {
	
	private int club_comment_no;
	private int club_board_no;
	private String club_comment_content;
	private String member_id;
	private String club_comment_writer;
	private Date club_comment_writedate;
	
	public int getClub_comment_no() {
		return club_comment_no;
	}
	public void setClub_comment_no(int club_comment_no) {
		this.club_comment_no = club_comment_no;
	}
	public int getClub_board_no() {
		return club_board_no;
	}
	public void setClub_board_no(int club_board_no) {
		this.club_board_no = club_board_no;
	}
	public String getClub_comment_content() {
		return club_comment_content;
	}
	public void setClub_comment_content(String club_comment_content) {
		this.club_comment_content = club_comment_content;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getClub_comment_writer() {
		return club_comment_writer;
	}
	public void setClub_comment_writer(String club_comment_writer) {
		this.club_comment_writer = club_comment_writer;
	}
	public Date getClub_comment_writedate() {
		return club_comment_writedate;
	}
	public void setClub_comment_writedate(Date club_comment_writedate) {
		this.club_comment_writedate = club_comment_writedate;
	}
	

}
