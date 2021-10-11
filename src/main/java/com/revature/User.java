package com.revature;

public interface User {
	public void checkBalance();
	public void createAccount();
	public void login();
	public void getAccountNumber();
	public void deposit(double amount);
	public void withdraw(double amount);
	public void transferBalance(double amount);

}
