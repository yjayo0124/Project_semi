package web.dto;

import java.util.Date;

public class FishInfoFile {

	private int fish_file_no ;
	private int fish_no ;
	private String fish_originname ;
	private String fish_storedname ;
	private Date fish_writtendate ;
	private long filesize ;
	
	
	
	@Override
	public String toString() {
		return "FishInfoFile [fish_file_no=" + fish_file_no + ", fish_no=" + fish_no + ", fish_originname="
				+ fish_originname + ", fish_storedname=" + fish_storedname + ", fish_writtendate=" + fish_writtendate
				+ ", filesize=" + filesize + "]";
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public int getFish_no() {
		return fish_no;
	}

	public void setFish_no(int fish_no) {
		this.fish_no = fish_no;
	}

	public int getFish_file_no() {
		return fish_file_no;
	}
	public void setFish_file_no(int fish_file_no) {
		this.fish_file_no = fish_file_no;
	}
	public String getFish_originname() {
		return fish_originname;
	}
	public void setFish_originname(String fish_originname) {
		this.fish_originname = fish_originname;
	}
	public String getFish_storedname() {
		return fish_storedname;
	}
	public void setFish_storedname(String fish_storedname) {
		this.fish_storedname = fish_storedname;
	}
	public Date getFish_writtendate() {
		return fish_writtendate;
	}
	public void setFish_writtendate(Date fish_writtendate) {
		this.fish_writtendate = fish_writtendate;
	}
	
}
