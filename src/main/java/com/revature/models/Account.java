package com.revature.models;

public class Account {
	public double balance;
	public int accID;
	public double getBalance(int id) {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccID(int id) {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accID;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accID != other.accID)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", accID=" + accID + "]";
	}
	
	
}
