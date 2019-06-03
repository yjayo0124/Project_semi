package web.dto;

import java.util.Date;

public class BuyBoard {
	private int boardno;
	private String title;
	private String writer;
	private String content;
	private int hit;
	private Date writtendate;
	
	private String direct;
	private String delivery;
	private int price;
	private String phoneAgree;
	@Override
	public String toString() {
		return "BuyBoard [boardno=" + boardno + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", hit=" + hit + ", writtendate=" + writtendate + ", direct=" + direct + ", delivery=" + delivery
				+ ", price=" + price + ", phoneAgree=" + phoneAgree + "]";
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getWrittendate() {
		return writtendate;
	}
	public void setWrittendate(Date writtendate) {
		this.writtendate = writtendate;
	}
	public String getDirect() {
		return direct;
	}
	public void setDirect(String direct) {
		this.direct = direct;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPhoneAgree() {
		return phoneAgree;
	}
	public void setPhoneAgree(String phoneAgree) {
		this.phoneAgree = phoneAgree;
	}
	
	
	
	
	
	
	
}
