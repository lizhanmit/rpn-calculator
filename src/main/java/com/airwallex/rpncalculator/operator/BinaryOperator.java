package com.airwallex.rpncalculator.operator;

import java.util.List;
import java.util.Stack;

import com.airwallex.rpncalculator.RpnCalculator;
import com.airwallex.rpncalculator.Utils;
import com.airwallex.rpncalculator.exception.IllegalOperandException;
import com.airwallex.rpncalculator.exception.InsufficientParamException;


public class BinaryOperator implements Operator {

	private BinaryOperator() {
	}

	public static BinaryOperator getInstance() {
		return Inner.binaryOperator;
	}
	
	private static class Inner {
		private static final BinaryOperator binaryOperator = new BinaryOperator();
	}
	
	@Override
	public void process(int index, String operatorValue, Stack<Double> stack, Stack<List<Double>> logStack) {
		if (stack.size() > 1) {
			double num2 = stack.pop();
			double num1 = stack.pop();
			double result = 0.0;
			
			switch (operatorValue) {
				case Utils.ADD:
					result = num1 + num2;
					break;
				case Utils.SUBTRACT:
					result = num1 - num2;
					break;
				case Utils.MULTIPLY:
					result = num1 * num2;
					break;
				case Utils.DIVIDE:
					result = divide(num1,num2);
					break;
				default:
					break;
			}
			
			stack.push(result);
			RpnCalculator.snapshotStack(stack, logStack);
		} else {
			throw new InsufficientParamException(index, operatorValue);
		}
	}
	
	private static double divide(double num1, double num2) {
		if (num2 == 0) {
			throw new IllegalOperandException("Divisor cannot be 0");
		}
		
		return num1 / num2;
	}

}
