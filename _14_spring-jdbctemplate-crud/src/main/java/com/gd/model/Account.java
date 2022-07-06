package com.gd.model;

public class Account {

	private int accountNo;
	private String accountName;
	private String accountType;
	private double balance;

	public Account() {
	}

	public Account(int accountNo, String accountName, String accountType, double balance) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.accountType = accountType;
		this.balance = balance;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "\t=====================" + "\n\tGot Account Details" + "\n\t====================="
				+ "\n\tAccount No: " + this.accountNo + "\n\tAccount No: " + this.accountName + "\n\tAccount No: "
				+ this.accountType + "\n\tAccount No: " + this.balance;
	}
}
