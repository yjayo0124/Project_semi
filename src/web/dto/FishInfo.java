package web.dto;

import java.sql.Date;

public class FishInfo {
	private int fish_no ;
	private String fish_type ;
	private String fish_sesson ;
	private String fish_length ;
	private String fish_care ;
	private String fish_content ;
	private Date fish_written_date ;
	private int fish_file_idx ;
	private String member_id ;
	public int getFish_no() {
		return fish_no;
	}
	public void setFish_no(int fish_no) {
		this.fish_no = fish_no;
	}
	public String getFish_type() {
		return fish_type;
	}
	public void setFish_type(String fish_type) {
		this.fish_type = fish_type;
	}
	public String getFish_sesson() {
		return fish_sesson;
	}
	public void setFish_sesson(String fish_sesson) {
		this.fish_sesson = fish_sesson;
	}
	public String getFish_length() {
		return fish_length;
	}
	public void setFish_length(String fish_length) {
		this.fish_length = fish_length;
	}
	public String getFish_care() {
		return fish_care;
	}
	public void setFish_care(String fish_care) {
		this.fish_care = fish_care;
	}
	public String getFish_content() {
		return fish_content;
	}
	public void setFish_content(String fish_content) {
		this.fish_content = fish_content;
	}
	public Date getFish_written_date() {
		return fish_written_date;
	}
	public void setFish_written_date(Date fish_written_date) {
		this.fish_written_date = fish_written_date;
	}
	public int getFish_file_idx() {
		return fish_file_idx;
	}
	public void setFish_file_idx(int fish_file_idx) {
		this.fish_file_idx = fish_file_idx;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	@Override
	public String toString() {
		return "FishInfo [fish_no=" + fish_no + ", fish_type=" + fish_type + ", fish_sesson=" + fish_sesson
				+ ", fish_length=" + fish_length + ", fish_care=" + fish_care + ", fish_content=" + fish_content
				+ ", fish_written_date=" + fish_written_date + ", fish_file_idx=" + fish_file_idx + ", member_id="
				+ member_id + "]";
	}
	
	
	
	
}
