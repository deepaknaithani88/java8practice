package deepak.practice.calculator;

import deepak.practice.calculator.operations.Addition;
import deepak.practice.calculator.operations.Division;
import deepak.practice.calculator.operations.Multiplication;
import deepak.practice.calculator.operations.ArithmeticOperator;
import deepak.practice.calculator.operations.Subtraction;

public class CalculatorLambda {

	public static void main(String[] args) {
		new CalculatorLambda().readInputs(args);
	}

	private void readInputs(String[] args) {
		int operator = Integer.parseInt(args[0]);

		int a = Integer.parseInt(args[1]);
		int b = Integer.parseInt(args[2]);

		switch (operator) {
		case 1:
			Addition add = (x, y) -> (x + y);
			System.out.println(sysout(add, a, b));
			break;
		case 2:
			Subtraction sub = (x, y) -> (x - y);
			System.out.println(sysout(sub, a, b));
			break;
		case 3:
			Multiplication mul = (x, y) -> (x * y);
			System.out.println(sysout(mul, a, b));
			break;
		case 4:
			Division div = (x, y) -> (x / y);
			System.out.println(sysout(div, a, b));
			break;
		default:
			break;
		}
	}

	private int sysout(ArithmeticOperator operator, int a, int b) {
		return operator.operate(a, b);
	}

}
