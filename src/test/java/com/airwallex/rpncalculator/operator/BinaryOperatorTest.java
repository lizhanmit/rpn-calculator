package com.airwallex.rpncalculator.operator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.List;
import java.util.Stack;

import org.junit.Test;

import com.airwallex.rpncalculator.exception.IllegalOperandException;
import com.airwallex.rpncalculator.exception.InsufficientParamException;


public class BinaryOperatorTest {

	private Stack<Double> stack = new Stack<>();
	private Stack<List<Double>> logStack = new Stack<>();
	private Operator binaryOperator = BinaryOperator.getInstance();
	
    private void initStack() {
		stack.add(2.0);
		stack.add(4.0);
    }
	
	private void clearStack() {
		if (!stack.isEmpty()) {
			stack.clear();
		}
		
		if (!logStack.isEmpty()) {
			logStack.clear();
		}
	}
	
	@Test
	public void addOperatorShouldWorkCorrectly() {
		clearStack();
		initStack();
		
		binaryOperator.process(2, "+", stack, logStack);
		assertEquals(new Double(6.0), stack.peek());
	}
	
	@Test
	public void subtractOperatorShouldWorkCorrectly() {
		clearStack();
		initStack();
		
		binaryOperator.process(2, "-", stack, logStack);
		assertEquals(new Double(-2.0), stack.peek());
	}
	
	@Test
	public void multiplyOperatorShouldWorkCorrectly() {
		clearStack();
		initStack();
		
		binaryOperator.process(2, "*", stack, logStack);
		assertEquals(new Double(8.0), stack.peek());
	}
	
	@Test
	public void divideOperatorShouldWorkCorrectly() {
		clearStack();
		initStack();
		
		binaryOperator.process(2, "/", stack, logStack);
		assertEquals(new Double(0.5), stack.peek());
	}
	
	@Test
	public void insufficientParamExceptionShouldBeThrownWhenOnlyOneParamForAddOperator() {
		clearStack();
		stack.add(2.0);
		
		assertThrows("operator + (position: 3): insufficient parameters", InsufficientParamException.class, () -> binaryOperator.process(1, "+", stack, logStack));
	}
	
	@Test
	public void illegalOperandExceptionShouldBeThrownWhenDivisorIsZero() {
		clearStack();
		stack.add(2.0);
		stack.add(0.0);
		
		assertThrows("Divisor cannot be 0", IllegalOperandException.class, () -> binaryOperator.process(2, "/", stack, logStack));
	}
}
