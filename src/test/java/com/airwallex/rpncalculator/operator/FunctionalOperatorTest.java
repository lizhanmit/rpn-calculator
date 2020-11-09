package com.airwallex.rpncalculator.operator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class FunctionalOperatorTest {

	private Stack<Double> stack = new Stack<>();
	private Stack<List<Double>> logStack = new Stack<>();
	private Operator functionalOperator = FunctionalOperator.getInstance();

	private void initStack() {
		stack.add(2.0);
		stack.add(4.0);
		
		List<Double> numList1 = new ArrayList<>();
		numList1.add(new Double(2.0));
		logStack.push(numList1);
		
		List<Double> numList2 = new ArrayList<>();
		numList2.add(new Double(2.0));
		numList2.add(new Double(4.0));
		logStack.push(numList2);
	}
	
	@Test
	public void undoShouldWorkCorrectly() {
		initStack();
		functionalOperator.process(0, "undo", stack, logStack);
		
		assertEquals(new Double(2.0), stack.peek());
		assertEquals(new Double(2.0), logStack.peek().get(0));
	}
	
	@Test
	public void clearShouldWorkCorrectly() {
		initStack();
		functionalOperator.process(0, "clear", stack, logStack);
		
		assertTrue(stack.isEmpty());
		assertNull(logStack.peek().get(0));
		assertEquals(new Double(2.0), logStack.get(0).get(0));
		assertEquals(new Double(2.0), logStack.get(1).get(0));
		assertEquals(new Double(4.0), logStack.get(1).get(1));
	}
}
