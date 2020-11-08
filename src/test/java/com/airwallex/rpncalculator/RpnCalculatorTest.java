package com.airwallex.rpncalculator;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class RpnCalculatorTest {

	@Test
	public void testSnapshotStack() {
		Stack<Double> stack = new Stack<>();
		stack.add(1.1);
		stack.add(1.2);
		
		Stack<List<Double>> logStack = new Stack<>();
		
		RpnCalculator.snapshotStack(stack, logStack);
		
		List<Double> numList = logStack.peek();
		
		assertEquals(new Double(1.1), numList.get(0));
		assertEquals(new Double(1.2), numList.get(1));
	}
}
