package web.dto;

public class LoginLog {
	private int logno;
	private String logintime;
	private String loginip;
	private String member_id;
	
	
	@Override
	public String toString() {
		return "LoginLog [logno=" + logno + ", logintime=" + logintime + ", loginip=" + loginip + ", member_id="
				+ member_id + "]";
	}
	public int getLogno() {
		return logno;
	}
	public void setLogno(int logno) {
		this.logno = logno;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
	
	
	
}
