package com.yby.run;



public class Account {
	private String id;
	private String code;
	
	private int number = 0;
	private double balance;
	
	public Account(String id,String code)
	{
		this.id = id;
		this.code = code;
		
		
		
	}
	
	public String getId(){
		return id;
	}
	
	public String getCode() {
		return code;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String toString() {
		return id+"    "+code;
	}
	

	
	
}
