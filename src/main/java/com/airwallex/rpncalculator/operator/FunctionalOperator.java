package com.airwallex.rpncalculator.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.airwallex.rpncalculator.Utils;


public class FunctionalOperator implements Operator {

	private FunctionalOperator() {
	}

	public static FunctionalOperator getInstance() {
		return Inner.functionalOperator;
	}
	
	private static class Inner {
		private static final FunctionalOperator functionalOperator = new FunctionalOperator();
	}
	
	@Override
	public void process(int index, String operatorValue, Stack<Double> stack, Stack<List<Double>> logStack) {
		switch (operatorValue) {
		case Utils.UNDO:
			undo(stack, logStack);
			break;
		case Utils.CLEAR:
			clear(stack, logStack);
			break;
		default:
			break;
		}
	}

	private static void undo(Stack<Double> stack, Stack<List<Double>> logStack) {
		if (!stack.isEmpty()) {
			stack.clear();
		}
		
		if (!logStack.isEmpty()) {
			logStack.pop();
			
			if (!logStack.isEmpty()) {
				List<Double> numList = logStack.peek();
				for (Double num : numList) {
					if (num != null) {
						stack.push(num);
					}
				}
			}
		}
	}
	
	private static void clear(Stack<Double> stack, Stack<List<Double>> logStack) {
		if (!stack.isEmpty()) {
			stack.clear();
		}
		
		List<Double> numList = new ArrayList<>();
		numList.add(null);
		logStack.push(numList);
	}
}
