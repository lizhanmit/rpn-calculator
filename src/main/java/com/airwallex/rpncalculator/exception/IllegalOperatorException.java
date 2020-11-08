package com.airwallex.rpncalculator.exception;

public class IllegalOperatorException extends ExpressionException {

	private static final long serialVersionUID = 6910853914751190710L;
	
	public IllegalOperatorException(String operatorValue) {
		super("Illegal operator: " + operatorValue);
	}

}
