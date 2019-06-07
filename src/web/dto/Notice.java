package web.dto;

import java.util.Date;

public class Notice {

	private int notice_no;
	private String notice_title;
	private String notice_writer;
	private String notice_content;
	private int notice_hit;
	private Date notice_written_date;
	private String member_id;
	


	
	@Override
	public String toString() {
		return "Notice [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_writer=" + notice_writer
				+ ", notice_content=" + notice_content + ", notice_hit=" + notice_hit + ", notice_written_date="
				+ notice_written_date + ", member_id=" + member_id + "]";
	}

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_writer() {
		return notice_writer;
	}

	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public int getNotice_hit() {
		return notice_hit;
	}

	public void setNotice_hit(int notice_hit) {
		this.notice_hit = notice_hit;
	}

	public Date getNotice_written_date() {
		return notice_written_date;
	}

	public void setNotice_written_date(Date notice_written_date) {
		this.notice_written_date = notice_written_date;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	
	
	
	
	
	
}
