package web.dto;

import java.util.Date;

public class FreeBoard {
	private int free_board_no;
	private String free_board_title;
	private String free_board_content;
	private String free_board_writer;
	private int free_board_hit;
	private Date free_board_written_date;
	private int free_board_comment_no;
	private int free_board_file_idx;
	private String member_id;

	@Override
	public String toString() {
		return "FreeBoard [free_board_no=" + free_board_no + ", free_board_title=" + free_board_title
				+ ", free_board_content=" + free_board_content + ", free_board_writer=" + free_board_writer
				+ ", free_board_hit=" + free_board_hit + ", free_board_written_date=" + free_board_written_date
				+ ", free_board_comment_no=" + free_board_comment_no + ", free_board_file_idx=" + free_board_file_idx
				+ ", member_id=" + member_id + "]";
	}

	public int getFree_board_no() {
		return free_board_no;
	}

	public void setFree_board_no(int free_board_no) {
		this.free_board_no = free_board_no;
	}

	public String getFree_board_title() {
		return free_board_title;
	}

	public void setFree_board_title(String free_board_title) {
		this.free_board_title = free_board_title;
	}

	public String getFree_board_content() {
		return free_board_content;
	}

	public void setFree_board_content(String free_board_content) {
		this.free_board_content = free_board_content;
	}

	public String getFree_board_writer() {
		return free_board_writer;
	}

	public void setFree_board_writer(String free_board_writer) {
		this.free_board_writer = free_board_writer;
	}

	public int getFree_board_hit() {
		return free_board_hit;
	}

	public void setFree_board_hit(int free_board_hit) {
		this.free_board_hit = free_board_hit;
	}

	public Date getFree_board_written_date() {
		return free_board_written_date;
	}

	public void setFree_board_written_date(Date free_board_written_date) {
		this.free_board_written_date = free_board_written_date;
	}

	public int getFree_board_comment_no() {
		return free_board_comment_no;
	}

	public void setFree_board_comment_no(int free_board_comment_no) {
		this.free_board_comment_no = free_board_comment_no;
	}

	public int getFree_board_file_idx() {
		return free_board_file_idx;
	}

	public void setFree_board_file_idx(int free_board_file_idx) {
		this.free_board_file_idx = free_board_file_idx;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
	
	
	

}
