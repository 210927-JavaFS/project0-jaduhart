package com.revature;

public class Admin extends Employee {

	Admin(int accNo, String username, String password, double balance) {
		super(accNo, username, password, balance);
		// TODO Auto-generated constructor stub
	}
	
	
	public void AccessAccount(int accNo) {
		//in here the employee should access info from table in dbeaver???
		//print (accNo Balance, AccNo username, AccNo)
		//no if statement cus it can see everyone
	}
	
	public void DeleteAccount(int accNO) {
		//would this just delete the account in the data base? IG lol
	}
	
	public void AddAccount(String username, String password) {
		//need to add some sort of future ID generator for this part
	}

}
