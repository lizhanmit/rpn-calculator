package com.airwallex.rpncalculator;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entry class.
 *
 */
public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		logger.info("Program starts");
		
		System.out.println("=== Welcome to use RPN Calculator ===");
		
		RpnCalculator rpnCalculator = new RpnCalculator();
		
		while (true) {
			System.out.println("Please input RPN expression: ");
			Scanner scanner = new Scanner(System.in);
			String rpnExpression = scanner.nextLine();
			
			logger.info("User input RPN expression: {}", rpnExpression);
			logger.info("Processing RPN expression starts");
			
			rpnCalculator.process(rpnExpression);
			
			logger.info("Processing RPN expression ends");
			
			rpnCalculator.printStack();
			
			if (Utils.getValueFromConfigFile("debug").equalsIgnoreCase("true")) {
				System.out.println("logStack: " + rpnCalculator.getLogStack());
			}
		}
	}
}
