package web.dto.boast;

import java.util.Date;

public class BoastComment {

	private int rnum;
	private int boast_board_comment_no;
	private int boast_board_no;
	private String boast_content;
	private String member_id;
	private Date boast_comment_written_date;
	@Override
	public String toString() {
		return "BoastComment [rnum=" + rnum + ", boast_board_comment_no=" + boast_board_comment_no + ", boast_board_no="
				+ boast_board_no + ", boast_content=" + boast_content + ", member_id=" + member_id
				+ ", boast_comment_written_date=" + boast_comment_written_date + "]";
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
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
	public String getBoast_content() {
		return boast_content;
	}
	public void setBoast_content(String boast_content) {
		this.boast_content = boast_content;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Date getBoast_comment_written_date() {
		return boast_comment_written_date;
	}
	public void setBoast_comment_written_date(Date boast_comment_written_date) {
		this.boast_comment_written_date = boast_comment_written_date;
	}
	
	
}
