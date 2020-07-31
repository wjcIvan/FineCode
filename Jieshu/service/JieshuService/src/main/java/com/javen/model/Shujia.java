package com.javen.model;

public class Shujia {
	int sid;
	String name, loc;

	public Shujia() {
		super();
	}

	public Shujia(int sid, String name, String loc) {
		super();
		this.sid = sid;
		this.name = name;
		this.loc = loc;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
