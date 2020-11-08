package com.airwallex.rpncalculator.exception;

public class InsufficientParamException extends ExpressionException {

	private static final long serialVersionUID = -4264001850928075309L;

	public InsufficientParamException(int index, String operatorValue) {
		super("operator " + operatorValue + " (position: " + (index * 2 + 1) + "): insufficient parameters");
	}
}
