package web.dto.club;

public class Club {
	private int club_no;
	private String club_originname;
    private String club_storedname;
	private String club_title;
	private String club_include;
	private int club_tag;
	private String member_id;
	
	
	public int getClub_no() {
		return club_no;
	}
	public void setClub_no(int club_no) {
		this.club_no = club_no;
	}
	public String getClub_originname() {
		return club_originname;
	}
	public void setClub_originname(String club_originname) {
		this.club_originname = club_originname;
	}
	public String getClub_storedname() {
		return club_storedname;
	}
	public void setClub_storedname(String club_storedname) {
		this.club_storedname = club_storedname;
	}
	public String getClub_title() {
		return club_title;
	}
	public void setClub_title(String club_title) {
		this.club_title = club_title;
	}
	public String getClub_include() {
		return club_include;
	}
	public void setClub_include(String club_include) {
		this.club_include = club_include;
	}
	public int getClub_tag() {
		return club_tag;
	}
	public void setClub_tag(int club_tag) {
		this.club_tag = club_tag;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
}
