package com.airwallex.rpncalculator.operator;

import java.util.List;
import java.util.Stack;

import com.airwallex.rpncalculator.RpnCalculator;
import com.airwallex.rpncalculator.Utils;
import com.airwallex.rpncalculator.exception.IllegalOperandException;
import com.airwallex.rpncalculator.exception.InsufficientParamException;


public class UnaryOperator implements Operator {

	private UnaryOperator() {
	}

	public static UnaryOperator getInstance() {
		return Inner.unaryOperator;
	}
	
	private static class Inner {
		private static final UnaryOperator unaryOperator = new UnaryOperator();
	}

	@Override
	public void process(int index, String operatorValue, Stack<Double> stack, Stack<List<Double>> logStack) {
		if (stack.size() > 0) {
			double num = stack.pop();
			double result = 0.0;
			
			switch (operatorValue) {
				case Utils.SQRT:
					result = sqrt(num);
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
	
	private static double sqrt(double num) {
		if (num < 0) {
			throw new IllegalOperandException("Cannot get square root of a negative value");
		}
		
		return Math.sqrt(num);
	}
	
	

}
