package com.revature;

public class Employee extends Customer {

	Employee(int accNo, String username, String password, double balance) {
		super(accNo, username, password, balance);
		// TODO Auto-generated constructor stub
	}
	
	public void AccessAccount(int accNo) {
		//in here the employee should access info from table in dbeaver???
		//print (accNo Balance, AccNo username, AccNo)
		//if statement to guarantee that the id is a customer one
	}

}
