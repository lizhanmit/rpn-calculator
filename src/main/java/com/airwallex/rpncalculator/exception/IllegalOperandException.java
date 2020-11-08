package com.airwallex.rpncalculator.exception;

public class IllegalOperandException extends ExpressionException {

	private static final long serialVersionUID = 6910853914751190710L;
	
	public IllegalOperandException(String operatorValue) {
		super("Illegal operand: " + operatorValue);
	}

}
