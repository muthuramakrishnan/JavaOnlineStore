package com.muthustore.configs;

import com.muthustore.entities.Cart;
import com.muthustore.entities.User;
import com.muthustore.entities.impl.DefaultCart;
import com.muthustore.menu.Menu;

public class ApplicationContext {
	private static ApplicationContext instance;
	private User loggedInUser;
	private Menu mainMenu;
	private Cart sessionCart;

	private ApplicationContext() {
	}

	public Cart getSessionCart() {
		if (sessionCart == null) {
			this.sessionCart = new DefaultCart();
		}
		return sessionCart;
	}

	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		if (sessionCart != null) {
			sessionCart.clear();
		}
		this.loggedInUser = loggedInUser;
	}

	public Menu getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(Menu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public static ApplicationContext getInstance() {
		if (instance == null) {
			instance = new ApplicationContext();
		}
		return instance;
	}
}
