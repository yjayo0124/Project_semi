package web.dto.club;

public class ClubMember {
	private int club_member_no;
	private int club_no;
	private String member_id;
	
	public int getClub_member_no() {
		return club_member_no;
	}
	public void setClub_member_no(int club_member_no) {
		this.club_member_no = club_member_no;
	}
	public int getClub_no() {
		return club_no;
	}
	public void setClub_no(int club_no) {
		this.club_no = club_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
}
