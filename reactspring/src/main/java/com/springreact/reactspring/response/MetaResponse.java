package com.springreact.reactspring.response;

public class MetaResponse {

	private String id;
	private String name; 
	private String balance;
	public MetaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MetaResponse(String id, String name, String balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	
	
}