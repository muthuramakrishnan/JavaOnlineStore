package com.muthustore.entities.impl;

import java.util.Arrays;

import com.muthustore.entities.Cart;
import com.muthustore.entities.Product;

public class DefaultCart implements Cart {

	private static final int DEFAULT_CART_CAPACITY = 10;
	private Product[] products;
	private int lastIndex = 0;

	{
		products = new Product[DEFAULT_CART_CAPACITY];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addProduct(Product product) {
		if (product == null) {
			return;
		}
		if (products.length > lastIndex) {
			throw new IndexOutOfBoundsException("Reached the maximum cart capacity" + products.length);
		}
		products[lastIndex++] = product;
	}

	@Override
	public Product[] getProducts() {
		// TODO Auto-generated method stub
		return Arrays.copyOf(products, DEFAULT_CART_CAPACITY);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		products = new Product[DEFAULT_CART_CAPACITY];
		lastIndex = 0;

	}

}
