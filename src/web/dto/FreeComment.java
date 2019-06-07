package web.dto;

import java.util.Date;

public class FreeComment {
 
	private int free_board_comment_no;
	private String free_board_content;
	private String free_board_comment_date;
	private String member_id;
	private int free_board_no;
	
	@Override
	public String toString() {
		return "FreeComment [free_board_comment_no=" + free_board_comment_no + ", free_board_content="
				+ free_board_content + ", comment_date=" + free_board_comment_date + ", member_id=" + member_id
				+ ", free_board_no=" + free_board_no + "]";
	}

	
	public int getFree_board_comment_no() {
		return free_board_comment_no;
	}
	public void setFree_board_comment_no(int free_board_comment_no) {
		this.free_board_comment_no = free_board_comment_no;
	}
	public String getFree_board_content() {
		return free_board_content;
	}
	public void setFree_board_content(String free_board_content) {
		this.free_board_content = free_board_content;
	}
	public String getFree_board_comment_date() {
		return free_board_comment_date;
	}
	public void setFree_board_comment_date(String comment_date) {
		this.free_board_comment_date = comment_date;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getFree_board_no() {
		return free_board_no;
	}
	public void setFree_board_no(int free_board_no) {
		this.free_board_no = free_board_no;
	}

	
	
	
}
