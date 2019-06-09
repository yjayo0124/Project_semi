package web.dto.boast;

public class Recommend {
	private String member_id;
	private int boast_board_no;
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getBoast_board_no() {
		return boast_board_no;
	}
	public void setBoast_board_no(int boast_board_no) {
		this.boast_board_no = boast_board_no;
	}
	@Override
	public String toString() {
		return "Recommend [member_id=" + member_id + ", boast_board_no=" + boast_board_no + "]";
	}
	

	
}
