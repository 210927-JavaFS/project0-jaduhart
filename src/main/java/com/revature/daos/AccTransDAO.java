package com.revature.daos;

import com.revature.models.Account;

public interface AccTransDAO {
	public boolean withdraw(int id, double amount);
	public boolean deposit(int id, double amount);
	public boolean transfer(int id, double amount, int id2); //make boolean when you can
	public Account getbal(int id);
	public Account getAccID(int id);
}
