package com.airwallex.rpncalculator.operator;

import java.util.HashMap;
import java.util.Map;

import com.airwallex.rpncalculator.Utils;
import com.airwallex.rpncalculator.exception.IllegalOperatorException;

public class OperatorFactory {

	public static final Map<String, String> operatorMap = new HashMap<>();
	
	static {
		operatorMap.put(Utils.ADD, Utils.BINARY);
		operatorMap.put(Utils.SUBTRACT, Utils.BINARY);
		operatorMap.put(Utils.MULTIPLY, Utils.BINARY);
		operatorMap.put(Utils.DIVIDE, Utils.BINARY);
		operatorMap.put(Utils.SQRT, Utils.UNARY);
		operatorMap.put(Utils.UNDO, Utils.FUNCTIONAL);
		operatorMap.put(Utils.CLEAR, Utils.FUNCTIONAL);
	}
	
	public static String getOperatorType(String operatorValue) {
		String operatorType = operatorMap.get(operatorValue);
		
		if (operatorType == null) {
			throw new IllegalOperatorException(operatorValue);
		}
		
		return operatorType;
	}
	
	public static Operator getOperator(String operatorType) {
		if (operatorType.equals(Utils.UNARY)) {
			return UnaryOperator.getInstance();
		}
		
		if (operatorType.equals(Utils.BINARY)) {
			return BinaryOperator.getInstance();
		} 
		
		if (operatorType.equals(Utils.FUNCTIONAL)) {
			return FunctionalOperator.getInstance();
		}
		
		return null;
	}
}
