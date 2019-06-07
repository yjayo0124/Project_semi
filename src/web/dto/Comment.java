package web.dto;

import java.util.Date;

public class Comment {
	private int rnum;
	private int commentNo;
	private int boardNo;
	private String userid;
	private String content;
	private String writtenDate;
	@Override
	public String toString() {
		return "Comment [rnum=" + rnum + ", commentNo=" + commentNo + ", boardNo=" + boardNo + ", userid=" + userid
				+ ", content=" + content + ", writtenDate=" + writtenDate + "]";
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(String writtenDate) {
		this.writtenDate = writtenDate;
	}
	
	
	
	
}
