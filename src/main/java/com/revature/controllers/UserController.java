package com.revature.controllers;

import java.util.List;

import com.revature.models.User;
import com.revature.services.userService;

public class UserController {
	private userService userService = new userService();
	public void displayUsers() {
		System.out.println("Users:");
		List<User> list = userService.findAllUsers();
		for(User user:list) {
			System.out.println(user);
		}
	}
	public User displayUserID(int id ) {
		System.out.println("User:");
		User tempUser = userService.findUserID(id);
			System.out.println(tempUser);
			return tempUser;
		}
}
