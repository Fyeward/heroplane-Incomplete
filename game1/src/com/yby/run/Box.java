package com.yby.run;

import java.util.ArrayList;

import java.util.List;



public class Box {
	List<Account> accounts;
	private static Box bankInstance = new Box();
	
	
	private Box() {
		accounts = new ArrayList<Account>();
	}
	
	public void addAccount(String id,String code) {
		accounts.add(new Account(id,code));
	}
	
	
	
	public int getNumOfAccounts() {
		return accounts.size();
	}
	
	public Account getAccount(int index) {
		return accounts.get(index);
	}
	
	public static Box getBank() {
		return bankInstance;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	
}
