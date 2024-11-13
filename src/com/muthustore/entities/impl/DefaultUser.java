package com.muthustore.entities.impl;

import java.util.HashMap;
import java.util.Map;

import com.muthustore.Validator;
import com.muthustore.entities.User;
import com.muthustore.entities.UserFields;

public class DefaultUser implements User {
	private static int totalUserCounter = 0;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	private Map<String, String> errorMap = new HashMap<>();

	public DefaultUser(String firstName, String lastName, String email, String password) {

		doArgumentValidation(firstName, lastName, email, password);

		this.id = totalUserCounter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	private void doArgumentValidation(String firstName, String lastName, String email, String password) {
		Validator.validateFirstName(firstName, UserFields.firstName, errorMap);
		Validator.validateLastName(lastName, UserFields.lastName, errorMap);
		Validator.validateEmail(email, UserFields.email, errorMap);

		StringBuilder errorMessage = new StringBuilder("");
		for (Map.Entry<String, String> entry : errorMap.entrySet()) {
			String entryErrorMessage = entry.getValue();
			if (entryErrorMessage != null) {
				errorMessage.append(entryErrorMessage).append("\n");
			}
		}

		if (errorMessage.toString().length() > 0) {
			throw new IllegalArgumentException(errorMessage.toString());
		}
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setPassword(String newPassword) {
		this.password = newPassword;

	}

	@Override
	public void setEmail(String newEmail) {
		this.email = newEmail;

	}

}
