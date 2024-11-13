package com.muthustore;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.muthustore.entities.ProductFields;
import com.muthustore.entities.UserFields;

public class Validator {
	private static final String emailRegex = "([a-z][-]*[a-z0-9]+([-]*[a-z0-9]+)*)@(gmail.com)";
	private static final Pattern emailPat = Pattern.compile(emailRegex);
	private static Matcher emailMat;

	public static void validateFirstName(String firstName, UserFields fieldName, Map<String, String> errorMap) {
		if (firstName == null || firstName.length() < 3) {
			errorMap.put(fieldName.toString(), "First Name should be atleast 3 characters long");
		}
	}

	public static void validateLastName(String lastName, UserFields fieldName, Map<String, String> errorMap) {
		if (lastName == null || lastName.length() < 1) {
			errorMap.put(fieldName.toString(), "Last Name should be atleast 1 character long");
		}
	}

	public static void validateEmail(String email, UserFields fieldName, Map<String, String> errorMap) {
		String message = null;

		if (email == null) {
			message = "Email cannot be empty";
		} else {
			emailMat = emailPat.matcher(email);
			if (!emailMat.matches()) {
				message = "Input an email with @gmail.com as the domain name";
			}
		}

		if (message != null) {
			errorMap.put(fieldName.toString(), message);
		}
	}

	public static void validateProductName(String productName, ProductFields fieldName, Map<String, String> errorMap) {
		if (productName == null || productName.length() < 3) {
			errorMap.put(fieldName.toString(), "Product Name should be atleast 3 characters in length");
		}
	}

	public static void validateCategoryName(String categoryName, ProductFields fieldName,
			Map<String, String> errorMap) {
		if (categoryName == null || categoryName.length() < 3) {
			errorMap.put(fieldName.toString(), "Category Name Name should be atleast 3 characters in length");
		}
	}

}
