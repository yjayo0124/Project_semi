package web.dto.boast;

import java.util.Date;

public class BoastBoard {
	
	private int boast_board_no;
	private String boast_board_title;
	private String boast_board_writer;
	private String boast_board_content;
	private int boast_board_hit;
	private Date boast_board_written_date;
	private int boast_board_comment_no;
	private String member_id;
	
	@Override
	public String toString() {
		return "BoastBoard [boast_board_no=" + boast_board_no + ", boast_board_title=" + boast_board_title
				+ ", boast_board_writer=" + boast_board_writer + ", boast_board_content=" + boast_board_content
				+ ", boast_board_hit=" + boast_board_hit + ", boast_board_written_date=" + boast_board_written_date
				+ ", boast_board_comment_no=" + boast_board_comment_no + ", member_id=" + member_id + "]";
	}
	public int getBoast_board_no() {
		return boast_board_no;
	}
	public void setBoast_board_no(int boast_board_no) {
		this.boast_board_no = boast_board_no;
	}
	public String getBoast_board_title() {
		return boast_board_title;
	}
	public void setBoast_board_title(String boast_board_title) {
		this.boast_board_title = boast_board_title;
	}
	public String getBoast_board_writer() {
		return boast_board_writer;
	}
	public void setBoast_board_writer(String boast_board_writer) {
		this.boast_board_writer = boast_board_writer;
	}
	public String getBoast_board_content() {
		return boast_board_content;
	}
	public void setBoast_board_content(String boast_board_content) {
		this.boast_board_content = boast_board_content;
	}
	public int getBoast_board_hit() {
		return boast_board_hit;
	}
	public void setBoast_board_hit(int boast_board_hit) {
		this.boast_board_hit = boast_board_hit;
	}
	public Date getBoast_board_written_date() {
		return boast_board_written_date;
	}
	public void setBoast_board_written_date(Date boast_board_written_date) {
		this.boast_board_written_date = boast_board_written_date;
	}
	public int getBoast_board_comment_no() {
		return boast_board_comment_no;
	}
	public void setBoast_board_comment_no(int boast_board_comment_no) {
		this.boast_board_comment_no = boast_board_comment_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
}
