package com.revature.models;

public class User {
	private String firstName;
	private String lastName;
	private int userId;
	private int accId;
	private int accLevel;
	private String passwd;
	private double balance;
	
	public User(String firstName, String lastName, int userId, int accId, int accLevel, String passwd) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.accId = accId;
		this.accLevel = accLevel;
		this.passwd = passwd;
	}
	public User(String firstName, String lastName, int userId, int accId, int accLevel, String passwd, double balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.accId = accId;
		this.accLevel = accLevel;
		this.passwd = passwd;
		this.balance = balance;
	}
	public User() {
		super();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public int getAccLevel() {
		return accLevel;
	}
	public void setAccLevel(int accLevel) {
		this.accLevel = accLevel;
	}
	public String getPassword() {
		return passwd;
	}
	public void setPassword(String passwd) {
		this.passwd = passwd;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accId;
		result = prime * result + accLevel;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
		result = prime * result + userId;
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
		User other = (User) obj;
		if (accId != other.accId)
			return false;
		if (accLevel != other.accLevel)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userId=" + userId + ", accId=" + accId
				+ ", accLevel=" + accLevel + ", passwd=" + passwd + ", balance=" + balance + "]";
	}

	

}
