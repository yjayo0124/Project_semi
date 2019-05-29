package web.dto;

import java.util.Date;

public class FreeFile {
	
	private int free_board_file_idx;
	private int free_board_file_no;
	private String free_board_file_origin_name;
	private String free_board_file_stored_name;
	private Date free_board_file_upload_date;
	private int free_board_no;
	
	
	@Override
	public String toString() {
		return "FreeFile [free_board_file_idx=" + free_board_file_idx + ", free_board_file_no=" + free_board_file_no
				+ ", free_board_file_orgin_name=" + free_board_file_origin_name + ", free_board_file_stored_name="
				+ free_board_file_stored_name + ", free_board_file_upload_date=" + free_board_file_upload_date
				+ ", free_board_no=" + free_board_no + "]";
	}

	public int getFree_board_file_idx() {
		return free_board_file_idx;
	}

	public void setFree_board_file_idx(int free_board_file_idx) {
		this.free_board_file_idx = free_board_file_idx;
	}

	public int getFree_board_file_no() {
		return free_board_file_no;
	}

	public void setFree_board_file_no(int free_board_file_no) {
		this.free_board_file_no = free_board_file_no;
	}

	public String getFree_board_file_origin_name() {
		return free_board_file_origin_name;
	}

	public void setFree_board_file_origin_name(String free_board_file_orgin_name) {
		this.free_board_file_origin_name = free_board_file_orgin_name;
	}

	public String getFree_board_file_stored_name() {
		return free_board_file_stored_name;
	}

	public void setFree_board_file_stored_name(String free_board_file_stored_name) {
		this.free_board_file_stored_name = free_board_file_stored_name;
	}

	public Date getFree_board_file_upload_date() {
		return free_board_file_upload_date;
	}

	public void setFree_board_file_upload_date(Date free_board_file_upload_date) {
		this.free_board_file_upload_date = free_board_file_upload_date;
	}

	public int getFree_board_no() {
		return free_board_no;
	}

	public void setFree_board_no(int free_board_no) {
		this.free_board_no = free_board_no;
	}

	
	
	
}
