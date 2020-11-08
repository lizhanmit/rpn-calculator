package com.airwallex.rpncalculator;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== Welcome to use RPN Calculator ===");
		
		RpnCalculator rpnCalculator = new RpnCalculator();

		
		while (true) {
			System.out.println("Please input RPN expression: ");
			Scanner scanner = new Scanner(System.in);
			String rpnExpression = scanner.nextLine();
			rpnCalculator.process(rpnExpression);
		}
	}
}
