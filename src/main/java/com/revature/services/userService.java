package com.revature.services;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImp;
import com.revature.models.*;

public class userService {
	private UserDAO userDao = new UserDAOImp();
	public List<User> findAllUsers(){
		return userDao.findAll();
	}
	public User findUserID(int id) {
		return userDao.findUser(id);
	}
	public boolean newUser(User user) {
		return userDao.addUser(user);
	}
	public User getLevel(int id) {
		return userDao.getRole(id);
	}
	public boolean setLevel(int id) {
		return userDao.makeRole(id);
	}
	public boolean userActive(int id) {
		return userDao.userActive(id);
	}
	public User userPassword(int id) {
		return userDao.findUserPass(id);
	}
	public User userID(int id) {
		return userDao.getUserID(id);
	}
	public void asetActive(int ch, int id) {
		userDao.asetActive(ch, id);
	}
}
