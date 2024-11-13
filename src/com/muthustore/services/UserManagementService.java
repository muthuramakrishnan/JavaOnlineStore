package com.muthustore.services;

import com.muthustore.entities.User;

public interface UserManagementService {
	String registerUser(User user);

	User[] getUsers();

	User getUserByEmail(String userEmail);
}
