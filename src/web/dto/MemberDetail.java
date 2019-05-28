package web.dto;


public class MemberDetail {
	private String member_id;
	private String member_pw;
	private int member_code;
	private String member_nick;
	private String member_name;
	private String member_gender;
	private String member_birthday;
	private String member_email;
	private String member_phone;
	private int member_group;
	
	@Override
	public String toString() {
		return "MemberDetail [member_id=" + member_id + ", member_pw=" + member_pw + ", member_code=" + member_code
				+ ", member_nick=" + member_nick + ", member_name=" + member_name + ", member_gender=" + member_gender
				+ ", member_birthday=" + member_birthday + ", member_email=" + member_email + ", member_phone="
				+ member_phone + ", member_group=" + member_group + "]";
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

	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

	public String getMember_nick() {
		return member_nick;
	}

	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public String getMember_birthday() {
		return member_birthday;
	}

	public void setMember_birthday(String member_birthday) {
		this.member_birthday = member_birthday;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public int getMember_group() {
		return member_group;
	}

	public void setMember_group(int member_group) {
		this.member_group = member_group;
	}
	
	
	
	
}
