package com.revature;

public class Customer extends Base {
	private int accNo;
	private String username;
	private String password;
	private double balance;
	
	Customer(int accNo, String username, String password, double balance){
		this.accNo = accNo;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	

	public void checkBalance(String balance) {
		System.out.println("Your balance is: " +balance);

	}


	public void getAccountNumber(int accNo) {
		System.out.println("Your Account Number is: " +accNo);

	}
	
	public double deposit(int amount, double balance) {
		balance = (balance +amount); 
		return balance;
	}


	public double withdraw(int amount, double balance) {
		balance =- amount; 
		return balance;
	}


	public void transfer(double acc1B, double acc2B, int amount) {
		acc1B -= amount;
		acc2B += amount;
		//put a print line w/ both balances
	}

}

