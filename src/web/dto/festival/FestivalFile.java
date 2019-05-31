package web.dto.festival;

import java.util.Date;

public class FestivalFile {
	
	private int festival_file_no;
	private int festival_board_no;
	private String festival_originname;
	private String festival_storedname;
	private Date festival_writtendate;
	
	public int getFestival_file_no() {
		return festival_file_no;
	}
	public void setFestival_file_no(int festival_file_no) {
		this.festival_file_no = festival_file_no;
	}
	public int getFestival_board_no() {
		return festival_board_no;
	}
	public void setFestival_board_no(int festival_board_no) {
		this.festival_board_no = festival_board_no;
	}
	public String getFestival_originname() {
		return festival_originname;
	}
	public void setFestival_originname(String festival_originname) {
		this.festival_originname = festival_originname;
	}
	public String getFestival_storedname() {
		return festival_storedname;
	}
	public void setFestival_storedname(String festival_storedname) {
		this.festival_storedname = festival_storedname;
	}
	public Date getFestival_writtendate() {
		return festival_writtendate;
	}
	public void setFestival_writtendate(Date festival_writtendate) {
		this.festival_writtendate = festival_writtendate;
	}
}
