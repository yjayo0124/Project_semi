package web.dto.festival;

import java.util.Date;

public class FestivalBoard {
	private int festival_board_no;
    private String festival_title;
    private String festival_content;
    private String festival_start;
    private String festival_end;
    private String festival_phone;
    private String festival_web;
    private String festival_host;
    private String festival_fee;
    private int member_code;
    private String festival_storedname;
    
    
    private Date festival_writtendate;
    
	public int getFestival_board_no() {
		return festival_board_no;
	}
	public void setFestival_board_no(int festival_board_no) {
		this.festival_board_no = festival_board_no;
	}
	public String getFestival_title() {
		return festival_title;
	}
	public void setFestival_title(String festival_title) {
		this.festival_title = festival_title;
	}
	
	public String getFestival_phone() {
		return festival_phone;
	}
	public void setFestival_phone(String festival_phone) {
		this.festival_phone = festival_phone;
	}
	public String getFestival_web() {
		return festival_web;
	}
	public void setFestival_web(String festival_web) {
		this.festival_web = festival_web;
	}
	public String getFestival_host() {
		return festival_host;
	}
	public void setFestival_host(String festival_host) {
		this.festival_host = festival_host;
	}
	public String getFestival_fee() {
		return festival_fee;
	}
	public void setFestival_fee(String festival_fee) {
		this.festival_fee = festival_fee;
	}
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public Date getFestival_writtendate() {
		return festival_writtendate;
	}
	public void setFestival_writtendate(Date festival_writtendate) {
		this.festival_writtendate = festival_writtendate;
	}
	public String getFestival_start() {
		return festival_start;
	}
	public void setFestival_start(String festival_start) {
		this.festival_start = festival_start;
	}
	public String getFestival_end() {
		return festival_end;
	}
	public void setFestival_end(String festival_end) {
		this.festival_end = festival_end;
	}
	public String getFestival_content() {
		return festival_content;
	}
	public void setFestival_content(String festival_content) {
		this.festival_content = festival_content;
	}
	public String getFestival_storedname() {
		return festival_storedname;
	}
	public void setFestival_storedname(String festival_storedname) {
		this.festival_storedname = festival_storedname;
	}
	

}
