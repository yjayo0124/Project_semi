package web.dto.boast;

import java.util.Date;

public class BoastComment {

	private int boast_board_comment_no;
	private int boast_board_no;
	private String boast_board_content;
	private String member_id;
	private Date boast_board_comment_written_date;
	
	
	public int getBoast_board_comment_no() {
		return boast_board_comment_no;
	}
	public void setBoast_board_comment_no(int boast_board_comment_no) {
		this.boast_board_comment_no = boast_board_comment_no;
	}
	public int getBoast_board_no() {
		return boast_board_no;
	}
	public void setBoast_board_no(int boast_board_no) {
		this.boast_board_no = boast_board_no;
	}
	public String getBoast_board_content() {
		return boast_board_content;
	}
	public void setBoast_board_content(String boast_board_content) {
		this.boast_board_content = boast_board_content;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Date getBoast_board_comment_written_date() {
		return boast_board_comment_written_date;
	}
	public void setBoast_board_comment_written_date(Date boast_board_comment_written_date) {
		this.boast_board_comment_written_date = boast_board_comment_written_date;
	}
	
	
}
