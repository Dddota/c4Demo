package com.bdqn.model;

public class Topic {
	private int tId;//������
	private String tName;//��������
	
	
	
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Topic(String tName) {
		super();
		this.tName = tName;
	}
	
	

	@Override
	public String toString() {
		return "Topic [tId=" + tId + ", tName=" + tName + "]";
	}

	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	
	
	
}
