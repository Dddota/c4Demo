package com.bdqn.model;

public class User {
	private int uId;//�û���id
	private String uName;//�û���
	private String uPwd;//����
	public User() {
		super();
	}
	public User(String uName, String uPwd) {
		super();
		this.uName = uName;
		this.uPwd = uPwd;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	
	

}
