package com.javen.model;

public class Book {

	private int bid,sid,nowsid,statu;
	private String bname, author, sumary, img, isbn;
	
	

	

	




	public Book(int bid, int sid, int nowsid, int statu, String bname, String author, String sumary, String img,
			String isbn) {
		super();
		this.bid = bid;
		this.sid = sid;
		this.nowsid = nowsid;
		this.statu = statu;
		this.bname = bname;
		this.author = author;
		this.sumary = sumary;
		this.img = img;
		this.isbn = isbn;
	}










	public int getBid() {
		return bid;
	}










	public void setBid(int bid) {
		this.bid = bid;
	}










	public int getSid() {
		return sid;
	}










	public void setSid(int sid) {
		this.sid = sid;
	}










	public int getNowsid() {
		return nowsid;
	}










	public void setNowsid(int nowsid) {
		this.nowsid = nowsid;
	}










	public int getStatu() {
		return statu;
	}










	public void setStatu(int statu) {
		this.statu = statu;
	}










	public String getBname() {
		return bname;
	}










	public void setBname(String bname) {
		this.bname = bname;
	}










	public String getAuthor() {
		return author;
	}










	public void setAuthor(String author) {
		this.author = author;
	}










	public String getSumary() {
		return sumary;
	}










	public void setSumary(String sumary) {
		this.sumary = sumary;
	}










	public String getImg() {
		return img;
	}










	public void setImg(String img) {
		this.img = img;
	}










	public String getIsbn() {
		return isbn;
	}










	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}










	public Book() {
		// TODO Auto-generated constructor stub
	}

}
