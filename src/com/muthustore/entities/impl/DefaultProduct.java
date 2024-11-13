package com.muthustore.entities.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.muthustore.Validator;
import com.muthustore.entities.Product;
import com.muthustore.entities.ProductFields;

public class DefaultProduct implements Product {
	private UUID id;
	private String productName;
	private String categoryName;
	private double price;
	Map<String, String> errorMap = new HashMap<String, String>();

	public DefaultProduct(UUID id, String productName, String categoryName, double price) {
		doArgumentValidation(id, productName, categoryName, price);

		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
	}

	private void doArgumentValidation(UUID id, String productName, String categoryName, double price) {
		Validator.validateProductName(productName, ProductFields.productName, errorMap);
		Validator.validateCategoryName(categoryName, ProductFields.categoryName, errorMap);

		StringBuilder errorMsg = new StringBuilder("");
		for (Map.Entry<String, String> entry : errorMap.entrySet()) {
			String error = entry.getValue();
			if (error != null) {
				errorMsg.append(error).append("\n");
			}
		}

		if (errorMsg.toString().length() > 0) {
			throw new IllegalArgumentException(errorMsg.toString());
		}
	}

	@Override
	public String toString() {
		return "DefaultProduct [id=" + id + ", productName=" + productName + ", categoryName=" + categoryName
				+ ", price=" + price + "]";
	}

	@Override
	public UUID getId() {
		return this.id;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

}
