package com.airwallex.rpncalculator.operator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.List;
import java.util.Stack;

import org.junit.Test;

import com.airwallex.rpncalculator.exception.IllegalOperandException;
import com.airwallex.rpncalculator.exception.InsufficientParamException;


public class UnaryOperatorTest {

	private Stack<Double> stack = new Stack<>();
	private Stack<List<Double>> logStack = new Stack<>();
	private Operator unaryOperator = UnaryOperator.getInstance();
	
	
	private void clearStack() {
		if (!stack.isEmpty()) {
			stack.clear();
		}
		
		if (!logStack.isEmpty()) {
			logStack.clear();
		}
	}
	
	@Test
	public void sqrtOperatorShouldWorkCorrectly() {
		clearStack();
		stack.add(4.0);
		
		unaryOperator.process(2, "sqrt", stack, logStack);
		assertEquals(new Double(2.0), stack.peek());
	}
	
	@Test
	public void insufficientParamExceptionShouldBeThrownWhenNoParamForSqrtOperator() {
		clearStack();
		
		assertThrows("operator + (position: 1): insufficient parameters", InsufficientParamException.class, () -> unaryOperator.process(0, "sqrt", stack, logStack));
	}
	
	@Test
	public void illegalOperandExceptionShouldBeThrownWhenGettingSqrtOfNegativeValue() {
		clearStack();
		stack.add(-2.0);
		
		assertThrows("Cannot get square root of a negative value", IllegalOperandException.class, () -> unaryOperator.process(2, "sqrt", stack, logStack));
	}
}
