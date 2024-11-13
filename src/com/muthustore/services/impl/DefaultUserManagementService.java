package com.muthustore.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.muthustore.entities.User;
import com.muthustore.services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {
	private List<User> userList = new ArrayList<>();

	@Override
	public String registerUser(User user) {
		userList.add(user);
		return "User Registered Successfully";
	}

	@Override
	public User getUserByEmail(String userEmail) {
		Optional<User> optionalUser = userList.stream().filter(user -> user.getEmail() == userEmail).findFirst();
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}

	@Override
	public User[] getUsers() {
		return userList.toArray(new User[userList.size()]);
	}

}
