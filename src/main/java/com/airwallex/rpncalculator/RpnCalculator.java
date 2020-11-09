package com.airwallex.rpncalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.airwallex.rpncalculator.exception.ExpressionException;
import com.airwallex.rpncalculator.operator.Operator;
import com.airwallex.rpncalculator.operator.OperatorFactory;

public class RpnCalculator {

	private Stack<Double> stack = new Stack<>();
	private Stack<List<Double>> logStack = new Stack<>();

	public void process(String rpnExpression) {
		if (rpnExpression.trim().equals("")) {
			return;
		}
		
		String[] exprArr = rpnExpression.toLowerCase().split(" ");
		for (int i = 0; i < exprArr.length; i++) {
			Double number = Utils.toDouble(exprArr[i]);
			// if the element is a number, push to stack, and then save a snapshot of the stack to logStack
			if (number != null) {
				stack.push(number);
				snapshotStack(stack, logStack);
			} else {
				try {
					String operatorType = OperatorFactory.getOperatorType(exprArr[i]);
					Operator operator = OperatorFactory.getOperator(operatorType);
					operator.process(i, exprArr[i], stack, logStack);
				} catch (ExpressionException e) {
					System.out.println(e.getMessage());
					break;
				} 
			}
		}
		
		printStack(stack);
		
		if (Utils.getValueFromConfigFile("debug").equals("true")) {
			System.out.println("logStack: " + logStack);
		}
	}

	
	public static void snapshotStack(Stack<Double> stack, Stack<List<Double>> logStack) {
		List<Double> numList = new ArrayList<>();
		for (Double num : stack) {
			numList.add(num);
		}
		logStack.push(numList);
	}

	private static void printStack(Stack<Double> stack) {
		System.out.print("stack: ");
		if (!stack.isEmpty()) {
			for (Double num : stack) {
				System.out.print(Utils.formatNumber(num) + " ");
			}
		}
		System.out.println();
	}


	public Stack<Double> getStack() {
		return stack;
	}

	public Stack<List<Double>> getLogStack() {
		return logStack;
	}
}
