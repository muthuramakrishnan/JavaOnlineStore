package com.muthustore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		System.out.println("""
				1. Register user
				2. Find user by email
				""");

		byte optionSelected = Byte.parseByte(consoleReader.readLine());

		switch (optionSelected) {
		case 1: {

		}
		}
	}
}
