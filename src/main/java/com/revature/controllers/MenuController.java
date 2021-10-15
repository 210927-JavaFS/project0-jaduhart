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
		private static UserController userController = new UserController();
		
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
				int priv =curID.getAccLevel();
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
						mainmenu(curID, priv);
					}
					
				}else 
				{
					System.out.println("Account Not Fount ");
				}
				break;
				
				
				
				
				///acc UserDAOS.AuthenticateAccount(pin);
				
				
			}
		}
		
		private void mainmenu(User user, int priv) 
		{
			switch(priv)
			{
			case 1:
			//here is where I could put switch for acc_level
			System.out.println("Welcome to CodeLyoko Bank, Customer!");
			System.out.println();
			
			do 
			{
				Account curAcc = accServ.getAccID(user.getAccId());
				System.out.println("Choose from menu Below");
				System.out.println();

				System.out.println("1) Deposit  2) Withdraw");
				System.out.println();
				System.out.println("3) Balance  4) Transfer");
				System.out.println("5) View Acct Info  6)Logout");
				int choice = sc.nextInt();
				sc.nextLine();
				AccTransDAO accTransDao = new AccTransDAOImp();


				
				switch(choice) 
				{
				
				case 1:
					System.out.println("How much would you like to deposit?");
					double amtd = sc.nextDouble();
					accServ.deposit(curAcc.accID, amtd);
					System.out.println("Deposit Successful!");
					break;
					
				case 2:
					System.out.println("How much would you like to withdraw?");
					double amtw = sc.nextDouble();
					accServ.withdraw(curAcc.accID, amtw);
					System.out.println("Withdraw Successful!");

					break;
				case 3:
					System.out.println("Balance Check! Current balance =" + curAcc.getBalance(user.getUserId()));
					
					break;
				case 4:
					System.out.println("How much would you like to transfer?");
					double amtt = sc.nextDouble();
					sc.nextLine();
					System.out.println("To who's account? *Must enter a UserID");
					int id2 = sc.nextInt();
					sc.nextLine();
					
					accServ.transfer(curAcc.accID, amtt, id2);
					System.out.println("Transfer Successful!");
					
					break;
				case 5:
					userController.displayUserID(user.getUserId());
					break;
				case 6:
					Menu();
				default:
						System.out.println("Enter choice from the menu");
					break;
				}
				

				
			}while(true);
			case 2:
				//here is where I could put switch for acc_level
				System.out.println("Welcome to CodeLyoko Bank, Employee! " );
				System.out.println();
				
				do 
				{
					Account curAcc = accServ.getAccID(user.getAccId());
					System.out.println("Choose from menu Below");
					System.out.println();

					System.out.println("1) Deposit  2) Withdraw");
					System.out.println();
					System.out.println("3) Balance  4) Transfer");
					System.out.println("5) View Acct Info  6) View All Accs");
					System.out.println("7) Logout");
					int choice = sc.nextInt();
					sc.nextLine();
					AccTransDAO accTransDao = new AccTransDAOImp();


					
					switch(choice) 
					{
					
					case 1:
						System.out.println("How much would you like to deposit?");
						double amtd = sc.nextDouble();
						accServ.deposit(curAcc.accID, amtd);
						System.out.println("Deposit Successful!");
						break;
						
					case 2:
						System.out.println("How much would you like to withdraw?");
						double amtw = sc.nextDouble();
						accServ.withdraw(curAcc.accID, amtw);
						System.out.println("Withdraw Successful!" );

						break;
					case 3:
						System.out.println("Balance Check! Current balance =" + curAcc.getBalance(user.getUserId()));
						
						break;
					case 4:
						System.out.println("How much would you like to transfer?");
						double amtt = sc.nextDouble();
						sc.nextLine();
						System.out.println("To who's account? *Must enter a UserID");
						int id2 = sc.nextInt();
						sc.nextLine();
						
						accServ.transfer(curAcc.accID, amtt, id2);
						System.out.println("Transfer Successful!");
						
						break;
					case 5:
						userController.displayUserID(user.getUserId());
						break;
					case 6:
						userController.displayUsers();
						break;
					case 7:
						Menu();
						break;
						
					default:
							System.out.println("Enter choice from the menu");
						break;
					}
					

					
				}while(true);
			case 3:
				//here is where I could put switch for acc_level
				System.out.println("Welcome to CodeLyoko Bank, Admin!" );
				System.out.println();
				
				do 
				{
					Account curAcc = accServ.getAccID(user.getAccId());
					System.out.println("Choose from menu Below");
					System.out.println();

					System.out.println("1) Deposit  2) Withdraw");
					System.out.println();
					System.out.println("3) Balance  4) Transfer");
					System.out.println("5) View Acct Info  6)Activate/Deactivate Accs");
					System.out.println("7) View All Accts   8)Logout");
					int choice = sc.nextInt();
					sc.nextLine();
					AccTransDAO accTransDao = new AccTransDAOImp();


					
					switch(choice) 
					{
					
					case 1:
						System.out.println("How much would you like to deposit?");
						double amtd = sc.nextDouble();
						accServ.deposit(curAcc.accID, amtd);
						System.out.println("Deposit Successful!" );
						break;
						
					case 2:
						System.out.println("How much would you like to withdraw?");
						double amtw = sc.nextDouble();
						accServ.withdraw(curAcc.accID, amtw);
						System.out.println("Withdraw Successful!");

						break;
					case 3:
						System.out.println("Balance Check! Current balance =" + curAcc.getBalance(user.getUserId()));
						
						break;
					case 4:
						System.out.println("How much would you like to transfer?");
						double amtt = sc.nextDouble();
						sc.nextLine();
						System.out.println("To who's account? *Must enter a UserID");
						int id2 = sc.nextInt();
						sc.nextLine();
						
						accServ.transfer(curAcc.accID, amtt, id2);
						System.out.println("Transfer Successful!");
						
						break;
					case 5:
						userController.displayUserID(user.getUserId());
						break;
					case 6:
						System.out.println("Ooo feeling spicy... who do you wan't to deactivate/ activate? *enter UserID");
						int dac = sc.nextInt();
						//User refUser = userServ.findUserID(dac);
						sc.nextLine();
						System.out.println("1)Activate  2)Deactivate");
						int decision = sc.nextInt();
						sc.nextLine();
						switch(decision){
						case 1: 
							userServ.asetActive(1,dac);
						case 2:
							userServ.asetActive(0,dac);
						default:
							break;
						
						}
					case 7 :
						userController.displayUsers();
						break;
					case 8:
						Menu();
						break;
						
					default:
							System.out.println("Enter choice from the menu");
						break;
					}
					

					
				}while(true);
			default:
				break;
			}
				
		}
}
