package com.revature.services;


import com.revature.daos.AccTransDAO;
import com.revature.daos.AccTransDAOImp;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImp;
import com.revature.models.*;


public class accTranService {
	private AccTransDAO accTransDao = new AccTransDAOImp();
	public Account getAccID(int id) {
		return accTransDao.getAccID(id);
	}
	public Account getBal(int id) {
		return accTransDao.getbal(id);
	}
	public boolean withdraw(int id, double amount ) {
		return accTransDao.withdraw(id, amount);
	}
	public boolean deposit(int id, double amount ) {
		return accTransDao.deposit(id, amount);
	}
	public boolean transfer(int id, double amount, int id2 ) {
		return accTransDao.transfer(id, amount, id2);
	}

}
