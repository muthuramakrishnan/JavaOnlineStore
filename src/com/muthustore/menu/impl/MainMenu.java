package com.muthustore.menu.impl;

import com.muthustore.configs.ApplicationContext;
import com.muthustore.menu.Menu;

public class MainMenu implements Menu {

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = """
			Please enter number in console to proceed.
			1. Sign Up
			2. Sign Out
			3. Product Catalog
			4. My orders
			5. Settings
			6. Customer List
			""";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = """
			Please enter number in console to proceed.
			1. Sign Up
			2. Sign In
			3. Product Catalog
			4. My orders
			5. Settings
			6. Customer List
			""";
	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		while (true) {
			if (context.getMainMenu() == null) {
				context.setMainMenu(this);
			}

			Menu menuToNavigate = null;

			mainLoop: while (true) {
				printMenuHeader();
			}
		}
	}

	@Override
	public void printMenuHeader() {
		// TODO Auto-generated method stub
		System.out.println("**** MAIN MENU ***");
		if (context.getLoggedInUser() == null) {
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
		} else {
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
		}

	}

}
