package com.airwallex.rpncalculator.operator;

import java.util.List;
import java.util.Stack;


public interface Operator {

	public abstract void process(int index, String operatorValue, Stack<Double> stack, Stack<List<Double>> logStack);
}
