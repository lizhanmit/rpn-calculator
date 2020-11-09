package com.airwallex.rpncalculator;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class RpnCalculatorTest {

	RpnCalculator rpnCalculator = new RpnCalculator();
	
	@Test
	public void testProcess() {
		rpnCalculator.process("7 12 2 /");
		
		Stack<Double> stack = rpnCalculator.getStack();
		assertEquals(new Double(7.0), stack.get(0));
		assertEquals(new Double(6.0), stack.get(1));
		
		Stack<List<Double>> logStack = rpnCalculator.getLogStack();
		assertEquals(new Double(7.0), logStack.get(0).get(0));
		assertEquals(new Double(7.0), logStack.get(1).get(0));
		assertEquals(new Double(12.0), logStack.get(1).get(1));
		assertEquals(new Double(7.0), logStack.get(2).get(0));
		assertEquals(new Double(12.0), logStack.get(2).get(1));
		assertEquals(new Double(2.0), logStack.get(2).get(2));
		assertEquals(new Double(7.0), logStack.get(3).get(0));
		assertEquals(new Double(6.0), logStack.get(3).get(1));
	}
	
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
