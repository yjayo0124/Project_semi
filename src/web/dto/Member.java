package web.dto;

public class Member {

	private int member_code;
	private String member_id;
	private String member_pw;
	private String member_nick;
	private int member_group;
	
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public int getMember_group() {
		return member_group;
	}
	public void setMember_group(int member_group) {
		this.member_group = member_group;
	}
	
	
}
