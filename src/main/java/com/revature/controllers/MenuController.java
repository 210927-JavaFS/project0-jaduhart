package com.revature.controllers;
import java.io.IOException;
import java.util.Scanner;

import com.revature.daos.AccTransDAO;
import com.revature.daos.AccTransDAOImp;
import com.revature.daos.UserDAOImp;
import com.revature.models.User;
import com.revature.models.Account;
import com.revature.services.accTranService;
import com.revature.services.userService;


public class MenuController {
		
		private static  Scanner sc = new Scanner(System.in);
		
		private accTranService accServ = new accTranService();
		private userService userServ = new userService();
		
		
		public void Menu() 
		{
			
			//menu system for user
			do {
				System.out.println("Welcome! Select an option below.");
				System.out.println("1) Login  2) New Account");
				int input = sc.nextInt();

				switch(input) 
				{
				case 1:
					login();
					
				case 2:
					//AccountRepository.NewAccount();
					break;
					default:
						System.out.println("Invalid Input ");

						break;
				}
				
				
			}while(true);
			
		}
		
		public void login() {
			System.out.println("Login Selected.");
			boolean loggedIn = false;
			while(!loggedIn) {
				System.out.println("Enter your UserID ");
				
				int userID = sc.nextInt();
				sc.nextLine();
				User curID = userServ.userID(userID);
				System.out.println(curID);
				if(curID.getPassword() != null) 
				{
					System.out.println("Enter your Account Password ");
					
					String password = sc.nextLine();
					//String userPass = userService.getU(userID); //is it through the service layer or DAO
					if(!curID.getPassword().equals(password)) {
						System.out.println("Invalid Password");
						break;
					}
					else {
						mainmenu(curID);
					}
					
				}else 
				{
					System.out.println("Account Not Fount ");
				}
				break;
				
				
				
				
				///acc UserDAOS.AuthenticateAccount(pin);
				
				
			}
		}
		
		private void mainmenu(User user) 
		{
			//here is where I could put switch for acc_level
			//System.out.println("Welcome to CodeLyoko Bank, " + User.first_name);
			System.out.println();
			
			do 
			{
				Account curAcc = accServ.getAccID(user.getAccId());
				System.out.println("Choose from menu Below");
				System.out.println();

				System.out.println("1) Deposit  2) Withdraw");
				System.out.println();
				System.out.println("3) Balance  4) Transfer");
				System.out.println("5) View Acct Info  6) Logout");
				int choice = sc.nextInt();
				AccTransDAO accTransDao = new AccTransDAOImp();


				
				switch(choice) 
				{
				
				case 1:
					break;
				case 2:
					//AccountRepository.accwithDraw(acc);

					break;
				case 3:
					//AccountRepository.accBalance(acc);
					break;
				case 4:
					//loginmenu();
					break;
				case 5:
					break;
				case 6:
					//Menu();
					break;
				default:
						System.out.println("Enter choice from the menu");
					break;
				}
				

				
			}while(true);
		}
		
	
}
