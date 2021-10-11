package com.revature;

import com.revature.controllers.MenuController;
import com.revature.models.;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Welcome to the land of Revature, your adventure awaits.");
		
		MenuController menuController = new MenuController();

		Player player = menuController.getPlayer();
		
		
		TownController townController = new TownController();
		townController.enterTown(player);
		
		System.out.println("You adventure ends for now. Saving your progress.");
		
		menuController.savePlayer(player);
		System.out.println("Saving complete. See you again soon.");
	}

}
