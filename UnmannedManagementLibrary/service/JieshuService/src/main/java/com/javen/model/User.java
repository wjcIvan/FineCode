package com.javen.model;

public class User {
	private int uid;

	private String user;

	private String pswd;

	private String sex;
	private String name;
	private String icon;
	private int credit;
	
	

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public User(int uid, String user, String pswd, String sex, String name, String icon) {
		super();
		this.uid = uid;
		this.user = user;
		this.pswd = pswd;
		this.sex = sex;
		this.name = name;
		this.icon = icon;
	}
	
	

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", user=" + user + ", pswd=" + pswd + ", sex=" + sex + ", name=" + name + ", icon="
				+ icon + "]";
	}
	
	
	
	

}