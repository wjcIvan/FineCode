package com.javen.model;

public class Borrow {

	int brid, bid, uid, statu;
	String time;

	public Borrow() {
		// TODO Auto-generated constructor stub
	}

	public int getBrid() {
		return brid;
	}

	public void setBrid(int brid) {
		this.brid = brid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Borrow(int brid, int bid, int uid, int statu, String time) {
		super();
		this.brid = brid;
		this.bid = bid;
		this.uid = uid;
		this.statu = statu;
		this.time = time;
	}
	
}
